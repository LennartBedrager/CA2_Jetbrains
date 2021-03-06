/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestApi;

import com.google.gson.Gson;
import entity.Person;
import facade.PersonFacadeImpl;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Oliver
 */
@Path("person")
public class RestPersons {

    PersonFacadeImpl pfi = new PersonFacadeImpl();
    Gson gson = new Gson();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestPersons
     */
    public RestPersons() {
    }

    //Return all persons
    @Path("/complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersons() {
        List<Person> persons = pfi.getAllPersons();
        if (persons == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(persons);
    }

    //R
    @Path("/complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {
        Person p = pfi.getPerson(id);

        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(p);
    }

    @Path("/complete/zip={zip}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByZip(@PathParam("zip") int zip) {
        List<Person> persons = pfi.getPersonsViaZipcode(zip);

        if (persons == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(persons);
    }
    
    @Path("/complete/fname={fname}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByFirstName(@PathParam("fname") String fname) {
        List<Person> persons = pfi.getPersonsViaFirstName(fname);

        if (persons == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(persons);
    }
    
    @Path("/complete/lname={lname}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByLastName(@PathParam("lname") String lname) {
        List<Person> persons = pfi.getPersonsViaLastName(lname);

        if (persons == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(persons);
    }
    
    @Path("/complete/phone={phone}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByPhone(@PathParam("phone") String phone) {
        Person person = pfi.getPersonByPhone(phone);

        if (person == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(person);
    }

    
    
    
    //C
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createPerson(String person) {
        Person newPerson = gson.fromJson(person, Person.class);
        if (newPerson == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        System.out.println(newPerson.getFirstName());
        pfi.createPerson(newPerson);
        return gson.toJson(newPerson);
    }

    //U
    @Path("/complete/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)
    public String updateUser(String person, @PathParam("id") int id) {
        Person newPerson = gson.fromJson(person, Person.class);
        if (newPerson == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Person updatedPerson = pfi.updatePerson(newPerson,id);
        return gson.toJson(updatedPerson);
    }

    //D
    @Path("/complete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePerson(@PathParam("id") int id) {
        Person deletedPerson = pfi.deletePerson(id);
        return gson.toJson(deletedPerson);
    }


 /*@GET
    @Path("contactinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContactAll() {
        List<Person> per1 = pfi.getAllPersons();

        if (per1 == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        ArrayList<Person> personsContact = new ArrayList();
        for (Person op : per1) {
            Person p = new Person();
            p.setId(op.getId());
            p.setFirstName(op.getFirstName());
            p.setLastName(op.getLastName());
            p.setEmail(op.getEmail());
            p.setPhone(op.getPhone());
            p.setAddress(op.getAddress());
            personsContact.add(p);
        }
        return gson.toJson(personsContact);
    } */

 /* @GET
    @Path("contactinfo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getContactFromId(@PathParam("id") int id) {
        Person op = pfi.getPerson(id);
        if (op == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Person p = new Person();
        p.setId(op.getId());
        p.setFirstName(op.getFirstName());
        p.setLastName(op.getLastName());
        p.setEmail(op.getEmail());
        p.setPhone(op.getPhone());
        p.setAddress(op.getAddress());
        return gson.toJson(p);
    } */
}
