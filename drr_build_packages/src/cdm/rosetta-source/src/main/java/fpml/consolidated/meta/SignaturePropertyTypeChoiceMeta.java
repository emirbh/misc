package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignaturePropertyTypeChoice;
import fpml.consolidated.validation.SignaturePropertyTypeChoiceTypeFormatValidator;
import fpml.consolidated.validation.SignaturePropertyTypeChoiceValidator;
import fpml.consolidated.validation.exists.SignaturePropertyTypeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignaturePropertyTypeChoice.class)
public class SignaturePropertyTypeChoiceMeta implements RosettaMetaData<SignaturePropertyTypeChoice> {

	@Override
	public List<Validator<? super SignaturePropertyTypeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignaturePropertyTypeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignaturePropertyTypeChoice> validator(ValidatorFactory factory) {
		return factory.<SignaturePropertyTypeChoice>create(SignaturePropertyTypeChoiceValidator.class);
	}

	@Override
	public Validator<? super SignaturePropertyTypeChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignaturePropertyTypeChoice>create(SignaturePropertyTypeChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignaturePropertyTypeChoice> validator() {
		return new SignaturePropertyTypeChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignaturePropertyTypeChoice> typeFormatValidator() {
		return new SignaturePropertyTypeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignaturePropertyTypeChoice, Set<String>> onlyExistsValidator() {
		return new SignaturePropertyTypeChoiceOnlyExistsValidator();
	}
}
