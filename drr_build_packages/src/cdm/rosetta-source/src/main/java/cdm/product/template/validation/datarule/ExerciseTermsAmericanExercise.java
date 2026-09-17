package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.template.ExerciseFee;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.PartialExercise;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ExerciseTermsAmericanExercise")
@ImplementedBy(ExerciseTermsAmericanExercise.Default.class)
public interface ExerciseTermsAmericanExercise extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsAmericanExercise";
	String DEFINITION = "if style = OptionExerciseStyleEnum -> American then commencementDate exists and exerciseFee is absent and partialExercise is absent and expirationDate count = 1";
	
	class Default implements ExerciseTermsAmericanExercise {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseTerms exerciseTerms) {
			ComparisonResult result = executeDataRule(exerciseTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExerciseTerms exerciseTerms) {
			try {
				if (areEqual(MapperS.of(exerciseTerms).<OptionExerciseStyleEnum>map("getStyle", _exerciseTerms -> _exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>map("getCommencementDate", _exerciseTerms -> _exerciseTerms.getCommencementDate())).andNullSafe(notExists(MapperS.of(exerciseTerms).<ExerciseFee>map("getExerciseFee", _exerciseTerms -> _exerciseTerms.getExerciseFee()))).andNullSafe(notExists(MapperS.of(exerciseTerms).<PartialExercise>map("getPartialExercise", _exerciseTerms -> _exerciseTerms.getPartialExercise()))).andNullSafe(areEqual(MapperS.of(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>mapC("getExpirationDate", _exerciseTerms -> _exerciseTerms.getExpirationDate()).resultCount()), MapperS.of(1), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsAmericanExercise {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseTerms exerciseTerms) {
			return Collections.emptyList();
		}
	}
}
