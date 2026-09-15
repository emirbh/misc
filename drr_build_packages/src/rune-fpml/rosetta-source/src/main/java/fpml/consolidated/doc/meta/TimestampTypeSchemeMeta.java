package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TimestampTypeScheme;
import fpml.consolidated.doc.validation.TimestampTypeSchemeTypeFormatValidator;
import fpml.consolidated.doc.validation.TimestampTypeSchemeValidator;
import fpml.consolidated.doc.validation.exists.TimestampTypeSchemeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TimestampTypeScheme.class)
public class TimestampTypeSchemeMeta implements RosettaMetaData<TimestampTypeScheme> {

	@Override
	public List<Validator<? super TimestampTypeScheme>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimestampTypeScheme, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TimestampTypeScheme> validator(ValidatorFactory factory) {
		return factory.<TimestampTypeScheme>create(TimestampTypeSchemeValidator.class);
	}

	@Override
	public Validator<? super TimestampTypeScheme> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TimestampTypeScheme>create(TimestampTypeSchemeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TimestampTypeScheme> validator() {
		return new TimestampTypeSchemeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TimestampTypeScheme> typeFormatValidator() {
		return new TimestampTypeSchemeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimestampTypeScheme, Set<String>> onlyExistsValidator() {
		return new TimestampTypeSchemeOnlyExistsValidator();
	}
}
