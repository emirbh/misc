package drr.regulation.common.trade.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.functions.RateOption;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingRateIdentifierRule.FloatingRateIdentifierRuleDefault.class)
public abstract class FloatingRateIdentifierRule implements ReportFunction<InterestRatePayout, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected RateOption rateOption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(InterestRatePayout input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(InterestRatePayout input);

	public static class FloatingRateIdentifierRuleDefault extends FloatingRateIdentifierRule {
		@Override
		protected String doEvaluate(InterestRatePayout input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, InterestRatePayout input) {
			final MapperS<InterestRateIndex> thenArg0 = MapperS.of(rateOption.evaluate(input));
			final MapperS<InterestRateIndex> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(item.<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<AssetIdentifier>mapC("getIdentifier", floatingRateIndex -> floatingRateIndex.getIdentifier()).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.Any).get());
			final FieldWithMetaString fieldWithMetaString = thenArg1
				.mapSingleToItem(item -> MapperS.of(item.<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<AssetIdentifier>mapC("getIdentifier", floatingRateIndex -> floatingRateIndex.getIdentifier()).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
