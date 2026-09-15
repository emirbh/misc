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
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEnvironmentalPhysicalLegToSettlementPayout.MapEnvironmentalPhysicalLegToSettlementPayoutDefault.class)
public abstract class MapEnvironmentalPhysicalLegToSettlementPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationListToObservableCommodityWithAddress mapCommodityClassificationListToObservableCommodityWithAddress;
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlEnvironmentalPhysicalLeg 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlEnvironmentalPhysicalLeg, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapEnvironmentalPhysicalLegToSettlementPayoutDefault extends MapEnvironmentalPhysicalLegToSettlementPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlEnvironmentalPhysicalLeg, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, EnvironmentalPhysicalLeg fpmlEnvironmentalPhysicalLeg, List<? extends Counterparty> cdmCounterpartyList) {
			payout = toBuilder(Payout.builder()
				.setSettlementPayout(SettlementPayout.builder()
					.setPayerReceiver(mapPayerReceiver.evaluate(MapperS.of(fpmlEnvironmentalPhysicalLeg).<PartyReference>map("getPayerPartyReference", environmentalPhysicalLeg -> environmentalPhysicalLeg.getPayerPartyReference()).get(), MapperS.of(fpmlEnvironmentalPhysicalLeg).<PartyReference>map("getReceiverPartyReference", environmentalPhysicalLeg -> environmentalPhysicalLeg.getReceiverPartyReference()).get(), cdmCounterpartyList))
					.setUnderlier(Underlier.builder()
						.setObservable(mapCommodityClassificationListToObservableCommodityWithAddress.evaluate(MapperS.of(fpmlEnvironmentalPhysicalLeg).<CommodityClassification>mapC("getCommodityClassification", environmentalPhysicalLeg -> environmentalPhysicalLeg.getCommodityClassification()).getMulti(), fpmlEnvironmentalPhysicalLeg))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
