package cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapOptionTransactionSupplementCounterpartyList.MapDividendSwapOptionTransactionSupplementCounterpartyListDefault.class)
public abstract class MapDividendSwapOptionTransactionSupplementCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerModelToCounterpartyList mapBuyerSellerModelToCounterpartyList;

	/**
	* @param fpmlDividendSwapOptionTransactionSupplement 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlDividendSwapOptionTransactionSupplement);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement);

	public static class MapDividendSwapOptionTransactionSupplementCounterpartyListDefault extends MapDividendSwapOptionTransactionSupplementCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlDividendSwapOptionTransactionSupplement);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement) {
			counterpartyList.addAll(toBuilder(mapBuyerSellerModelToCounterpartyList.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getBuyerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getBuyerPartyReference()).get(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<PartyReference>map("getSellerPartyReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getSellerPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
