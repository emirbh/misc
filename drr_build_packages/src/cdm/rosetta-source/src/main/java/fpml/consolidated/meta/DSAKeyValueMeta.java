package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.DSAKeyValue;
import fpml.consolidated.validation.DSAKeyValueTypeFormatValidator;
import fpml.consolidated.validation.DSAKeyValueValidator;
import fpml.consolidated.validation.exists.DSAKeyValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DSAKeyValue.class)
public class DSAKeyValueMeta implements RosettaMetaData<DSAKeyValue> {

	@Override
	public List<Validator<? super DSAKeyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DSAKeyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DSAKeyValue> validator(ValidatorFactory factory) {
		return factory.<DSAKeyValue>create(DSAKeyValueValidator.class);
	}

	@Override
	public Validator<? super DSAKeyValue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DSAKeyValue>create(DSAKeyValueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DSAKeyValue> validator() {
		return new DSAKeyValueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DSAKeyValue> typeFormatValidator() {
		return new DSAKeyValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DSAKeyValue, Set<String>> onlyExistsValidator() {
		return new DSAKeyValueOnlyExistsValidator();
	}
}
