package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBasketUnderlyingByNotional;
import fpml.consolidated.com.QuantityReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityBasketUnderlyingByNotionalChoice1")
@ImplementedBy(CommodityBasketUnderlyingByNotionalChoice1.Default.class)
public interface CommodityBasketUnderlyingByNotionalChoice1 extends Validator<CommodityBasketUnderlyingByNotional> {
	
	String NAME = "CommodityBasketUnderlyingByNotionalChoice1";
	String DEFINITION = "if quantityReference exists then totalNotionalQuantity is absent";
	
	class Default implements CommodityBasketUnderlyingByNotionalChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByNotional commodityBasketUnderlyingByNotional) {
			ComparisonResult result = executeDataRule(commodityBasketUnderlyingByNotional);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasketUnderlyingByNotional", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasketUnderlyingByNotional", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityBasketUnderlyingByNotional commodityBasketUnderlyingByNotional) {
			try {
				if (exists(MapperS.of(commodityBasketUnderlyingByNotional).<QuantityReference>map("getQuantityReference", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getQuantityReference())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityBasketUnderlyingByNotional).<BigDecimal>map("getTotalNotionalQuantity", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getTotalNotionalQuantity()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityBasketUnderlyingByNotionalChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByNotional commodityBasketUnderlyingByNotional) {
			return Collections.emptyList();
		}
	}
}
