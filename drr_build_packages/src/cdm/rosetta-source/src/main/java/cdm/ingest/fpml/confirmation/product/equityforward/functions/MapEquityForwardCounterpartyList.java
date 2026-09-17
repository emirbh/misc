package cdm.ingest.fpml.confirmation.product.equityforward.functions;

import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.eqd.EquityForward;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEquityForwardCounterpartyList.MapEquityForwardCounterpartyListDefault.class)
public abstract class MapEquityForwardCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlEquityForward 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(EquityForward fpmlEquityForward) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlEquityForward);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(EquityForward fpmlEquityForward);

	public static class MapEquityForwardCounterpartyListDefault extends MapEquityForwardCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(EquityForward fpmlEquityForward) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlEquityForward);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, EquityForward fpmlEquityForward) {
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
