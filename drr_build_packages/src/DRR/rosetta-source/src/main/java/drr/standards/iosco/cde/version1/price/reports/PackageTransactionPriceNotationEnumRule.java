package drr.standards.iosco.cde.version1.price.reports;

import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationFromPrice;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionPriceNotationEnumRule.PackageTransactionPriceNotationEnumRuleDefault.class)
public abstract class PackageTransactionPriceNotationEnumRule implements ReportFunction<TransactionReportInstructionBase, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationFromPrice notationFromPrice;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstructionBase input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstructionBase input);

	public static class PackageTransactionPriceNotationEnumRuleDefault extends PackageTransactionPriceNotationEnumRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstructionBase input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstructionBase input) {
			final MapperS<Price> thenArg = MapperS.of(packageTransactionPriceRule.evaluate(input));
			output = MapperS.of(notationFromPrice.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
