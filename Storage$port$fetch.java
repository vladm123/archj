public interface Storage$port$fetch {
  public static class Impl implements archjava.runtime.PortInterfaceImpl, Storage$port$fetch {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Storage enclosingObject;
    public Impl(Storage o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("fetch", o, archjava.reflect.Type.forName("Storage"));
      port.setPortObject(this);
      port.addMethod(m0);
    }
    public final archjava.reflect.Method m0 = new archjava.reflect.Method("getName", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("java.lang.String"));
    { m0.setParameterNames(new String[] {"email"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
