package drr.regulation.common.trade.underlier.reports;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.functions.GetIndexIndicatorFromFloatingRate;
import drr.regulation.common.functions.RateOption;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;


@ImplementedBy(FloatingRateIndicatorRule.FloatingRateIndicatorRuleDefault.class)
public abstract class FloatingRateIndicatorRule implements ReportFunction<InterestRatePayout, IndexEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetIndexIndicatorFromFloatingRate getIndexIndicatorFromFloatingRate;
	@Inject protected RateOption rateOption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public IndexEnum evaluate(InterestRatePayout input) {
		IndexEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract IndexEnum doEvaluate(InterestRatePayout input);

	public static class FloatingRateIndicatorRuleDefault extends FloatingRateIndicatorRule {
		@Override
		protected IndexEnum doEvaluate(InterestRatePayout input) {
			IndexEnum output = null;
			return assignOutput(output, input);
		}
		
		protected IndexEnum assignOutput(IndexEnum output, InterestRatePayout input) {
			final MapperS<InterestRateIndex> thenArg = MapperS.of(rateOption.evaluate(input));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(getIndexIndicatorFromFloatingRate.evaluate(item.<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString).get()))).get();
			
			return output;
		}
	}
}
