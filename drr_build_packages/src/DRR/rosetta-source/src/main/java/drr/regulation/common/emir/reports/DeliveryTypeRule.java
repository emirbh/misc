package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.DeliveryTypeEnum;
import javax.inject.Inject;


@ImplementedBy(DeliveryTypeRule.DeliveryTypeRuleDefault.class)
public abstract class DeliveryTypeRule implements ReportFunction<TransactionReportInstruction, DeliveryTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.contract.reports.DeliveryTypeRule deliveryTypeRule;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public DeliveryTypeEnum evaluate(TransactionReportInstruction input) {
		DeliveryTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract DeliveryTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class DeliveryTypeRuleDefault extends DeliveryTypeRule {
		@Override
		protected DeliveryTypeEnum doEvaluate(TransactionReportInstruction input) {
			DeliveryTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected DeliveryTypeEnum assignOutput(DeliveryTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(deliveryTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
