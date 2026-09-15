package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityRelativePaymentDates;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityFixedLegToPriceWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityNotionalQuantityToQuantityWithAddress;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.FixedLeg;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedLegToFixedPricePayout.MapFixedLegToFixedPricePayoutDefault.class)
public abstract class MapFixedLegToFixedPricePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityFixedLegToPriceWithAddress mapCommodityFixedLegToPriceWithAddress;
	@Inject protected MapCommodityNotionalQuantityToQuantityWithAddress mapCommodityNotionalQuantityToQuantityWithAddress;
	@Inject protected MapCommodityRelativePaymentDates mapCommodityRelativePaymentDates;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlFixedLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FixedLeg fpmlFixedLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFixedLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FixedLeg fpmlFixedLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFixedLegToFixedPricePayoutDefault extends MapFixedLegToFixedPricePayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FixedLeg fpmlFixedLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFixedLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FixedLeg fpmlFixedLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setFixedPricePayout(FixedPricePayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlFixedLeg).<PartyReference>map("getPayerPartyReference", fixedLeg -> fixedLeg.getPayerPartyReference()).get(), MapperS.of(fpmlFixedLeg).<PartyReference>map("getReceiverPartyReference", fixedLeg -> fixedLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(mapCommodityNotionalQuantityToQuantityWithAddress.evaluate(MapperS.of(fpmlFixedLeg).<BigDecimal>map("getTotalNotionalQuantity", fixedLeg -> fixedLeg.getTotalNotionalQuantity()).get(), fpmlFixedLeg))
						.build())
					.setPaymentDates(mapCommodityRelativePaymentDates.evaluate(MapperS.of(fpmlFixedLeg).<CommodityRelativePaymentDates>map("getRelativePaymentDates", fixedLeg -> fixedLeg.getRelativePaymentDates()).get()))
					.setFixedPrice(FixedPrice.builder()
						.setPrice(mapCommodityFixedLegToPriceWithAddress.evaluate(MapperS.of(fpmlFixedLeg).<CommodityFixedPrice>map("getFixedPrice", fixedLeg -> fixedLeg.getFixedPrice()).get(), MapperS.of(fpmlFixedLeg).<CommodityFixedPriceSchedule>map("getFixedPriceSchedule", fixedLeg -> fixedLeg.getFixedPriceSchedule()).get(), fpmlFixedLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
