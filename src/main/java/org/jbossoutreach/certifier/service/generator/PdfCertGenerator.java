package org.jbossoutreach.certifier.service.generator;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.jbossoutreach.certifier.CertCache;
import org.jbossoutreach.certifier.model.Certificate;
import org.jbossoutreach.certifier.service.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * An implementation of {@code CertGenerator} that generates a PDF certificate.
 */
public class PdfCertGenerator implements CertGenerator {
    private final Template template;
    private final String outPath;

    public PdfCertGenerator(Template template, String outPath) {
        this.template = template;
        this.outPath = outPath;
    }

    @Override
    public String generateCert(Certificate certificate) throws Exception {
        final String id = UUID.randomUUID().toString();
        final String outFilePath = outPath + "/" + id + ".pdf";
        final Document document = new Document(PageSize.A4.rotate());
        final File outFile = new File(outFilePath);
        outFile.getParentFile().mkdirs();
        outFile.createNewFile();
        final PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outFile));

        document.open();
        document.add(new Chunk(""));
        try {
            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                    template.buildTemplate(certificate));
        } finally {
            document.close();
        }

        CertCache.getInstance().put(id, outFilePath);
        return id;
    }
}
