package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetDeliveryTypeDSBRecord;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import javax.inject.Inject;


@ImplementedBy(DeliveryTypeRule.DeliveryTypeRuleDefault.class)
public abstract class DeliveryTypeRule implements ReportFunction<TransactionReportInstruction, AnnaDsbDeliveryTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDeliveryTypeDSBRecord getDeliveryTypeDSBRecord;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AnnaDsbDeliveryTypeEnum evaluate(TransactionReportInstruction input) {
		AnnaDsbDeliveryTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AnnaDsbDeliveryTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class DeliveryTypeRuleDefault extends DeliveryTypeRule {
		@Override
		protected AnnaDsbDeliveryTypeEnum doEvaluate(TransactionReportInstruction input) {
			AnnaDsbDeliveryTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AnnaDsbDeliveryTypeEnum assignOutput(AnnaDsbDeliveryTypeEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(getDeliveryTypeDSBRecord.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
