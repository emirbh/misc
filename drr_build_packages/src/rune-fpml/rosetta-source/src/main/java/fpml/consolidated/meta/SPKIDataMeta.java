package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SPKIData;
import fpml.consolidated.validation.SPKIDataTypeFormatValidator;
import fpml.consolidated.validation.SPKIDataValidator;
import fpml.consolidated.validation.exists.SPKIDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SPKIData.class)
public class SPKIDataMeta implements RosettaMetaData<SPKIData> {

	@Override
	public List<Validator<? super SPKIData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SPKIData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SPKIData> validator(ValidatorFactory factory) {
		return factory.<SPKIData>create(SPKIDataValidator.class);
	}

	@Override
	public Validator<? super SPKIData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SPKIData>create(SPKIDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SPKIData> validator() {
		return new SPKIDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SPKIData> typeFormatValidator() {
		return new SPKIDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SPKIData, Set<String>> onlyExistsValidator() {
		return new SPKIDataOnlyExistsValidator();
	}
}
