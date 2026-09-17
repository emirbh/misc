package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.PGPData;
import fpml.consolidated.PGPDataType;
import fpml.consolidated.validation.PGPDataTypeFormatValidator;
import fpml.consolidated.validation.PGPDataValidator;
import fpml.consolidated.validation.datarule.PGPDataTypeChoice;
import fpml.consolidated.validation.exists.PGPDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PGPData.class)
public class PGPDataMeta implements RosettaMetaData<PGPData> {

	@Override
	public List<Validator<? super PGPData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PGPDataType>create(PGPDataTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PGPData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PGPData> validator(ValidatorFactory factory) {
		return factory.<PGPData>create(PGPDataValidator.class);
	}

	@Override
	public Validator<? super PGPData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PGPData>create(PGPDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PGPData> validator() {
		return new PGPDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PGPData> typeFormatValidator() {
		return new PGPDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PGPData, Set<String>> onlyExistsValidator() {
		return new PGPDataOnlyExistsValidator();
	}
}
