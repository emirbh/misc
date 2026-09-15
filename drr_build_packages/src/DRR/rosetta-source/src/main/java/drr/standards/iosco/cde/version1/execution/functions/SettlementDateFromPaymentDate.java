package drr.standards.iosco.cde.version1.execution.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.common.schedule.PaymentDateSchedule;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.functions.AdjustableDateResolution;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(SettlementDateFromPaymentDate.SettlementDateFromPaymentDateDefault.class)
public abstract class SettlementDateFromPaymentDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;

	/**
	* @param paymentDates 
	* @return date 
	*/
	public List<Date> evaluate(PaymentDates paymentDates) {
		List<Date> date = doEvaluate(paymentDates);
		
		return date;
	}

	protected abstract List<Date> doEvaluate(PaymentDates paymentDates);

	public static class SettlementDateFromPaymentDateDefault extends SettlementDateFromPaymentDate {
		@Override
		protected List<Date> doEvaluate(PaymentDates paymentDates) {
			List<Date> date = new ArrayList<>();
			return assignOutput(date, paymentDates);
		}
		
		protected List<Date> assignOutput(List<Date> date, PaymentDates paymentDates) {
			date.addAll(MapperS.of(paymentDates).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()).getMulti());
			
			date.addAll(MapperS.of(paymentDates).<Date>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate()).getMulti());
			
			date.addAll(MapperS.of(paymentDates).<PaymentDateSchedule>map("getPaymentDateSchedule", _paymentDates -> _paymentDates.getPaymentDateSchedule()).<AdjustableOrRelativeDate>map("getFinalPaymentDate", paymentDateSchedule -> paymentDateSchedule.getFinalPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate())
				.mapSingleToItem(item -> MapperS.of(adjustableDateResolution.evaluate(item.get()))).getMulti());
			
			return date;
		}
	}
}
