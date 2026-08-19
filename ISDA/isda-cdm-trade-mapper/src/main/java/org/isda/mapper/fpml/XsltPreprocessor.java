package org.isda.mapper.fpml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Path;

/**
 * Preprocessor that applies an XSLT stylesheet to normalise
 * proprietary FpML dialects (e.g. CitiML) to standard FpML.
 *
 * Usage:
 *   new XsltPreprocessor("citiml", Path.of("config/citiml-to-fpml.xslt"))
 */
public final class XsltPreprocessor implements FpmlPreprocessor {

    private final String preprocessorName;
    private final Transformer transformer;

    public XsltPreprocessor(String name, Path xsltPath) {
        this.preprocessorName = name;
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            this.transformer = factory.newTransformer(
                    new StreamSource(xsltPath.toFile()));
        } catch (TransformerException e) {
            throw new RuntimeException("Failed to load XSLT: " + xsltPath, e);
        }
    }

    @Override
    public String process(String xml) {
        try {
            StringWriter out = new StringWriter();
            transformer.transform(
                    new StreamSource(new StringReader(xml)),
                    new StreamResult(out));
            return out.toString();
        } catch (TransformerException e) {
            throw new RuntimeException("XSLT transform failed", e);
        }
    }

    @Override
    public String name() {
        return preprocessorName;
    }
}
