package drr.regulation.jfsa.rewrite.margin.reports;

import cdm.event.common.TradeIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.standards.iosco.uti.functions.GetUniqueTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifierRule.UniqueTransactionIdentifierRuleDefault.class)
public abstract class UniqueTransactionIdentifierRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueTransactionIdentifier getUniqueTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class UniqueTransactionIdentifierRuleDefault extends UniqueTransactionIdentifierRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			final SupervisoryBodyEnum supervisoryBodyEnum = SupervisoryBodyEnum.JFSA;
			final MapperS<String> thenArg = MapperS.of(getUniqueTransactionIdentifier.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), (supervisoryBodyEnum == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum)), MapperS.of(input).<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<TradeIdentifier>map("getUniqueTradeIdentifier", collateralDetails -> collateralDetails.getUniqueTradeIdentifier()).get(), null));
			output = thenArg
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
