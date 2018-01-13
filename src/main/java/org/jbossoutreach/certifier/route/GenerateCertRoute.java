package org.jbossoutreach.certifier.route;

import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.jbossoutreach.certifier.CertCache;
import org.jbossoutreach.certifier.model.Certificate;
import org.jbossoutreach.certifier.model.Student;
import org.jbossoutreach.certifier.service.CertManager;

public class GenerateCertRoute implements Route {
    private static final String ROUTE_PATH = "/certificates";

    private final CertManager certManager;

    public GenerateCertRoute(CertManager certManager) {
        this.certManager = certManager;
    }

    @Override
    public void setup(Router router) {

        router.route().handler(BodyHandler.create());
        router.post(ROUTE_PATH).handler(this::post);
        router.get(ROUTE_PATH + "/:id").handler(this::get);
    }

    private void get(RoutingContext ctx) {
        final CertCache certCache = CertCache.getInstance();
        final String certPath = certCache.get(ctx.request().getParam("id"));

        if (certPath == null) {
            ctx.response()
                    .setStatusCode(404)
                    .end("Certificate not found. Please ensure the ID is correct.");
        } else {
            ctx.response()
                    .sendFile(certPath);
        }
    }

    private void post(RoutingContext ctx) {
        Student student = Json.decodeValue(ctx.getBodyAsString(), Student.class);     // Decode the JSON object passed through AJAX

        final Certificate certificate = new Certificate(
                "JBoss Community",
                "Certificate of Achievement",
                "Basic Git Bootcamp",
                student
        );

        final String certId = certManager.generateCert(certificate);
        if (certId == null) {
            ctx.response()
                    .setStatusCode(500)
                    .end("Failed to generate the certificate.");
        } else {
            ctx.response()
                    .setStatusCode(201)
                    .end(certId);
        }
    }

}
