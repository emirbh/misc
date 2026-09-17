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
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapGasPhysicalLegToSettlementPayout.MapGasPhysicalLegToSettlementPayoutDefault.class)
public abstract class MapGasPhysicalLegToSettlementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithAddress mapCommodityClassificationListToObservableCommodityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlGasPhysicalLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(GasPhysicalLeg fpmlGasPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlGasPhysicalLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(GasPhysicalLeg fpmlGasPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapGasPhysicalLegToSettlementPayoutDefault extends MapGasPhysicalLegToSettlementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(GasPhysicalLeg fpmlGasPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlGasPhysicalLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, GasPhysicalLeg fpmlGasPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setSettlementPayout(SettlementPayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlGasPhysicalLeg).<PartyReference>map("getPayerPartyReference", gasPhysicalLeg -> gasPhysicalLeg.getPayerPartyReference()).get(), MapperS.of(fpmlGasPhysicalLeg).<PartyReference>map("getReceiverPartyReference", gasPhysicalLeg -> gasPhysicalLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapCommodityClassificationListToObservableCommodityWithAddress.evaluate(MapperS.of(fpmlGasPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", gasPhysicalLeg -> gasPhysicalLeg.getCommodityClassification()).getMulti(), fpmlGasPhysicalLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
