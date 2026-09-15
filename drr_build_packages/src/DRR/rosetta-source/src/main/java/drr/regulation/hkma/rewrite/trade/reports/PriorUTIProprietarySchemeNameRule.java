package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.common.trade.link.functions.GetPriorTransactionIdentifier;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import drr.standards.iso.functions.IsValidLeiFromGlobalUti;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUTIProprietarySchemeNameRule.PriorUTIProprietarySchemeNameRuleDefault.class)
public abstract class PriorUTIProprietarySchemeNameRule implements ReportFunction<TransactionReportInstruction, UTIProprietarySchemeNameEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetPriorTransactionIdentifier getPriorTransactionIdentifier;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;
	@Inject protected IsValidLeiFromGlobalUti isValidLeiFromGlobalUti;
	@Inject protected PriorUTIProprietaryRule priorUTIProprietaryRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public UTIProprietarySchemeNameEnum evaluate(TransactionReportInstruction input) {
		UTIProprietarySchemeNameEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract UTIProprietarySchemeNameEnum doEvaluate(TransactionReportInstruction input);

	public static class PriorUTIProprietarySchemeNameRuleDefault extends PriorUTIProprietarySchemeNameRule {
		@Override
		protected UTIProprietarySchemeNameEnum doEvaluate(TransactionReportInstruction input) {
			UTIProprietarySchemeNameEnum output = null;
			return assignOutput(output, input);
		}
		
		protected UTIProprietarySchemeNameEnum assignOutput(UTIProprietarySchemeNameEnum output, TransactionReportInstruction input) {
			if (exists(MapperS.of(priorUTIProprietaryRule.evaluate(input))).getOrDefault(false)) {
				if (exists(MapperS.of(getPriorTransactionIdentifier.evaluate(input, RegimeNameEnum.HKMA))).andNullSafe(areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(getPriorTransactionIdentifier.evaluate(input, RegimeNameEnum.HKMA))), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(isValidLeiFromGlobalUti.evaluate(getPriorTransactionIdentifier.evaluate(input, RegimeNameEnum.HKMA))), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
					output = UTIProprietarySchemeNameEnum.UTI_TID;
				} else {
					output = UTIProprietarySchemeNameEnum.UTI_USI;
				}
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
