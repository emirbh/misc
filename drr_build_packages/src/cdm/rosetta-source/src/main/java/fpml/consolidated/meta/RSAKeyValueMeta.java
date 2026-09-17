package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.RSAKeyValue;
import fpml.consolidated.validation.RSAKeyValueTypeFormatValidator;
import fpml.consolidated.validation.RSAKeyValueValidator;
import fpml.consolidated.validation.exists.RSAKeyValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RSAKeyValue.class)
public class RSAKeyValueMeta implements RosettaMetaData<RSAKeyValue> {

	@Override
	public List<Validator<? super RSAKeyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RSAKeyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RSAKeyValue> validator(ValidatorFactory factory) {
		return factory.<RSAKeyValue>create(RSAKeyValueValidator.class);
	}

	@Override
	public Validator<? super RSAKeyValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RSAKeyValue>create(RSAKeyValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RSAKeyValue> validator() {
		return new RSAKeyValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RSAKeyValue> typeFormatValidator() {
		return new RSAKeyValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RSAKeyValue, Set<String>> onlyExistsValidator() {
		return new RSAKeyValueOnlyExistsValidator();
	}
}
