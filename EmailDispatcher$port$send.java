public interface EmailDispatcher$port$send {
  public static class Impl implements archjava.runtime.PortInterfaceImpl, EmailDispatcher$port$send {
    archjava.reflect.Connector _connector;
    public void setConnector(archjava.reflect.Connector ctor) { _connector = ctor; }
    public void callConstructors() {
        }
    private EmailDispatcher enclosingObject;
    public Impl(EmailDispatcher o) {
      enclosingObject = o;
      port = new archjava.reflect.Port("send", o, archjava.reflect.Type.forName("EmailDispatcher"));
      port.setPortObject(this);
      port.addMethod(m0);
    }
    public final archjava.reflect.Method m0 = new archjava.reflect.Method("sendEmail", archjava.reflect.Method.PROVIDED, archjava.reflect.Type.forName("boolean"));
    { m0.setParameterNames(new String[] {"providerName", "providerEmail", "recipientName", "recipientEmail", "text"});
      m0.setParameterTypes(new archjava.reflect.Type[] {archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String"), archjava.reflect.Type.forName("java.lang.String")});
    }
    public final archjava.reflect.Port port;
  }
}
