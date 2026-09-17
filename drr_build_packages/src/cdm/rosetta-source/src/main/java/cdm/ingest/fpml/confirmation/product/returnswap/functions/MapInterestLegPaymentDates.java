package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableRelativeOrPeriodicDates2;
import cdm.product.common.schedule.PaymentDateSchedule;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates2;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestLegPaymentDates.MapInterestLegPaymentDatesDefault.class)
public abstract class MapInterestLegPaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableRelativeOrPeriodicDates2 mapAdjustableRelativeOrPeriodicDates2;

	/**
	* @param fpmlAdjustableRelativeOrPeriodicDates2 
	* @return paymentDates 
	*/
	public PaymentDates evaluate(AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2) {
		PaymentDates.PaymentDatesBuilder paymentDatesBuilder = doEvaluate(fpmlAdjustableRelativeOrPeriodicDates2);
		
		final PaymentDates paymentDates;
		if (paymentDatesBuilder == null) {
			paymentDates = null;
		} else {
			paymentDates = paymentDatesBuilder.build();
			objectValidator.validate(PaymentDates.class, paymentDates);
		}
		
		return paymentDates;
	}

	protected abstract PaymentDates.PaymentDatesBuilder doEvaluate(AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2);

	public static class MapInterestLegPaymentDatesDefault extends MapInterestLegPaymentDates {
		@Override
		protected PaymentDates.PaymentDatesBuilder doEvaluate(AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2) {
			PaymentDates.PaymentDatesBuilder paymentDates = PaymentDates.builder();
			return assignOutput(paymentDates, fpmlAdjustableRelativeOrPeriodicDates2);
		}
		
		protected PaymentDates.PaymentDatesBuilder assignOutput(PaymentDates.PaymentDatesBuilder paymentDates, AdjustableRelativeOrPeriodicDates2 fpmlAdjustableRelativeOrPeriodicDates2) {
			final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates = mapAdjustableRelativeOrPeriodicDates2.evaluate(fpmlAdjustableRelativeOrPeriodicDates2);
			final PaymentDates.PaymentDatesBuilder withMetaArgument = PaymentDates.builder()
				.setPaymentDateSchedule(PaymentDateSchedule.builder()
					.setInterimPaymentDates((adjustableRelativeOrPeriodicDates == null ? Collections.<AdjustableRelativeOrPeriodicDates>emptyList() : Collections.singletonList(adjustableRelativeOrPeriodicDates)))
					.build())
				.build() == null ? null : PaymentDates.builder()
				.setPaymentDateSchedule(PaymentDateSchedule.builder()
					.setInterimPaymentDates((adjustableRelativeOrPeriodicDates == null ? Collections.<AdjustableRelativeOrPeriodicDates>emptyList() : Collections.singletonList(adjustableRelativeOrPeriodicDates)))
					.build())
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlAdjustableRelativeOrPeriodicDates2).<String>map("getId", adjustableRelativeOrPeriodicDates2 -> adjustableRelativeOrPeriodicDates2.getId()).get());
			paymentDates = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(paymentDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
