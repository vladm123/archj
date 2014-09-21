public interface SimpleVouch$port$authenticatorExtern {
  public void register (java.lang.String name, java.lang.String email, java.lang.String password, Object _sender) ;

  public int authenticate (java.lang.String email, java.lang.String password, Object _sender) ;

  public void deauthenticate (java.lang.String email, Object _sender) ;

  public static class Impl implements archjava.runtime.PortInterfaceImpl, SimpleVouch$port$authenticatorExtern {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private SimpleVouch enclosingObject;
    public Impl(SimpleVouch o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("authenticatorExtern", o, archjava.reflect.Type.forName("SimpleVouch"));
      port.setPortObject(this);
      port.addMethod(m0);
      port.addMethod(m1);
      port.addMethod(m2);
    }
    public void register (java.lang.String name, java.lang.String email, java.lang.String password, Object _sender)  {
      try {
        Object _args[] = new Object[3];
        _args[0] = name;
        _args[1] = email;
        _args[2] = password;
        archjava.reflect.Method _method = m0;
        archjava.reflect.Call _call = new archjava.reflect.Call(_connector, _method, _args);
        Object _result = _connector.invoke(_call);
      } catch (Throwable _t) {
        // TODO: handle exceptions appropriately
        _t.printStackTrace();
        throw new RuntimeException(_t.getMessage());
      }
    }

    public int authenticate (java.lang.String email, java.lang.String password, Object _sender)  {
      try {
        Object _args[] = new Object[2];
        _args[0] = email;
        _args[1] = password;
        archjava.reflect.Method _method = m1;
        archjava.reflect.Call _call = new archjava.reflect.Call(_connector, _method, _args);
        Object _result = _connector.invoke(_call);
        return ((java.lang.Integer) _result).intValue();
      } catch (Throwable _t) {
        // TODO: handle exceptions appropriately
        _t.printStackTrace();
        throw new RuntimeException(_t.getMessage());
      }
    }

    public void deauthenticate (java.lang.String email, Object _sender)  {
      try {
        Object _args[] = new Object[1];
        _args[0] = email;
        archjava.reflect.Method _method = m2;
        archjava.reflect.Call _call = new archjava.reflect.Call(_connector, _method, _args);
        Object _result = _connector.invoke(_call);
      } catch (Throwable _t) {
        // TODO: handle exceptions appropriately
        _t.printStackTrace();
        throw new RuntimeException(_t.getMessage());
      }
    }

    public final archjava.reflect.Method m0 = new archjava.reflect.Method("register", archjava.reflect.Method.REQUIRED, archjava.reflect.Type.forName("void"));
    { m0.setParameterNames(new String[] {"name", "email", "password"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Method m1 = new archjava.reflect.Method("authenticate", archjava.reflect.Method.REQUIRED, archjava.reflect.Type.forName("int"));
    { m1.setParameterNames(new String[] {"email", "password"});
      m1.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Method m2 = new archjava.reflect.Method("deauthenticate", archjava.reflect.Method.REQUIRED, archjava.reflect.Type.forName("void"));
    { m2.setParameterNames(new String[] {"email"});
      m2.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
