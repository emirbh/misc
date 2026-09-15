package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.UnderlyerInterestLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("UnderlyerInterestLegChoice")
@ImplementedBy(UnderlyerInterestLegChoice.Default.class)
public interface UnderlyerInterestLegChoice extends Validator<UnderlyerInterestLeg> {
	
	String NAME = "UnderlyerInterestLegChoice";
	String DEFINITION = "optional choice fixedRate, spreadSchedule";
	
	class Default implements UnderlyerInterestLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerInterestLeg underlyerInterestLeg) {
			ComparisonResult result = executeDataRule(underlyerInterestLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UnderlyerInterestLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "UnderlyerInterestLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(UnderlyerInterestLeg underlyerInterestLeg) {
			try {
				return choice(MapperS.of(underlyerInterestLeg), Arrays.asList("fixedRate", "spreadSchedule"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UnderlyerInterestLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnderlyerInterestLeg underlyerInterestLeg) {
			return Collections.emptyList();
		}
	}
}
