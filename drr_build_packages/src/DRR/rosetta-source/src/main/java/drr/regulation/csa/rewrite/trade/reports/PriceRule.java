package drr.regulation.csa.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iosco.cde.version3.price.reports.PriceValueRule;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PriceRule.PriceRuleDefault.class)
public abstract class PriceRule implements ReportFunction<TransactionReportInstruction, PriceFormat> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceValueRule priceValueRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceFormat evaluate(TransactionReportInstruction input) {
		PriceFormat.PriceFormatBuilder outputBuilder = doEvaluate(input);
		
		final PriceFormat output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceFormat.class, output);
		}
		
		return output;
	}

	protected abstract PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input);

	public static class PriceRuleDefault extends PriceRule {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input) {
			PriceFormat.PriceFormatBuilder output = PriceFormat.builder();
			return assignOutput(output, input);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get())))))).get());
			output = toBuilder(thenArg1
				.mapSingleToItem(item -> MapperS.of(priceFormatFromNotation.evaluate(priceValueRule.evaluate(item.get()), priceNotationRule.evaluate(item.get())))).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
