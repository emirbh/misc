package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPrincipalPayerReceiver.MapPrincipalPayerReceiverDefault.class)
public abstract class MapPrincipalPayerReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlPrincipalExchange 
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @param cdmCounterpartyList 
	* @return payerReceiver 
	*/
	public PayerReceiver evaluate(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		PayerReceiver.PayerReceiverBuilder payerReceiverBuilder = doEvaluate(fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		
		final PayerReceiver payerReceiver;
		if (payerReceiverBuilder == null) {
			payerReceiver = null;
		} else {
			payerReceiver = payerReceiverBuilder.build();
			objectValidator.validate(PayerReceiver.class, payerReceiver);
		}
		
		return payerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<CounterpartyRoleEnum> payer(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<CounterpartyRoleEnum> receiver(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapPrincipalPayerReceiverDefault extends MapPrincipalPayerReceiver {
		@Override
		protected PayerReceiver.PayerReceiverBuilder doEvaluate(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			PayerReceiver.PayerReceiverBuilder payerReceiver = PayerReceiver.builder();
			return assignOutput(payerReceiver, fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		}
		
		protected PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder payerReceiver, PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (greaterThanEquals(MapperS.of(fpmlPrincipalExchange).<BigDecimal>map("getPrincipalExchangeAmount", principalExchange -> principalExchange.getPrincipalExchangeAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				payerReceiver = toBuilder(PayerReceiver.builder()
					.setPayer(payer(fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get())
					.setReceiver(receiver(fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get())
					.build());
			} else {
				payerReceiver = toBuilder(PayerReceiver.builder()
					.setPayer(receiver(fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get())
					.setReceiver(payer(fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get())
					.build());
			}
			
			return Optional.ofNullable(payerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<CounterpartyRoleEnum> payer(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlPayerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList));
		}
		
		@Override
		protected MapperS<CounterpartyRoleEnum> receiver(PrincipalExchange fpmlPrincipalExchange, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlReceiverPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList));
		}
	}
}
