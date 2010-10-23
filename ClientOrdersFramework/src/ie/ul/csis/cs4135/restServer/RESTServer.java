package ie.ul.csis.cs4135.restServer;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class RESTServer {
	
    public static void main(String[] args) throws Exception {
        // Create a new Component.
        Component component = new Component();

        // Add a new HTTP server listening on port 8182.
        component.getServers().add(Protocol.HTTP, 8182);

        component.getDefaultHost().attach("/pcshop", new PCShopApplication());

        // Start the component.
        component.start();

    }

}
