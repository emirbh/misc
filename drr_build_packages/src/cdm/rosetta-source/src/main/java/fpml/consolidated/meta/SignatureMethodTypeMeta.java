package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureMethodType;
import fpml.consolidated.validation.SignatureMethodTypeTypeFormatValidator;
import fpml.consolidated.validation.SignatureMethodTypeValidator;
import fpml.consolidated.validation.exists.SignatureMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignatureMethodType.class)
public class SignatureMethodTypeMeta implements RosettaMetaData<SignatureMethodType> {

	@Override
	public List<Validator<? super SignatureMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignatureMethodType> validator(ValidatorFactory factory) {
		return factory.<SignatureMethodType>create(SignatureMethodTypeValidator.class);
	}

	@Override
	public Validator<? super SignatureMethodType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignatureMethodType>create(SignatureMethodTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignatureMethodType> validator() {
		return new SignatureMethodTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignatureMethodType> typeFormatValidator() {
		return new SignatureMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureMethodType, Set<String>> onlyExistsValidator() {
		return new SignatureMethodTypeOnlyExistsValidator();
	}
}
