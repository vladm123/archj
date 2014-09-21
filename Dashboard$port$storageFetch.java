public interface Dashboard$port$storageFetch {
  public java.lang.String getName (java.lang.String email, Object _sender) ;

  public static class Impl implements archjava.runtime.PortInterfaceImpl, Dashboard$port$storageFetch {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Dashboard enclosingObject;
    public Impl(Dashboard o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("storageFetch", o, archjava.reflect.Type.forName("Dashboard"));
      port.setPortObject(this);
      port.addMethod(m0);
    }
    public java.lang.String getName (java.lang.String email, Object _sender)  {
      try {
        Object _args[] = new Object[1];
        _args[0] = email;
        archjava.reflect.Method _method = m0;
        archjava.reflect.Call _call = new archjava.reflect.Call(_connector, _method, _args);
        Object _result = _connector.invoke(_call);
        return (java.lang.String)_result;
      } catch (Throwable _t) {
        // TODO: handle exceptions appropriately
        _t.printStackTrace();
        throw new RuntimeException(_t.getMessage());
      }
    }

    public final archjava.reflect.Method m0 = new archjava.reflect.Method("getName", archjava.reflect.Method.REQUIRED, archjava.reflect.Type.forName("java.lang.String"));
    { m0.setParameterNames(new String[] {"email"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
