package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.BullionPhysicalLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("BullionPhysicalLegChoice")
@ImplementedBy(BullionPhysicalLegChoice.Default.class)
public interface BullionPhysicalLegChoice extends Validator<BullionPhysicalLeg> {
	
	String NAME = "BullionPhysicalLegChoice";
	String DEFINITION = "optional choice physicalQuantity, physicalQuantitySchedule";
	
	class Default implements BullionPhysicalLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BullionPhysicalLeg bullionPhysicalLeg) {
			ComparisonResult result = executeDataRule(bullionPhysicalLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BullionPhysicalLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BullionPhysicalLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BullionPhysicalLeg bullionPhysicalLeg) {
			try {
				return choice(MapperS.of(bullionPhysicalLeg), Arrays.asList("physicalQuantity", "physicalQuantitySchedule"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BullionPhysicalLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BullionPhysicalLeg bullionPhysicalLeg) {
			return Collections.emptyList();
		}
	}
}
