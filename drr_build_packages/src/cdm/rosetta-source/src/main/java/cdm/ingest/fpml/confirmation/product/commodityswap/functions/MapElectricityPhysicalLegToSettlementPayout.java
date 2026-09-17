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
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapElectricityPhysicalLegToSettlementPayout.MapElectricityPhysicalLegToSettlementPayoutDefault.class)
public abstract class MapElectricityPhysicalLegToSettlementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithAddress mapCommodityClassificationListToObservableCommodityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlElectricityPhysicalLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(ElectricityPhysicalLeg fpmlElectricityPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlElectricityPhysicalLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(ElectricityPhysicalLeg fpmlElectricityPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapElectricityPhysicalLegToSettlementPayoutDefault extends MapElectricityPhysicalLegToSettlementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(ElectricityPhysicalLeg fpmlElectricityPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlElectricityPhysicalLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, ElectricityPhysicalLeg fpmlElectricityPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setSettlementPayout(SettlementPayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlElectricityPhysicalLeg).<PartyReference>map("getPayerPartyReference", electricityPhysicalLeg -> electricityPhysicalLeg.getPayerPartyReference()).get(), MapperS.of(fpmlElectricityPhysicalLeg).<PartyReference>map("getReceiverPartyReference", electricityPhysicalLeg -> electricityPhysicalLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapCommodityClassificationListToObservableCommodityWithAddress.evaluate(MapperS.of(fpmlElectricityPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", electricityPhysicalLeg -> electricityPhysicalLeg.getCommodityClassification()).getMulti(), fpmlElectricityPhysicalLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
