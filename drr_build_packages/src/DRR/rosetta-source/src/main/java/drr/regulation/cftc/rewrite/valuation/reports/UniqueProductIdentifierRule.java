package drr.regulation.cftc.rewrite.valuation.reports;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueProductIdentifierRule.UniqueProductIdentifierRuleDefault.class)
public abstract class UniqueProductIdentifierRule implements ReportFunction<ValuationReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class UniqueProductIdentifierRuleDefault extends UniqueProductIdentifierRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			final MapperC<ProductIdentifier> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<ProductIdentifier>mapC("getUniqueProductIdentifier", valuationTradeInformation -> valuationTradeInformation.getUniqueProductIdentifier()));
			final MapperC<ProductIdentifier> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
			final MapperS<ProductIdentifier> thenArg2 = MapperS.of(thenArg1.get());
			final FieldWithMetaString fieldWithMetaString = thenArg2
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
