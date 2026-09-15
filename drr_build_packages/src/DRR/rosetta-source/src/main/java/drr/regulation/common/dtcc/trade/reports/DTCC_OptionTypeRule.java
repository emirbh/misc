package drr.regulation.common.dtcc.trade.reports;

import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCap;
import drr.base.qualification.product.functions.IsFloor;
import drr.base.qualification.product.functions.IsOption;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_OptionTypeRule.DTCC_OptionTypeRuleDefault.class)
public abstract class DTCC_OptionTypeRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCap isCap;
	@Inject protected IsFloor isFloor;
	@Inject protected IsOption isOption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;

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

	public static class DTCC_OptionTypeRuleDefault extends DTCC_OptionTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<NonTransferableProduct> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(productForEvent.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(Product -> {
					final MapperS<NonTransferableProduct> thenArg0 = thenArg
						.filterSingleNullSafe(item -> qualify_AssetClass_Commodity.evaluate(economicTermsForProduct.evaluate(item.get())));
					final MapperS<OptionTypeEnum> thenArg1 = thenArg0
						.mapSingleToItem(item -> MapperS.of(MapperS.of(economicTermsForProduct.evaluate(item.get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionTypeEnum>map("getOptionType", optionPayout -> optionPayout.getOptionType()));
					return thenArg1
						.mapSingleToItem(item -> {
							if (areEqual(item, MapperS.of(OptionTypeEnum.PUT), CardinalityOperator.All).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFloor.evaluate(Product.get())))).getOrDefault(false)) {
								return MapperS.of("Put");
							}
							if (areEqual(item, MapperS.of(OptionTypeEnum.CALL), CardinalityOperator.All).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCap.evaluate(Product.get())))).getOrDefault(false)) {
								return MapperS.of("Call");
							}
							if (areEqual(item, MapperS.of(OptionTypeEnum.RECEIVER), CardinalityOperator.All).getOrDefault(false)) {
								return MapperS.of("Receiver");
							}
							if (areEqual(item, MapperS.of(OptionTypeEnum.PAYER), CardinalityOperator.All).getOrDefault(false)) {
								return MapperS.of("Payer");
							}
							if (areEqual(item, MapperS.of(OptionTypeEnum.STRADDLE), CardinalityOperator.All).getOrDefault(false)) {
								return MapperS.of("Straddle");
							}
							final Boolean _boolean = isOption.evaluate(Product.get());
							if ((_boolean == null ? false : _boolean)) {
								return MapperS.of("Other");
							}
							return MapperS.<String>ofNull();
						});
				}).get();
			
			return output;
		}
	}
}
