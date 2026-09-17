package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.CompoundingRate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CompoundingRateChoice")
@ImplementedBy(CompoundingRateChoice.Default.class)
public interface CompoundingRateChoice extends Validator<CompoundingRate> {
	
	String NAME = "CompoundingRateChoice";
	String DEFINITION = "one-of";
	
	class Default implements CompoundingRateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompoundingRate compoundingRate) {
			ComparisonResult result = executeDataRule(compoundingRate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CompoundingRate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CompoundingRate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CompoundingRate compoundingRate) {
			try {
				return choice(MapperS.of(compoundingRate), Arrays.asList("interestLegRate", "specificRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CompoundingRateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompoundingRate compoundingRate) {
			return Collections.emptyList();
		}
	}
}
