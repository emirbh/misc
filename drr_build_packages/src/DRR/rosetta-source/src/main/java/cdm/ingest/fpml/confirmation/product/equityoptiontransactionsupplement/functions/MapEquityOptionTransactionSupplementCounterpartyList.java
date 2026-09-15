package cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionTransactionSupplementCounterpartyList.MapEquityOptionTransactionSupplementCounterpartyListDefault.class)
public abstract class MapEquityOptionTransactionSupplementCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlEquityOptionTransactionSupplement 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlEquityOptionTransactionSupplement);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement);

	public static class MapEquityOptionTransactionSupplementCounterpartyListDefault extends MapEquityOptionTransactionSupplementCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlEquityOptionTransactionSupplement);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, EquityOptionTransactionSupplement fpmlEquityOptionTransactionSupplement) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlEquityOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", equityOptionTransactionSupplement -> equityOptionTransactionSupplement.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
