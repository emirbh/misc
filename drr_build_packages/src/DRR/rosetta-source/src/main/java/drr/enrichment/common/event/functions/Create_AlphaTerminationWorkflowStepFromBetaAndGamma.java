package drr.enrichment.common.event.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.ActionEnum;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.PartyChangeInstruction;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_PartyChange;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.functions.TradeStateForEvent;
import drr.regulation.common.ReportableEvent;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AlphaTerminationWorkflowStepFromBetaAndGamma.Create_AlphaTerminationWorkflowStepFromBetaAndGammaDefault.class)
public abstract class Create_AlphaTerminationWorkflowStepFromBetaAndGamma implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyChange create_PartyChange;
	@Inject protected TradeForEvent tradeForEvent;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param betaReportableEvent 
	* @param alphaUTI 
	* @param ccpPartyReference 
	* @param betaCounterparty 
	* @param gammaCounterparty 
	* @return proposedAlphaTerm 
	*/
	public WorkflowStep evaluate(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty) {
		WorkflowStep.WorkflowStepBuilder proposedAlphaTermBuilder = doEvaluate(betaReportableEvent, alphaUTI, ccpPartyReference, betaCounterparty, gammaCounterparty);
		
		final WorkflowStep proposedAlphaTerm;
		if (proposedAlphaTermBuilder == null) {
			proposedAlphaTerm = null;
		} else {
			proposedAlphaTerm = proposedAlphaTermBuilder.build();
			objectValidator.validate(WorkflowStep.class, proposedAlphaTerm);
		}
		
		return proposedAlphaTerm;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty);

	protected abstract MapperS<? extends FieldWithMetaString> betaCurrency(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty);

	protected abstract MapperS<CounterpartyRoleEnum> clearingCounterpartyRole(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty);

	protected abstract MapperS<? extends PartyChangeInstruction> partyChangeInstruction(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty);

	public static class Create_AlphaTerminationWorkflowStepFromBetaAndGammaDefault extends Create_AlphaTerminationWorkflowStepFromBetaAndGamma {
		@Override
		protected WorkflowStep.WorkflowStepBuilder doEvaluate(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty) {
			WorkflowStep.WorkflowStepBuilder proposedAlphaTerm = WorkflowStep.builder();
			return assignOutput(proposedAlphaTerm, betaReportableEvent, alphaUTI, ccpPartyReference, betaCounterparty, gammaCounterparty);
		}
		
		protected WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder proposedAlphaTerm, ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty) {
			final TradeState tradeState = create_PartyChange.evaluate(partyChangeInstruction(betaReportableEvent, alphaUTI, ccpPartyReference, betaCounterparty, gammaCounterparty).<Counterparty>map("getCounterparty", _partyChangeInstruction -> _partyChangeInstruction.getCounterparty()).get(), null, null, partyChangeInstruction(betaReportableEvent, alphaUTI, ccpPartyReference, betaCounterparty, gammaCounterparty).<TradeIdentifier>mapC("getTradeId", _partyChangeInstruction -> _partyChangeInstruction.getTradeId()).getMulti(), tradeStateForEvent.evaluate(betaReportableEvent));
			proposedAlphaTerm
				.getOrCreateProposedEvent()
				.getOrCreateInstruction(0)
				.setBefore((tradeState == null ? ReferenceWithMetaTradeState.builder().build() : ReferenceWithMetaTradeState.builder().setValue(tradeState).build()));
			
			final NonNegativeQuantitySchedule nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder()
				.setValue(BigDecimal.valueOf(0))
				.setUnit(UnitType.builder()
					.setCurrency(betaCurrency(betaReportableEvent, alphaUTI, ccpPartyReference, betaCounterparty, gammaCounterparty).get())
					.build())
				.build();
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantityValue((nonNegativeQuantitySchedule == null ? Collections.<NonNegativeQuantitySchedule>emptyList() : Collections.singletonList(nonNegativeQuantitySchedule)))
				.build();
			proposedAlphaTerm
				.getOrCreateProposedEvent()
				.getOrCreateInstruction(0)
				.getOrCreatePrimitiveInstruction()
				.setQuantityChange(QuantityChangeInstruction.builder()
					.setChange((priceQuantity == null ? Collections.<PriceQuantity>emptyList() : Collections.singletonList(priceQuantity)))
					.setDirection(QuantityChangeDirectionEnum.REPLACE)
					.setLotIdentifier(Collections.<Identifier>emptyList())
					.build());
			
			proposedAlphaTerm
				.getOrCreateNextEvent()
				.setIntent(EventIntentEnum.CLEARING);
			
			proposedAlphaTerm
				.getOrCreateProposedEvent()
				.setIntent(EventIntentEnum.CLEARING);
			
			final MapperC<EventTimestamp> thenArg = MapperS.of(betaReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEvent -> reportableEvent.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp())
				.filterItemNullSafe(item -> areEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.EXECUTION_DATE_TIME), CardinalityOperator.All).get());
			proposedAlphaTerm
				.addTimestamp(thenArg
					.min(item -> item.<ZonedDateTime>map("getDateTime", eventTimestamp -> eventTimestamp.getDateTime()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate()))).getMulti());
			
			proposedAlphaTerm
				.addTimestamp(MapperS.of(betaReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEvent -> reportableEvent.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp())
					.filterItemNullSafe(item -> notEqual(item.<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.EXECUTION_DATE_TIME), CardinalityOperator.Any).get()).getMulti());
			
			proposedAlphaTerm
				.addEventIdentifier(MapperS.of(betaReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEvent -> reportableEvent.getOriginatingWorkflowStep()).<Identifier>mapC("getEventIdentifier", workflowStep -> workflowStep.getEventIdentifier()).getMulti());
			
			proposedAlphaTerm
				.setAction(ActionEnum.NEW);
			
			return Optional.ofNullable(proposedAlphaTerm)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> betaCurrency(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty) {
			return MapperS.of(distinctIgnoringPrecision(MapperS.of(tradeForEvent.evaluate(betaReportableEvent)).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
		}
		
		@Override
		protected MapperS<CounterpartyRoleEnum> clearingCounterpartyRole(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty) {
			final MapperC<Counterparty> thenArg = MapperS.of(tradeForEvent.evaluate(betaReportableEvent)).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty())
				.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(ccpPartyReference), CardinalityOperator.All).get());
			return MapperS.of(thenArg.<CounterpartyRoleEnum>map("getRole", counterparty -> counterparty.getRole()).get());
		}
		
		@Override
		protected MapperS<? extends PartyChangeInstruction> partyChangeInstruction(ReportableEvent betaReportableEvent, TradeIdentifier alphaUTI, Party ccpPartyReference, Counterparty betaCounterparty, Counterparty gammaCounterparty) {
			return MapperS.of(PartyChangeInstruction.builder()
				.setCounterparty(Counterparty.builder()
					.setRole(clearingCounterpartyRole(betaReportableEvent, alphaUTI, ccpPartyReference, betaCounterparty, gammaCounterparty).get())
					.setPartyReference(MapperS.of(gammaCounterparty).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get())
					.build())
				.setTradeId((alphaUTI == null ? Collections.<TradeIdentifier>emptyList() : Collections.singletonList(alphaUTI)))
				.build());
		}
	}
}
