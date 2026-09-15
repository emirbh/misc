package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureProperties;
import fpml.consolidated.validation.SignaturePropertiesTypeFormatValidator;
import fpml.consolidated.validation.SignaturePropertiesValidator;
import fpml.consolidated.validation.exists.SignaturePropertiesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignatureProperties.class)
public class SignaturePropertiesMeta implements RosettaMetaData<SignatureProperties> {

	@Override
	public List<Validator<? super SignatureProperties>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureProperties, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignatureProperties> validator(ValidatorFactory factory) {
		return factory.<SignatureProperties>create(SignaturePropertiesValidator.class);
	}

	@Override
	public Validator<? super SignatureProperties> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignatureProperties>create(SignaturePropertiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignatureProperties> validator() {
		return new SignaturePropertiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignatureProperties> typeFormatValidator() {
		return new SignaturePropertiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureProperties, Set<String>> onlyExistsValidator() {
		return new SignaturePropertiesOnlyExistsValidator();
	}
}
