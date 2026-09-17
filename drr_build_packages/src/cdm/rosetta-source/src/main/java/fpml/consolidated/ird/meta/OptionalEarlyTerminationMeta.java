package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.OptionalEarlyTermination;
import fpml.consolidated.ird.validation.OptionalEarlyTerminationTypeFormatValidator;
import fpml.consolidated.ird.validation.OptionalEarlyTerminationValidator;
import fpml.consolidated.ird.validation.exists.OptionalEarlyTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionalEarlyTermination.class)
public class OptionalEarlyTerminationMeta implements RosettaMetaData<OptionalEarlyTermination> {

	@Override
	public List<Validator<? super OptionalEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionalEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionalEarlyTermination> validator(ValidatorFactory factory) {
		return factory.<OptionalEarlyTermination>create(OptionalEarlyTerminationValidator.class);
	}

	@Override
	public Validator<? super OptionalEarlyTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionalEarlyTermination>create(OptionalEarlyTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionalEarlyTermination> validator() {
		return new OptionalEarlyTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionalEarlyTermination> typeFormatValidator() {
		return new OptionalEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionalEarlyTermination, Set<String>> onlyExistsValidator() {
		return new OptionalEarlyTerminationOnlyExistsValidator();
	}
}
