package cdm.ingest.fpml.confirmation.product.genericproduct.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapGenericProductCounterpartyList.MapGenericProductCounterpartyListDefault.class)
public abstract class MapGenericProductCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlGenericProduct 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(GenericProduct fpmlGenericProduct) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlGenericProduct);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(GenericProduct fpmlGenericProduct);

	public static class MapGenericProductCounterpartyListDefault extends MapGenericProductCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(GenericProduct fpmlGenericProduct) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlGenericProduct);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, GenericProduct fpmlGenericProduct) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlGenericProduct).<PartyReference>map("getBuyerPartyReference", genericProduct -> genericProduct.getBuyerPartyReference()).get(), MapperS.of(fpmlGenericProduct).<PartyReference>map("getSellerPartyReference", genericProduct -> genericProduct.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
