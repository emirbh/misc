package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCreditDefaultSwapPayoutList.MapCreditDefaultSwapPayoutListDefault.class)
public abstract class MapCreditDefaultSwapPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditDefaultSwapPayout mapCreditDefaultSwapPayout;
	@Inject protected MapFeeLegToInterestRateLegPayout mapFeeLegToInterestRateLegPayout;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlCreditDefaultSwap 
	* @param cdmCounterpartyList 
	* @return payouts 
	*/
	public List<? extends Payout> evaluate(CreditDefaultSwap fpmlCreditDefaultSwap, List<? extends Counterparty> cdmCounterpartyList) {
		List<Payout.PayoutBuilder> payoutsBuilder = doEvaluate(fpmlCreditDefaultSwap, cdmCounterpartyList);
		
		final List<? extends Payout> payouts;
		if (payoutsBuilder == null) {
			payouts = null;
		} else {
			payouts = payoutsBuilder.stream().map(Payout::build).collect(Collectors.toList());
			objectValidator.validate(Payout.class, payouts);
		}
		
		return payouts;
	}

	protected abstract List<Payout.PayoutBuilder> doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends PayerReceiver> generalTermsPayerReceiver(CreditDefaultSwap fpmlCreditDefaultSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditDefaultSwapPayoutListDefault extends MapCreditDefaultSwapPayoutList {
		@Override
		protected List<Payout.PayoutBuilder> doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<Payout.PayoutBuilder> payouts = new ArrayList<>();
			return assignOutput(payouts, fpmlCreditDefaultSwap, cdmCounterpartyList);
		}
		
		protected List<Payout.PayoutBuilder> assignOutput(List<Payout.PayoutBuilder> payouts, CreditDefaultSwap fpmlCreditDefaultSwap, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout0 = mapCreditDefaultSwapPayout.evaluate(fpmlCreditDefaultSwap, generalTermsPayerReceiver(fpmlCreditDefaultSwap, cdmCounterpartyList).get(), cdmCounterpartyList);
			if (payout0 == null) {
				payouts.addAll(toBuilder(Collections.<Payout>emptyList()));
			} else {
				payouts.addAll(toBuilder(Collections.singletonList(payout0)));
			}
			
			if (exists(MapperS.of(fpmlCreditDefaultSwap).<FeeLeg>map("getFeeLeg", creditDefaultSwap -> creditDefaultSwap.getFeeLeg()).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment())).getOrDefault(false)) {
				final Payout payout1 = mapFeeLegToInterestRateLegPayout.evaluate(MapperS.of(fpmlCreditDefaultSwap).<FeeLeg>map("getFeeLeg", creditDefaultSwap -> creditDefaultSwap.getFeeLeg()).get(), MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).getMulti(), generalTermsPayerReceiver(fpmlCreditDefaultSwap, cdmCounterpartyList).get(), cdmCounterpartyList);
				if (payout1 == null) {
					payouts.addAll(toBuilder(Collections.<Payout>emptyList()));
				} else {
					payouts.addAll(toBuilder(Collections.singletonList(payout1)));
				}
			} else {
				payouts.addAll(toBuilder(Collections.<Payout>emptyList()));
			}
			
			return Optional.ofNullable(payouts)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PayerReceiver> generalTermsPayerReceiver(CreditDefaultSwap fpmlCreditDefaultSwap, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<PartyReference>map("getSellerPartyReference", generalTerms -> generalTerms.getSellerPartyReference()).get(), MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<PartyReference>map("getBuyerPartyReference", generalTerms -> generalTerms.getBuyerPartyReference()).get(), cdmCounterpartyList));
		}
	}
}
