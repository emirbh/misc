package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.common.schedule.metafields.ReferenceWithMetaPaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PaymentDates;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentDatesReference.MapPaymentDatesReferenceDefault.class)
public abstract class MapPaymentDatesReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPaymentDates 
	* @return paymentDatesReference 
	*/
	public ReferenceWithMetaPaymentDates evaluate(PaymentDates fpmlPaymentDates) {
		ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder paymentDatesReferenceBuilder = doEvaluate(fpmlPaymentDates);
		
		final ReferenceWithMetaPaymentDates paymentDatesReference;
		if (paymentDatesReferenceBuilder == null) {
			paymentDatesReference = null;
		} else {
			paymentDatesReference = paymentDatesReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaPaymentDates.class, paymentDatesReference);
		}
		
		return paymentDatesReference;
	}

	protected abstract ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder doEvaluate(PaymentDates fpmlPaymentDates);

	public static class MapPaymentDatesReferenceDefault extends MapPaymentDatesReference {
		@Override
		protected ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder doEvaluate(PaymentDates fpmlPaymentDates) {
			ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder paymentDatesReference = ReferenceWithMetaPaymentDates.builder();
			return assignOutput(paymentDatesReference, fpmlPaymentDates);
		}
		
		protected ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder assignOutput(ReferenceWithMetaPaymentDates.ReferenceWithMetaPaymentDatesBuilder paymentDatesReference, PaymentDates fpmlPaymentDates) {
			paymentDatesReference = toBuilder(ReferenceWithMetaPaymentDates.builder().setValue(null).setExternalReference(MapperS.of(fpmlPaymentDates).<String>map("getId", paymentDates -> paymentDates.getId()).get()).build());
			
			return Optional.ofNullable(paymentDatesReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
