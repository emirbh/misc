package cdm.ingest.fpml.confirmation.product.genericproduct.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapSellerAsPayerAndBuyerAsReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithAddress;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.CashflowNotional;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGenericProductPayout.MapGenericProductPayoutDefault.class)
public abstract class MapGenericProductPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithAddress mapAssetToObservableWithAddress;
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;
	@Inject protected MapSellerAsPayerAndBuyerAsReceiver mapSellerAsPayerAndBuyerAsReceiver;

	/**
	* @param fpmlGenericProduct 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlGenericProduct, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapGenericProductPayoutDefault extends MapGenericProductPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlGenericProduct, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList) {
			final MapperS<GenericProduct> thenArg = MapperS.of(fpmlGenericProduct);
			payout = toBuilder(thenArg
				.mapSingleToItem(item -> MapperS.of(Payout.builder()
					.setSettlementPayout(SettlementPayout.builder()
						.setPayerReceiver(mapSellerAsPayerAndBuyerAsReceiver.evaluate(item.<PartyReference>map("getSellerPartyReference", genericProduct -> genericProduct.getSellerPartyReference()).get(), item.<PartyReference>map("getBuyerPartyReference", genericProduct -> genericProduct.getBuyerPartyReference()).get(), cdmCounterpartyList))
						.setPriceQuantity(ResolvablePriceQuantity.builder()
							.setQuantitySchedule(mapNotionalAmountToQuantityWithAddress.evaluate(item.<CashflowNotional>mapC("getNotional", genericProduct -> genericProduct.getNotional()).<BigDecimal>map("getAmount", cashflowNotional -> cashflowNotional.getAmount())
								.first().get(), null))
							.build())
						.setSettlementTerms(SettlementTerms.builder()
							.setSettlementType(item.<SettlementTypeEnum>map("getSettlementType", genericProduct -> genericProduct.getSettlementType()).checkedMap("to-enum", e -> cdm.product.common.settlement.SettlementTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
							.build())
						.setUnderlier(Underlier.builder()
							.setObservable(mapAssetToObservableWithAddress.evaluate(item.<TradeUnderlyer2>mapC("getUnderlyer", genericProduct -> genericProduct.getUnderlyer()).<Asset>map("getUnderlyingAsset", tradeUnderlyer2 -> tradeUnderlyer2.getUnderlyingAsset())
								.first().get()))
							.build())
						.build())
					.build())).get());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
