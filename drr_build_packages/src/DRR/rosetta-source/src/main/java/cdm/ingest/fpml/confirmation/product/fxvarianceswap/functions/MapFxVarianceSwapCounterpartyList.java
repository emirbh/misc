package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import fpml.consolidated.fx.FxPerformanceFloatingLeg;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxVarianceSwapCounterpartyList.MapFxVarianceSwapCounterpartyListDefault.class)
public abstract class MapFxVarianceSwapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterparty mapCounterparty;

	/**
	* @param fpmlFxVarianceSwap 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(FxVarianceSwap fpmlFxVarianceSwap) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlFxVarianceSwap);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(FxVarianceSwap fpmlFxVarianceSwap);

	public static class MapFxVarianceSwapCounterpartyListDefault extends MapFxVarianceSwapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(FxVarianceSwap fpmlFxVarianceSwap) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlFxVarianceSwap);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, FxVarianceSwap fpmlFxVarianceSwap) {
			final Counterparty counterparty0 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_1, MapperS.of(fpmlFxVarianceSwap).<FxPerformanceFloatingLeg>map("getFloatingLeg", fxVarianceSwap -> fxVarianceSwap.getFloatingLeg()).<PartyReference>map("getPayerPartyReference", fxPerformanceFloatingLeg -> fxPerformanceFloatingLeg.getPayerPartyReference()).get());
			if (counterparty0 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty0)));
			}
			
			final Counterparty counterparty1 = mapCounterparty.evaluate(CounterpartyRoleEnum.PARTY_2, MapperS.of(fpmlFxVarianceSwap).<FxPerformanceFixedLeg>map("getFixedLeg", fxVarianceSwap -> fxVarianceSwap.getFixedLeg()).<PartyReference>map("getPayerPartyReference", fxPerformanceFixedLeg -> fxPerformanceFixedLeg.getPayerPartyReference()).get());
			if (counterparty1 == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else {
				counterpartyList.addAll(toBuilder(Collections.singletonList(counterparty1)));
			}
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
