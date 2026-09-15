package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.party.reports.Direction1Rule;
import drr.standards.iso.Direction1Enum;
import javax.inject.Inject;


@ImplementedBy(DirectionRule.DirectionRuleDefault.class)
public abstract class DirectionRule implements ReportFunction<TransactionReportInstruction, Direction1Enum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1Rule direction1Rule;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Direction1Enum evaluate(TransactionReportInstruction input) {
		Direction1Enum output = doEvaluate(input);
		
		return output;
	}

	protected abstract Direction1Enum doEvaluate(TransactionReportInstruction input);

	public static class DirectionRuleDefault extends DirectionRule {
		@Override
		protected Direction1Enum doEvaluate(TransactionReportInstruction input) {
			Direction1Enum output = null;
			return assignOutput(output, input);
		}
		
		protected Direction1Enum assignOutput(Direction1Enum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(direction1Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
