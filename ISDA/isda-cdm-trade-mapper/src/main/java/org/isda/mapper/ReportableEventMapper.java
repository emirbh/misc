package org.isda.mapper;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
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

    private static ReportableInformation buildReportableInformation(SwapTrade trade,
                                                                      WorkflowStep workflowStep) {
        ConfirmationMethodEnum confirmationMethod = mapConfirmationMethod(trade.getConfirmationMethod());
        ExecutionVenueTypeEnum venueType = mapExecutionVenue(trade.getExecutionVenue());

        return ReportableInformation.builder()
                .setConfirmationMethod(confirmationMethod)
                .setExecutionVenueType(venueType)
                .setLargeSizeTrade(false)
                .addPartyInformation(PartyInformation.builder()
                        .setPartyReference(
                                cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                        .setExternalReference("Party1"))
                        .addRegimeInformation(buildRegimeInfo(trade, ReportingRoleEnum.REPORTING_PARTY)))
                .addPartyInformation(PartyInformation.builder()
                        .setPartyReference(
                                cdm.base.staticdata.party.metafields.ReferenceWithMetaParty.builder()
                                        .setExternalReference("Party2"))
                        .addRegimeInformation(buildRegimeInfo(trade, ReportingRoleEnum.COUNTERPARTY)))
                .build();
    }

    private static ReportingRegime buildRegimeInfo(SwapTrade trade, ReportingRoleEnum role) {
        MandatorilyClearableEnum clearable = mapClearingStatus(trade.getClearingStatus());

        return ReportingRegime.builder()
                .setSupervisoryBody(
                        drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum.builder()
                                .setValue(SupervisoryBodyEnum.CFTC))
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

    static ExecutionVenueTypeEnum mapExecutionVenue(String venue) {
        if (venue == null) return ExecutionVenueTypeEnum.OFF_FACILITY;
        switch (venue) {
            case "XXXX":
            case "XOFF": return ExecutionVenueTypeEnum.OFF_FACILITY;
            default: return ExecutionVenueTypeEnum.SEF;
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
