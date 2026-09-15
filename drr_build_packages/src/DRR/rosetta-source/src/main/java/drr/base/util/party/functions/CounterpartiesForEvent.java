package drr.base.util.party.functions;

import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradeForEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(CounterpartiesForEvent.CounterpartiesForEventDefault.class)
public abstract class CounterpartiesForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return counterparties 
	*/
	public List<? extends Counterparty> evaluate(ReportableEventBase reportableEvent) {
		List<Counterparty.CounterpartyBuilder> counterpartiesBuilder = doEvaluate(reportableEvent);
		
		final List<? extends Counterparty> counterparties;
		if (counterpartiesBuilder == null) {
			counterparties = null;
		} else {
			counterparties = counterpartiesBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterparties);
		}
		
		return counterparties;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(ReportableEventBase reportableEvent);

	public static class CounterpartiesForEventDefault extends CounterpartiesForEvent {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(ReportableEventBase reportableEvent) {
			List<Counterparty.CounterpartyBuilder> counterparties = new ArrayList<>();
			return assignOutput(counterparties, reportableEvent);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterparties, ReportableEventBase reportableEvent) {
			counterparties.addAll(toBuilder(MapperS.of(tradeForEvent.evaluate(reportableEvent)).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti()));
			
			return Optional.ofNullable(counterparties)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
