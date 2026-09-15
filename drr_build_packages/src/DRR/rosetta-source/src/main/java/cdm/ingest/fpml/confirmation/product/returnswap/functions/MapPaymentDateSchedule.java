package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates;
import cdm.product.common.schedule.PaymentDateSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.ReturnSwapPaymentDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentDateSchedule.MapPaymentDateScheduleDefault.class)
public abstract class MapPaymentDateSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates mapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates;

	/**
	* @param fpmlReturnSwapPaymentDates 
	* @return paymentDateSchedule 
	*/
	public PaymentDateSchedule evaluate(ReturnSwapPaymentDates fpmlReturnSwapPaymentDates) {
		PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateScheduleBuilder = doEvaluate(fpmlReturnSwapPaymentDates);
		
		final PaymentDateSchedule paymentDateSchedule;
		if (paymentDateScheduleBuilder == null) {
			paymentDateSchedule = null;
		} else {
			paymentDateSchedule = paymentDateScheduleBuilder.build();
			objectValidator.validate(PaymentDateSchedule.class, paymentDateSchedule);
		}
		
		return paymentDateSchedule;
	}

	protected abstract PaymentDateSchedule.PaymentDateScheduleBuilder doEvaluate(ReturnSwapPaymentDates fpmlReturnSwapPaymentDates);

	public static class MapPaymentDateScheduleDefault extends MapPaymentDateSchedule {
		@Override
		protected PaymentDateSchedule.PaymentDateScheduleBuilder doEvaluate(ReturnSwapPaymentDates fpmlReturnSwapPaymentDates) {
			PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateSchedule = PaymentDateSchedule.builder();
			return assignOutput(paymentDateSchedule, fpmlReturnSwapPaymentDates);
		}
		
		protected PaymentDateSchedule.PaymentDateScheduleBuilder assignOutput(PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateSchedule, ReturnSwapPaymentDates fpmlReturnSwapPaymentDates) {
			final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates = mapAdjustableOrRelativeDatesToAdjustableRelativeOrPeriodicDates.evaluate(MapperS.of(fpmlReturnSwapPaymentDates).<AdjustableOrRelativeDates>map("getPaymentDatesInterim", returnSwapPaymentDates -> returnSwapPaymentDates.getPaymentDatesInterim()).get());
			paymentDateSchedule = toBuilder(PaymentDateSchedule.builder()
				.setInterimPaymentDates((adjustableRelativeOrPeriodicDates == null ? Collections.<AdjustableRelativeOrPeriodicDates>emptyList() : Collections.singletonList(adjustableRelativeOrPeriodicDates)))
				.setFinalPaymentDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlReturnSwapPaymentDates).<AdjustableOrRelativeDate>map("getPaymentDateFinal", returnSwapPaymentDates -> returnSwapPaymentDates.getPaymentDateFinal()).get()))
				.build());
			
			return Optional.ofNullable(paymentDateSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
