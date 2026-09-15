package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.ClearedEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearedRule.ClearedRuleDefault.class)
public abstract class ClearedRule implements ReportFunction<TransactionReportInstruction, ClearedEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.ClearedRule clearedRule;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearedEnum evaluate(TransactionReportInstruction input) {
		ClearedEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearedEnum doEvaluate(TransactionReportInstruction input);

	public static class ClearedRuleDefault extends ClearedRule {
		@Override
		protected ClearedEnum doEvaluate(TransactionReportInstruction input) {
			ClearedEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearedEnum assignOutput(ClearedEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(clearedRule.evaluate(item.get())), MapperS.of(ClearedEnum.I), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(ClearedEnum.N);
					}
					return MapperS.of(clearedRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
