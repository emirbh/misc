package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapEarlyTermination;
import fpml.consolidated.eq.shared.validation.ReturnSwapEarlyTerminationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapEarlyTerminationValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapEarlyTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapEarlyTermination.class)
public class ReturnSwapEarlyTerminationMeta implements RosettaMetaData<ReturnSwapEarlyTermination> {

	@Override
	public List<Validator<? super ReturnSwapEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapEarlyTermination> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapEarlyTermination>create(ReturnSwapEarlyTerminationValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapEarlyTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapEarlyTermination>create(ReturnSwapEarlyTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapEarlyTermination> validator() {
		return new ReturnSwapEarlyTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapEarlyTermination> typeFormatValidator() {
		return new ReturnSwapEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapEarlyTermination, Set<String>> onlyExistsValidator() {
		return new ReturnSwapEarlyTerminationOnlyExistsValidator();
	}
}
