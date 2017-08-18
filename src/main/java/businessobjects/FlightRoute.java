package businessobjects;

public class FlightRoute {

    private String outbound_route;
    private String inbound_route;

    public FlightRoute(String outboundRoute, String inboundRoute) {
        this.outbound_route = outbound_route;
        this.inbound_route = inbound_route;
    }


    public String getOutbound_route(){
        return outbound_route;
    }

    public String getInbound_route(){
        return inbound_route;
    }

    public void setOutbound_route(String outbound_route) {
        this.outbound_route = outbound_route;
    }

    public void setInbound_route(String inbound_route) {
        this.inbound_route = inbound_route;
    }
}
