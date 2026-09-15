package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReportException;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportExceptionTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.NonpublicExecutionReportExceptionValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.NonpublicExecutionReportExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonpublicExecutionReportException.class)
public class NonpublicExecutionReportExceptionMeta implements RosettaMetaData<NonpublicExecutionReportException> {

	@Override
	public List<Validator<? super NonpublicExecutionReportException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonpublicExecutionReportException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonpublicExecutionReportException> validator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReportException>create(NonpublicExecutionReportExceptionValidator.class);
	}

	@Override
	public Validator<? super NonpublicExecutionReportException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonpublicExecutionReportException>create(NonpublicExecutionReportExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReportException> validator() {
		return new NonpublicExecutionReportExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonpublicExecutionReportException> typeFormatValidator() {
		return new NonpublicExecutionReportExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonpublicExecutionReportException, Set<String>> onlyExistsValidator() {
		return new NonpublicExecutionReportExceptionOnlyExistsValidator();
	}
}
