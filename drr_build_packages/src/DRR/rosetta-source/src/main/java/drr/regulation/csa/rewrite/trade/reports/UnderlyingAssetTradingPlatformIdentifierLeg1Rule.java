package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.qualification.product.functions.IsEquityForward;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg1Aligned;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetTradingPlatformIdentifierLeg2Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetTradingPlatformIdentifierLeg1Rule.UnderlyingAssetTradingPlatformIdentifierLeg1RuleDefault.class)
public abstract class UnderlyingAssetTradingPlatformIdentifierLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg1Aligned isCSALeg1Aligned;
	@Inject protected IsEquity isEquity;
	@Inject protected IsEquityForward isEquityForward;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetTradingPlatformIdentifierLeg1Rule underlyingAssetTradingPlatformIdentifierLeg1Rule;
	@Inject protected UnderlyingAssetTradingPlatformIdentifierLeg2Rule underlyingAssetTradingPlatformIdentifierLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingAssetTradingPlatformIdentifierLeg1RuleDefault extends UnderlyingAssetTradingPlatformIdentifierLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(productForEvent.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquityForward.evaluate(productForEvent.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))))).getOrDefault(false)) {
						if (areEqual(MapperS.of(isCSALeg1Aligned.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
							final String string0 = underlyingAssetTradingPlatformIdentifierLeg1Rule.evaluate(item.get());
							return string0 == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string0).build());
						}
						final String string1 = underlyingAssetTradingPlatformIdentifierLeg2Rule.evaluate(item.get());
						return string1 == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string1).build());
					}
					return MapperS.<FieldWithMetaString>ofNull();
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
