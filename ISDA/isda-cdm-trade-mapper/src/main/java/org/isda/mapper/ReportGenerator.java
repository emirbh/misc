package org.isda.mapper;

import com.google.inject.Injector;
import com.regnosys.rosetta.common.serialisation.RosettaObjectMapper;
import com.rosetta.model.lib.RosettaModelObject;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.cftc.rewrite.trade.reports.CFTCPart43ReportFunction;
import drr.regulation.cftc.rewrite.trade.reports.CFTCPart45ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.regulation.esma.emir.refit.trade.reports.ESMAEMIRTradeReportFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.regulation.fca.ukemir.refit.trade.reports.FCAUKEMIRTradeReportFunction;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Phase 6: Runs DRR report functions for multiple regimes against a
 * TransactionReportInstruction and collects the results.
 */
public final class ReportGenerator {

    private final CFTCPart45ReportFunction cftcPart45;
    private final CFTCPart43ReportFunction cftcPart43;
    private final ESMAEMIRTradeReportFunction esmaEmir;
    private final FCAUKEMIRTradeReportFunction fcaUkEmir;

    public ReportGenerator(Injector injector) {
        this.cftcPart45 = injector.getInstance(CFTCPart45ReportFunction.class);
        this.cftcPart43 = injector.getInstance(CFTCPart43ReportFunction.class);
        this.esmaEmir = injector.getInstance(ESMAEMIRTradeReportFunction.class);
        this.fcaUkEmir = injector.getInstance(FCAUKEMIRTradeReportFunction.class);
    }

    /**
     * Generates reports for all configured regimes.
     * Returns a map of regime name → report object.
     */
    public Map<String, RosettaModelObject> generateAll(TransactionReportInstruction instruction) {
        Map<String, RosettaModelObject> reports = new LinkedHashMap<>();

        try {
            CFTCPart45TransactionReport part45 = cftcPart45.evaluate(instruction);
            reports.put("CFTCPart45", part45);
        } catch (Exception e) {
            System.err.println("  CFTC Part 45 failed: " + e.getMessage());
        }

        try {
            CFTCPart43TransactionReport part43 = cftcPart43.evaluate(instruction);
            reports.put("CFTCPart43", part43);
        } catch (Exception e) {
            System.err.println("  CFTC Part 43 failed: " + e.getMessage());
        }

        try {
            ESMAEMIRTransactionReport esma = esmaEmir.evaluate(instruction);
            reports.put("ESMA_EMIR", esma);
        } catch (Exception e) {
            System.err.println("  ESMA EMIR failed: " + e.getMessage());
        }

        try {
            FCAUKEMIRTransactionReport fca = fcaUkEmir.evaluate(instruction);
            reports.put("FCA_UKEMIR", fca);
        } catch (Exception e) {
            System.err.println("  FCA UK EMIR failed: " + e.getMessage());
        }

        return reports;
    }

    public static String toJson(RosettaModelObject report) {
        try {
            return RosettaObjectMapper.getNewRosettaObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(report);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialise report", e);
        }
    }
}
