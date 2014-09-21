import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public component class SimpleVouch {
	private final static String providerName = "Vlad";
	private final static String providerEmail = "vlad.c.manea@gmail.com";
	private final static String providerPassword = "vladsecret";
	private final static String recipientName = "Klaus";
	private final static String recipientEmail = "klausmh@diku.dk";
	private final static String text = "Hello";
	
	private final Authenticator authenticator = new Authenticator();
	private final Dashboard dashboard = new Dashboard();
	private final EmailDispatcher emailDispatcher = new EmailDispatcher();
	private final Storage storage = new Storage();
	
	// Adding the connects
	connect authenticator.extern, authenticatorExtern;
	connect authenticator.intern, dashboard.authenticatorIntern;
	connect authenticator.storageAuth, storage.auth;
	connect dashboard.send, dashboardSend;
	connect dashboard.emailSend, emailDispatcher.send;
	connect dashboard.storageFetch, storage.fetch;
	
	public port authenticatorExtern {
		requires void register(String name, String email, String password);
		requires int authenticate(String email, String password);
		requires void deauthenticate(String email);
	}
	
	public port dashboardSend {
		requires boolean sendVouch(String providerEmail, int providerToken, String recipientName, String recipientEmail, String text);
	}
	
	public static void main(String args[]) {

		/*
		// Register Vlad
		Authenticator.register(providerName, providerEmail, providerPassword);
		
		// In a galaxy far, far away...
		
		// Authenticate Vlad, send a vouch, disappear (success)
		int authToken = Authenticator.authenticate(providerEmail, providerPassword);
		System.out.println(String.format("Send vouch status: %s",
				Dashboard.sendVouch(providerEmail, authToken, recipientName, recipientEmail, text)));
		Authenticator.deauthenticate(providerEmail);
		
		// "Another" Vlad tries to send a vouch (failure)
		System.out.println(String.format("Send vouch status: %s",
				Dashboard.sendVouch(providerEmail, authToken, recipientName, recipientEmail, text)));
		*/
	}
}

component class Authenticator {
	private static Map<String, Integer> authenticatedUsers = new HashMap<String, Integer>();
	private static Random random = new Random();
	
	public port extern {
		provides void register(String name, String email, String password) {
			storage.register(name, email, password);
		}
		
		provides int authenticate(String email, String password) {
			deauthenticate(email);
			
			if (!storage.verify(email, password)) {
				return 0;
			}
			
			int token = 1 + random.nextInt(Integer.MAX_VALUE - 1);
			authenticatedUsers.put(email, token);
			return token;
		}
		
		provides void deauthenticate(String email) {
			authenticatedUsers.remove(email);
		}
	}
	
	public port intern {
		provides boolean verify(String email, int token) {
			if (!authenticatedUsers.containsKey(email)) {
				return false;
			}

			int userToken = authenticatedUsers.get(email);

			if (userToken == 0 || userToken != token) {
				return false;
			}
			
			return true;
		}
	}
	
	public port storageAuth {
		requires boolean register(String name, String email, String password);
		requires boolean verify(String email, String password);
	}
}

component class Dashboard {
	public port send {
		provides boolean sendVouch(String providerEmail, int providerToken, String recipientName, String recipientEmail, String text) {
			if (!Authenticator.verify(providerEmail, providerToken)) {
				return false;
			}
			
			String providerName = Storage.getName(providerEmail);
			return EmailDispatcher.sendEmail(providerName, providerEmail, recipientName, recipientEmail, text);
		}
	}
	
	public port storageFetch {
		requires String getName(String email);
	}

	public port emailSend {
		requires boolean sendEmail(String providerName, String providerEmail, String recipientName, String recipientEmail, String text);
	}
}

component class EmailDispatcher {
	public port send {
		provides boolean sendEmail(String providerName, String providerEmail, String recipientName, String recipientEmail, String text) {
			System.out.println(String.format("An email has been \"sent\" from %s (%s) to %s (%s) with content \"%s.\"",
					providerName, providerEmail, recipientName, recipientEmail, text));
			return true; // Mails are always sent for simplicity...
		}
	}
}

component class Storage {
	private Map<String, UserData> users = new HashMap<String, UserData>();

	public port auth {
		provides boolean register(String name, String email, String password) {
			if (users.containsKey(email)) {
				return false;
			}
			
			users.put(email,  new UserData(email, name, password));
			return true;
		}
	
		provides boolean verify(String email, String password) {
			if (!users.containsKey(email)) {
				return false;
			}
			
			UserData user = users.get(email);
			if (password.compareTo(user.getPassword()) != 0) {
				return false;
			}
			
			return true;
		}
	}
	
	public port fetch {
		provides String getName(String email) {
			if (!users.containsKey(email)) {
				return null;
			}
			
			UserData user = users.get(email);
			return user.getName();
		} 
	}
}

class UserData {
	private final String email;
	private final String name;
	private final String password;
	
	public UserData(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}

