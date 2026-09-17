package cdm.product.template.meta;

import cdm.product.template.PartialExercise;
import cdm.product.template.validation.PartialExerciseTypeFormatValidator;
import cdm.product.template.validation.PartialExerciseValidator;
import cdm.product.template.validation.datarule.PartialExerciseMinimumChoice;
import cdm.product.template.validation.exists.PartialExerciseOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=PartialExercise.class)
public class PartialExerciseMeta implements RosettaMetaData<PartialExercise> {

	@Override
	public List<Validator<? super PartialExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartialExercise>create(PartialExerciseMinimumChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartialExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartialExercise> validator(ValidatorFactory factory) {
		return factory.<PartialExercise>create(PartialExerciseValidator.class);
	}

	@Override
	public Validator<? super PartialExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartialExercise>create(PartialExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartialExercise> validator() {
		return new PartialExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartialExercise> typeFormatValidator() {
		return new PartialExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartialExercise, Set<String>> onlyExistsValidator() {
		return new PartialExerciseOnlyExistsValidator();
	}
}
