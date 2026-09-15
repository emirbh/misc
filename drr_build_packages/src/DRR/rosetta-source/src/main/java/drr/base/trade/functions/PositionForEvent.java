package drr.base.trade.functions;

import cdm.event.position.CounterpartyPosition;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PositionForEvent.PositionForEventDefault.class)
public abstract class PositionForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionStateForEvent positionStateForEvent;

	/**
	* @param reportableEvent 
	* @return reportablePosition 
	*/
	public CounterpartyPosition evaluate(ReportableEventBase reportableEvent) {
		CounterpartyPosition.CounterpartyPositionBuilder reportablePositionBuilder = doEvaluate(reportableEvent);
		
		final CounterpartyPosition reportablePosition;
		if (reportablePositionBuilder == null) {
			reportablePosition = null;
		} else {
			reportablePosition = reportablePositionBuilder.build();
			objectValidator.validate(CounterpartyPosition.class, reportablePosition);
		}
		
		return reportablePosition;
	}

	protected abstract CounterpartyPosition.CounterpartyPositionBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class PositionForEventDefault extends PositionForEvent {
		@Override
		protected CounterpartyPosition.CounterpartyPositionBuilder doEvaluate(ReportableEventBase reportableEvent) {
			CounterpartyPosition.CounterpartyPositionBuilder reportablePosition = CounterpartyPosition.builder();
			return assignOutput(reportablePosition, reportableEvent);
		}
		
		protected CounterpartyPosition.CounterpartyPositionBuilder assignOutput(CounterpartyPosition.CounterpartyPositionBuilder reportablePosition, ReportableEventBase reportableEvent) {
			reportablePosition = toBuilder(MapperS.of(positionStateForEvent.evaluate(reportableEvent)).<CounterpartyPosition>map("getCounterpartyPosition", counterpartyPositionState -> counterpartyPositionState.getCounterpartyPosition()).get());
			
			return Optional.ofNullable(reportablePosition)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
