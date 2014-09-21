public interface Dashboard$port$emailSend {
  public boolean sendEmail (java.lang.String providerName, java.lang.String providerEmail, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, Object _sender) ;

  public static class Impl implements archjava.runtime.PortInterfaceImpl, Dashboard$port$emailSend {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private Dashboard enclosingObject;
    public Impl(Dashboard o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("emailSend", o, archjava.reflect.Type.forName("Dashboard"));
      port.setPortObject(this);
      port.addMethod(m0);
    }
    public boolean sendEmail (java.lang.String providerName, java.lang.String providerEmail, java.lang.String recipientName, java.lang.String recipientEmail, java.lang.String text, Object _sender)  {
      try {
        Object _args[] = new Object[5];
        _args[0] = providerName;
        _args[1] = providerEmail;
        _args[2] = recipientName;
        _args[3] = recipientEmail;
        _args[4] = text;
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

    public final archjava.reflect.Method m0 = new archjava.reflect.Method("sendEmail", archjava.reflect.Method.REQUIRED, archjava.reflect.Type.forName("boolean"));
    { m0.setParameterNames(new String[] {"providerName", "providerEmail", "recipientName", "recipientEmail", "text"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
