package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.math.UnitType;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.PrincipalPayment;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPrincipalPayment.MapPrincipalPaymentDefault.class)
public abstract class MapPrincipalPayment implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapPrincipalPayerReceiver mapPrincipalPayerReceiver;
	@Inject protected MapPrincipalPaymentDate mapPrincipalPaymentDate;

	/**
	* @param fpmlPrincipalExchange 
	* @param fpmlCurrency 
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @param cdmCounterpartyList 
	* @return principalPayment 
	*/
	public PrincipalPayment evaluate(PrincipalExchange fpmlPrincipalExchange, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		PrincipalPayment.PrincipalPaymentBuilder principalPaymentBuilder = doEvaluate(fpmlPrincipalExchange, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		
		final PrincipalPayment principalPayment;
		if (principalPaymentBuilder == null) {
			principalPayment = null;
		} else {
			principalPayment = principalPaymentBuilder.build();
			objectValidator.validate(PrincipalPayment.class, principalPayment);
		}
		
		return principalPayment;
	}

	protected abstract PrincipalPayment.PrincipalPaymentBuilder doEvaluate(PrincipalExchange fpmlPrincipalExchange, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<BigDecimal> amount(PrincipalExchange fpmlPrincipalExchange, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapPrincipalPaymentDefault extends MapPrincipalPayment {
		@Override
		protected PrincipalPayment.PrincipalPaymentBuilder doEvaluate(PrincipalExchange fpmlPrincipalExchange, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			PrincipalPayment.PrincipalPaymentBuilder principalPayment = PrincipalPayment.builder();
			return assignOutput(principalPayment, fpmlPrincipalExchange, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		}
		
		protected PrincipalPayment.PrincipalPaymentBuilder assignOutput(PrincipalPayment.PrincipalPaymentBuilder principalPayment, PrincipalExchange fpmlPrincipalExchange, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			final BigDecimal ifThenElseResult;
			if (lessThan(amount(fpmlPrincipalExchange, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(amount(fpmlPrincipalExchange, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList), MapperS.of(BigDecimal.valueOf(-1))).get();
			} else {
				ifThenElseResult = amount(fpmlPrincipalExchange, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get();
			}
			principalPayment = toBuilder(PrincipalPayment.builder()
				.setPrincipalPaymentDate(mapPrincipalPaymentDate.evaluate(fpmlPrincipalExchange))
				.setPayerReceiver(mapPrincipalPayerReceiver.evaluate(fpmlPrincipalExchange, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList))
				.setPrincipalAmount(Money.builder()
					.setValue(ifThenElseResult)
					.setUnit(UnitType.builder()
						.setCurrency(mapCurrency.evaluate(fpmlCurrency))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(principalPayment)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> amount(PrincipalExchange fpmlPrincipalExchange, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlPrincipalExchange).<BigDecimal>map("getPrincipalExchangeAmount", principalExchange -> principalExchange.getPrincipalExchangeAmount());
		}
	}
}
