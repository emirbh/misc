package drr.regulation.common.trade.contract.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.reports.SettlementTermsRule;
import drr.standards.iso.DeliveryTypeEnum;
import javax.inject.Inject;


@ImplementedBy(DeliveryTypeRule.DeliveryTypeRuleDefault.class)
public abstract class DeliveryTypeRule implements ReportFunction<TransactionReportInstruction, DeliveryTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DeliveryTypeFromProductRule deliveryTypeFromProductRule;
	@Inject protected DeliveryTypeFromSettlementRule deliveryTypeFromSettlementRule;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected SettlementTermsRule settlementTermsRule;

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
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(MapperS.of(deliveryTypeFromSettlementRule.evaluate(settlementTermsRule.evaluate(item.get()))).getOrDefault(deliveryTypeFromProductRule.evaluate(productForEvent.evaluate(item.get()))))).get();
			
			return output;
		}
	}
}
