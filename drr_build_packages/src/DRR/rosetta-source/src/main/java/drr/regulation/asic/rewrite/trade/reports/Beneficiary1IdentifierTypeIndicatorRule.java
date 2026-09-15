package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(Beneficiary1IdentifierTypeIndicatorRule.Beneficiary1IdentifierTypeIndicatorRuleDefault.class)
public abstract class Beneficiary1IdentifierTypeIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.party.reports.Beneficiary1IdentifierTypeIndicatorRule beneficiary1IdentifierTypeIndicatorRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;

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

	public static class Beneficiary1IdentifierTypeIndicatorRuleDefault extends Beneficiary1IdentifierTypeIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(beneficiary1IdentifierTypeIndicatorRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
