package drr.ingest.fpml.recordkeeping.message.functions;

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
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.AllocationReportingStatus;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReport;
import fpml.consolidated.shared.OriginatingEvent;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapIntent.MapIntentDefault.class)
public abstract class MapIntent implements RosettaFunction {

	/**
	* @param fpmlNonpublicExecutionReport 
	* @return intent 
	*/
	public EventIntentEnum evaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
		EventIntentEnum intent = doEvaluate(fpmlNonpublicExecutionReport);
		
		return intent;
	}

	protected abstract EventIntentEnum doEvaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperC<? extends PartyTradeInformation> partyTradeInformation(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperC<? extends PartyTradeInformation> clearing(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperC<Boolean> intentToAllocate(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	protected abstract MapperC<Boolean> postAllocation(NonpublicExecutionReport fpmlNonpublicExecutionReport);

	public static class MapIntentDefault extends MapIntent {
		@Override
		protected EventIntentEnum doEvaluate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			EventIntentEnum intent = null;
			return assignOutput(intent, fpmlNonpublicExecutionReport);
		}
		
		protected EventIntentEnum assignOutput(EventIntentEnum intent, NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			intent = MapperS.of(fpmlNonpublicExecutionReport)
				.mapSingleToItem(item -> {
					if (areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Netting"), CardinalityOperator.All).orNullSafe(areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("PortfolioCompression"), CardinalityOperator.All)).orNullSafe(areEqual(item.<TerminatingEvent>map("getTerminatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTerminatingEvent()).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("PortfolioCompression"), CardinalityOperator.All)).orNullSafe(areEqual(item.<TerminatingEvent>map("getTerminatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTerminatingEvent()).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("Netting"), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.COMPRESSION);
					}
					if (ComparisonResult.ofNullSafe(postAllocation(fpmlNonpublicExecutionReport)
						.first()).andNullSafe(exists(intentToAllocate(fpmlNonpublicExecutionReport))).orNullSafe(areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Allocation"), CardinalityOperator.All)).orNullSafe(areEqual(item.<TerminatingEvent>map("getTerminatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTerminatingEvent()).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("Allocation"), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.ALLOCATION);
					}
					if (areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("PortfolioRebalancing"), CardinalityOperator.All).orNullSafe(areEqual(item.<TerminatingEvent>map("getTerminatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getTerminatingEvent()).<String>map("getValue", terminatingEvent -> terminatingEvent.getValue()), MapperS.of("PortfolioRebalancing"), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.PORTFOLIO_REBALANCING);
					}
					if (areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Trade"), CardinalityOperator.All).orNullSafe(areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("ForwardAgainstFixing"), CardinalityOperator.All)).orNullSafe(exists(item.<Trade>map("getTrade", nonpublicExecutionReport -> nonpublicExecutionReport.getTrade()))).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.CONTRACT_FORMATION);
					}
					if (areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Novation"), CardinalityOperator.All).orNullSafe(exists(item.<TradeNovationContent>map("getNovation", nonpublicExecutionReport -> nonpublicExecutionReport.getNovation()))).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.NOVATION);
					}
					if (exists(item.<OptionExercise>map("getOptionExercise", nonpublicExecutionReport -> nonpublicExecutionReport.getOptionExercise())).orNullSafe(areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("Exercise"), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.OPTION_EXERCISE);
					}
					if (exists(item.<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment())).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.CONTRACT_TERMS_AMENDMENT);
					}
					if (exists(clearing(fpmlNonpublicExecutionReport)).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.CLEARING);
					}
					if (areEqual(item.<OriginatingEvent>map("getOriginatingEvent", nonpublicExecutionReport -> nonpublicExecutionReport.getOriginatingEvent()).<String>map("getValue", originatingEvent -> originatingEvent.getValue()), MapperS.of("CreditEvent"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(EventIntentEnum.CREDIT_EVENT);
					}
					return MapperS.<EventIntentEnum>ofNull();
				}).get();
			
			return intent;
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> partyTradeInformation(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return MapperS.of(fpmlNonpublicExecutionReport).<Trade>map("getTrade", nonpublicExecutionReport -> nonpublicExecutionReport.getTrade()).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation());
		}
		
		@Override
		protected MapperC<? extends PartyTradeInformation> clearing(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			final MapperS<NonpublicExecutionReport> thenArg0 = MapperS.of(fpmlNonpublicExecutionReport);
			final MapperC<Trade> thenArg1 = MapperC.<Trade>of(thenArg0.<Trade>map("getTrade", nonpublicExecutionReport -> nonpublicExecutionReport.getTrade()), thenArg0.<TradeAmendmentContent>map("getAmendment", nonpublicExecutionReport -> nonpublicExecutionReport.getAmendment()).<Trade>map("getTrade", tradeAmendmentContent -> tradeAmendmentContent.getTrade()));
			return MapperC.<PartyTradeInformation>of(thenArg1.<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()))
				.filterItemNullSafe(item -> areEqual(item.<Boolean>map("getIntentToClear", _partyTradeInformation -> _partyTradeInformation.getIntentToClear()), MapperS.of(true), CardinalityOperator.All).get());
		}
		
		@Override
		protected MapperC<Boolean> intentToAllocate(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return partyTradeInformation(fpmlNonpublicExecutionReport)
				.mapItem(item -> areEqual(item.<Boolean>map("getIntentToAllocate", _partyTradeInformation -> _partyTradeInformation.getIntentToAllocate()), MapperS.of(true), CardinalityOperator.All).asMapper());
		}
		
		@Override
		protected MapperC<Boolean> postAllocation(NonpublicExecutionReport fpmlNonpublicExecutionReport) {
			return partyTradeInformation(fpmlNonpublicExecutionReport)
				.mapItem(item -> areEqual(item.<AllocationReportingStatus>map("getAllocationStatus", _partyTradeInformation -> _partyTradeInformation.getAllocationStatus()).<String>map("getValue", allocationReportingStatus -> allocationReportingStatus.getValue()), MapperS.of("PostAllocation"), CardinalityOperator.All).asMapper());
		}
	}
}
