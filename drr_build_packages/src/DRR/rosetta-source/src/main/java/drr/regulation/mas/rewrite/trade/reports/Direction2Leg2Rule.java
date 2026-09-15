package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.functions.CounterpartiesForEvent;
import drr.base.util.party.functions.CounterpartyRoleFromLEI;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.party.functions.Direction2;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import drr.standards.iosco.cde.version3.party.reports.Direction1Rule;
import drr.standards.iso.Direction2Enum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Direction2Leg2Rule.Direction2Leg2RuleDefault.class)
public abstract class Direction2Leg2Rule implements ReportFunction<TransactionReportInstruction, Direction2Enum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CounterpartiesForEvent counterpartiesForEvent;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected CounterpartyRoleFromLEI counterpartyRoleFromLEI;
	@Inject protected Direction1Rule direction1Rule;
	@Inject protected Direction2 direction2;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Direction2Enum evaluate(TransactionReportInstruction input) {
		Direction2Enum output = doEvaluate(input);
		
		return output;
	}

	protected abstract Direction2Enum doEvaluate(TransactionReportInstruction input);

	public static class Direction2Leg2RuleDefault extends Direction2Leg2Rule {
		@Override
		protected Direction2Enum doEvaluate(TransactionReportInstruction input) {
			Direction2Enum output = null;
			return assignOutput(output, input);
		}
		
		protected Direction2Enum assignOutput(Direction2Enum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<Direction2Enum> ifThenElseResult;
			if (notExists(MapperS.of(direction1Rule.evaluate(thenArg.get()))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(direction2.evaluate(payoutLeg2Rule.evaluate(thenArg.get()), counterpartyRoleFromLEI.evaluate(counterpartiesForEvent.evaluate(thenArg.get()), counterparty1Rule.evaluate(thenArg.get()))));
			} else {
				ifThenElseResult = MapperS.<Direction2Enum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
