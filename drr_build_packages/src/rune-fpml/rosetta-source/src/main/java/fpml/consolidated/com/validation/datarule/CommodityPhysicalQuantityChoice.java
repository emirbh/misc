package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityPhysicalQuantity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityPhysicalQuantityChoice")
@ImplementedBy(CommodityPhysicalQuantityChoice.Default.class)
public interface CommodityPhysicalQuantityChoice extends Validator<CommodityPhysicalQuantity> {
	
	String NAME = "CommodityPhysicalQuantityChoice";
	String DEFINITION = "optional choice physicalQuantity, physicalQuantitySchedule";
	
	class Default implements CommodityPhysicalQuantityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantity commodityPhysicalQuantity) {
			ComparisonResult result = executeDataRule(commodityPhysicalQuantity);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalQuantity", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalQuantity", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalQuantity commodityPhysicalQuantity) {
			try {
				return choice(MapperS.of(commodityPhysicalQuantity), Arrays.asList("physicalQuantity", "physicalQuantitySchedule"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalQuantityChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalQuantity commodityPhysicalQuantity) {
			return Collections.emptyList();
		}
	}
}
