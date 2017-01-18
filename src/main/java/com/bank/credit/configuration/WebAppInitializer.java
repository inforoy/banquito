package com.bank.credit.configuration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    private static final Logger LOGGER = Logger.getLogger(WebAppInitializer.class);

    /**
     * Constructor (starts logger).
     */
    public WebAppInitializer() {
        LOGGER.info("Starting.... {}");
    }

    /**
     * Clases que se incluyen en el arranque (StartUp) de una aplicacion
     * Inicialmente se incluye el BootStrap que se encarga de disponer
     * de una utilidad de carga de propiedades encriptadas leidas de un fichero
     * de propiedades
     */
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppBasicConfiguration.class);
        // dao
        // rootContext.register(JPAConfig.class);
        // rootContext.register(SecurityConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebMvcConfiguration.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}
