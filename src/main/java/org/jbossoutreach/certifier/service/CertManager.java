package org.jbossoutreach.certifier.service;

import org.jbossoutreach.certifier.model.Certificate;
import org.jbossoutreach.certifier.service.generator.CertGenerator;

public class CertManager {
    private final CertGenerator certGenerator;

    public CertManager(CertGenerator certGenerator) {
        this.certGenerator = certGenerator;
    }

    /**
     * Generates a certificate for {@code student} using the provided {@code CertGenerator}
     * @param certificate to generate a certificate for
     * @return null if generation failed; the String path to the certificate if successful
     */

    public String generateCert(Certificate certificate) {
        final String certId;
        try {
            certId = certGenerator.generateCert(certificate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return certId;
    }
}
