package org.isda.mapper;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.Injector;
import drr.regulation.common.ReportingSide;
import drr.enrichment.common.trade.functions.Create_TransactionReportInstruction;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractTradeCounterparty;

/**
 * Phase 5: Creates a TransactionReportInstruction from a ReportableEvent.
 *
 * Uses DRR's Create_TransactionReportInstruction function which enriches the
 * report instruction with regulatory static data (UPI, UTI lookup, LEI validation, etc.).
 */
public final class ReportInstructionMapper {

    private final Create_TransactionReportInstruction createInstruction;
    private final ExtractTradeCounterparty extractCounterparty;

    public ReportInstructionMapper(Injector injector) {
        this.createInstruction = injector.getInstance(Create_TransactionReportInstruction.class);
        this.extractCounterparty = injector.getInstance(ExtractTradeCounterparty.class);
    }

    public TransactionReportInstruction map(ReportableEvent reportableEvent) {
        ReportingSide reportingSide = buildReportingSide(reportableEvent);
        return createInstruction.evaluate(reportableEvent, reportingSide);
    }

    private ReportingSide buildReportingSide(ReportableEvent reportableEvent) {
        ReferenceWithMetaParty party1 = extractCounterparty
                .evaluate(reportableEvent, CounterpartyRoleEnum.PARTY_1)
                .getPartyReference();

        ReferenceWithMetaParty party2 = extractCounterparty
                .evaluate(reportableEvent, CounterpartyRoleEnum.PARTY_2)
                .getPartyReference();

        return ReportingSide.builder()
                .setReportingParty(party1)
                .setReportingCounterparty(party2)
                .build();
    }
}
