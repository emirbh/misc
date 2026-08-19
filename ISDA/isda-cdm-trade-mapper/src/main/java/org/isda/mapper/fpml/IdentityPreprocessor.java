package org.isda.mapper.fpml;

/**
 * Pass-through preprocessor for standard FpML files.
 */
public final class IdentityPreprocessor implements FpmlPreprocessor {

    @Override
    public String process(String xml) {
        return xml;
    }

    @Override
    public String name() {
        return "identity";
    }
}
