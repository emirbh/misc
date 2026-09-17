package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CommodityProductDefinition;
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
@RosettaDataRule("CommodityProductDefinitionCommodityProductDefinitionChoice")
@ImplementedBy(CommodityProductDefinitionCommodityProductDefinitionChoice.Default.class)
public interface CommodityProductDefinitionCommodityProductDefinitionChoice extends Validator<CommodityProductDefinition> {
	
	String NAME = "CommodityProductDefinitionCommodityProductDefinitionChoice";
	String DEFINITION = "optional choice exchangeId, priceSource";
	
	class Default implements CommodityProductDefinitionCommodityProductDefinitionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityProductDefinition commodityProductDefinition) {
			ComparisonResult result = executeDataRule(commodityProductDefinition);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityProductDefinition", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityProductDefinition", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityProductDefinition commodityProductDefinition) {
			try {
				return choice(MapperS.of(commodityProductDefinition), Arrays.asList("exchangeId", "priceSource"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityProductDefinitionCommodityProductDefinitionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityProductDefinition commodityProductDefinition) {
			return Collections.emptyList();
		}
	}
}
