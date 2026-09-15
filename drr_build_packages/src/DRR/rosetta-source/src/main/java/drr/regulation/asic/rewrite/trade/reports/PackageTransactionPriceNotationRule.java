package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.link.reports.PackageIdentifierRule;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionPriceNotationEnumRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PackageTransactionPriceNotationRule.PackageTransactionPriceNotationRuleDefault.class)
public abstract class PackageTransactionPriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
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
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final String string = packageIdentifierRule.evaluate(thenArg.get());
			output = MapperS.of(defaultPercentageToDecimal.evaluate(packageTransactionPriceNotationEnumRule.evaluate(thenArg.get()), (string == null ? exists(MapperS.<FieldWithMetaString>ofNull()) : exists(MapperS.of(FieldWithMetaString.builder().setValue(string).build()))).andNullSafe(notExists(MapperS.of(packageTransactionPriceNotationEnumRule.evaluate(thenArg.get())))).get())).get();
			
			return output;
		}
	}
}
