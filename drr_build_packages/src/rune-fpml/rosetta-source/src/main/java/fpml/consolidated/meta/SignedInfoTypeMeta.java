package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignedInfoType;
import fpml.consolidated.validation.SignedInfoTypeTypeFormatValidator;
import fpml.consolidated.validation.SignedInfoTypeValidator;
import fpml.consolidated.validation.exists.SignedInfoTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignedInfoType.class)
public class SignedInfoTypeMeta implements RosettaMetaData<SignedInfoType> {

	@Override
	public List<Validator<? super SignedInfoType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignedInfoType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignedInfoType> validator(ValidatorFactory factory) {
		return factory.<SignedInfoType>create(SignedInfoTypeValidator.class);
	}

	@Override
	public Validator<? super SignedInfoType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignedInfoType>create(SignedInfoTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignedInfoType> validator() {
		return new SignedInfoTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignedInfoType> typeFormatValidator() {
		return new SignedInfoTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignedInfoType, Set<String>> onlyExistsValidator() {
		return new SignedInfoTypeOnlyExistsValidator();
	}
}
