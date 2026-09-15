package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyValueType;
import fpml.consolidated.validation.KeyValueTypeTypeFormatValidator;
import fpml.consolidated.validation.KeyValueTypeValidator;
import fpml.consolidated.validation.datarule.KeyValueTypeChoice;
import fpml.consolidated.validation.exists.KeyValueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KeyValueType.class)
public class KeyValueTypeMeta implements RosettaMetaData<KeyValueType> {

	@Override
	public List<Validator<? super KeyValueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<KeyValueType>create(KeyValueTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KeyValueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KeyValueType> validator(ValidatorFactory factory) {
		return factory.<KeyValueType>create(KeyValueTypeValidator.class);
	}

	@Override
	public Validator<? super KeyValueType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KeyValueType>create(KeyValueTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KeyValueType> validator() {
		return new KeyValueTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KeyValueType> typeFormatValidator() {
		return new KeyValueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyValueType, Set<String>> onlyExistsValidator() {
		return new KeyValueTypeOnlyExistsValidator();
	}
}
