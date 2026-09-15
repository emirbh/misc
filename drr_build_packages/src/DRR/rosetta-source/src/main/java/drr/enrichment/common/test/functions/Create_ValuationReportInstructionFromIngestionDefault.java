package drr.enrichment.common.test.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.enrichment.common.valuation.functions.Create_ValuationReportInstructionFromInstruction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ValuationReportInstructionFromIngestionDefault.Create_ValuationReportInstructionFromIngestionDefaultDefault.class)
public abstract class Create_ValuationReportInstructionFromIngestionDefault implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ValuationReportInstructionFromInstruction create_ValuationReportInstructionFromInstruction;

	/**
	* @param originatingWorkflowStep 
	* @param reportableInformation 
	* @param regimeNameEnum 
	* @return valuationReportInstruction 
	*/
	public ValuationReportInstruction evaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, RegimeNameEnum regimeNameEnum) {
		ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstructionBuilder = doEvaluate(originatingWorkflowStep, reportableInformation, regimeNameEnum);
		
		final ValuationReportInstruction valuationReportInstruction;
		if (valuationReportInstructionBuilder == null) {
			valuationReportInstruction = null;
		} else {
			valuationReportInstruction = valuationReportInstructionBuilder.build();
			objectValidator.validate(ValuationReportInstruction.class, valuationReportInstruction);
		}
		
		return valuationReportInstruction;
	}

	protected abstract ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, RegimeNameEnum regimeNameEnum);

	public static class Create_ValuationReportInstructionFromIngestionDefaultDefault extends Create_ValuationReportInstructionFromIngestionDefault {
		@Override
		protected ValuationReportInstruction.ValuationReportInstructionBuilder doEvaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, RegimeNameEnum regimeNameEnum) {
			ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction = ValuationReportInstruction.builder();
			return assignOutput(valuationReportInstruction, originatingWorkflowStep, reportableInformation, regimeNameEnum);
		}
		
		protected ValuationReportInstruction.ValuationReportInstructionBuilder assignOutput(ValuationReportInstruction.ValuationReportInstructionBuilder valuationReportInstruction, WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation, RegimeNameEnum regimeNameEnum) {
			valuationReportInstruction = toBuilder(create_ValuationReportInstructionFromInstruction.evaluate(ReportableEvent.builder()
				.setOriginatingWorkflowStep(originatingWorkflowStep)
				.setReportableInformation(reportableInformation)
				.build(), CounterpartyRoleEnum.PARTY_1, CounterpartyRoleEnum.PARTY_2, null, null, regimeNameEnum));
			
			return Optional.ofNullable(valuationReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
