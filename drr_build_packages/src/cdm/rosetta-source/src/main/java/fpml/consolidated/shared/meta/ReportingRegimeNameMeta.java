package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ReportingRegimeName;
import fpml.consolidated.shared.validation.ReportingRegimeNameTypeFormatValidator;
import fpml.consolidated.shared.validation.ReportingRegimeNameValidator;
import fpml.consolidated.shared.validation.exists.ReportingRegimeNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingRegimeName.class)
public class ReportingRegimeNameMeta implements RosettaMetaData<ReportingRegimeName> {

	@Override
	public List<Validator<? super ReportingRegimeName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingRegimeName> validator(ValidatorFactory factory) {
		return factory.<ReportingRegimeName>create(ReportingRegimeNameValidator.class);
	}

	@Override
	public Validator<? super ReportingRegimeName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingRegimeName>create(ReportingRegimeNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRegimeName> validator() {
		return new ReportingRegimeNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingRegimeName> typeFormatValidator() {
		return new ReportingRegimeNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeName, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeNameOnlyExistsValidator();
	}
}
