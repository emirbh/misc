package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureValue;
import fpml.consolidated.validation.SignatureValueTypeFormatValidator;
import fpml.consolidated.validation.SignatureValueValidator;
import fpml.consolidated.validation.exists.SignatureValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignatureValue.class)
public class SignatureValueMeta implements RosettaMetaData<SignatureValue> {

	@Override
	public List<Validator<? super SignatureValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignatureValue> validator(ValidatorFactory factory) {
		return factory.<SignatureValue>create(SignatureValueValidator.class);
	}

	@Override
	public Validator<? super SignatureValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignatureValue>create(SignatureValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignatureValue> validator() {
		return new SignatureValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignatureValue> typeFormatValidator() {
		return new SignatureValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureValue, Set<String>> onlyExistsValidator() {
		return new SignatureValueOnlyExistsValidator();
	}
}
