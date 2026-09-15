package cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.common.functions.MapResolvablePriceQuantityReference;
import cdm.ingest.fpml.confirmation.other.functions.MapOptionTypeEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapSwapOptionStrikePrice;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapCreditDefaultSwapNonTransferableProduct;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.CreditOptionStrike;
import fpml.consolidated.cd.PhysicalSettlementTerms;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NotionalAmountReference;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapOptionPayout.MapCreditDefaultSwapOptionPayoutDefault.class)
public abstract class MapCreditDefaultSwapOptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCreditDefaultSwapNonTransferableProduct mapCreditDefaultSwapNonTransferableProduct;
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapOptionTypeEnum mapOptionTypeEnum;
	@Inject protected MapPhysicalSettlementTermsWithReference mapPhysicalSettlementTermsWithReference;
	@Inject protected MapResolvablePriceQuantityReference mapResolvablePriceQuantityReference;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;
	@Inject protected MapSwapOptionFeature mapSwapOptionFeature;
	@Inject protected MapSwapOptionStrikePrice mapSwapOptionStrikePrice;

	/**
	* @param fpmlCreditDefaultSwapOption 
	* @param cdmCounterpartyList 
	* @param fpmlTradeHeader 
	* @param fpmlPhysicalSettlement 
	* @return payout 
	*/
	public Payout evaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader, PhysicalSettlementTerms fpmlPhysicalSettlement) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader, fpmlPhysicalSettlement);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader, PhysicalSettlementTerms fpmlPhysicalSettlement);

	public static class MapCreditDefaultSwapOptionPayoutDefault extends MapCreditDefaultSwapOptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader, PhysicalSettlementTerms fpmlPhysicalSettlement) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlCreditDefaultSwapOption, cdmCounterpartyList, fpmlTradeHeader, fpmlPhysicalSettlement);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, CreditDefaultSwapOption fpmlCreditDefaultSwapOption, List<? extends Counterparty> cdmCounterpartyList, TradeHeader fpmlTradeHeader, PhysicalSettlementTerms fpmlPhysicalSettlement) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<PartyReference>map("getSellerPartyReference", creditDefaultSwapOption -> creditDefaultSwapOption.getSellerPartyReference()).get(), MapperS.of(fpmlCreditDefaultSwapOption).<PartyReference>map("getBuyerPartyReference", creditDefaultSwapOption -> creditDefaultSwapOption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantityReference(mapResolvablePriceQuantityReference.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<NotionalAmountReference>map("getNotionalReference", creditDefaultSwapOption -> creditDefaultSwapOption.getNotionalReference()).<String>map("getHref", notionalAmountReference -> notionalAmountReference.getHref()).get()))
						.build())
					.setPrincipalPayment(null)
					.setSettlementTerms(SettlementTerms.builder()
						.setSettlementType(MapperS.of(fpmlCreditDefaultSwapOption).<SettlementTypeEnum>map("getSettlementType", creditDefaultSwapOption -> creditDefaultSwapOption.getSettlementType()).checkedMap("to-enum", e -> cdm.product.common.settlement.SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
						.setSettlementCurrency(mapCurrency.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<Currency>map("getSettlementCurrency", creditDefaultSwapOption -> creditDefaultSwapOption.getSettlementCurrency()).get()))
						.setPhysicalSettlementTerms(mapPhysicalSettlementTermsWithReference.evaluate(fpmlCreditDefaultSwapOption))
						.build())
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<PartyReference>map("getBuyerPartyReference", creditDefaultSwapOption -> creditDefaultSwapOption.getBuyerPartyReference()).get(), MapperS.of(fpmlCreditDefaultSwapOption).<PartyReference>map("getSellerPartyReference", creditDefaultSwapOption -> creditDefaultSwapOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setFeature(mapSwapOptionFeature.evaluate(fpmlCreditDefaultSwapOption, cdmCounterpartyList))
					.setObservationTerms(null)
					.setSchedule(null)
					.setDelivery(null)
					.setUnderlier(Underlier.builder()
						.setProduct(Product.builder()
							.setNonTransferableProduct(mapCreditDefaultSwapNonTransferableProduct.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).get(), null, cdmCounterpartyList))
							.build())
						.build())
					.setOptionType(mapOptionTypeEnum.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<OptionTypeEnum>map("getOptionType", creditDefaultSwapOption -> creditDefaultSwapOption.getOptionType()).map("to-string", OptionTypeEnum::toDisplayString).get()))
					.setExerciseTerms(mapExerciseTerms.evaluate(MapperS.of(fpmlCreditDefaultSwapOption).<Exercise>map("getExercise", creditDefaultSwapOption -> creditDefaultSwapOption.getExercise()).get(), MapperS.of(fpmlCreditDefaultSwapOption).<ExerciseProcedure>map("getExerciseProcedure", creditDefaultSwapOption -> creditDefaultSwapOption.getExerciseProcedure()).get(), null, MapperS.of(fpmlCreditDefaultSwapOption).<PartyReference>map("getBuyerPartyReference", creditDefaultSwapOption -> creditDefaultSwapOption.getBuyerPartyReference()).get(), MapperS.of(fpmlCreditDefaultSwapOption).<PartyReference>map("getSellerPartyReference", creditDefaultSwapOption -> creditDefaultSwapOption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(mapSwapOptionStrikePrice.evaluate(fpmlCreditDefaultSwapOption, MapperS.of(fpmlCreditDefaultSwapOption).<CreditOptionStrike>map("getStrike", creditDefaultSwapOption -> creditDefaultSwapOption.getStrike()).<BigDecimal>map("getSpread", creditOptionStrike -> creditOptionStrike.getSpread()).get(), null, MapperS.of(fpmlCreditDefaultSwapOption).<CreditDefaultSwap>map("getCreditDefaultSwap", creditDefaultSwapOption -> creditDefaultSwapOption.getCreditDefaultSwap()).<ProtectionTerms>mapC("getProtectionTerms", creditDefaultSwap -> creditDefaultSwap.getProtectionTerms()).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<Currency>map("getCurrency", money -> money.getCurrency())
						.first().get()))
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
