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


@ImplementedBy(MapSellerAsPayerAndBuyerAsReceiver.MapSellerAsPayerAndBuyerAsReceiverDefault.class)
public abstract class MapSellerAsPayerAndBuyerAsReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlSellerPartyReference 
	* @param fpmlBuyerPartyReference 
	* @param cdmCounterpartyList 
	* @return payerReceiver 
	*/
	public PayerReceiver evaluate(PartyReference fpmlSellerPartyReference, PartyReference fpmlBuyerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		PayerReceiver.PayerReceiverBuilder payerReceiverBuilder = doEvaluate(fpmlSellerPartyReference, fpmlBuyerPartyReference, cdmCounterpartyList);
		
		final PayerReceiver payerReceiver;
		if (payerReceiverBuilder == null) {
			payerReceiver = null;
		} else {
			payerReceiver = payerReceiverBuilder.build();
			objectValidator.validate(PayerReceiver.class, payerReceiver);
		}
		
		return payerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(PartyReference fpmlSellerPartyReference, PartyReference fpmlBuyerPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapSellerAsPayerAndBuyerAsReceiverDefault extends MapSellerAsPayerAndBuyerAsReceiver {
		@Override
		protected PayerReceiver.PayerReceiverBuilder doEvaluate(PartyReference fpmlSellerPartyReference, PartyReference fpmlBuyerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			PayerReceiver.PayerReceiverBuilder payerReceiver = PayerReceiver.builder();
			return assignOutput(payerReceiver, fpmlSellerPartyReference, fpmlBuyerPartyReference, cdmCounterpartyList);
		}
		
		protected PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder payerReceiver, PartyReference fpmlSellerPartyReference, PartyReference fpmlBuyerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			payerReceiver = toBuilder(PayerReceiver.builder()
				.setPayer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlSellerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.setReceiver(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlBuyerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(payerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
