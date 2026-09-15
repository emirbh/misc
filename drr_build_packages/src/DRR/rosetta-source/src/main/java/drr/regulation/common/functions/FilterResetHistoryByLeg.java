package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.event.common.Reset;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.Index;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.event.Observation;
import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.metafields.ReferenceWithMetaObservation;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradeStateForEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FilterResetHistoryByLeg.FilterResetHistoryByLegDefault.class)
public abstract class FilterResetHistoryByLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param reportableEvent 
	* @param payoutLeg 
	* @return resetHistory 
	*/
	public List<? extends Reset> evaluate(ReportableEventBase reportableEvent, PayoutLegWithAuxiliary payoutLeg) {
		List<Reset.ResetBuilder> resetHistoryBuilder = doEvaluate(reportableEvent, payoutLeg);
		
		final List<? extends Reset> resetHistory;
		if (resetHistoryBuilder == null) {
			resetHistory = null;
		} else {
			resetHistory = resetHistoryBuilder.stream().map(Reset::build).collect(Collectors.toList());
			objectValidator.validate(Reset.class, resetHistory);
		}
		
		return resetHistory;
	}

	protected abstract List<Reset.ResetBuilder> doEvaluate(ReportableEventBase reportableEvent, PayoutLegWithAuxiliary payoutLeg);

	public static class FilterResetHistoryByLegDefault extends FilterResetHistoryByLeg {
		@Override
		protected List<Reset.ResetBuilder> doEvaluate(ReportableEventBase reportableEvent, PayoutLegWithAuxiliary payoutLeg) {
			List<Reset.ResetBuilder> resetHistory = new ArrayList<>();
			return assignOutput(resetHistory, reportableEvent, payoutLeg);
		}
		
		protected List<Reset.ResetBuilder> assignOutput(List<Reset.ResetBuilder> resetHistory, ReportableEventBase reportableEvent, PayoutLegWithAuxiliary payoutLeg) {
			if (exists(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Reset>mapC("getResetHistory", tradeState -> tradeState.getResetHistory()).<ReferenceWithMetaObservation>mapC("getObservations", reset -> reset.getObservations()).<Observation>map("Type coercion", referenceWithMetaObservation -> referenceWithMetaObservation.getValue()).<ObservationIdentifier>map("getObservationIdentifier", observation -> observation.getObservationIdentifier()).<Observable>map("getObservable", observationIdentifier -> observationIdentifier.getObservable()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex())).getOrDefault(false)) {
				resetHistory.addAll(toBuilder(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Reset>mapC("getResetHistory", tradeState -> tradeState.getResetHistory())
					.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaObservation>mapC("getObservations", reset -> reset.getObservations()).<Observation>map("Type coercion", referenceWithMetaObservation -> referenceWithMetaObservation.getValue()).<ObservationIdentifier>map("getObservationIdentifier", observation -> observation.getObservationIdentifier()).<Observable>map("getObservable", observationIdentifier -> observationIdentifier.getObservable()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()), MapperS.of(payoutLeg).<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()), CardinalityOperator.Any).orNullSafe(areEqual(item.<ReferenceWithMetaObservation>mapC("getObservations", reset -> reset.getObservations()).<Observation>map("Type coercion", referenceWithMetaObservation -> referenceWithMetaObservation.getValue()).<ObservationIdentifier>map("getObservationIdentifier", observation -> observation.getObservationIdentifier()).<Observable>map("getObservable", observationIdentifier -> observationIdentifier.getObservable()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex -> fieldWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()), MapperS.of(payoutLeg).<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()), CardinalityOperator.Any)).get()).getMulti()));
			} else if (exists(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Reset>mapC("getResetHistory", tradeState -> tradeState.getResetHistory()).<ReferenceWithMetaObservation>mapC("getObservations", reset -> reset.getObservations()).<Observation>map("Type coercion", referenceWithMetaObservation -> referenceWithMetaObservation.getValue()).<ObservationIdentifier>map("getObservationIdentifier", observation -> observation.getObservationIdentifier()).<Observable>map("getObservable", observationIdentifier -> observationIdentifier.getObservable()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())).getOrDefault(false)) {
				resetHistory.addAll(toBuilder(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Reset>mapC("getResetHistory", tradeState -> tradeState.getResetHistory())
					.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaObservation>mapC("getObservations", reset -> reset.getObservations()).<Observation>map("Type coercion", referenceWithMetaObservation -> referenceWithMetaObservation.getValue()).<ObservationIdentifier>map("getObservationIdentifier", observation -> observation.getObservationIdentifier()).<Observable>map("getObservable", observationIdentifier -> observationIdentifier.getObservable()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()), MapperS.of(payoutLeg).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier()), CardinalityOperator.All).get()).getMulti()));
			} else {
				resetHistory.addAll(toBuilder(Collections.<Reset>emptyList()));
			}
			
			return Optional.ofNullable(resetHistory)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
