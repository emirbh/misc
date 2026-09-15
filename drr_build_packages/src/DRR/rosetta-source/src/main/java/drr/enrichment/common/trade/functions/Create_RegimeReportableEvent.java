package drr.enrichment.common.trade.functions;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.RegimeReportableEvent;
import drr.regulation.common.RegimeReportingSide;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_RegimeReportableEvent.Create_RegimeReportableEventDefault.class)
public abstract class Create_RegimeReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @param regimeReportingSide 
	* @return regimeReportableEvent 
	*/
	public RegimeReportableEvent evaluate(ReportableEvent reportableEvent, List<? extends RegimeReportingSide> regimeReportingSide) {
		RegimeReportableEvent.RegimeReportableEventBuilder regimeReportableEventBuilder = doEvaluate(reportableEvent, regimeReportingSide);
		
		final RegimeReportableEvent regimeReportableEvent;
		if (regimeReportableEventBuilder == null) {
			regimeReportableEvent = null;
		} else {
			regimeReportableEvent = regimeReportableEventBuilder.build();
			objectValidator.validate(RegimeReportableEvent.class, regimeReportableEvent);
		}
		
		return regimeReportableEvent;
	}

	protected abstract RegimeReportableEvent.RegimeReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, List<? extends RegimeReportingSide> regimeReportingSide);

	public static class Create_RegimeReportableEventDefault extends Create_RegimeReportableEvent {
		@Override
		protected RegimeReportableEvent.RegimeReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, List<? extends RegimeReportingSide> regimeReportingSide) {
			if (regimeReportingSide == null) {
				regimeReportingSide = Collections.emptyList();
			}
			RegimeReportableEvent.RegimeReportableEventBuilder regimeReportableEvent = RegimeReportableEvent.builder();
			return assignOutput(regimeReportableEvent, reportableEvent, regimeReportingSide);
		}
		
		protected RegimeReportableEvent.RegimeReportableEventBuilder assignOutput(RegimeReportableEvent.RegimeReportableEventBuilder regimeReportableEvent, ReportableEvent reportableEvent, List<? extends RegimeReportingSide> regimeReportingSide) {
			regimeReportableEvent = toBuilder(RegimeReportableEvent.builder()
				.setOriginatingWorkflowStep(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).get())
				.setReportableTrade(MapperS.of(reportableEvent).<TradeState>map("getReportableTrade", _reportableEvent -> _reportableEvent.getReportableTrade()).get())
				.setReportableInformation(MapperS.of(reportableEvent).<ReportableInformation>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get())
				.setReportablePosition(MapperS.of(reportableEvent).<CounterpartyPositionState>map("getReportablePosition", _reportableEvent -> _reportableEvent.getReportablePosition()).get())
				.setRegimeReportingSide(new ArrayList(regimeReportingSide))
				.build());
			
			return Optional.ofNullable(regimeReportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
