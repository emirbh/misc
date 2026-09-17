package cdm.base.math.validation.datarule;

import cdm.base.math.UnitType;
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
@RosettaDataRule("UnitTypeUnitType")
@ImplementedBy(UnitTypeUnitType.Default.class)
public interface UnitTypeUnitType extends Validator<UnitType> {
	
	String NAME = "UnitTypeUnitType";
	String DEFINITION = "one-of";
	
	class Default implements UnitTypeUnitType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnitType unitType) {
			ComparisonResult result = executeDataRule(unitType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UnitType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "UnitType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(UnitType unitType) {
			try {
				return choice(MapperS.of(unitType), Arrays.asList("capacityUnit", "weatherUnit", "financialUnit", "currency"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UnitTypeUnitType {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnitType unitType) {
			return Collections.emptyList();
		}
	}
}
