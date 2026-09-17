package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMAContractType;
import fpml.consolidated.recordkeeping.processes.validation.ESMAContractTypeTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.ESMAContractTypeValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.ESMAContractTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ESMAContractType.class)
public class ESMAContractTypeMeta implements RosettaMetaData<ESMAContractType> {

	@Override
	public List<Validator<? super ESMAContractType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ESMAContractType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMAContractType> validator(ValidatorFactory factory) {
		return factory.<ESMAContractType>create(ESMAContractTypeValidator.class);
	}

	@Override
	public Validator<? super ESMAContractType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMAContractType>create(ESMAContractTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMAContractType> validator() {
		return new ESMAContractTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMAContractType> typeFormatValidator() {
		return new ESMAContractTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMAContractType, Set<String>> onlyExistsValidator() {
		return new ESMAContractTypeOnlyExistsValidator();
	}
}
