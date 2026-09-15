package drr.base.trade.quantity.functions;

import cdm.event.common.Trade;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.base.trade.functions.TradeForEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetTradeForQuantity.GetTradeForQuantityDefault.class)
public abstract class GetTradeForQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return trade 
	*/
	public Trade evaluate(ReportableEventBase reportableEvent) {
		Trade.TradeBuilder tradeBuilder = doEvaluate(reportableEvent);
		
		final Trade trade;
		if (tradeBuilder == null) {
			trade = null;
		} else {
			trade = tradeBuilder.build();
			objectValidator.validate(Trade.class, trade);
		}
		
		return trade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class GetTradeForQuantityDefault extends GetTradeForQuantity {
		@Override
		protected Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent) {
			Trade.TradeBuilder trade = Trade.builder();
			return assignOutput(trade, reportableEvent);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder trade, ReportableEventBase reportableEvent) {
			final Boolean _boolean = isActionTypeTERM.evaluate(reportableEvent);
			if ((_boolean == null ? false : _boolean)) {
				trade = toBuilder(beforeTradeForEvent.evaluate(reportableEvent));
			} else {
				trade = toBuilder(tradeForEvent.evaluate(reportableEvent));
			}
			
			return Optional.ofNullable(trade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
