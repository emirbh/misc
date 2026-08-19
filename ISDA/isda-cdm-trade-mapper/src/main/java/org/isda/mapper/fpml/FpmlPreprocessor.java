package org.isda.mapper.fpml;

/**
 * Transforms raw XML content before FpML parsing.
 * Implementations handle proprietary dialects (e.g. CitiML)
 * by normalising them to standard FpML structure.
 */
public interface FpmlPreprocessor {

    /**
     * Transform the input XML string. Returns standard FpML XML.
     * The identity preprocessor returns the input unchanged.
     */
    String process(String xml);

    /**
     * Short name for logging/display.
     */
    String name();
}
