package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionPriceNotationEnumRule;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceNotationRule.PackageTransactionPriceNotationRuleDefault.class)
public abstract class PackageTransactionPriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
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
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(packageTransactionPriceNotationEnumRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
