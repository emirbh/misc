package drr.base.trade.link.functions;

import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ExecutionDetails;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradeForEvent;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PackageInformation.PackageInformationDefault.class)
public abstract class PackageInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return packageInformation 
	*/
	public IdentifiedList evaluate(ReportableEventBase reportableEvent) {
		IdentifiedList.IdentifiedListBuilder packageInformationBuilder = doEvaluate(reportableEvent);
		
		final IdentifiedList packageInformation;
		if (packageInformationBuilder == null) {
			packageInformation = null;
		} else {
			packageInformation = packageInformationBuilder.build();
			objectValidator.validate(IdentifiedList.class, packageInformation);
		}
		
		return packageInformation;
	}

	protected abstract IdentifiedList.IdentifiedListBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class PackageInformationDefault extends PackageInformation {
		@Override
		protected IdentifiedList.IdentifiedListBuilder doEvaluate(ReportableEventBase reportableEvent) {
			IdentifiedList.IdentifiedListBuilder packageInformation = IdentifiedList.builder();
			return assignOutput(packageInformation, reportableEvent);
		}
		
		protected IdentifiedList.IdentifiedListBuilder assignOutput(IdentifiedList.IdentifiedListBuilder packageInformation, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<IdentifiedList>map("getPackageInformation", businessEvent -> businessEvent.getPackageInformation())).getOrDefault(false)) {
				packageInformation = toBuilder(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<IdentifiedList>map("getPackageInformation", businessEvent -> businessEvent.getPackageInformation()).get());
			} else if (exists(MapperS.of(tradeForEvent.evaluate(reportableEvent)).<ExecutionDetails>map("getExecutionDetails", trade -> trade.getExecutionDetails()).<IdentifiedList>map("getPackageReference", executionDetails -> executionDetails.getPackageReference())).getOrDefault(false)) {
				packageInformation = toBuilder(MapperS.of(tradeForEvent.evaluate(reportableEvent)).<ExecutionDetails>map("getExecutionDetails", trade -> trade.getExecutionDetails()).<IdentifiedList>map("getPackageReference", executionDetails -> executionDetails.getPackageReference()).get());
			} else {
				packageInformation = null;
			}
			
			return Optional.ofNullable(packageInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
