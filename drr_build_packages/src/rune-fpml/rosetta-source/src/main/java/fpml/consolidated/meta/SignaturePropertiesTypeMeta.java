package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignaturePropertiesType;
import fpml.consolidated.validation.SignaturePropertiesTypeTypeFormatValidator;
import fpml.consolidated.validation.SignaturePropertiesTypeValidator;
import fpml.consolidated.validation.exists.SignaturePropertiesTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignaturePropertiesType.class)
public class SignaturePropertiesTypeMeta implements RosettaMetaData<SignaturePropertiesType> {

	@Override
	public List<Validator<? super SignaturePropertiesType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignaturePropertiesType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignaturePropertiesType> validator(ValidatorFactory factory) {
		return factory.<SignaturePropertiesType>create(SignaturePropertiesTypeValidator.class);
	}

	@Override
	public Validator<? super SignaturePropertiesType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignaturePropertiesType>create(SignaturePropertiesTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignaturePropertiesType> validator() {
		return new SignaturePropertiesTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignaturePropertiesType> typeFormatValidator() {
		return new SignaturePropertiesTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignaturePropertiesType, Set<String>> onlyExistsValidator() {
		return new SignaturePropertiesTypeOnlyExistsValidator();
	}
}
