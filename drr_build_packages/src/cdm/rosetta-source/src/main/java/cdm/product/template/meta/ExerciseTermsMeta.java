package cdm.product.template.meta;

import cdm.product.template.ExerciseTerms;
import cdm.product.template.validation.ExerciseTermsTypeFormatValidator;
import cdm.product.template.validation.ExerciseTermsValidator;
import cdm.product.template.validation.datarule.ExerciseTermsAmericanExercise;
import cdm.product.template.validation.datarule.ExerciseTermsBermudaExercise;
import cdm.product.template.validation.datarule.ExerciseTermsCommencementAndExpirationDate;
import cdm.product.template.validation.datarule.ExerciseTermsEuropeanExercise;
import cdm.product.template.validation.datarule.ExerciseTermsExerciseDateExpirationDateChoice;
import cdm.product.template.validation.datarule.ExerciseTermsExpirationTimeChoice;
import cdm.product.template.validation.exists.ExerciseTermsOnlyExistsValidator;
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
@RosettaMeta(model=ExerciseTerms.class)
public class ExerciseTermsMeta implements RosettaMetaData<ExerciseTerms> {

	@Override
	public List<Validator<? super ExerciseTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExerciseTerms>create(ExerciseTermsExerciseDateExpirationDateChoice.class),
			factory.<ExerciseTerms>create(ExerciseTermsCommencementAndExpirationDate.class),
			factory.<ExerciseTerms>create(ExerciseTermsAmericanExercise.class),
			factory.<ExerciseTerms>create(ExerciseTermsEuropeanExercise.class),
			factory.<ExerciseTerms>create(ExerciseTermsBermudaExercise.class),
			factory.<ExerciseTerms>create(ExerciseTermsExpirationTimeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseTerms> validator(ValidatorFactory factory) {
		return factory.<ExerciseTerms>create(ExerciseTermsValidator.class);
	}

	@Override
	public Validator<? super ExerciseTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExerciseTerms>create(ExerciseTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseTerms> validator() {
		return new ExerciseTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseTerms> typeFormatValidator() {
		return new ExerciseTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseTerms, Set<String>> onlyExistsValidator() {
		return new ExerciseTermsOnlyExistsValidator();
	}
}
