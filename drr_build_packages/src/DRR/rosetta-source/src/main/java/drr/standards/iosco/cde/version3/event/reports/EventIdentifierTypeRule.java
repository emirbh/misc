package drr.standards.iosco.cde.version3.event.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.qualification.functions.Qualify_CreditEventDetermined;
import cdm.event.qualification.functions.Qualify_PortfolioRebalancing;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventIdentifierTypeRule.EventIdentifierTypeRuleDefault.class)
public abstract class EventIdentifierTypeRule implements ReportFunction<TransactionReportInstructionBase, EventTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected Qualify_CreditEventDetermined qualify_CreditEventDetermined;
	@Inject protected Qualify_PortfolioRebalancing qualify_PortfolioRebalancing;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EventTypeEnum evaluate(TransactionReportInstructionBase input) {
		EventTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract EventTypeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class EventIdentifierTypeRuleDefault extends EventIdentifierTypeRule {
		@Override
		protected EventTypeEnum doEvaluate(TransactionReportInstructionBase input) {
			EventTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected EventTypeEnum assignOutput(EventTypeEnum output, TransactionReportInstructionBase input) {
			final MapperS<BusinessEvent> thenArg;
			if (exists(MapperS.of(input).<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<Identifier>mapC("getEventIdentifier", workflowStep -> workflowStep.getEventIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier())).getOrDefault(false)) {
				thenArg = MapperS.of(input)
					.mapSingleToItem(item -> item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()));
			} else {
				thenArg = MapperS.<BusinessEvent>ofNull();
			}
			output = thenArg
				.mapSingleToItem(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Compression.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.COMPRESSION), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_PortfolioRebalancing.evaluate(item.get())))).getOrDefault(false)) {
						return MapperS.of(EventTypeEnum.COMP);
					}
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditEventDetermined.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CREDIT_EVENT), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(EventTypeEnum.CREV);
					}
					return MapperS.<EventTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
