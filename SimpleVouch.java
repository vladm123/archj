public class SimpleVouch extends archjava.runtime.Component
  implements archjava.runtime.HasPorts, archjava.runtime.IComponent {

  public SimpleVouch (archjava.runtime.Parent $parentArg$) {
    super ($parentArg$);
    connect$0 c0 = new connect$0(this.authenticator, this);
    this.authenticator.extern$port$ = c0;
    this.authenticatorExtern$port$ = c0;
    connect$1 c1 = new connect$1(this.authenticator, this.dashboard);
    this.authenticator.intern$port$ = c1;
    this.dashboard.authenticatorIntern$port$ = c1;
    connect$2 c2 = new connect$2(this.authenticator, this.storage);
    this.authenticator.storageAuth$port$ = c2;
    this.storage.auth$port$ = c2;
    connect$3 c3 = new connect$3(this.dashboard, this);
    this.dashboard.send$port$ = c3;
    this.dashboardSend$port$ = c3;
    connect$4 c4 = new connect$4(this.dashboard, this.emailDispatcher);
    this.dashboard.emailSend$port$ = c4;
    this.emailDispatcher.send$port$ = c4;
    connect$5 c5 = new connect$5(this.dashboard, this.storage);
    this.dashboard.storageFetch$port$ = c5;
    this.storage.fetch$port$ = c5;

  }public SimpleVouch () {
    super ((archjava.runtime.Parent)null);
    connect$0 c0 = new connect$0(this.authenticator, this);
    this.authenticator.extern$port$ = c0;
    this.authenticatorExtern$port$ = c0;
    connect$1 c1 = new connect$1(this.authenticator, this.dashboard);
    this.authenticator.intern$port$ = c1;
    this.dashboard.authenticatorIntern$port$ = c1;
    connect$2 c2 = new connect$2(this.authenticator, this.storage);
    this.authenticator.storageAuth$port$ = c2;
    this.storage.auth$port$ = c2;
    connect$3 c3 = new connect$3(this.dashboard, this);
    this.dashboard.send$port$ = c3;
    this.dashboardSend$port$ = c3;
    connect$4 c4 = new connect$4(this.dashboard, this.emailDispatcher);
    this.dashboard.emailSend$port$ = c4;
    this.emailDispatcher.send$port$ = c4;
    connect$5 c5 = new connect$5(this.dashboard, this.storage);
    this.dashboard.storageFetch$port$ = c5;
    this.storage.fetch$port$ = c5;

  }

  private final static java.lang.String providerName = "Vlad";

  private final static java.lang.String providerEmail = "vlad.c.manea@gmail.com";

  private final static java.lang.String providerPassword = "vladsecret";

  private final static java.lang.String recipientName = "Klaus";

  private final static java.lang.String recipientEmail = "klausmh@diku.dk";

  private final static java.lang.String text = "Hello";

  private final Authenticator authenticator = new Authenticator(new archjava.runtime.Parent(this));

  private final Dashboard dashboard = new Dashboard(new archjava.runtime.Parent(this));

  private final EmailDispatcher emailDispatcher = new EmailDispatcher(new archjava.runtime.Parent(this));

  private final Storage storage = new Storage(new archjava.runtime.Parent(this));

  public void simulate () {
    archjava.runtime.Component.checkPort(this.authenticatorExtern$port$, "authenticatorExtern").register(SimpleVouch.providerName, SimpleVouch.providerEmail, SimpleVouch.providerPassword, this);
    int authToken = archjava.runtime.Component.checkPort(this.authenticatorExtern$port$, "authenticatorExtern").authenticate(SimpleVouch.providerEmail, SimpleVouch.providerPassword, this);
    java.lang.System.out.println("Send vouch status: " + archjava.runtime.Component.checkPort(this.dashboardSend$port$, "dashboardSend").sendVouch(SimpleVouch.providerEmail, authToken, SimpleVouch.recipientName, SimpleVouch.recipientEmail, SimpleVouch.text, this));
    java.lang.System.out.println("If you saw true, then everything is perfect :)");
    archjava.runtime.Component.checkPort(this.authenticatorExtern$port$, "authenticatorExtern").deauthenticate(SimpleVouch.providerEmail, this);
    java.lang.System.out.println("Send vouch status: " + archjava.runtime.Component.checkPort(this.dashboardSend$port$, "dashboardSend").sendVouch(SimpleVouch.providerEmail, authToken, SimpleVouch.recipientName, SimpleVouch.recipientEmail, SimpleVouch.text, this));
    java.lang.System.out.println("If you saw false, then everything is perfect :)");
  }

  public static void main (java.lang.String[] args) {
    new SimpleVouch((archjava.runtime.Parent)null).simulate();
  }

  public void register (java.lang.String name, java.lang.String email, java.lang.String password, SimpleVouch$port$authenticatorExtern sender) {
    authenticatorExtern$port$.register(name, email, password, this);
  }

  public int authenticate (java.lang.String email, java.lang.String password, SimpleVouch$port$authenticatorExtern sender) {
    return authenticatorExtern$port$.authenticate(email, password, this);
  }

  public void deauthenticate (java.lang.String email, SimpleVouch$port$authenticatorExtern sender) {
    authenticatorExtern$port$.deauthenticate(email, this);
  }

  public SimpleVouch$port$authenticatorExtern authenticatorExtern$port$;

  public boolean sendVouch (java.lang.String providerEmail, int providerToken, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, SimpleVouch$port$dashboardSend sender) {
    return dashboardSend$port$.sendVouch(providerEmail, providerToken, recipientName, recipientEmail, text, this);
  }

  public SimpleVouch$port$dashboardSend dashboardSend$port$;

  static final class connect$0 implements archjava.runtime.PortInterfaceImpl, Authenticator$port$extern, SimpleVouch$port$authenticatorExtern {
    public void setConnector(archjava.reflect.Connector ctor) { throw new RuntimeException("_connector is final"); }
    private boolean calledConstructors = false;
    public void callConstructors() {
      if (!calledConstructors) {
        calledConstructors = true;
      }
    }
    connect$0(Authenticator f_0, SimpleVouch f_1) {
      f0 = f_0;
      f1 = f_1;
    }

    private final Authenticator f0;
    private final SimpleVouch f1;
    public int authenticate (java.lang.String email, java.lang.String password, Object _sender)  {
      return f0.authenticate(email, password, (Authenticator$port$extern)this);
    }

    public void register (java.lang.String name, java.lang.String email, java.lang.String password, Object _sender)  {
      f0.register(name, email, password, (Authenticator$port$extern)this);
    }

    public void deauthenticate (java.lang.String email, Object _sender)  {
      f0.deauthenticate(email, (Authenticator$port$extern)this);
    }

  }


  static final class connect$1 implements archjava.runtime.PortInterfaceImpl, Authenticator$port$intern, Dashboard$port$authenticatorIntern {
    public void setConnector(archjava.reflect.Connector ctor) { throw new RuntimeException("_connector is final"); }
    private boolean calledConstructors = false;
    public void callConstructors() {
      if (!calledConstructors) {
        calledConstructors = true;
      }
    }
    connect$1(Authenticator f_0, Dashboard f_1) {
      f0 = f_0;
      f1 = f_1;
    }

    private final Authenticator f0;
    private final Dashboard f1;
    public boolean verify (java.lang.String email, int token, Object _sender)  {
      return f0.verify(email, token, (Authenticator$port$intern)this);
    }

  }


  static final class connect$2 implements archjava.runtime.PortInterfaceImpl, Authenticator$port$storageAuth, Storage$port$auth {
    public void setConnector(archjava.reflect.Connector ctor) { throw new RuntimeException("_connector is final"); }
    private boolean calledConstructors = false;
    public void callConstructors() {
      if (!calledConstructors) {
        calledConstructors = true;
      }
    }
    connect$2(Authenticator f_0, Storage f_1) {
      f0 = f_0;
      f1 = f_1;
    }

    private final Authenticator f0;
    private final Storage f1;
    public boolean register (java.lang.String name, java.lang.String email, java.lang.String password, Object _sender)  {
      return f1.register(name, email, password, (Storage$port$auth)this);
    }

    public boolean verify (java.lang.String email, java.lang.String password, Object _sender)  {
      return f1.verify(email, password, (Storage$port$auth)this);
    }

  }


  static final class connect$3 implements archjava.runtime.PortInterfaceImpl, Dashboard$port$send, SimpleVouch$port$dashboardSend {
    public void setConnector(archjava.reflect.Connector ctor) { throw new RuntimeException("_connector is final"); }
    private boolean calledConstructors = false;
    public void callConstructors() {
      if (!calledConstructors) {
        calledConstructors = true;
      }
    }
    connect$3(Dashboard f_0, SimpleVouch f_1) {
      f0 = f_0;
      f1 = f_1;
    }

    private final Dashboard f0;
    private final SimpleVouch f1;
    public boolean sendVouch (java.lang.String providerEmail, int providerToken, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, Object _sender)  {
      return f0.sendVouch(providerEmail, providerToken, recipientName, recipientEmail, text, (Dashboard$port$send)this);
    }

  }


  static final class connect$4 implements archjava.runtime.PortInterfaceImpl, Dashboard$port$emailSend, EmailDispatcher$port$send {
    public void setConnector(archjava.reflect.Connector ctor) { throw new RuntimeException("_connector is final"); }
    private boolean calledConstructors = false;
    public void callConstructors() {
      if (!calledConstructors) {
        calledConstructors = true;
      }
    }
    connect$4(Dashboard f_0, EmailDispatcher f_1) {
      f0 = f_0;
      f1 = f_1;
    }

    private final Dashboard f0;
    private final EmailDispatcher f1;
    public boolean sendEmail (java.lang.String providerName, java.lang.String providerEmail, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, Object _sender)  {
      return f1.sendEmail(providerName, providerEmail, recipientName, recipientEmail, text, (EmailDispatcher$port$send)this);
    }

  }


  static final class connect$5 implements archjava.runtime.PortInterfaceImpl, Dashboard$port$storageFetch, Storage$port$fetch {
    public void setConnector(archjava.reflect.Connector ctor) { throw new RuntimeException("_connector is final"); }
    private boolean calledConstructors = false;
    public void callConstructors() {
      if (!calledConstructors) {
        calledConstructors = true;
      }
    }
    connect$5(Dashboard f_0, Storage f_1) {
      f0 = f_0;
      f1 = f_1;
    }

    private final Dashboard f0;
    private final Storage f1;
    public java.lang.String getName (java.lang.String email, Object _sender)  {
      return f1.getName(email, (Storage$port$fetch)this);
    }

  }


  public archjava.reflect.Port[] get$ports() {
    return new archjava.reflect.Port[] { new SimpleVouch$port$authenticatorExtern.Impl(this).port, new SimpleVouch$port$dashboardSend.Impl(this).port };  }
  protected void $initSubs() {
  }
}


