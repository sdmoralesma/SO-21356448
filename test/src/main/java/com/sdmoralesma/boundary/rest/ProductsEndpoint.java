package com.sdmoralesma.boundary.rest;

import com.sdmoralesma.boundary.CustomerGateway;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author luigi
 */
@Path("products")
@RequestScoped
public class ProductsEndpoint {

    @Context
    private UriInfo context;

    @Inject
    CustomerGateway gateway;

    /**
     * Creates a new instance of ProductsEndpoint
     */
    public ProductsEndpoint() {
    }

    /**
     * Retrieves representation of an instance of
     * com.sdmoralesma.boundary.rest.ProductsEndpoint
     *
     * @return
     */
    @GET
    @Produces("application/xml")
    public Response findStateful() {
        return Response.ok(gateway.find(Integer.valueOf(1))).build();
    }

    /**
     * PUT method for updating or creating an instance of ProductsEndpoint
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
