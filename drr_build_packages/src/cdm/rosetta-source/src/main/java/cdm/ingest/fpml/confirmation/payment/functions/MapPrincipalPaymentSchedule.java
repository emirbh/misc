package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.common.settlement.PrincipalPayment;
import cdm.product.common.settlement.PrincipalPaymentSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PrincipalExchanges;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPrincipalPaymentSchedule.MapPrincipalPaymentScheduleDefault.class)
public abstract class MapPrincipalPaymentSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPrincipalPayment mapPrincipalPayment;

	/**
	* @param fpmlPrincipalExchanges 
	* @param fpmlPrincipalExchangeList 
	* @param fpmlCurrency 
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @param cdmCounterpartyList 
	* @return principalPaymentSchedule 
	*/
	public PrincipalPaymentSchedule evaluate(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentScheduleBuilder = doEvaluate(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		
		final PrincipalPaymentSchedule principalPaymentSchedule;
		if (principalPaymentScheduleBuilder == null) {
			principalPaymentSchedule = null;
		} else {
			principalPaymentSchedule = principalPaymentScheduleBuilder.build();
			objectValidator.validate(PrincipalPaymentSchedule.class, principalPaymentSchedule);
		}
		
		return principalPaymentSchedule;
	}

	protected abstract PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder doEvaluate(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperC<? extends PrincipalExchange> sortedPrincipalExchangeList(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends PrincipalExchange> initialPrincipalExchange(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends PrincipalExchange> finalPrincipalExchange(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapPrincipalPaymentScheduleDefault extends MapPrincipalPaymentSchedule {
		@Override
		protected PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder doEvaluate(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlPrincipalExchangeList == null) {
				fpmlPrincipalExchangeList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentSchedule = PrincipalPaymentSchedule.builder();
			return assignOutput(principalPaymentSchedule, fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		}
		
		protected PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder assignOutput(PrincipalPaymentSchedule.PrincipalPaymentScheduleBuilder principalPaymentSchedule, PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			PrincipalPayment ifThenElseResult0 = null;
			if (exists(initialPrincipalExchange(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList)).getOrDefault(false)) {
				ifThenElseResult0 = mapPrincipalPayment.evaluate(initialPrincipalExchange(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get(), fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
			}
			PrincipalPayment ifThenElseResult1 = null;
			if (exists(finalPrincipalExchange(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList)).getOrDefault(false)) {
				ifThenElseResult1 = mapPrincipalPayment.evaluate(finalPrincipalExchange(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList).get(), fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
			}
			principalPaymentSchedule = toBuilder(PrincipalPaymentSchedule.builder()
				.setInitialPrincipalPayment(ifThenElseResult0)
				.setFinalPrincipalPayment(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(principalPaymentSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PrincipalExchange> sortedPrincipalExchangeList(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperC.<PrincipalExchange>of(fpmlPrincipalExchangeList)
				.sort(item -> MapperS.of(item.<ZonedDateTime>map("getUnadjustedPrincipalExchangeDate", principalExchange -> principalExchange.getUnadjustedPrincipalExchangeDate()).getOrDefault(item.<ZonedDateTime>map("getAdjustedPrincipalExchangeDate", principalExchange -> principalExchange.getAdjustedPrincipalExchangeDate()).get())));
		}
		
		@Override
		protected MapperS<? extends PrincipalExchange> initialPrincipalExchange(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getInitialExchange", principalExchanges -> principalExchanges.getInitialExchange()).getOrDefault(false)) {
				return sortedPrincipalExchangeList(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList)
					.first();
			}
			return MapperS.<PrincipalExchange>ofNull();
		}
		
		@Override
		protected MapperS<? extends PrincipalExchange> finalPrincipalExchange(PrincipalExchanges fpmlPrincipalExchanges, List<? extends PrincipalExchange> fpmlPrincipalExchangeList, Currency fpmlCurrency, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (MapperS.of(fpmlPrincipalExchanges).<Boolean>map("getFinalExchange", principalExchanges -> principalExchanges.getFinalExchange()).getOrDefault(false)) {
				return sortedPrincipalExchangeList(fpmlPrincipalExchanges, fpmlPrincipalExchangeList, fpmlCurrency, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList)
					.last();
			}
			return MapperS.<PrincipalExchange>ofNull();
		}
	}
}
