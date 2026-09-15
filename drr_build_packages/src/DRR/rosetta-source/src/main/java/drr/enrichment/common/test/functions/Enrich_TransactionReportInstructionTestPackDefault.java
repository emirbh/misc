package drr.enrichment.common.test.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.transform.Enrich;
import drr.base.trade.ReportingSide;
import drr.enrichment.common.test.labels.Enrich_TransactionReportInstructionTestPackDefaultLabelProvider;
import drr.enrichment.common.trade.functions.Create_ReportableEventFromInstruction;
import drr.enrichment.common.trade.functions.Create_TransactionReportInstruction;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Enrich_TransactionReportInstructionTestPackDefaultLabelProvider.class)
@Enrich()
@ImplementedBy(Enrich_TransactionReportInstructionTestPackDefault.Enrich_TransactionReportInstructionTestPackDefaultDefault.class)
public abstract class Enrich_TransactionReportInstructionTestPackDefault implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ReportableEventFromInstruction create_ReportableEventFromInstruction;
	@Inject protected Create_TransactionReportInstruction create_TransactionReportInstruction;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected ExtractPartyByNameContains extractPartyByNameContains;
	@Inject protected ExtractReportableTrade extractReportableTrade;
	@Inject protected FilterPartyNoMatch filterPartyNoMatch;

	/**
	* @param reportableEvent ReportableEvent containing a proposed BusinessEvent (i.e. the output sample from an Ingestion).
	* @return transactionReportInstruction TransactionReportInstruction containing a BusinessEvent and a ReportingSide (i.e. the input sample for a Report).
	*/
	public TransactionReportInstruction evaluate(ReportableEvent reportableEvent) {
		TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstructionBuilder = doEvaluate(reportableEvent);
		
		final TransactionReportInstruction transactionReportInstruction;
		if (transactionReportInstructionBuilder == null) {
			transactionReportInstruction = null;
		} else {
			transactionReportInstruction = transactionReportInstructionBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, transactionReportInstruction);
		}
		
		return transactionReportInstruction;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends ReportableEvent> acceptedReportableEvent(ReportableEvent reportableEvent);

	protected abstract MapperC<? extends Party> parties(ReportableEvent reportableEvent);

	protected abstract MapperC<? extends Counterparty> counterparties(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends Party> reportingParty(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends Party> reportingCounterpartyRole(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends Party> partyResponsibleForReporting(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends Party> reportSubmittingParty(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends ReportingSide> reportingSide(ReportableEvent reportableEvent);

	protected abstract MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent);

	public static class Enrich_TransactionReportInstructionTestPackDefaultDefault extends Enrich_TransactionReportInstructionTestPackDefault {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent) {
			TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction = TransactionReportInstruction.builder();
			return assignOutput(transactionReportInstruction, reportableEvent);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction, ReportableEvent reportableEvent) {
			transactionReportInstruction = toBuilder(create_TransactionReportInstruction.evaluate(enrichedReportableEvent(reportableEvent).get(), reportingSide(reportableEvent).get()));
			
			return Optional.ofNullable(transactionReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReportableEvent> acceptedReportableEvent(ReportableEvent reportableEvent) {
			return MapperS.of(create_ReportableEventFromInstruction.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperC<? extends Party> parties(ReportableEvent reportableEvent) {
			return acceptedReportableEvent(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<Party>mapC("getParty", workflowStep -> workflowStep.getParty());
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterparties(ReportableEvent reportableEvent) {
			return acceptedReportableEvent(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter())
				.first().<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty());
		}
		
		@Override
		protected MapperS<? extends Party> reportingParty(ReportableEvent reportableEvent) {
			final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(extractCounterpartyByRole.evaluate(counterparties(reportableEvent).getMulti(), CounterpartyRoleEnum.PARTY_1)).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			return MapperS.of(MapperS.of(extractPartyByNameContains.evaluate(parties(reportableEvent).getMulti(), "reportingParty")).getOrDefault((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
		}
		
		@Override
		protected MapperS<? extends Party> reportingCounterpartyRole(ReportableEvent reportableEvent) {
			final MapperC<Party> thenArg = MapperC.<Party>of(filterPartyNoMatch.evaluate(counterparties(reportableEvent).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty.getValue()).getMulti(), reportingParty(reportableEvent).get())).getMulti().isEmpty() ? MapperC.<Party>of(filterPartyNoMatch.evaluate(parties(reportableEvent).getMulti(), reportingParty(reportableEvent).get())) : MapperC.<Party>of(filterPartyNoMatch.evaluate(counterparties(reportableEvent).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty.getValue()).getMulti(), reportingParty(reportableEvent).get()));
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<? extends Party> partyResponsibleForReporting(ReportableEvent reportableEvent) {
			return MapperS.of(extractPartyByNameContains.evaluate(parties(reportableEvent).getMulti(), "partyResponsibleForReporting"));
		}
		
		@Override
		protected MapperS<? extends Party> reportSubmittingParty(ReportableEvent reportableEvent) {
			return MapperS.of(extractPartyByNameContains.evaluate(parties(reportableEvent).getMulti(), "reportSubmittingParty"));
		}
		
		@Override
		protected MapperS<? extends ReportingSide> reportingSide(ReportableEvent reportableEvent) {
			final Party _reportingParty = reportingParty(reportableEvent).get();
			final Party _partyResponsibleForReporting = partyResponsibleForReporting(reportableEvent).get();
			final Party _reportSubmittingParty = reportSubmittingParty(reportableEvent).get();
			final Party reportingCounterparty = reportingCounterpartyRole(reportableEvent).get();
			return MapperS.of(ReportingSide.builder()
				.setReportingParty(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(_reportingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(_reportingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.setPartyResponsibleForReporting(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(_partyResponsibleForReporting)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(_partyResponsibleForReporting)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.setReportSubmittingParty(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(_reportSubmittingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(_reportSubmittingParty)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.setReportingCounterparty(ReferenceWithMetaParty.builder()
					.setGlobalReference(Optional.ofNullable(reportingCounterparty)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(reportingCounterparty)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build())
				.build());
		}
		
		@Override
		protected MapperS<? extends ReportableEvent> enrichedReportableEvent(ReportableEvent reportableEvent) {
			return MapperS.of(ReportableEvent.builder()
				.setOriginatingWorkflowStep(acceptedReportableEvent(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).get())
				.setReportableTrade(extractReportableTrade.evaluate(acceptedReportableEvent(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).get()))
				.setReportablePosition(acceptedReportableEvent(reportableEvent).<CounterpartyPositionState>map("getReportablePosition", _reportableEvent -> _reportableEvent.getReportablePosition()).get())
				.setReportableInformation(acceptedReportableEvent(reportableEvent).<ReportableInformation>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get())
				.build());
		}
	}
}
