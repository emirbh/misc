package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(FlipPayerAndReceiver.FlipPayerAndReceiverDefault.class)
public abstract class FlipPayerAndReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payerReceiver 
	* @return flippedPayerReceiver 
	*/
	public PayerReceiver evaluate(PayerReceiver payerReceiver) {
		PayerReceiver.PayerReceiverBuilder flippedPayerReceiverBuilder = doEvaluate(payerReceiver);
		
		final PayerReceiver flippedPayerReceiver;
		if (flippedPayerReceiverBuilder == null) {
			flippedPayerReceiver = null;
		} else {
			flippedPayerReceiver = flippedPayerReceiverBuilder.build();
			objectValidator.validate(PayerReceiver.class, flippedPayerReceiver);
		}
		
		return flippedPayerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(PayerReceiver payerReceiver);

	public static class FlipPayerAndReceiverDefault extends FlipPayerAndReceiver {
		@Override
		protected PayerReceiver.PayerReceiverBuilder doEvaluate(PayerReceiver payerReceiver) {
			PayerReceiver.PayerReceiverBuilder flippedPayerReceiver = PayerReceiver.builder();
			return assignOutput(flippedPayerReceiver, payerReceiver);
		}
		
		protected PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder flippedPayerReceiver, PayerReceiver payerReceiver) {
			flippedPayerReceiver = toBuilder(PayerReceiver.builder()
				.setPayer(MapperS.of(payerReceiver).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())
				.setReceiver(MapperS.of(payerReceiver).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())
				.build());
			
			return Optional.ofNullable(flippedPayerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
