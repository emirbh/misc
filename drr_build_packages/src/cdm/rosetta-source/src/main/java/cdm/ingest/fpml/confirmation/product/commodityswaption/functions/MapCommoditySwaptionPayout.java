package cdm.ingest.fpml.confirmation.product.commodityswaption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlCommodityPhysicalExercise;
import cdm.ingest.fpml.confirmation.common.functions.MapExerciseTerms;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSeller;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.settlement.functions.MapCommoditySwaptionSettlementTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.com.CommoditySwaptionUnderlying;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwaptionPayout.MapCommoditySwaptionPayoutDefault.class)
public abstract class MapCommoditySwaptionPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlCommodityPhysicalExercise getFpmlCommodityPhysicalExercise;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCommoditySwaptionSettlementTerms mapCommoditySwaptionSettlementTerms;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;
	@Inject protected MapUnderlierNonTransferableProduct mapUnderlierNonTransferableProduct;

	/**
	* @param fpmlCommoditySwaption 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlCommoditySwaption, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommoditySwaptionPayoutDefault extends MapCommoditySwaptionPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlCommoditySwaption, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, CommoditySwaption fpmlCommoditySwaption, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setOptionPayout(OptionPayout.builder()
					.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getSellerPartyReference", commoditySwaption -> commoditySwaption.getSellerPartyReference()).get(), MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getBuyerPartyReference", commoditySwaption -> commoditySwaption.getBuyerPartyReference()).get(), cdmCounterpartyList))
					.setSettlementTerms(mapCommoditySwaptionSettlementTerms.evaluate(fpmlCommoditySwaption))
					.setBuyerSeller(mapBuyerSeller.evaluate(MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getBuyerPartyReference", commoditySwaption -> commoditySwaption.getBuyerPartyReference()).get(), MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getSellerPartyReference", commoditySwaption -> commoditySwaption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setProduct(Product.builder()
							.setNonTransferableProduct(mapUnderlierNonTransferableProduct.evaluate(MapperS.of(fpmlCommoditySwaption).<CommoditySwaptionUnderlying>map("getCommoditySwap", commoditySwaption -> commoditySwaption.getCommoditySwap()).<CommodityLeg>mapC("getCommoditySwapLeg", commoditySwaptionUnderlying -> commoditySwaptionUnderlying.getCommoditySwapLeg()).getMulti(), MapperS.of(fpmlCommoditySwaption).<CommoditySwaptionUnderlying>map("getCommoditySwap", commoditySwaption -> commoditySwaption.getCommoditySwap()).<IdentifiedCurrency>map("getSettlementCurrency", commoditySwaptionUnderlying -> commoditySwaptionUnderlying.getSettlementCurrency()).get(), MapperS.of(fpmlCommoditySwaption).<CommoditySwaptionUnderlying>map("getCommoditySwap", commoditySwaption -> commoditySwaption.getCommoditySwap()).<AdjustableOrRelativeDate>map("getEffectiveDate", commoditySwaptionUnderlying -> commoditySwaptionUnderlying.getEffectiveDate()).get(), MapperS.of(fpmlCommoditySwaption).<CommoditySwaptionUnderlying>map("getCommoditySwap", commoditySwaption -> commoditySwaption.getCommoditySwap()).<AdjustableOrRelativeDate>map("getTerminationDate", commoditySwaptionUnderlying -> commoditySwaptionUnderlying.getTerminationDate()).get(), cdmCounterpartyList))
							.build())
						.build())
					.setOptionType(MapperS.of(fpmlCommoditySwaption).<PutCallEnum>map("getOptionType", commoditySwaption -> commoditySwaption.getOptionType()).checkedMap("to-enum", e -> OptionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.setExerciseTerms(mapExerciseTerms.evaluate(getFpmlCommodityPhysicalExercise.evaluate(MapperS.of(fpmlCommoditySwaption).<CommodityPhysicalExercise>map("getPhysicalExercise", commoditySwaption -> commoditySwaption.getPhysicalExercise()).get()), null, null, MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getBuyerPartyReference", commoditySwaption -> commoditySwaption.getBuyerPartyReference()).get(), MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getSellerPartyReference", commoditySwaption -> commoditySwaption.getSellerPartyReference()).get(), cdmCounterpartyList))
					.setStrike(null)
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
