/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestApi;

import com.google.gson.Gson;
import entity.Company;
import facade.CompanyFacadeImpl;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * @author PC
 */
@Path("company")
public class RestCompanies {

    CompanyFacadeImpl pfi = new CompanyFacadeImpl();
    Gson gson = new Gson();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestCompanies
     */
    public RestCompanies() {
    }

    //C
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(String company) {
        Company newCompany = gson.fromJson(company, Company.class);
        pfi.createCompany(newCompany);
    }

    //R
    @Path("/complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {
        Company company = pfi.getCompany(id);

        if (company == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(company);
    }

    //U
    @Path("/complete/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(String company, @PathParam("id") int id) {
        Company newCompany = gson.fromJson(company, Company.class);
        if (newCompany == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        pfi.updateCompany(newCompany);
    }

    //D
    @Path("/complete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletePerson(@PathParam("id") int id) {
        pfi.deleteCompany(id);
    }

    //Return all persons
    @Path("/complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersons() {
        List<Company> persons = pfi.getAllCompanies();
        if (persons == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gson.toJson(persons);
    }
}
