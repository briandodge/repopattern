package gov.dvla.osl.Repository;

import gov.dvla.osl.Repository.resources.MainClassResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RespositoryApplication extends Application<RespositoryConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RespositoryApplication().run(args);
    }

    @Override
    public String getName() {
        return "Respository";
    }

    @Override
    public void initialize(final Bootstrap<RespositoryConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RespositoryConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application


        environment.jersey().register(new MainClassResource());
    }

}
