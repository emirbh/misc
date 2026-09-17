package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyValue;
import fpml.consolidated.KeyValueType;
import fpml.consolidated.validation.KeyValueTypeFormatValidator;
import fpml.consolidated.validation.KeyValueValidator;
import fpml.consolidated.validation.datarule.KeyValueTypeChoice;
import fpml.consolidated.validation.exists.KeyValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KeyValue.class)
public class KeyValueMeta implements RosettaMetaData<KeyValue> {

	@Override
	public List<Validator<? super KeyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<KeyValueType>create(KeyValueTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KeyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KeyValue> validator(ValidatorFactory factory) {
		return factory.<KeyValue>create(KeyValueValidator.class);
	}

	@Override
	public Validator<? super KeyValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KeyValue>create(KeyValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KeyValue> validator() {
		return new KeyValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KeyValue> typeFormatValidator() {
		return new KeyValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyValue, Set<String>> onlyExistsValidator() {
		return new KeyValueOnlyExistsValidator();
	}
}
