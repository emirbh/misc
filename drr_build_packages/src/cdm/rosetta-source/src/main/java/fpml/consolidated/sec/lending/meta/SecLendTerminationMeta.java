package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecLendTermination;
import fpml.consolidated.sec.lending.validation.SecLendTerminationTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecLendTerminationValidator;
import fpml.consolidated.sec.lending.validation.exists.SecLendTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecLendTermination.class)
public class SecLendTerminationMeta implements RosettaMetaData<SecLendTermination> {

	@Override
	public List<Validator<? super SecLendTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecLendTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecLendTermination> validator(ValidatorFactory factory) {
		return factory.<SecLendTermination>create(SecLendTerminationValidator.class);
	}

	@Override
	public Validator<? super SecLendTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecLendTermination>create(SecLendTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecLendTermination> validator() {
		return new SecLendTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecLendTermination> typeFormatValidator() {
		return new SecLendTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecLendTermination, Set<String>> onlyExistsValidator() {
		return new SecLendTerminationOnlyExistsValidator();
	}
}
