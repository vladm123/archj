public interface Storage$port$auth {
  public static class Impl implements archjava.runtime.PortInterfaceImpl, Storage$port$auth {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Storage enclosingObject;
    public Impl(Storage o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("auth", o, archjava.reflect.Type.forName("Storage"));
      port.setPortObject(this);
      port.addMethod(m0);
      port.addMethod(m1);
    }
    public final archjava.reflect.Method m0 = new archjava.reflect.Method("register", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("boolean"));
    { m0.setParameterNames(new String[] {"name", "email", "password"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Method m1 = new archjava.reflect.Method("verify", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("boolean"));
    { m1.setParameterNames(new String[] {"email", "password"});
      m1.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
