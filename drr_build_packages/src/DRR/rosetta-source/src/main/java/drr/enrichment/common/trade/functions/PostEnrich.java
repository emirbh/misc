package drr.enrichment.common.trade.functions;

import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.common.ReportableInformation;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PostEnrich.PostEnrichDefault.class)
public abstract class PostEnrich implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState 
	* @param enrichedWorkflowStep 
	* @return reportableInformation 
	*/
	public ReportableInformation evaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
		ReportableInformation.ReportableInformationBuilder reportableInformationBuilder = doEvaluate(tradeState, enrichedWorkflowStep);
		
		final ReportableInformation reportableInformation;
		if (reportableInformationBuilder == null) {
			reportableInformation = null;
		} else {
			reportableInformation = reportableInformationBuilder.build();
			objectValidator.validate(ReportableInformation.class, reportableInformation);
		}
		
		return reportableInformation;
	}

	protected abstract ReportableInformation.ReportableInformationBuilder doEvaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep);

	public static class PostEnrichDefault extends PostEnrich {
		@Override
		protected ReportableInformation.ReportableInformationBuilder doEvaluate(TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
			ReportableInformation.ReportableInformationBuilder reportableInformation = ReportableInformation.builder();
			return assignOutput(reportableInformation, tradeState, enrichedWorkflowStep);
		}
		
		protected ReportableInformation.ReportableInformationBuilder assignOutput(ReportableInformation.ReportableInformationBuilder reportableInformation, TradeState tradeState, WorkflowStep enrichedWorkflowStep) {
			return Optional.ofNullable(reportableInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
