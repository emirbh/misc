package drr.base.trade.valuation.functions;

import cdm.event.common.Valuation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.PositionStateForEvent;
import drr.base.trade.functions.TradeStateForEvent;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetValuation.GetValuationDefault.class)
public abstract class GetValuation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionStateForEvent positionStateForEvent;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param reportableEvent 
	* @return valuation 
	*/
	public Valuation evaluate(ReportableEventBase reportableEvent) {
		Valuation.ValuationBuilder valuationBuilder = doEvaluate(reportableEvent);
		
		final Valuation valuation;
		if (valuationBuilder == null) {
			valuation = null;
		} else {
			valuation = valuationBuilder.build();
			objectValidator.validate(Valuation.class, valuation);
		}
		
		return valuation;
	}

	protected abstract Valuation.ValuationBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class GetValuationDefault extends GetValuation {
		@Override
		protected Valuation.ValuationBuilder doEvaluate(ReportableEventBase reportableEvent) {
			Valuation.ValuationBuilder valuation = Valuation.builder();
			return assignOutput(valuation, reportableEvent);
		}
		
		protected Valuation.ValuationBuilder assignOutput(Valuation.ValuationBuilder valuation, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Valuation>mapC("getValuationHistory", tradeState -> tradeState.getValuationHistory())).getOrDefault(false)) {
				valuation = toBuilder(MapperS.of(tradeStateForEvent.evaluate(reportableEvent)).<Valuation>mapC("getValuationHistory", tradeState -> tradeState.getValuationHistory())
					.max(item -> item.<ZonedDateTime>map("getTimestamp", _valuation -> _valuation.getTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate()))).get());
			} else if (exists(MapperS.of(positionStateForEvent.evaluate(reportableEvent)).<Valuation>mapC("getValuationHistory", counterpartyPositionState -> counterpartyPositionState.getValuationHistory())).getOrDefault(false)) {
				valuation = toBuilder(MapperS.of(positionStateForEvent.evaluate(reportableEvent)).<Valuation>mapC("getValuationHistory", counterpartyPositionState -> counterpartyPositionState.getValuationHistory())
					.max(item -> item.<ZonedDateTime>map("getTimestamp", _valuation -> _valuation.getTimestamp()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate()))).get());
			} else {
				valuation = null;
			}
			
			return Optional.ofNullable(valuation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
