package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityClassificationListToObservableCommodityWithAddress;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.OilPhysicalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOilPhysicalLegToSettlementPayout.MapOilPhysicalLegToSettlementPayoutDefault.class)
public abstract class MapOilPhysicalLegToSettlementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithAddress mapCommodityClassificationListToObservableCommodityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlOilPhysicalLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(OilPhysicalLeg fpmlOilPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlOilPhysicalLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(OilPhysicalLeg fpmlOilPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapOilPhysicalLegToSettlementPayoutDefault extends MapOilPhysicalLegToSettlementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(OilPhysicalLeg fpmlOilPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlOilPhysicalLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, OilPhysicalLeg fpmlOilPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setSettlementPayout(SettlementPayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlOilPhysicalLeg).<PartyReference>map("getPayerPartyReference", oilPhysicalLeg -> oilPhysicalLeg.getPayerPartyReference()).get(), MapperS.of(fpmlOilPhysicalLeg).<PartyReference>map("getReceiverPartyReference", oilPhysicalLeg -> oilPhysicalLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapCommodityClassificationListToObservableCommodityWithAddress.evaluate(MapperS.of(fpmlOilPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", oilPhysicalLeg -> oilPhysicalLeg.getCommodityClassification()).getMulti(), fpmlOilPhysicalLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
