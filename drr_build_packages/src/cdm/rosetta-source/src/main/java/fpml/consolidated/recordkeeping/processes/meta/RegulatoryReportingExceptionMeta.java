package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryReportingException;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryReportingExceptionTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryReportingExceptionValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryReportingExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryReportingException.class)
public class RegulatoryReportingExceptionMeta implements RosettaMetaData<RegulatoryReportingException> {

	@Override
	public List<Validator<? super RegulatoryReportingException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryReportingException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryReportingException> validator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingException>create(RegulatoryReportingExceptionValidator.class);
	}

	@Override
	public Validator<? super RegulatoryReportingException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryReportingException>create(RegulatoryReportingExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingException> validator() {
		return new RegulatoryReportingExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryReportingException> typeFormatValidator() {
		return new RegulatoryReportingExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryReportingException, Set<String>> onlyExistsValidator() {
		return new RegulatoryReportingExceptionOnlyExistsValidator();
	}
}
