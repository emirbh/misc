package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapCounterpartyList.MapCommoditySwapCounterpartyListDefault.class)
public abstract class MapCommoditySwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlPayer getFpmlPayer;
	@Inject protected GetFpmlReceiver getFpmlReceiver;
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlCommoditySwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(CommoditySwap fpmlCommoditySwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlCommoditySwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(CommoditySwap fpmlCommoditySwap);

	protected abstract MapperS<? extends PartyReference> payer(CommoditySwap fpmlCommoditySwap);

	protected abstract MapperS<? extends PartyReference> receiver(CommoditySwap fpmlCommoditySwap);

	public static class MapCommoditySwapCounterpartyListDefault extends MapCommoditySwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(CommoditySwap fpmlCommoditySwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlCommoditySwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, CommoditySwap fpmlCommoditySwap) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(payer(fpmlCommoditySwap).get(), receiver(fpmlCommoditySwap).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PartyReference> payer(CommoditySwap fpmlCommoditySwap) {
			final MapperC<PartyReference> thenArg = MapperS.of(fpmlCommoditySwap).<CommodityLeg>mapC("getCommoditySwapLeg", commoditySwap -> commoditySwap.getCommoditySwapLeg())
				.mapItem(item -> MapperS.of(getFpmlPayer.evaluate(item.get())));
			return thenArg
				.first();
		}
		
		@Override
		protected MapperS<? extends PartyReference> receiver(CommoditySwap fpmlCommoditySwap) {
			final MapperC<PartyReference> thenArg = MapperS.of(fpmlCommoditySwap).<CommodityLeg>mapC("getCommoditySwapLeg", commoditySwap -> commoditySwap.getCommoditySwapLeg())
				.mapItem(item -> MapperS.of(getFpmlReceiver.evaluate(item.get())));
			return thenArg
				.first();
		}
	}
}
