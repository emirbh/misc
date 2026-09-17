package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EnvironmentalPhysicalLegChoice")
@ImplementedBy(EnvironmentalPhysicalLegChoice.Default.class)
public interface EnvironmentalPhysicalLegChoice extends Validator<EnvironmentalPhysicalLeg> {
	
	String NAME = "EnvironmentalPhysicalLegChoice";
	String DEFINITION = "optional choice businessCentersReference, businessCenters";
	
	class Default implements EnvironmentalPhysicalLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalPhysicalLeg environmentalPhysicalLeg) {
			ComparisonResult result = executeDataRule(environmentalPhysicalLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EnvironmentalPhysicalLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EnvironmentalPhysicalLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EnvironmentalPhysicalLeg environmentalPhysicalLeg) {
			try {
				return choice(MapperS.of(environmentalPhysicalLeg), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EnvironmentalPhysicalLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalPhysicalLeg environmentalPhysicalLeg) {
			return Collections.emptyList();
		}
	}
}
