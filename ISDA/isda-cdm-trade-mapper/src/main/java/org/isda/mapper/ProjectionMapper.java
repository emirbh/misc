package org.isda.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import com.google.inject.Injector;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapperCreator;
import com.rosetta.model.lib.RosettaModelObject;
import drr.projection.iso20022.esma.emir.refit.trade.functions.Project_EsmaEmirTradeReportToIso20022;
import drr.projection.iso20022.fca.ukemir.refit.trade.functions.Project_FcaUkEmirTradeReportToIso20022;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.Auth030EsmaModelConfig;
import iso20022.Auth030FcaModelConfig;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Phase 7: Projects regime-specific reports to submission formats.
 *
 * DRR 5.20.1 ships ISO 20022 projections for ESMA, FCA, ASIC, JFSA and MAS
 * only — there is no CFTC projection, so CFTC Part 43/45 stop at the Phase 6
 * report and are skipped here.
 */
public final class ProjectionMapper {

    private final Project_EsmaEmirTradeReportToIso20022 esmaProjection;
    private final Project_FcaUkEmirTradeReportToIso20022 fcaProjection;

    public ProjectionMapper(Injector injector) {
        this.esmaProjection = injector.getInstance(Project_EsmaEmirTradeReportToIso20022.class);
        this.fcaProjection = injector.getInstance(Project_FcaUkEmirTradeReportToIso20022.class);
    }

    /**
     * Projects all reports in the map to their submission XML format.
     * Returns regime name → XML string.
     */
    public Map<String, String> projectAll(Map<String, RosettaModelObject> reports) {
        Map<String, String> projections = new LinkedHashMap<>();

        for (Map.Entry<String, RosettaModelObject> entry : reports.entrySet()) {
            String regime = entry.getKey();
            RosettaModelObject report = entry.getValue();

            try {
                String xml = projectReport(regime, report);
                if (xml != null) {
                    projections.put(regime, xml);
                }
            } catch (Exception e) {
                System.err.println("  Projection failed for " + regime + ": " + e.getMessage());
            }
        }

        return projections;
    }

    private String projectReport(String regime, RosettaModelObject report) throws IOException {
        switch (regime) {
            case "ESMA_EMIR": {
                iso20022.auth030.esma.Document doc =
                        esmaProjection.evaluate((ESMAEMIRTransactionReport) report);
                return toXml(doc, Auth030EsmaModelConfig.XML_CONFIG_PATH);
            }
            case "FCA_UKEMIR": {
                iso20022.auth030.fca.Document doc =
                        fcaProjection.evaluate((FCAUKEMIRTransactionReport) report);
                return toXml(doc, Auth030FcaModelConfig.XML_CONFIG_PATH);
            }
            default:
                System.out.println("  No projection available for " + regime
                        + " in DRR 5.20.1 — report generated but not projected");
                return null;
        }
    }

    private static String toXml(Object document, String configPath) throws IOException {
        URL xmlConfig = Resources.getResource(configPath);
        ObjectMapper xmlMapper = RosettaObjectMapperCreator.forXML(xmlConfig.openStream()).create();
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(document);
    }

    private static String toRosettaJson(RosettaModelObject document) {
        return ReportGenerator.toJson(document);
    }
}
