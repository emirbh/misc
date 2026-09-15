package drr.enrichment.common.test.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractReportableTrade.ExtractReportableTradeDefault.class)
public abstract class ExtractReportableTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param workflowStep 
	* @return reportableTrade 
	*/
	public TradeState evaluate(WorkflowStep workflowStep) {
		TradeState.TradeStateBuilder reportableTradeBuilder = doEvaluate(workflowStep);
		
		final TradeState reportableTrade;
		if (reportableTradeBuilder == null) {
			reportableTrade = null;
		} else {
			reportableTrade = reportableTradeBuilder.build();
			objectValidator.validate(TradeState.class, reportableTrade);
		}
		
		return reportableTrade;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(WorkflowStep workflowStep);

	protected abstract MapperC<? extends FieldWithMetaString> eventIds(WorkflowStep workflowStep);

	public static class ExtractReportableTradeDefault extends ExtractReportableTrade {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(WorkflowStep workflowStep) {
			TradeState.TradeStateBuilder reportableTrade = TradeState.builder();
			return assignOutput(reportableTrade, workflowStep);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder reportableTrade, WorkflowStep workflowStep) {
			if (areEqual(eventIds(workflowStep).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("NovationNewTradeEventId"), CardinalityOperator.Any).getOrDefault(false)) {
				reportableTrade = toBuilder(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter())
					.first().get());
			} else if (areEqual(eventIds(workflowStep).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("NovationOldTradeEventId"), CardinalityOperator.Any).getOrDefault(false)) {
				reportableTrade = toBuilder(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter())
					.last().get());
			} else {
				reportableTrade = null;
			}
			
			return Optional.ofNullable(reportableTrade)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> eventIds(WorkflowStep workflowStep) {
			return MapperS.of(workflowStep).<Identifier>mapC("getEventIdentifier", _workflowStep -> _workflowStep.getEventIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier());
		}
	}
}
