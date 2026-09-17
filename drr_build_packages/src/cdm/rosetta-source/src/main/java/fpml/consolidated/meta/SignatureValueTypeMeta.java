package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureValueType;
import fpml.consolidated.validation.SignatureValueTypeTypeFormatValidator;
import fpml.consolidated.validation.SignatureValueTypeValidator;
import fpml.consolidated.validation.exists.SignatureValueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignatureValueType.class)
public class SignatureValueTypeMeta implements RosettaMetaData<SignatureValueType> {

	@Override
	public List<Validator<? super SignatureValueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureValueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignatureValueType> validator(ValidatorFactory factory) {
		return factory.<SignatureValueType>create(SignatureValueTypeValidator.class);
	}

	@Override
	public Validator<? super SignatureValueType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignatureValueType>create(SignatureValueTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignatureValueType> validator() {
		return new SignatureValueTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignatureValueType> typeFormatValidator() {
		return new SignatureValueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureValueType, Set<String>> onlyExistsValidator() {
		return new SignatureValueTypeOnlyExistsValidator();
	}
}
