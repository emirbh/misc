package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iso.Direction1Enum;
import javax.inject.Inject;


@ImplementedBy(Direction1Rule.Direction1RuleDefault.class)
public abstract class Direction1Rule implements ReportFunction<TransactionReportInstruction, Direction1Enum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.party.reports.Direction1Rule direction1Rule;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

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

	public static class Direction1RuleDefault extends Direction1Rule {
		@Override
		protected Direction1Enum doEvaluate(TransactionReportInstruction input) {
			Direction1Enum output = null;
			return assignOutput(output, input);
		}
		
		protected Direction1Enum assignOutput(Direction1Enum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(direction1Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
