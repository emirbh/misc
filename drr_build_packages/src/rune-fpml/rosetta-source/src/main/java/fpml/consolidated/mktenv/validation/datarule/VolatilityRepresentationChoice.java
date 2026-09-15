package fpml.consolidated.mktenv.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.VolatilityRepresentation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("VolatilityRepresentationChoice")
@ImplementedBy(VolatilityRepresentationChoice.Default.class)
public interface VolatilityRepresentationChoice extends Validator<VolatilityRepresentation> {
	
	String NAME = "VolatilityRepresentationChoice";
	String DEFINITION = "optional choice asset, yieldCurveReference";
	
	class Default implements VolatilityRepresentationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityRepresentation volatilityRepresentation) {
			ComparisonResult result = executeDataRule(volatilityRepresentation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilityRepresentation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilityRepresentation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(VolatilityRepresentation volatilityRepresentation) {
			try {
				return choice(MapperS.of(volatilityRepresentation), Arrays.asList("asset", "yieldCurveReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VolatilityRepresentationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityRepresentation volatilityRepresentation) {
			return Collections.emptyList();
		}
	}
}
