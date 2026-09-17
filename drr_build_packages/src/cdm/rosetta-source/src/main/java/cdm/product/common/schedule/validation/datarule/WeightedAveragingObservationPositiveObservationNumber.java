package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.WeightedAveragingObservation;
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
@RosettaDataRule("WeightedAveragingObservationPositiveObservationNumber")
@ImplementedBy(WeightedAveragingObservationPositiveObservationNumber.Default.class)
public interface WeightedAveragingObservationPositiveObservationNumber extends Validator<WeightedAveragingObservation> {
	
	String NAME = "WeightedAveragingObservationPositiveObservationNumber";
	String DEFINITION = "if observationNumber exists then observationNumber >= 0";
	
	class Default implements WeightedAveragingObservationPositiveObservationNumber {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeightedAveragingObservation weightedAveragingObservation) {
			ComparisonResult result = executeDataRule(weightedAveragingObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "WeightedAveragingObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "WeightedAveragingObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(WeightedAveragingObservation weightedAveragingObservation) {
			try {
				if (exists(MapperS.of(weightedAveragingObservation).<Integer>map("getObservationNumber", _weightedAveragingObservation -> _weightedAveragingObservation.getObservationNumber())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(weightedAveragingObservation).<Integer>map("getObservationNumber", _weightedAveragingObservation -> _weightedAveragingObservation.getObservationNumber()), MapperS.of(0), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WeightedAveragingObservationPositiveObservationNumber {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeightedAveragingObservation weightedAveragingObservation) {
			return Collections.emptyList();
		}
	}
}
