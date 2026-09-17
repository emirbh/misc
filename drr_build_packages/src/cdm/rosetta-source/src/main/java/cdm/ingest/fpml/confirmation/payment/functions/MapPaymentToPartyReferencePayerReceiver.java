package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentToPartyReferencePayerReceiver.MapPaymentToPartyReferencePayerReceiverDefault.class)
public abstract class MapPaymentToPartyReferencePayerReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @return partyReferencePayerReceiver 
	*/
	public PartyReferencePayerReceiver evaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder partyReferencePayerReceiverBuilder = doEvaluate(fpmlPayerPartyReference, fpmlReceiverPartyReference);
		
		final PartyReferencePayerReceiver partyReferencePayerReceiver;
		if (partyReferencePayerReceiverBuilder == null) {
			partyReferencePayerReceiver = null;
		} else {
			partyReferencePayerReceiver = partyReferencePayerReceiverBuilder.build();
			objectValidator.validate(PartyReferencePayerReceiver.class, partyReferencePayerReceiver);
		}
		
		return partyReferencePayerReceiver;
	}

	protected abstract PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference);

	public static class MapPaymentToPartyReferencePayerReceiverDefault extends MapPaymentToPartyReferencePayerReceiver {
		@Override
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder partyReferencePayerReceiver = PartyReferencePayerReceiver.builder();
			return assignOutput(partyReferencePayerReceiver, fpmlPayerPartyReference, fpmlReceiverPartyReference);
		}
		
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder assignOutput(PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder partyReferencePayerReceiver, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference) {
			partyReferencePayerReceiver
				.getOrCreatePayerPartyReference()
				.setExternalReference(MapperS.of(fpmlPayerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get());
			
			partyReferencePayerReceiver
				.getOrCreateReceiverPartyReference()
				.setExternalReference(MapperS.of(fpmlReceiverPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get());
			
			return Optional.ofNullable(partyReferencePayerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
