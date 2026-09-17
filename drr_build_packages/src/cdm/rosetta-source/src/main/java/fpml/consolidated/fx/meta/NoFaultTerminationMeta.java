package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.NoFaultTermination;
import fpml.consolidated.fx.validation.NoFaultTerminationTypeFormatValidator;
import fpml.consolidated.fx.validation.NoFaultTerminationValidator;
import fpml.consolidated.fx.validation.exists.NoFaultTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NoFaultTermination.class)
public class NoFaultTerminationMeta implements RosettaMetaData<NoFaultTermination> {

	@Override
	public List<Validator<? super NoFaultTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoFaultTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NoFaultTermination> validator(ValidatorFactory factory) {
		return factory.<NoFaultTermination>create(NoFaultTerminationValidator.class);
	}

	@Override
	public Validator<? super NoFaultTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NoFaultTermination>create(NoFaultTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NoFaultTermination> validator() {
		return new NoFaultTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NoFaultTermination> typeFormatValidator() {
		return new NoFaultTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoFaultTermination, Set<String>> onlyExistsValidator() {
		return new NoFaultTerminationOnlyExistsValidator();
	}
}
