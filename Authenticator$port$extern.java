public interface Authenticator$port$extern {
  public static class Impl implements archjava.runtime.PortInterfaceImpl, Authenticator$port$extern {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Authenticator enclosingObject;
    public Impl(Authenticator o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("extern", o, archjava.reflect.Type.forName("Authenticator"));
      port.setPortObject(this);
      port.addMethod(m0);
      port.addMethod(m1);
      port.addMethod(m2);
    }
    public final archjava.reflect.Method m0 = new archjava.reflect.Method("register", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("void"));
    { m0.setParameterNames(new String[] {"name", "email", "password"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Method m1 = new archjava.reflect.Method("authenticate", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("int"));
    { m1.setParameterNames(new String[] {"email", "password"});
      m1.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Method m2 = new archjava.reflect.Method("deauthenticate", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("void"));
    { m2.setParameterNames(new String[] {"email"});
      m2.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
