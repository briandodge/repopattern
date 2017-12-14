package gov.dvla.osl.Repository.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.dvla.osl.Repository.api.IRepository;
import gov.dvla.osl.Repository.api.MyRepo;
import gov.dvla.osl.Repository.api.domain.Driver;
import gov.dvla.osl.Repository.api.domain.IEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("repos")
public class MainClassResource {



    @GET
    @Path("runmain/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response runmain(@PathParam("name") String name){

        List<Driver> drivers = null;
        IRepository repo = new MyRepo();
        try {
//            drivers = repo.add(new Driver(name));
            drivers = repo.findAll();

            Driver driver = drivers.get(1);
            IEntity newDriver = new Driver(name);
            newDriver.set_id(driver.get_id());
            drivers = repo.update(newDriver);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return Response.ok(drivers).build();
    }
}
