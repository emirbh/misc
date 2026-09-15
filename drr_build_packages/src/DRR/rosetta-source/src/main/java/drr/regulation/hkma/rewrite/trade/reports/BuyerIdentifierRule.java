package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iosco.cde.version3.party.reports.Direction1BuyerIdentifierRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(BuyerIdentifierRule.BuyerIdentifierRuleDefault.class)
public abstract class BuyerIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1BuyerIdentifierRule direction1BuyerIdentifierRule;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected PayerIdentifierLeg1Rule payerIdentifierLeg1Rule;
	@Inject protected PayerIdentifierLeg2Rule payerIdentifierLeg2Rule;
	@Inject protected ReceiverIdentifierLeg1Rule receiverIdentifierLeg1Rule;
	@Inject protected ReceiverIdentifierLeg2Rule receiverIdentifierLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class BuyerIdentifierRuleDefault extends BuyerIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (notExists(MapperS.of(payerIdentifierLeg1Rule.evaluate(item.get()))).andNullSafe(notExists(MapperS.of(payerIdentifierLeg2Rule.evaluate(item.get())))).andNullSafe(notExists(MapperS.of(receiverIdentifierLeg1Rule.evaluate(item.get())))).andNullSafe(notExists(MapperS.of(receiverIdentifierLeg2Rule.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(direction1BuyerIdentifierRule.evaluate(item.get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
