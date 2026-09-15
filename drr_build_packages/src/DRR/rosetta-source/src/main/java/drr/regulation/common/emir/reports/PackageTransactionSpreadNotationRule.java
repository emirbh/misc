package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionSpreadNotationEnumRule;
import javax.inject.Inject;


@ImplementedBy(PackageTransactionSpreadNotationRule.PackageTransactionSpreadNotationRuleDefault.class)
public abstract class PackageTransactionSpreadNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PackageTransactionSpreadNotationEnumRule packageTransactionSpreadNotationEnumRule;

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

	public static class PackageTransactionSpreadNotationRuleDefault extends PackageTransactionSpreadNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableAction.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeEROR.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(packageTransactionSpreadNotationEnumRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
