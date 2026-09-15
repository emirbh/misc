package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityPhysicalQuantity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ElectricityPhysicalQuantityChoice")
@ImplementedBy(ElectricityPhysicalQuantityChoice.Default.class)
public interface ElectricityPhysicalQuantityChoice extends Validator<ElectricityPhysicalQuantity> {
	
	String NAME = "ElectricityPhysicalQuantityChoice";
	String DEFINITION = "optional choice physicalQuantity, physicalQuantitySchedule";
	
	class Default implements ElectricityPhysicalQuantityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalQuantity electricityPhysicalQuantity) {
			ComparisonResult result = executeDataRule(electricityPhysicalQuantity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectricityPhysicalQuantity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectricityPhysicalQuantity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ElectricityPhysicalQuantity electricityPhysicalQuantity) {
			try {
				return choice(MapperS.of(electricityPhysicalQuantity), Arrays.asList("physicalQuantity", "physicalQuantitySchedule"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ElectricityPhysicalQuantityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalQuantity electricityPhysicalQuantity) {
			return Collections.emptyList();
		}
	}
}
