package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version2.price.reports.PackageTransactionPriceNotationEnumRule;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceNotationRule.PackageTransactionPriceNotationRuleDefault.class)
public abstract class PackageTransactionPriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PackageTransactionPriceNotationEnumRule packageTransactionPriceNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstruction input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstruction input);

	public static class PackageTransactionPriceNotationRuleDefault extends PackageTransactionPriceNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = MapperS.of(defaultPercentageToDecimal.evaluate(packageTransactionPriceNotationEnumRule.evaluate(thenArg.get()), false)).get();
			
			return output;
		}
	}
}
