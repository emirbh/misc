package cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVarianceOptionTransactionSupplementCounterpartyList.MapVarianceOptionTransactionSupplementCounterpartyListDefault.class)
public abstract class MapVarianceOptionTransactionSupplementCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlVarianceOptionTransactionSupplement 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlVarianceOptionTransactionSupplement);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement);

	public static class MapVarianceOptionTransactionSupplementCounterpartyListDefault extends MapVarianceOptionTransactionSupplementCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlVarianceOptionTransactionSupplement);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
