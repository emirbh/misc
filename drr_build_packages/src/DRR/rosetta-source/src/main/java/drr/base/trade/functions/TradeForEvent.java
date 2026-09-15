package drr.base.trade.functions;

import cdm.event.common.Trade;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(TradeForEvent.TradeForEventDefault.class)
public abstract class TradeForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param reportableEvent 
	* @return reportableTrade 
	*/
	public Trade evaluate(ReportableEventBase reportableEvent) {
		Trade.TradeBuilder reportableTradeBuilder = doEvaluate(reportableEvent);
		
		final Trade reportableTrade;
		if (reportableTradeBuilder == null) {
			reportableTrade = null;
		} else {
			reportableTrade = reportableTradeBuilder.build();
			objectValidator.validate(Trade.class, reportableTrade);
		}
		
		return reportableTrade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class TradeForEventDefault extends TradeForEvent {
		@Override
		protected Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent) {
			Trade.TradeBuilder reportableTrade = Trade.builder();
			return assignOutput(reportableTrade, reportableEvent);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder reportableTrade, ReportableEventBase reportableEvent) {
			reportableTrade = toBuilder(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get());
			
			return Optional.ofNullable(reportableTrade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
