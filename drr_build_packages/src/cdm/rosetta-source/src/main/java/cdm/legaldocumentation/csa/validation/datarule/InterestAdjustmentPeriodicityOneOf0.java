package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.InterestAdjustmentPeriodicity;
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
@RosettaDataRule("InterestAdjustmentPeriodicityOneOf0")
@ImplementedBy(InterestAdjustmentPeriodicityOneOf0.Default.class)
public interface InterestAdjustmentPeriodicityOneOf0 extends Validator<InterestAdjustmentPeriodicity> {
	
	String NAME = "InterestAdjustmentPeriodicityOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements InterestAdjustmentPeriodicityOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAdjustmentPeriodicity interestAdjustmentPeriodicity) {
			ComparisonResult result = executeDataRule(interestAdjustmentPeriodicity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestAdjustmentPeriodicity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestAdjustmentPeriodicity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestAdjustmentPeriodicity interestAdjustmentPeriodicity) {
			try {
				return choice(MapperS.of(interestAdjustmentPeriodicity), Arrays.asList("standardElection", "customElection"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestAdjustmentPeriodicityOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAdjustmentPeriodicity interestAdjustmentPeriodicity) {
			return Collections.emptyList();
		}
	}
}
