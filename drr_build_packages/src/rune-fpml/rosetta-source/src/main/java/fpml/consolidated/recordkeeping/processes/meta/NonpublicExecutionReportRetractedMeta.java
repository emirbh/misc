package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReportRetracted;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportRetractedTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportRetractedValidator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.NonpublicExecutionReportRetractedChoice;
import fpml.consolidated.recordkeeping.processes.validation.exists.NonpublicExecutionReportRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonpublicExecutionReportRetracted.class)
public class NonpublicExecutionReportRetractedMeta implements RosettaMetaData<NonpublicExecutionReportRetracted> {

	@Override
	public List<Validator<? super NonpublicExecutionReportRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NonpublicExecutionReportRetracted>create(NonpublicExecutionReportRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NonpublicExecutionReportRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonpublicExecutionReportRetracted> validator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReportRetracted>create(NonpublicExecutionReportRetractedValidator.class);
	}

	@Override
	public Validator<? super NonpublicExecutionReportRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReportRetracted>create(NonpublicExecutionReportRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReportRetracted> validator() {
		return new NonpublicExecutionReportRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReportRetracted> typeFormatValidator() {
		return new NonpublicExecutionReportRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonpublicExecutionReportRetracted, Set<String>> onlyExistsValidator() {
		return new NonpublicExecutionReportRetractedOnlyExistsValidator();
	}
}
