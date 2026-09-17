package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.validation.ReportingBooleanTypeFormatValidator;
import fpml.consolidated.doc.validation.ReportingBooleanValidator;
import fpml.consolidated.doc.validation.exists.ReportingBooleanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingBoolean.class)
public class ReportingBooleanMeta implements RosettaMetaData<ReportingBoolean> {

	@Override
	public List<Validator<? super ReportingBoolean>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingBoolean, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingBoolean> validator(ValidatorFactory factory) {
		return factory.<ReportingBoolean>create(ReportingBooleanValidator.class);
	}

	@Override
	public Validator<? super ReportingBoolean> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingBoolean>create(ReportingBooleanTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingBoolean> validator() {
		return new ReportingBooleanValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingBoolean> typeFormatValidator() {
		return new ReportingBooleanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingBoolean, Set<String>> onlyExistsValidator() {
		return new ReportingBooleanOnlyExistsValidator();
	}
}
