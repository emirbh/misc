package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignatureType;
import fpml.consolidated.validation.SignatureTypeTypeFormatValidator;
import fpml.consolidated.validation.SignatureTypeValidator;
import fpml.consolidated.validation.exists.SignatureTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignatureType.class)
public class SignatureTypeMeta implements RosettaMetaData<SignatureType> {

	@Override
	public List<Validator<? super SignatureType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignatureType> validator(ValidatorFactory factory) {
		return factory.<SignatureType>create(SignatureTypeValidator.class);
	}

	@Override
	public Validator<? super SignatureType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignatureType>create(SignatureTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignatureType> validator() {
		return new SignatureTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignatureType> typeFormatValidator() {
		return new SignatureTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureType, Set<String>> onlyExistsValidator() {
		return new SignatureTypeOnlyExistsValidator();
	}
}
