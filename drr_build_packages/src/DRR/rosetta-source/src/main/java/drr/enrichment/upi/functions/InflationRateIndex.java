package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(InflationRateIndex.InflationRateIndexDefault.class)
public abstract class InflationRateIndex implements RosettaFunction {

	/**
	* @param interestRatePayout 
	* @return inflationRateIndex 
	*/
	public InflationRateIndexEnum evaluate(InterestRatePayout interestRatePayout) {
		InflationRateIndexEnum inflationRateIndex = doEvaluate(interestRatePayout);
		
		return inflationRateIndex;
	}

	protected abstract InflationRateIndexEnum doEvaluate(InterestRatePayout interestRatePayout);

	public static class InflationRateIndexDefault extends InflationRateIndex {
		@Override
		protected InflationRateIndexEnum doEvaluate(InterestRatePayout interestRatePayout) {
			InflationRateIndexEnum inflationRateIndex = null;
			return assignOutput(inflationRateIndex, interestRatePayout);
		}
		
		protected InflationRateIndexEnum assignOutput(InflationRateIndexEnum inflationRateIndex, InterestRatePayout interestRatePayout) {
			if (exists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).getOrDefault(false)) {
				final FieldWithMetaInflationRateIndexEnum fieldWithMetaInflationRateIndexEnum = MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex == null ? null : referenceWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaInflationRateIndexEnum>map("getInflationRateIndex", inflationIndex -> inflationIndex.getInflationRateIndex()).get();
				if (fieldWithMetaInflationRateIndexEnum == null) {
					inflationRateIndex = null;
				} else {
					inflationRateIndex = fieldWithMetaInflationRateIndexEnum.getValue();
				}
			} else {
				inflationRateIndex = null;
			}
			
			return inflationRateIndex;
		}
	}
}
