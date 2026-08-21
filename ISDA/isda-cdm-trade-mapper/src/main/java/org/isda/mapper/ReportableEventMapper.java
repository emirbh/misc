package org.isda.mapper;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import drr.base.trade.ConfirmationMethodEnum;
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.base.trade.PartyInformation;
import drr.regulation.common.*;

import java.util.Collections;

/**
 * Phase 4: Creates a DRR ReportableEvent from a CDM WorkflowStep.
 *
 * Adds ReportableInformation (reporting party, regime, venue, confirmation method)
 * which CDM does not carry but DRR requires.
 */
public final class ReportableEventMapper {

    private ReportableEventMapper() {}

    public static ReportableEvent map(SwapTrade trade, WorkflowStep workflowStep,
                                       TradeState reportableTrade) {
        return ReportableEvent.builder()
                .setOriginatingWorkflowStep(workflowStep)
                .setReportableTrade(reportableTrade)
                .setReportableInformation(buildReportableInformation(trade, workflowStep))
                .build();
    }

    /**
     * DRR 7 inverts the Phase 4 shape: jurisdictions are top level, each
     * carrying its own transaction and party detail, rather than parties each
     * carrying a list of regimes.
     */
    private static ReportableInformation buildReportableInformation(SwapTrade trade,
                                                                      WorkflowStep workflowStep) {
        return ReportableInformation.builder()
                .setConfirmationMethod(mapConfirmationMethod(trade.getConfirmationMethod()))
                .addGlobalPartyInformation(partyInformation("Party1"))
                .addGlobalPartyInformation(partyInformation("Party2"))
                .addJurisdictionInformation(buildJurisdictionInfo(trade))
                .build();
    }

    private static PartyInformation partyInformation(String externalReference) {
        return PartyInformation.builder()
                .setPartyReference(
                        cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                .setExternalReference(externalReference))
                .build();
    }

    private static ReportableJurisdictionInformation buildJurisdictionInfo(SwapTrade trade) {
        MandatorilyClearableEnum clearable = mapClearingStatus(trade.getClearingStatus());

        return ReportableJurisdictionInformation.builder()
                .setRegimeNameValue(RegimeNameEnum.DODD_FRANK_ACT)
                .setSupervisoryBodyValue(SupervisoryBodyEnum.CFTC)
                .setTransactionInformation(TransactionInformation.builder()
                        .setReportableExecutionVenue(ReportableExecutionVenue.builder()
                                .setExecutionVenueType(mapExecutionVenue(trade.getExecutionVenue())))
                        .setLargeSizeTrade(false))
                .addPartyInformation(jurisdictionParty(
                        "Party1", ReportingRoleEnum.REPORTING_PARTY, clearable))
                .addPartyInformation(jurisdictionParty(
                        "Party2", ReportingRoleEnum.COUNTERPARTY, clearable))
                .build();
    }

    private static JurisdictionPartyInformation jurisdictionParty(String externalReference,
                                                                  ReportingRoleEnum role,
                                                                  MandatorilyClearableEnum clearable) {
        return JurisdictionPartyInformation.builder()
                .setPartyReference(
                        cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                .setExternalReference(externalReference))
                .setReportingRole(role)
                .setMandatorilyClearable(clearable)
                .build();
    }

    static ConfirmationMethodEnum mapConfirmationMethod(String method) {
        if (method == null) return ConfirmationMethodEnum.ELECTRONIC;
        switch (method) {
            case "ELECTRONIC": return ConfirmationMethodEnum.ELECTRONIC;
            case "NON_ELECTRONIC": return ConfirmationMethodEnum.NON_ELECTRONIC;
            default: return ConfirmationMethodEnum.ELECTRONIC;
        }
    }

    /**
     * Accepts both the MIC codes used by the JSON/CSV feeds and the FpML
     * enum spellings that arrive from FpML and CitiML documents. Without the
     * latter, an explicit "OffFacility" would fall through to SEF and be
     * reported as an on-facility execution.
     */
    static ExecutionVenueTypeEnum mapExecutionVenue(String venue) {
        if (venue == null) return ExecutionVenueTypeEnum.OFF_FACILITY;
        switch (venue) {
            case "XXXX":
            case "XOFF":
            case "OffFacility": return ExecutionVenueTypeEnum.OFF_FACILITY;
            case "SEF":         return ExecutionVenueTypeEnum.SEF;
            case "DCM":         return ExecutionVenueTypeEnum.DCM;
            case "MTF":         return ExecutionVenueTypeEnum.MTF;
            case "OTF":         return ExecutionVenueTypeEnum.OTF;
            case "ETP":         return ExecutionVenueTypeEnum.ETP;
            default:            return ExecutionVenueTypeEnum.SEF;
        }
    }

    static MandatorilyClearableEnum mapClearingStatus(String status) {
        if (status == null) return MandatorilyClearableEnum.PRODUCT_NOT_MANDATORY;
        switch (status) {
            case "CLEARED": return MandatorilyClearableEnum.PRODUCT_AND_CPTY_MANDATORY;
            case "INTENDED": return MandatorilyClearableEnum.PRODUCT_MANDATORY_BUT_NOT_CPTY;
            case "UNCLEARED":
            default: return MandatorilyClearableEnum.PRODUCT_NOT_MANDATORY;
        }
    }
}
