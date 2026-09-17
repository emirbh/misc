package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CommodityReferenceFramework;
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
@RosettaDataRule("CommodityReferenceFrameworkCommodityReferenceFrameworkChoice")
@ImplementedBy(CommodityReferenceFrameworkCommodityReferenceFrameworkChoice.Default.class)
public interface CommodityReferenceFrameworkCommodityReferenceFrameworkChoice extends Validator<CommodityReferenceFramework> {
	
	String NAME = "CommodityReferenceFrameworkCommodityReferenceFrameworkChoice";
	String DEFINITION = "optional choice capacityUnit, weatherUnit";
	
	class Default implements CommodityReferenceFrameworkCommodityReferenceFrameworkChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReferenceFramework commodityReferenceFramework) {
			ComparisonResult result = executeDataRule(commodityReferenceFramework);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityReferenceFramework", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityReferenceFramework", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityReferenceFramework commodityReferenceFramework) {
			try {
				return choice(MapperS.of(commodityReferenceFramework), Arrays.asList("capacityUnit", "weatherUnit"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityReferenceFrameworkCommodityReferenceFrameworkChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReferenceFramework commodityReferenceFramework) {
			return Collections.emptyList();
		}
	}
}
