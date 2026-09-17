package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPayerReceiver.MapPayerReceiverDefault.class)
public abstract class MapPayerReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @param cdmCounterpartyList 
	* @return payerReceiver 
	*/
	public PayerReceiver evaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		PayerReceiver.PayerReceiverBuilder payerReceiverBuilder = doEvaluate(fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		
		final PayerReceiver payerReceiver;
		if (payerReceiverBuilder == null) {
			payerReceiver = null;
		} else {
			payerReceiver = payerReceiverBuilder.build();
			objectValidator.validate(PayerReceiver.class, payerReceiver);
		}
		
		return payerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapPayerReceiverDefault extends MapPayerReceiver {
		@Override
		protected PayerReceiver.PayerReceiverBuilder doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			PayerReceiver.PayerReceiverBuilder payerReceiver = PayerReceiver.builder();
			return assignOutput(payerReceiver, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		}
		
		protected PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder payerReceiver, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			payerReceiver = toBuilder(PayerReceiver.builder()
				.setPayer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlPayerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.setReceiver(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlReceiverPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(payerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
