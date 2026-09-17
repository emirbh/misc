package cdm.ingest.fpml.confirmation.product.commodityswaption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwaptionCounterpartyList.MapCommoditySwaptionCounterpartyListDefault.class)
public abstract class MapCommoditySwaptionCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlCommoditySwaption 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(CommoditySwaption fpmlCommoditySwaption) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlCommoditySwaption);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(CommoditySwaption fpmlCommoditySwaption);

	public static class MapCommoditySwaptionCounterpartyListDefault extends MapCommoditySwaptionCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(CommoditySwaption fpmlCommoditySwaption) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlCommoditySwaption);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, CommoditySwaption fpmlCommoditySwaption) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getBuyerPartyReference", commoditySwaption -> commoditySwaption.getBuyerPartyReference()).get(), MapperS.of(fpmlCommoditySwaption).<PartyReference>map("getSellerPartyReference", commoditySwaption -> commoditySwaption.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
