package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ReportingLevel;
import fpml.consolidated.doc.validation.ReportingLevelTypeFormatValidator;
import fpml.consolidated.doc.validation.ReportingLevelValidator;
import fpml.consolidated.doc.validation.exists.ReportingLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportingLevel.class)
public class ReportingLevelMeta implements RosettaMetaData<ReportingLevel> {

	@Override
	public List<Validator<? super ReportingLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportingLevel> validator(ValidatorFactory factory) {
		return factory.<ReportingLevel>create(ReportingLevelValidator.class);
	}

	@Override
	public Validator<? super ReportingLevel> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportingLevel>create(ReportingLevelTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportingLevel> validator() {
		return new ReportingLevelValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportingLevel> typeFormatValidator() {
		return new ReportingLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingLevel, Set<String>> onlyExistsValidator() {
		return new ReportingLevelOnlyExistsValidator();
	}
}
