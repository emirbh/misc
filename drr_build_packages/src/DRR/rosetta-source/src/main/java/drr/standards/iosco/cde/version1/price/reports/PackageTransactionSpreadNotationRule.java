package drr.standards.iosco.cde.version1.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationStringFromEnum;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionSpreadNotationRule.PackageTransactionSpreadNotationRuleDefault.class)
public abstract class PackageTransactionSpreadNotationRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationStringFromEnum notationStringFromEnum;
	@Inject protected PackageTransactionSpreadNotationEnumRule packageTransactionSpreadNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class PackageTransactionSpreadNotationRuleDefault extends PackageTransactionSpreadNotationRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperS<PriceNotationEnum> thenArg = MapperS.of(packageTransactionSpreadNotationEnumRule.evaluate(input));
			output = MapperS.of(notationStringFromEnum.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
