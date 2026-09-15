package drr.standards.iosco.cde.version1.execution.reports;

import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ConfirmationMethodEnum;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.ConfirmationEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ConfirmedRule.ConfirmedRuleDefault.class)
public abstract class ConfirmedRule implements ReportFunction<TransactionReportInstructionBase, ConfirmationEnum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ConfirmationEnum evaluate(TransactionReportInstructionBase input) {
		ConfirmationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ConfirmationEnum doEvaluate(TransactionReportInstructionBase input);

	public static class ConfirmedRuleDefault extends ConfirmedRule {
		@Override
		protected ConfirmationEnum doEvaluate(TransactionReportInstructionBase input) {
			ConfirmationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ConfirmationEnum assignOutput(ConfirmationEnum output, TransactionReportInstructionBase input) {
			if (notEqual(MapperS.of(input).<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp()).<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.CONFIRMATION_DATE_TIME), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<ConfirmationMethodEnum>map("getConfirmationMethod", reportableInformationBase -> reportableInformationBase.getConfirmationMethod()), MapperS.of(ConfirmationMethodEnum.NOT_CONFIRMED), CardinalityOperator.All)).getOrDefault(false)) {
				output = ConfirmationEnum.NCNF;
			} else {
				output = MapperS.of(input)
					.mapSingleToItem(item -> {
						if (areEqual(item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<ConfirmationMethodEnum>map("getConfirmationMethod", reportableInformationBase -> reportableInformationBase.getConfirmationMethod()), MapperS.of(ConfirmationMethodEnum.ELECTRONIC), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(ConfirmationEnum.ECNF);
						}
						if (areEqual(item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<ConfirmationMethodEnum>map("getConfirmationMethod", reportableInformationBase -> reportableInformationBase.getConfirmationMethod()), MapperS.of(ConfirmationMethodEnum.NON_ELECTRONIC), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(ConfirmationEnum.YCNF);
						}
						return MapperS.<ConfirmationEnum>ofNull();
					}).get();
			}
			
			return output;
		}
	}
}
