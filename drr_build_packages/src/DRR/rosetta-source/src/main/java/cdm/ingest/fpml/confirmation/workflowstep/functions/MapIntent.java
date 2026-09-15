package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.EventIntentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.OriginatingEvent;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapIntent.MapIntentDefault.class)
public abstract class MapIntent implements RosettaFunction {

	/**
	* @param fpmlTrade 
	* @param fpmlOriginatingEvent 
	* @param fpmlTerminatingEvent 
	* @param fpmlNovation 
	* @param fpmlTermination 
	* @param fpmlAmendment 
	* @param fpmlOptionExercise 
	* @return intent 
	*/
	public EventIntentEnum evaluate(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
		EventIntentEnum intent = doEvaluate(fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise);
		
		return intent;
	}

	protected abstract EventIntentEnum doEvaluate(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise);

	protected abstract MapperC<? extends PartyTradeInformation> partyTradeInformation(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise);

	protected abstract MapperC<? extends PartyTradeInformation> clearing(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise);

	protected abstract MapperC<Boolean> intentToAllocate(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise);

	protected abstract MapperC<Boolean> postAllocation(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise);

	public static class MapIntentDefault extends MapIntent {
		@Override
		protected EventIntentEnum doEvaluate(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
			EventIntentEnum intent = null;
			return assignOutput(intent, fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise);
		}
		
		protected EventIntentEnum assignOutput(EventIntentEnum intent, Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
			if (areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Novation"), CardinalityOperator.All).orNullSafe(exists(MapperS.of(fpmlNovation))).getOrDefault(false)) {
				intent = EventIntentEnum.NOVATION;
			} else if (exists(MapperS.of(fpmlTermination)).getOrDefault(false)) {
				intent = null;
			} else if (areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Netting"), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("PortfolioCompression"), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(fpmlTerminatingEvent).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("PortfolioCompression"), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(fpmlTerminatingEvent).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("Netting"), CardinalityOperator.All)).getOrDefault(false)) {
				intent = EventIntentEnum.COMPRESSION;
			} else if (ComparisonResult.ofNullSafe(postAllocation(fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise)
				.first()).andNullSafe(exists(intentToAllocate(fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise))).orNullSafe(areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Allocation"), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(fpmlTerminatingEvent).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("Allocation"), CardinalityOperator.All)).getOrDefault(false)) {
				intent = EventIntentEnum.ALLOCATION;
			} else if (areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("PortfolioRebalancing"), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(fpmlTerminatingEvent).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("PortfolioRebalancing"), CardinalityOperator.All)).getOrDefault(false)) {
				intent = EventIntentEnum.PORTFOLIO_REBALANCING;
			} else if (exists(MapperS.of(fpmlOptionExercise)).orNullSafe(areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Exercise"), CardinalityOperator.All)).getOrDefault(false)) {
				intent = EventIntentEnum.OPTION_EXERCISE;
			} else if (exists(MapperS.of(fpmlAmendment)).getOrDefault(false)) {
				intent = EventIntentEnum.CONTRACT_TERMS_AMENDMENT;
			} else if (exists(clearing(fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise)).getOrDefault(false)) {
				intent = EventIntentEnum.CLEARING;
			} else if (areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("CreditEvent"), CardinalityOperator.All).getOrDefault(false)) {
				intent = EventIntentEnum.CREDIT_EVENT;
			} else if (areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Trade"), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(fpmlOriginatingEvent).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("ForwardAgainstFixing"), CardinalityOperator.All)).orNullSafe(exists(MapperS.of(fpmlTrade))).getOrDefault(false)) {
				intent = EventIntentEnum.CONTRACT_FORMATION;
			} else {
				intent = null;
			}
			
			return intent;
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> partyTradeInformation(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
			return MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation());
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> clearing(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
			final MapperC<PartyTradeInformation> thenArg = MapperS.of(fpmlTrade)
				.mapSingleToList(item -> item.<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()));
			return thenArg
				.filterItemNullSafe(item -> areEqual(item.<Boolean>map("getIntentToClear", _partyTradeInformation -> _partyTradeInformation.getIntentToClear()), MapperS.of(true), CardinalityOperator.All).get());
		}
		
		@Override
		protected MapperC<Boolean> intentToAllocate(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
			return partyTradeInformation(fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise)
				.mapItem(item -> areEqual(item.<Boolean>map("getIntentToAllocate", _partyTradeInformation -> _partyTradeInformation.getIntentToAllocate()), MapperS.of(true), CardinalityOperator.All).asMapper());
		}
		
		@Override
		protected MapperC<Boolean> postAllocation(Trade fpmlTrade, OriginatingEvent fpmlOriginatingEvent, TerminatingEvent fpmlTerminatingEvent, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment, OptionExercise fpmlOptionExercise) {
			return partyTradeInformation(fpmlTrade, fpmlOriginatingEvent, fpmlTerminatingEvent, fpmlNovation, fpmlTermination, fpmlAmendment, fpmlOptionExercise)
				.mapItem(item -> areEqual(item.<AllocationReportingStatus>map("getAllocationStatus", _partyTradeInformation -> _partyTradeInformation.getAllocationStatus()).<String>map("getValue", allocationReportingStatus -> allocationReportingStatus.getValue()), MapperS.of("PostAllocation"), CardinalityOperator.All).asMapper());
		}
	}
}
