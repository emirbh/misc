package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SPKIDataType;
import fpml.consolidated.validation.SPKIDataTypeTypeFormatValidator;
import fpml.consolidated.validation.SPKIDataTypeValidator;
import fpml.consolidated.validation.exists.SPKIDataTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SPKIDataType.class)
public class SPKIDataTypeMeta implements RosettaMetaData<SPKIDataType> {

	@Override
	public List<Validator<? super SPKIDataType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SPKIDataType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SPKIDataType> validator(ValidatorFactory factory) {
		return factory.<SPKIDataType>create(SPKIDataTypeValidator.class);
	}

	@Override
	public Validator<? super SPKIDataType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SPKIDataType>create(SPKIDataTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SPKIDataType> validator() {
		return new SPKIDataTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SPKIDataType> typeFormatValidator() {
		return new SPKIDataTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SPKIDataType, Set<String>> onlyExistsValidator() {
		return new SPKIDataTypeOnlyExistsValidator();
	}
}