class Authenticator extends archjava.runtime.Component
  implements archjava.runtime.HasPorts, archjava.runtime.IComponent {

  Authenticator (archjava.runtime.Parent $parentArg$) {
    super ($parentArg$);

  }Authenticator () {
    super ((archjava.runtime.Parent)null);

  }

  private java.util.Map authenticatedUsers = new java.util.HashMap();

  private java.util.Random random = new java.util.Random();

  public void register (java.lang.String name, java.lang.String email, java.lang.String password, Authenticator$port$extern sender) {
    archjava.runtime.Component.checkPort(this.storageAuth$port$, "storageAuth").register(name, email, password, this);
  }

  public int authenticate (java.lang.String email, java.lang.String password, Authenticator$port$extern sender) {
    this.deauthenticate(email, (Authenticator$port$extern)null);
    if (!archjava.runtime.Component.checkPort(this.storageAuth$port$, "storageAuth").verify(email, password, this)) {
      return 0;
    }
    int token = 1 + this.random.nextInt(java.lang.Integer.MAX_VALUE - 1);
    this.authenticatedUsers.put(email, new java.lang.Integer(token));
    return token;
  }

  public void deauthenticate (java.lang.String email, Authenticator$port$extern sender) {
    this.authenticatedUsers.remove(email);
  }

  public Authenticator$port$extern extern$port$;

  public boolean verify (java.lang.String email, int token, Authenticator$port$intern sender) {
    if (!this.authenticatedUsers.containsKey(email)) {
      return false;
    }
    int userToken = ((java.lang.Integer)this.authenticatedUsers.get(email)).intValue();
    if (userToken == 0 || userToken != token) {
      return false;
    }
    return true;
  }

  public Authenticator$port$intern intern$port$;

  public boolean register (java.lang.String name, java.lang.String email, java.lang.String password, Authenticator$port$storageAuth sender) {
    return storageAuth$port$.register(name, email, password, this);
  }

  public boolean verify (java.lang.String email, java.lang.String password, Authenticator$port$storageAuth sender) {
    return storageAuth$port$.verify(email, password, this);
  }

  public Authenticator$port$storageAuth storageAuth$port$;

  public archjava.reflect.Port[] get$ports() {
    return new archjava.reflect.Port[] { new Authenticator$port$extern.Impl(this).port, new Authenticator$port$intern.Impl(this).port, new Authenticator$port$storageAuth.Impl(this).port };  }
  protected void $initSubs() {
  }
}


