package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.health.TemplateHealthCheck;
import org.example.resources.HelloDropWizardResource;

public class HelloDropWizardApplication extends Application<HelloDropWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloDropWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloDropWizard";
    }

    @Override
    public void initialize(final Bootstrap<HelloDropWizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloDropWizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final HelloDropWizardResource resource = new HelloDropWizardResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template",healthCheck);
    }
}
