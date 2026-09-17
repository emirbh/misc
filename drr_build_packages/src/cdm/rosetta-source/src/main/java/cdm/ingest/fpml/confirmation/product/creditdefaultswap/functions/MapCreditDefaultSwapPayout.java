package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCreditDefaultSwapChoiceToSettlementTerms;
import cdm.observable.asset.TransactedPrice;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.BasketReferenceInformation;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapChoice;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.IndexReferenceInformation;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.cd.ReferenceInformation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapPayout.MapCreditDefaultSwapPayoutDefault.class)
public abstract class MapCreditDefaultSwapPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBasketReferenceInformation mapBasketReferenceInformation;
	@Inject protected MapCreditDefaultSwapChoiceToSettlementTerms mapCreditDefaultSwapChoiceToSettlementTerms;
	@Inject protected MapCreditIndex mapCreditIndex;
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;
	@Inject protected MapProtectionTerms mapProtectionTerms;
	@Inject protected MapReferenceInformation mapReferenceInformation;

	/**
	* @param fpmlCreditDefaultSwap 
	* @param cdmGeneralTermsPayerReceiver 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(CreditDefaultSwap fpmlCreditDefaultSwap, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlCreditDefaultSwap, cdmGeneralTermsPayerReceiver, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends Currency> currency(CreditDefaultSwap fpmlCreditDefaultSwap, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditDefaultSwapPayoutDefault extends MapCreditDefaultSwapPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlCreditDefaultSwap, cdmGeneralTermsPayerReceiver, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, CreditDefaultSwap fpmlCreditDefaultSwap, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			final ResolvablePriceQuantity.ResolvablePriceQuantityBuilder withMetaArgument = ResolvablePriceQuantity.builder()
				.setQuantitySchedule(mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<BigDecimal>map("getAmount", money -> money.getAmount())
					.first().get(), null))
				.build() == null ? null : ResolvablePriceQuantity.builder()
				.setQuantitySchedule(mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<BigDecimal>map("getAmount", money -> money.getAmount())
					.first().get(), null))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<String>map("getId", money -> money.getId())
				.first().get());
			payout = toBuilder(Payout.builder()
				.setCreditDefaultPayout(CreditDefaultPayout.builder()
					.setPayerReceiver(cdmGeneralTermsPayerReceiver)
					.setGeneralTerms(GeneralTerms.builder()
						.setReferenceInformation(mapReferenceInformation.evaluate(MapperS.of(fpmlCreditDefaultSwap).<fpml.consolidated.cd.GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).get(), currency(fpmlCreditDefaultSwap, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).get()))
						.setIndexReferenceInformation(mapCreditIndex.evaluate(MapperS.of(fpmlCreditDefaultSwap).<fpml.consolidated.cd.GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<IndexReferenceInformation>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation()).get()))
						.setBasketReferenceInformation(mapBasketReferenceInformation.evaluate(MapperS.of(fpmlCreditDefaultSwap).<fpml.consolidated.cd.GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).get()))
						.build())
					.setPriceQuantity(withMetaArgument)
					.setSettlementTerms(mapCreditDefaultSwapChoiceToSettlementTerms.evaluate(MapperS.of(fpmlCreditDefaultSwap).<CreditDefaultSwapChoice>mapC("getCreditDefaultSwapChoice", creditDefaultSwap -> creditDefaultSwap.getCreditDefaultSwapChoice()).getMulti()))
					.setProtectionTerms(MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms())
						.mapItem(item -> MapperS.of(mapProtectionTerms.evaluate(item.get(), cdmCounterpartyList))).getMulti())
					.setTransactedPrice(TransactedPrice.builder()
						.setMarketFixedRate(MapperS.of(fpmlCreditDefaultSwap).<FeeLeg>map("getFeeLeg", creditDefaultSwap -> creditDefaultSwap.getFeeLeg()).<BigDecimal>map("getMarketFixedRate", feeLeg -> feeLeg.getMarketFixedRate()).get())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Currency> currency(CreditDefaultSwap fpmlCreditDefaultSwap, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlCreditDefaultSwap).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<Currency>map("getCurrency", money -> money.getCurrency())
				.first();
		}
	}
}
