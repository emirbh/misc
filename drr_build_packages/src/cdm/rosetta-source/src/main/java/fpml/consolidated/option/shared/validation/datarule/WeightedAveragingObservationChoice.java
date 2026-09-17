package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.WeightedAveragingObservation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("WeightedAveragingObservationChoice")
@ImplementedBy(WeightedAveragingObservationChoice.Default.class)
public interface WeightedAveragingObservationChoice extends Validator<WeightedAveragingObservation> {
	
	String NAME = "WeightedAveragingObservationChoice";
	String DEFINITION = "optional choice dateTime, observationNumber";
	
	class Default implements WeightedAveragingObservationChoice {
	
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
				return choice(MapperS.of(weightedAveragingObservation), Arrays.asList("dateTime", "observationNumber"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WeightedAveragingObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeightedAveragingObservation weightedAveragingObservation) {
			return Collections.emptyList();
		}
	}
}
