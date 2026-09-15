package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingRateIndex.FloatingRateIndexDefault.class)
public abstract class FloatingRateIndex implements RosettaFunction {

	/**
	* @param interestRatePayout 
	* @return floatingRateIndexName 
	*/
	public String evaluate(InterestRatePayout interestRatePayout) {
		String floatingRateIndexName = doEvaluate(interestRatePayout);
		
		return floatingRateIndexName;
	}

	protected abstract String doEvaluate(InterestRatePayout interestRatePayout);

	protected abstract MapperS<? extends FieldWithMetaFloatingRateIndexEnum> floatingRateIndex(InterestRatePayout interestRatePayout);

	public static class FloatingRateIndexDefault extends FloatingRateIndex {
		@Override
		protected String doEvaluate(InterestRatePayout interestRatePayout) {
			String floatingRateIndexName = null;
			return assignOutput(floatingRateIndexName, interestRatePayout);
		}
		
		protected String assignOutput(String floatingRateIndexName, InterestRatePayout interestRatePayout) {
			floatingRateIndexName = floatingRateIndex(interestRatePayout).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString).get();
			
			return floatingRateIndexName;
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaFloatingRateIndexEnum> floatingRateIndex(InterestRatePayout interestRatePayout) {
			if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).getOrDefault(false)) {
				return MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateIndex -> _floatingRateIndex.getFloatingRateIndex());
			}
			if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).getOrDefault(false)) {
				return MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateIndex -> _floatingRateIndex.getFloatingRateIndex());
			}
			return MapperS.<FieldWithMetaFloatingRateIndexEnum>ofNull();
		}
	}
}
