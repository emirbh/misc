package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.PGPDataType;
import fpml.consolidated.validation.PGPDataTypeTypeFormatValidator;
import fpml.consolidated.validation.PGPDataTypeValidator;
import fpml.consolidated.validation.datarule.PGPDataTypeChoice;
import fpml.consolidated.validation.exists.PGPDataTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PGPDataType.class)
public class PGPDataTypeMeta implements RosettaMetaData<PGPDataType> {

	@Override
	public List<Validator<? super PGPDataType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PGPDataType>create(PGPDataTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PGPDataType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PGPDataType> validator(ValidatorFactory factory) {
		return factory.<PGPDataType>create(PGPDataTypeValidator.class);
	}

	@Override
	public Validator<? super PGPDataType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PGPDataType>create(PGPDataTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PGPDataType> validator() {
		return new PGPDataTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PGPDataType> typeFormatValidator() {
		return new PGPDataTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PGPDataType, Set<String>> onlyExistsValidator() {
		return new PGPDataTypeOnlyExistsValidator();
	}
}
