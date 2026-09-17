package cdm.ingest.fpml.confirmation.product.fxswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverModelToCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxSwap;
import fpml.consolidated.fx.FxSwapLeg;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxSwapCounterpartyList.MapFxSwapCounterpartyListDefault.class)
public abstract class MapFxSwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverModelToCounterpartyList mapPayerReceiverModelToCounterpartyList;

	/**
	* @param fpmlFxSwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(FxSwap fpmlFxSwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlFxSwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(FxSwap fpmlFxSwap);

	public static class MapFxSwapCounterpartyListDefault extends MapFxSwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(FxSwap fpmlFxSwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlFxSwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, FxSwap fpmlFxSwap) {
			counterpartyList.addAll(toBuilder(mapPayerReceiverModelToCounterpartyList.evaluate(MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()).<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()).<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get())));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
