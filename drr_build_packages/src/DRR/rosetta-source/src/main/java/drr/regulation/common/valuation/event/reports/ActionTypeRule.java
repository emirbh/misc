package drr.regulation.common.valuation.event.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ActionTypeRule.ActionTypeRuleDefault.class)
public abstract class ActionTypeRule implements ReportFunction<ValuationReportInstruction, ActionTypeEnum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ActionTypeEnum evaluate(ValuationReportInstruction input) {
		ActionTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ActionTypeEnum doEvaluate(ValuationReportInstruction input);

	public static class ActionTypeRuleDefault extends ActionTypeRule {
		@Override
		protected ActionTypeEnum doEvaluate(ValuationReportInstruction input) {
			ActionTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ActionTypeEnum assignOutput(ActionTypeEnum output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<ActionTypeEnum>map("getAction", valuationTradeInformation -> valuationTradeInformation.getAction()), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).getOrDefault(false)) {
						return item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<ActionTypeEnum>map("getAction", valuationTradeInformation -> valuationTradeInformation.getAction());
					}
					return MapperS.<ActionTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
