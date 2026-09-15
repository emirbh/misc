package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.DSAKeyValueType;
import fpml.consolidated.validation.DSAKeyValueTypeTypeFormatValidator;
import fpml.consolidated.validation.DSAKeyValueTypeValidator;
import fpml.consolidated.validation.exists.DSAKeyValueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DSAKeyValueType.class)
public class DSAKeyValueTypeMeta implements RosettaMetaData<DSAKeyValueType> {

	@Override
	public List<Validator<? super DSAKeyValueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DSAKeyValueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DSAKeyValueType> validator(ValidatorFactory factory) {
		return factory.<DSAKeyValueType>create(DSAKeyValueTypeValidator.class);
	}

	@Override
	public Validator<? super DSAKeyValueType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DSAKeyValueType>create(DSAKeyValueTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DSAKeyValueType> validator() {
		return new DSAKeyValueTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DSAKeyValueType> typeFormatValidator() {
		return new DSAKeyValueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DSAKeyValueType, Set<String>> onlyExistsValidator() {
		return new DSAKeyValueTypeOnlyExistsValidator();
	}
}
