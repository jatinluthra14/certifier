package org.jbossoutreach.certifier.route;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

import org.jbossoutreach.certifier.model.Certificate;
import org.jbossoutreach.certifier.model.Student;
import org.jbossoutreach.certifier.service.CertManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateCertRoute implements Route {
    private final CertManager certManager;
    public static final String cacheName = "certCache";
    public static final String certPATH = "/certificates/";
    private DefaultCacheManager cacheManager;
    private Cache<String, String> cache;

    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy.HH:mm:ss");

    public GenerateCertRoute(CertManager certManager) {

        this.certManager = certManager;

        cacheManager = new DefaultCacheManager();   // Construct a simple local cache manager with default configuration
        cacheManager.defineConfiguration(cacheName, new ConfigurationBuilder().build());  // Define certCache configuration
        cache = cacheManager.getCache(cacheName);   // Obtain the certCache
    }

    @Override
    public void setup(Router router) {

        router.route().handler(BodyHandler.create());
        router.post("/generateCert").handler(this::generateCert);
        router.get(certPATH+"*").handler(this::getCert);
    }

    private void getCert(RoutingContext routingContext) {

            String certFile = cache.get(routingContext.request().path());
            if (certFile == null) {
                routingContext.response()
                        .setStatusCode(500)
                        .end("Failed to fetch the certificate.");
            } else {
                routingContext.response()
                        .setStatusCode(201)
                        .sendFile(certFile);
            }

        }

    private void generateCert(RoutingContext routingContext) {
        final Student student = new Student(
                routingContext.request().getFormAttribute("name"),
                routingContext.request().getFormAttribute("email"),
                routingContext.request().getFormAttribute("score")
        );

        final Certificate certificate = new Certificate(
                "Some Random Organisation",
                "Certificate of Participation",
                "Basic Git Bootcamp",
                student
        );

        final String outPath = certManager.generateCert(certificate);
        if (outPath == null) {
            routingContext.response()
                    .setStatusCode(500)
                    .end("Failed to generate the certificate.");
        } else {
            Date date = new Date();
            final String fileURL = certPATH + student.getName() + "(" + student.getEmail() + ")" + dateFormat.format(date) + ".pdf";
            cache.put(fileURL, outPath);

            routingContext.response()
                    .setStatusCode(201)
                    .end("http://localhost:4000" + fileURL);
        }
    }

}
