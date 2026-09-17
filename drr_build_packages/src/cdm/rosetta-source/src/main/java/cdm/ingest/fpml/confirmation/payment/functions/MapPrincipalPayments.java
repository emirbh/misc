package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.common.settlement.PrincipalPayments;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PrincipalExchanges;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPrincipalPayments.MapPrincipalPaymentsDefault.class)
public abstract class MapPrincipalPayments implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPrincipalPaymentSchedule mapPrincipalPaymentSchedule;

	/**
	* @param fpmlPrincipalExchanges 
	* @param fpmlPrincipalExchangeList 
	* @param fpmlCurrency 
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @param cdmCounterpartyList 
	* @return principalPayments 
	*/
	public PrincipalPayments evaluate(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		PrincipalPayments.PrincipalPaymentsBuilder principalPaymentsBuilder = doEvaluate(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		
		final PrincipalPayments principalPayments;
		if (principalPaymentsBuilder == null) {
			principalPayments = null;
		} else {
			principalPayments = principalPaymentsBuilder.build();
			objectValidator.validate(PrincipalPayments.class, principalPayments);
		}
		
		return principalPayments;
	}

	protected abstract PrincipalPayments.PrincipalPaymentsBuilder doEvaluate(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapPrincipalPaymentsDefault extends MapPrincipalPayments {
		@Override
		protected PrincipalPayments.PrincipalPaymentsBuilder doEvaluate(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlPrincipalExchangeList == null) {
				fpmlPrincipalExchangeList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			PrincipalPayments.PrincipalPaymentsBuilder principalPayments = PrincipalPayments.builder();
			return assignOutput(principalPayments, fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		}
		
		protected PrincipalPayments.PrincipalPaymentsBuilder assignOutput(PrincipalPayments.PrincipalPaymentsBuilder principalPayments, PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			final PrincipalPayments.PrincipalPaymentsBuilder withMetaArgument = PrincipalPayments.builder()
				.setInitialPayment(MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getInitialExchange", principalExchanges -> principalExchanges.getInitialExchange()).get())
				.setFinalPayment(MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getFinalExchange", principalExchanges -> principalExchanges.getFinalExchange()).get())
				.setIntermediatePayment(MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getIntermediateExchange", principalExchanges -> principalExchanges.getIntermediateExchange()).get())
				.setPrincipalPaymentSchedule(mapPrincipalPaymentSchedule.evaluate(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList))
				.build() == null ? null : PrincipalPayments.builder()
				.setInitialPayment(MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getInitialExchange", principalExchanges -> principalExchanges.getInitialExchange()).get())
				.setFinalPayment(MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getFinalExchange", principalExchanges -> principalExchanges.getFinalExchange()).get())
				.setIntermediatePayment(MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getIntermediateExchange", principalExchanges -> principalExchanges.getIntermediateExchange()).get())
				.setPrincipalPaymentSchedule(mapPrincipalPaymentSchedule.evaluate(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlPrincipalExchanges).<String>map("getId", principalExchanges -> principalExchanges.getId()).get());
			principalPayments = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(principalPayments)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
