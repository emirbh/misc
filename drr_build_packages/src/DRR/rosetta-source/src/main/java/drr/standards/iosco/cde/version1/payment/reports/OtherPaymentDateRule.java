package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.datetime.functions.AdjustableOrAdjustedOrRelativeDateResolution;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentDateRule.OtherPaymentDateRuleDefault.class)
public abstract class OtherPaymentDateRule implements ReportFunction<TransferState, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransferState input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransferState input);

	public static class OtherPaymentDateRuleDefault extends OtherPaymentDateRule {
		@Override
		protected Date doEvaluate(TransferState input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransferState input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<AdjustableOrAdjustedOrRelativeDate>map("getSettlementDate", transfer -> transfer.getSettlementDate()).get()))).get();
			
			return output;
		}
	}
}
