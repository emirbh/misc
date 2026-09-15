package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodicPaymentToPaymentDates.MapPeriodicPaymentToPaymentDatesDefault.class)
public abstract class MapPeriodicPaymentToPaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriodToFrequency mapPeriodToFrequency;

	/**
	* @param fpmlPeriodicPayment 
	* @return paymentFrequency 
	*/
	public PaymentDates evaluate(PeriodicPayment fpmlPeriodicPayment) {
		PaymentDates.PaymentDatesBuilder paymentFrequencyBuilder = doEvaluate(fpmlPeriodicPayment);
		
		final PaymentDates paymentFrequency;
		if (paymentFrequencyBuilder == null) {
			paymentFrequency = null;
		} else {
			paymentFrequency = paymentFrequencyBuilder.build();
			objectValidator.validate(PaymentDates.class, paymentFrequency);
		}
		
		return paymentFrequency;
	}

	protected abstract PaymentDates.PaymentDatesBuilder doEvaluate(PeriodicPayment fpmlPeriodicPayment);

	public static class MapPeriodicPaymentToPaymentDatesDefault extends MapPeriodicPaymentToPaymentDates {
		@Override
		protected PaymentDates.PaymentDatesBuilder doEvaluate(PeriodicPayment fpmlPeriodicPayment) {
			PaymentDates.PaymentDatesBuilder paymentFrequency = PaymentDates.builder();
			return assignOutput(paymentFrequency, fpmlPeriodicPayment);
		}
		
		protected PaymentDates.PaymentDatesBuilder assignOutput(PaymentDates.PaymentDatesBuilder paymentFrequency, PeriodicPayment fpmlPeriodicPayment) {
			paymentFrequency = toBuilder(PaymentDates.builder()
				.setPaymentFrequency(mapPeriodToFrequency.evaluate(MapperS.of(fpmlPeriodicPayment).<Period>map("getPaymentFrequency", periodicPayment -> periodicPayment.getPaymentFrequency()).get()))
				.setFirstPaymentDate(MapperS.of(fpmlPeriodicPayment).<ZonedDateTime>map("getFirstPaymentDate", periodicPayment -> periodicPayment.getFirstPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setLastRegularPaymentDate(MapperS.of(fpmlPeriodicPayment).<ZonedDateTime>map("getLastRegularPaymentDate", periodicPayment -> periodicPayment.getLastRegularPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.build());
			
			return Optional.ofNullable(paymentFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
