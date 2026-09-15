package drr.regulation.common.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.ReportableEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ExtractTradeCounterparty.ExtractTradeCounterpartyDefault.class)
public abstract class ExtractTradeCounterparty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @param role 
	* @return counterparty 
	*/
	public Counterparty evaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum role) {
		Counterparty.CounterpartyBuilder counterpartyBuilder = doEvaluate(reportableEvent, role);
		
		final Counterparty counterparty;
		if (counterpartyBuilder == null) {
			counterparty = null;
		} else {
			counterparty = counterpartyBuilder.build();
			objectValidator.validate(Counterparty.class, counterparty);
		}
		
		return counterparty;
	}

	protected abstract Counterparty.CounterpartyBuilder doEvaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum role);

	protected abstract MapperC<? extends Counterparty> counterparties(ReportableEvent reportableEvent, CounterpartyRoleEnum role);

	public static class ExtractTradeCounterpartyDefault extends ExtractTradeCounterparty {
		@Override
		protected Counterparty.CounterpartyBuilder doEvaluate(ReportableEvent reportableEvent, CounterpartyRoleEnum role) {
			Counterparty.CounterpartyBuilder counterparty = Counterparty.builder();
			return assignOutput(counterparty, reportableEvent, role);
		}
		
		protected Counterparty.CounterpartyBuilder assignOutput(Counterparty.CounterpartyBuilder counterparty, ReportableEvent reportableEvent, CounterpartyRoleEnum role) {
			counterparty = toBuilder(extractCounterpartyByRole.evaluate(counterparties(reportableEvent, role).getMulti(), role));
			
			return Optional.ofNullable(counterparty)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterparties(ReportableEvent reportableEvent, CounterpartyRoleEnum role) {
			return MapperS.of(tradeForEvent.evaluate(reportableEvent)).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty());
		}
	}
}
