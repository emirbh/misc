package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapTransactionSupplementCounterpartyList.MapDividendSwapTransactionSupplementCounterpartyListDefault.class)
public abstract class MapDividendSwapTransactionSupplementCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlDividendSwapTransactionSupplement 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlDividendSwapTransactionSupplement);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement);

	public static class MapDividendSwapTransactionSupplementCounterpartyListDefault extends MapDividendSwapTransactionSupplementCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlDividendSwapTransactionSupplement);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).<PartyReference>map("getPayerPartyReference", dividendLeg -> dividendLeg.getPayerPartyReference()).get(), MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg()).<PartyReference>map("getReceiverPartyReference", dividendLeg -> dividendLeg.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
