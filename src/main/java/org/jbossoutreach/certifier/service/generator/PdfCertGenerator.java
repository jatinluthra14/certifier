package org.jbossoutreach.certifier.service.generator;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.jbossoutreach.certifier.model.Certificate;
import org.jbossoutreach.certifier.service.template.Template;

import java.io.File;
import java.io.FileOutputStream;

/**
 * An implementation of {@code CertGenerator} that generates a PDF certificate.
 */
public class PdfCertGenerator implements CertGenerator {
    private final String outPath;
    private final Template template;

    public PdfCertGenerator(String outPath, Template template) {
        this.outPath = outPath;
        this.template = template;
    }

    @Override
    public String generateCert(Certificate certificate) throws Exception {
        final Document document = new Document(PageSize.A4.rotate());
        final File outFile = new File(outPath);
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
        return outPath;
    }
}
