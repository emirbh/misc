package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ExerciseProcedureOption;
import fpml.consolidated.shared.validation.ExerciseProcedureOptionTypeFormatValidator;
import fpml.consolidated.shared.validation.ExerciseProcedureOptionValidator;
import fpml.consolidated.shared.validation.datarule.ExerciseProcedureOptionChoice;
import fpml.consolidated.shared.validation.exists.ExerciseProcedureOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExerciseProcedureOption.class)
public class ExerciseProcedureOptionMeta implements RosettaMetaData<ExerciseProcedureOption> {

	@Override
	public List<Validator<? super ExerciseProcedureOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExerciseProcedureOption>create(ExerciseProcedureOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseProcedureOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseProcedureOption> validator(ValidatorFactory factory) {
		return factory.<ExerciseProcedureOption>create(ExerciseProcedureOptionValidator.class);
	}

	@Override
	public Validator<? super ExerciseProcedureOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExerciseProcedureOption>create(ExerciseProcedureOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseProcedureOption> validator() {
		return new ExerciseProcedureOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseProcedureOption> typeFormatValidator() {
		return new ExerciseProcedureOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseProcedureOption, Set<String>> onlyExistsValidator() {
		return new ExerciseProcedureOptionOnlyExistsValidator();
	}
}
