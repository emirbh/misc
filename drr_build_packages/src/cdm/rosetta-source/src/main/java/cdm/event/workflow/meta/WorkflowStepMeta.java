package cdm.event.workflow.meta;

import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.validation.WorkflowStepTypeFormatValidator;
import cdm.event.workflow.validation.WorkflowStepValidator;
import cdm.event.workflow.validation.datarule.WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice;
import cdm.event.workflow.validation.datarule.WorkflowStepWorkflowStepStatus;
import cdm.event.workflow.validation.exists.WorkflowStepOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=WorkflowStep.class)
public class WorkflowStepMeta implements RosettaMetaData<WorkflowStep> {

	@Override
	public List<Validator<? super WorkflowStep>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<WorkflowStep>create(WorkflowStepWorkflowStepStatus.class),
			factory.<WorkflowStep>create(WorkflowStepCounterpartyPositionBusinessEventOrBusinessEventChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WorkflowStep, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WorkflowStep> validator(ValidatorFactory factory) {
		return factory.<WorkflowStep>create(WorkflowStepValidator.class);
	}

	@Override
	public Validator<? super WorkflowStep> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WorkflowStep>create(WorkflowStepTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WorkflowStep> validator() {
		return new WorkflowStepValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WorkflowStep> typeFormatValidator() {
		return new WorkflowStepTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WorkflowStep, Set<String>> onlyExistsValidator() {
		return new WorkflowStepOnlyExistsValidator();
	}
}
