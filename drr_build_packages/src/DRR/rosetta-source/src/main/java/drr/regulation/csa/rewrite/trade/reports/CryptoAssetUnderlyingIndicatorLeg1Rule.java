package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommoditySwapFixedFloat;
import drr.base.qualification.product.functions.IsCommoditySwapFloatFloat;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg1Aligned;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg2Aligned;
import drr.standards.iosco.cde.version3.underlier.reports.CryptoAssetUnderlyingIndicatorRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CryptoAssetUnderlyingIndicatorLeg1Rule.CryptoAssetUnderlyingIndicatorLeg1RuleDefault.class)
public abstract class CryptoAssetUnderlyingIndicatorLeg1Rule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CryptoAssetUnderlyingIndicatorRule cryptoAssetUnderlyingIndicatorRule;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg1Aligned isCSALeg1Aligned;
	@Inject protected IsCSALeg2Aligned isCSALeg2Aligned;
	@Inject protected IsCommoditySwapFixedFloat isCommoditySwapFixedFloat;
	@Inject protected IsCommoditySwapFloatFloat isCommoditySwapFloatFloat;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class CryptoAssetUnderlyingIndicatorLeg1RuleDefault extends CryptoAssetUnderlyingIndicatorLeg1Rule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<Boolean> ifThenElseResult;
			if (areEqual(MapperS.of(isCSALeg1Aligned.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				final Boolean _boolean = qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(thenArg.get())));
				if ((_boolean == null ? false : _boolean)) {
					ifThenElseResult = MapperS.of(cryptoAssetUnderlyingIndicatorRule.evaluate(thenArg.get()));
				} else {
					ifThenElseResult = MapperS.<Boolean>ofNull();
				}
			} else if (areEqual(MapperS.of(isCSALeg2Aligned.evaluate(thenArg.get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				if (ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwapFloatFloat.evaluate(productForEvent.evaluate(thenArg.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwapFixedFloat.evaluate(productForEvent.evaluate(thenArg.get()))))).getOrDefault(false)) {
					ifThenElseResult = MapperS.of(cryptoAssetUnderlyingIndicatorRule.evaluate(thenArg.get()));
				} else {
					ifThenElseResult = MapperS.<Boolean>ofNull();
				}
			} else {
				ifThenElseResult = MapperS.<Boolean>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
