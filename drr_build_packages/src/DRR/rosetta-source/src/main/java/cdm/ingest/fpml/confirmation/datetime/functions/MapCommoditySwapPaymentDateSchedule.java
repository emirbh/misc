package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.product.common.schedule.PaymentDateSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapPaymentDateSchedule.MapCommoditySwapPaymentDateScheduleDefault.class)
public abstract class MapCommoditySwapPaymentDateSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDatesOrRelativeDateOffset mapAdjustableDatesOrRelativeDateOffset;

	/**
	* @param fpmlPaymentDates 
	* @return paymentDateSchedule 
	*/
	public PaymentDateSchedule evaluate(AdjustableDatesOrRelativeDateOffset fpmlPaymentDates) {
		PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateScheduleBuilder = doEvaluate(fpmlPaymentDates);
		
		final PaymentDateSchedule paymentDateSchedule;
		if (paymentDateScheduleBuilder == null) {
			paymentDateSchedule = null;
		} else {
			paymentDateSchedule = paymentDateScheduleBuilder.build();
			objectValidator.validate(PaymentDateSchedule.class, paymentDateSchedule);
		}
		
		return paymentDateSchedule;
	}

	protected abstract PaymentDateSchedule.PaymentDateScheduleBuilder doEvaluate(AdjustableDatesOrRelativeDateOffset fpmlPaymentDates);

	public static class MapCommoditySwapPaymentDateScheduleDefault extends MapCommoditySwapPaymentDateSchedule {
		@Override
		protected PaymentDateSchedule.PaymentDateScheduleBuilder doEvaluate(AdjustableDatesOrRelativeDateOffset fpmlPaymentDates) {
			PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateSchedule = PaymentDateSchedule.builder();
			return assignOutput(paymentDateSchedule, fpmlPaymentDates);
		}
		
		protected PaymentDateSchedule.PaymentDateScheduleBuilder assignOutput(PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateSchedule, AdjustableDatesOrRelativeDateOffset fpmlPaymentDates) {
			final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates = mapAdjustableDatesOrRelativeDateOffset.evaluate(fpmlPaymentDates);
			paymentDateSchedule = toBuilder(PaymentDateSchedule.builder()
				.setInterimPaymentDates((adjustableRelativeOrPeriodicDates == null ? Collections.<AdjustableRelativeOrPeriodicDates>emptyList() : Collections.singletonList(adjustableRelativeOrPeriodicDates)))
				.build());
			
			return Optional.ofNullable(paymentDateSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
