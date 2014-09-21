public interface Authenticator$port$intern {
  public static class Impl implements archjava.runtime.PortInterfaceImpl, Authenticator$port$intern {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Authenticator enclosingObject;
    public Impl(Authenticator o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("intern", o, archjava.reflect.Type.forName("Authenticator"));
      port.setPortObject(this);
      port.addMethod(m0);
    }
    public final archjava.reflect.Method m0 = new archjava.reflect.Method("verify", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("boolean"));
    { m0.setParameterNames(new String[] {"email", "token"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("int")});
    }
    public final archjava.reflect.Port port;
  }
}
