package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ExerciseProcedure;
import fpml.consolidated.shared.validation.ExerciseProcedureTypeFormatValidator;
import fpml.consolidated.shared.validation.ExerciseProcedureValidator;
import fpml.consolidated.shared.validation.datarule.ExerciseProcedureChoice;
import fpml.consolidated.shared.validation.exists.ExerciseProcedureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExerciseProcedure.class)
public class ExerciseProcedureMeta implements RosettaMetaData<ExerciseProcedure> {

	@Override
	public List<Validator<? super ExerciseProcedure>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExerciseProcedure>create(ExerciseProcedureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseProcedure, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseProcedure> validator(ValidatorFactory factory) {
		return factory.<ExerciseProcedure>create(ExerciseProcedureValidator.class);
	}

	@Override
	public Validator<? super ExerciseProcedure> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExerciseProcedure>create(ExerciseProcedureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseProcedure> validator() {
		return new ExerciseProcedureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseProcedure> typeFormatValidator() {
		return new ExerciseProcedureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseProcedure, Set<String>> onlyExistsValidator() {
		return new ExerciseProcedureOnlyExistsValidator();
	}
}
