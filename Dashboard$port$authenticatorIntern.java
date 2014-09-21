public interface Dashboard$port$authenticatorIntern {
  public boolean verify (java.lang.String email, int token, Object _sender) ;

  public static class Impl implements archjava.runtime.PortInterfaceImpl, Dashboard$port$authenticatorIntern {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Dashboard enclosingObject;
    public Impl(Dashboard o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("authenticatorIntern", o, archjava.reflect.Type.forName("Dashboard"));
      port.setPortObject(this);
      port.addMethod(m0);
    }
    public boolean verify (java.lang.String email, int token, Object _sender)  {
      try {
        Object _args[] = new Object[2];
        _args[0] = email;
        _args[1] = new java.lang.Integer(token);
        archjava.reflect.Method _method = m0;
        archjava.reflect.Call _call = new archjava.reflect.Call(_connector, _method, _args);
        Object _result = _connector.invoke(_call);
        return ((java.lang.Boolean) _result).booleanValue();
      } catch (Throwable _t) {
        // TODO: handle exceptions appropriately
        _t.printStackTrace();
        throw new RuntimeException(_t.getMessage());
      }
    }

    public final archjava.reflect.Method m0 = new archjava.reflect.Method("verify", archjava.reflect.Method.REQUIRED, archjava.reflect.Type.forName("boolean"));
    { m0.setParameterNames(new String[] {"email", "token"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("int")});
    }
    public final archjava.reflect.Port port;
  }
}
