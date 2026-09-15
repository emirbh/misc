package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapNonPeriodicPaymentDates.MapCommoditySwapNonPeriodicPaymentDatesDefault.class)
public abstract class MapCommoditySwapNonPeriodicPaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommoditySwapPaymentDateSchedule mapCommoditySwapPaymentDateSchedule;

	/**
	* @param fpmlPaymentDates 
	* @return paymentDates 
	*/
	public PaymentDates evaluate(AdjustableDatesOrRelativeDateOffset fpmlPaymentDates) {
		PaymentDates.PaymentDatesBuilder paymentDatesBuilder = doEvaluate(fpmlPaymentDates);
		
		final PaymentDates paymentDates;
		if (paymentDatesBuilder == null) {
			paymentDates = null;
		} else {
			paymentDates = paymentDatesBuilder.build();
			objectValidator.validate(PaymentDates.class, paymentDates);
		}
		
		return paymentDates;
	}

	protected abstract PaymentDates.PaymentDatesBuilder doEvaluate(AdjustableDatesOrRelativeDateOffset fpmlPaymentDates);

	public static class MapCommoditySwapNonPeriodicPaymentDatesDefault extends MapCommoditySwapNonPeriodicPaymentDates {
		@Override
		protected PaymentDates.PaymentDatesBuilder doEvaluate(AdjustableDatesOrRelativeDateOffset fpmlPaymentDates) {
			PaymentDates.PaymentDatesBuilder paymentDates = PaymentDates.builder();
			return assignOutput(paymentDates, fpmlPaymentDates);
		}
		
		protected PaymentDates.PaymentDatesBuilder assignOutput(PaymentDates.PaymentDatesBuilder paymentDates, AdjustableDatesOrRelativeDateOffset fpmlPaymentDates) {
			paymentDates = toBuilder(PaymentDates.builder()
				.setPaymentDateSchedule(mapCommoditySwapPaymentDateSchedule.evaluate(fpmlPaymentDates))
				.build());
			
			return Optional.ofNullable(paymentDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
