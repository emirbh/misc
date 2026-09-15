package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyInfoTypeChoice;
import fpml.consolidated.validation.KeyInfoTypeChoiceTypeFormatValidator;
import fpml.consolidated.validation.KeyInfoTypeChoiceValidator;
import fpml.consolidated.validation.datarule.KeyInfoTypeChoiceChoice;
import fpml.consolidated.validation.exists.KeyInfoTypeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KeyInfoTypeChoice.class)
public class KeyInfoTypeChoiceMeta implements RosettaMetaData<KeyInfoTypeChoice> {

	@Override
	public List<Validator<? super KeyInfoTypeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<KeyInfoTypeChoice>create(KeyInfoTypeChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KeyInfoTypeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KeyInfoTypeChoice> validator(ValidatorFactory factory) {
		return factory.<KeyInfoTypeChoice>create(KeyInfoTypeChoiceValidator.class);
	}

	@Override
	public Validator<? super KeyInfoTypeChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KeyInfoTypeChoice>create(KeyInfoTypeChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KeyInfoTypeChoice> validator() {
		return new KeyInfoTypeChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KeyInfoTypeChoice> typeFormatValidator() {
		return new KeyInfoTypeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyInfoTypeChoice, Set<String>> onlyExistsValidator() {
		return new KeyInfoTypeChoiceOnlyExistsValidator();
	}
}
