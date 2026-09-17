package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.RSAKeyValueType;
import fpml.consolidated.validation.RSAKeyValueTypeTypeFormatValidator;
import fpml.consolidated.validation.RSAKeyValueTypeValidator;
import fpml.consolidated.validation.exists.RSAKeyValueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RSAKeyValueType.class)
public class RSAKeyValueTypeMeta implements RosettaMetaData<RSAKeyValueType> {

	@Override
	public List<Validator<? super RSAKeyValueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RSAKeyValueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RSAKeyValueType> validator(ValidatorFactory factory) {
		return factory.<RSAKeyValueType>create(RSAKeyValueTypeValidator.class);
	}

	@Override
	public Validator<? super RSAKeyValueType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RSAKeyValueType>create(RSAKeyValueTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RSAKeyValueType> validator() {
		return new RSAKeyValueTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RSAKeyValueType> typeFormatValidator() {
		return new RSAKeyValueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RSAKeyValueType, Set<String>> onlyExistsValidator() {
		return new RSAKeyValueTypeOnlyExistsValidator();
	}
}
