package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityOptionChoice1")
@ImplementedBy(CommodityOptionChoice1.Default.class)
public interface CommodityOptionChoice1 extends Validator<CommodityOption> {
	
	String NAME = "CommodityOptionChoice1";
	String DEFINITION = "optional choice strikePricePerUnit, strikePricePerUnitSchedule, floatingStrikePricePerUnit, floatingStrikePricePerUnitSchedule, commoditySwap, weatherCalculationPeriods";
	
	class Default implements CommodityOptionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption commodityOption) {
			ComparisonResult result = executeDataRule(commodityOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityOption commodityOption) {
			try {
				return choice(MapperS.of(commodityOption), Arrays.asList("strikePricePerUnit", "strikePricePerUnitSchedule", "floatingStrikePricePerUnit", "floatingStrikePricePerUnitSchedule", "commoditySwap", "weatherCalculationPeriods"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityOptionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption commodityOption) {
			return Collections.emptyList();
		}
	}
}