class Dashboard extends archjava.runtime.Component
  implements archjava.runtime.HasPorts, archjava.runtime.IComponent {

  Dashboard (archjava.runtime.Parent $parentArg$) {
    super ($parentArg$);

  }Dashboard () {
    super ((archjava.runtime.Parent)null);

  }

  public boolean sendVouch (java.lang.String providerEmail, int providerToken, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, Dashboard$port$send sender) {
    if (!archjava.runtime.Component.checkPort(this.authenticatorIntern$port$, "authenticatorIntern").verify(providerEmail, providerToken, this)) {
      return false;
    }
    java.lang.String providerName = archjava.runtime.Component.checkPort(this.storageFetch$port$, "storageFetch").getName(providerEmail, this);
    return archjava.runtime.Component.checkPort(this.emailSend$port$, "emailSend").sendEmail(providerName, providerEmail, recipientName, recipientEmail, text, this);
  }

  public Dashboard$port$send send$port$;

  public java.lang.String getName (java.lang.String email, Dashboard$port$storageFetch sender) {
    return storageFetch$port$.getName(email, this);
  }

  public Dashboard$port$storageFetch storageFetch$port$;

  public boolean sendEmail (java.lang.String providerName, java.lang.String providerEmail, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, Dashboard$port$emailSend sender) {
    return emailSend$port$.sendEmail(providerName, providerEmail, recipientName, recipientEmail, text, this);
  }

  public Dashboard$port$emailSend emailSend$port$;

  public boolean verify (java.lang.String email, int token, Dashboard$port$authenticatorIntern sender) {
    return authenticatorIntern$port$.verify(email, token, this);
  }

  public Dashboard$port$authenticatorIntern authenticatorIntern$port$;

  public archjava.reflect.Port[] get$ports() {
    return new archjava.reflect.Port[] { new Dashboard$port$send.Impl(this).port, new Dashboard$port$storageFetch.Impl(this).port, new Dashboard$port$emailSend.Impl(this).port, new Dashboard$port$authenticatorIntern.Impl(this).port };  }
  protected void $initSubs() {
  }
}


