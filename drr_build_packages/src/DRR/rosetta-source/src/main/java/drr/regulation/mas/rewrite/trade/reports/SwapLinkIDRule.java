package drr.regulation.mas.rewrite.trade.reports;

import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.link.reports.PackageIdentifierRule;
import javax.inject.Inject;


@ImplementedBy(SwapLinkIDRule.SwapLinkIDRuleDefault.class)
public abstract class SwapLinkIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;

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

	public static class SwapLinkIDRuleDefault extends SwapLinkIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForMAS.evaluate(item.get()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(MapperS.of(productForEvent.evaluate(item.get())).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).get());
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final String string = packageIdentifierRule.evaluate(item.get());
					return string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build());
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
