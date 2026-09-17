package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyInfoType;
import fpml.consolidated.validation.KeyInfoTypeTypeFormatValidator;
import fpml.consolidated.validation.KeyInfoTypeValidator;
import fpml.consolidated.validation.exists.KeyInfoTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KeyInfoType.class)
public class KeyInfoTypeMeta implements RosettaMetaData<KeyInfoType> {

	@Override
	public List<Validator<? super KeyInfoType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super KeyInfoType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KeyInfoType> validator(ValidatorFactory factory) {
		return factory.<KeyInfoType>create(KeyInfoTypeValidator.class);
	}

	@Override
	public Validator<? super KeyInfoType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KeyInfoType>create(KeyInfoTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KeyInfoType> validator() {
		return new KeyInfoTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KeyInfoType> typeFormatValidator() {
		return new KeyInfoTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyInfoType, Set<String>> onlyExistsValidator() {
		return new KeyInfoTypeOnlyExistsValidator();
	}
}