class EmailDispatcher extends archjava.runtime.Component
  implements archjava.runtime.HasPorts, archjava.runtime.IComponent {

  EmailDispatcher (archjava.runtime.Parent $parentArg$) {
    super ($parentArg$);

  }EmailDispatcher () {
    super ((archjava.runtime.Parent)null);

  }

  public boolean sendEmail (java.lang.String providerName, java.lang.String providerEmail, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, EmailDispatcher$port$send sender) {
    java.lang.System.out.println("An email has been \"sent\" from " + providerName + " (" + providerEmail + ") to " + recipientName + " (" + recipientEmail + ") with content \"" + text + ".\"");
    return true;
  }

  public EmailDispatcher$port$send send$port$;

  public archjava.reflect.Port[] get$ports() {
    return new archjava.reflect.Port[] { new EmailDispatcher$port$send.Impl(this).port };  }
  protected void $initSubs() {
  }
}


class Storage extends archjava.runtime.Component
  implements archjava.runtime.HasPorts, archjava.runtime.IComponent {

  Storage (archjava.runtime.Parent $parentArg$) {
    super ($parentArg$);

  }Storage () {
    super ((archjava.runtime.Parent)null);

  }

  private java.util.Map users = new java.util.HashMap();

  public boolean register (java.lang.String name, java.lang.String email, java.lang.String password, Storage$port$auth sender) {
    if (this.users.containsKey(email)) {
      return false;
    }
    this.users.put(email, new UserData(email, name, password));
    return true;
  }

  public boolean verify (java.lang.String email, java.lang.String password, Storage$port$auth sender) {
    if (!this.users.containsKey(email)) {
      return false;
    }
    UserData user = (UserData)this.users.get(email);
    if (password.compareTo(user.getPassword()) != 0) {
      return false;
    }
    return true;
  }

  public Storage$port$auth auth$port$;

  public java.lang.String getName (java.lang.String email, Storage$port$fetch sender) {
    if (!this.users.containsKey(email)) {
      return null;
    }
    UserData user = (UserData)this.users.get(email);
    return user.getName();
  }

  public Storage$port$fetch fetch$port$;

  public archjava.reflect.Port[] get$ports() {
    return new archjava.reflect.Port[] { new Storage$port$auth.Impl(this).port, new Storage$port$fetch.Impl(this).port };  }
  protected void $initSubs() {
  }
}


class UserData {

  public UserData (java.lang.String email, java.lang.String name, java.lang.String password) {
    super ();

    this.email = email;
    this.name = name;
    this.password = password;
  }

  private final java.lang.String email;

  private final java.lang.String name;

  private final java.lang.String password;

  public java.lang.String getEmail () {
    return this.email;
  }

  public java.lang.String getName () {
    return this.name;
  }

  public java.lang.String getPassword () {
    return this.password;
  }

}


