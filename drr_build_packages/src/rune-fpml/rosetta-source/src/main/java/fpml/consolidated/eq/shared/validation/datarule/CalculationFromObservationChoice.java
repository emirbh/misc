package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.CalculationFromObservation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CalculationFromObservationChoice")
@ImplementedBy(CalculationFromObservationChoice.Default.class)
public interface CalculationFromObservationChoice extends Validator<CalculationFromObservation> {
	
	String NAME = "CalculationFromObservationChoice";
	String DEFINITION = "if initialLevel exists then closingLevel is absent and expiringLevel is absent else required choice initialLevelSource, closingLevel, expiringLevel";
	
	class Default implements CalculationFromObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFromObservation calculationFromObservation) {
			ComparisonResult result = executeDataRule(calculationFromObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFromObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFromObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationFromObservation calculationFromObservation) {
			try {
				if (exists(MapperS.of(calculationFromObservation).<BigDecimal>map("getInitialLevel", _calculationFromObservation -> _calculationFromObservation.getInitialLevel())).getOrDefault(false)) {
					return notExists(MapperS.of(calculationFromObservation).<Boolean>map("getClosingLevel", _calculationFromObservation -> _calculationFromObservation.getClosingLevel())).andNullSafe(notExists(MapperS.of(calculationFromObservation).<Boolean>map("getExpiringLevel", _calculationFromObservation -> _calculationFromObservation.getExpiringLevel())));
				}
				return choice(MapperS.of(calculationFromObservation), Arrays.asList("initialLevelSource", "closingLevel", "expiringLevel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationFromObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFromObservation calculationFromObservation) {
			return Collections.emptyList();
		}
	}
}
