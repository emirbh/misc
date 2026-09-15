package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignaturePropertyType;
import fpml.consolidated.validation.SignaturePropertyTypeTypeFormatValidator;
import fpml.consolidated.validation.SignaturePropertyTypeValidator;
import fpml.consolidated.validation.exists.SignaturePropertyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignaturePropertyType.class)
public class SignaturePropertyTypeMeta implements RosettaMetaData<SignaturePropertyType> {

	@Override
	public List<Validator<? super SignaturePropertyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignaturePropertyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignaturePropertyType> validator(ValidatorFactory factory) {
		return factory.<SignaturePropertyType>create(SignaturePropertyTypeValidator.class);
	}

	@Override
	public Validator<? super SignaturePropertyType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignaturePropertyType>create(SignaturePropertyTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignaturePropertyType> validator() {
		return new SignaturePropertyTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignaturePropertyType> typeFormatValidator() {
		return new SignaturePropertyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignaturePropertyType, Set<String>> onlyExistsValidator() {
		return new SignaturePropertyTypeOnlyExistsValidator();
	}
}
