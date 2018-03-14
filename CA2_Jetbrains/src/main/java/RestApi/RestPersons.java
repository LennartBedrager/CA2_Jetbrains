/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestApi;

import RestFacade.RestPersonFacade;
import com.google.gson.Gson;
import entity.Person;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Oliver
 */
@Path("persons")
public class RestPersons {

    Gson gson = new Gson();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestPersons
     */
    public RestPersons() {
    }


    //Returns all persons
    @Path("/complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> persons = RestPersonFacade.getAllPets();
        return gson.toJson(persons);
    }
    
    //Return person with ID
    @Path("/complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id){
        Person person = RestPersonFacade.getPersonById(id);
        return gson.toJson(person);
    }

    /**
     * PUT method for updating or creating an instance of RestPersons
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
