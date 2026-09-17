package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.InterestRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("InterestRateIndexChoice")
@ImplementedBy(InterestRateIndexChoice.Default.class)
public interface InterestRateIndexChoice extends Validator<InterestRateIndex> {
	
	String NAME = "InterestRateIndexChoice";
	String DEFINITION = "";
	
	class Default implements InterestRateIndexChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateIndex interestRateIndex) {
			ComparisonResult result = executeDataRule(interestRateIndex);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRateIndex", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestRateIndex interestRateIndex) {
			try {
				return choice(MapperS.of(interestRateIndex), Arrays.asList("FloatingRateIndex", "InflationIndex"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRateIndexChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateIndex interestRateIndex) {
			return Collections.emptyList();
		}
	}
}
