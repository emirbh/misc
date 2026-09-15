package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBasket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityBasketChoice")
@ImplementedBy(CommodityBasketChoice.Default.class)
public interface CommodityBasketChoice extends Validator<CommodityBasket> {
	
	String NAME = "CommodityBasketChoice";
	String DEFINITION = "required choice notionalQuantityBasket, notionalAmountBasket";
	
	class Default implements CommodityBasketChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasket commodityBasket) {
			ComparisonResult result = executeDataRule(commodityBasket);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasket", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasket", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityBasket commodityBasket) {
			try {
				return choice(MapperS.of(commodityBasket), Arrays.asList("notionalQuantityBasket", "notionalAmountBasket"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityBasketChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasket commodityBasket) {
			return Collections.emptyList();
		}
	}
}
