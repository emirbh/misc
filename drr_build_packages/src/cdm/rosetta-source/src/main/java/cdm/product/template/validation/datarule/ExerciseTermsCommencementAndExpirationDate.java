package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.template.ExerciseTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ExerciseTermsCommencementAndExpirationDate")
@ImplementedBy(ExerciseTermsCommencementAndExpirationDate.Default.class)
public interface ExerciseTermsCommencementAndExpirationDate extends Validator<ExerciseTerms> {
	
	String NAME = "ExerciseTermsCommencementAndExpirationDate";
	String DEFINITION = "if commencementDate exists then expirationDate exists";
	
	class Default implements ExerciseTermsCommencementAndExpirationDate {
	
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
				if (exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>map("getCommencementDate", _exerciseTerms -> _exerciseTerms.getCommencementDate())).getOrDefault(false)) {
					return exists(MapperS.of(exerciseTerms).<AdjustableOrRelativeDate>mapC("getExpirationDate", _exerciseTerms -> _exerciseTerms.getExpirationDate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseTermsCommencementAndExpirationDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseTerms exerciseTerms) {
			return Collections.emptyList();
		}
	}
}
