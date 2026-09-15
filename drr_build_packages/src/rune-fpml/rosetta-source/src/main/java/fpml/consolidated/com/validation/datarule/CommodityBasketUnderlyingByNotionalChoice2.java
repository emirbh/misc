package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityBasketUnderlyingByNotional;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
import fpml.consolidated.com.QuantityReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityBasketUnderlyingByNotionalChoice2")
@ImplementedBy(CommodityBasketUnderlyingByNotionalChoice2.Default.class)
public interface CommodityBasketUnderlyingByNotionalChoice2 extends Validator<CommodityBasketUnderlyingByNotional> {
	
	String NAME = "CommodityBasketUnderlyingByNotionalChoice2";
	String DEFINITION = "if notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and quantityReference is absent then totalNotionalQuantity exists";
	
	class Default implements CommodityBasketUnderlyingByNotionalChoice2 {
	
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
				if (notExists(MapperS.of(commodityBasketUnderlyingByNotional).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getNotionalQuantitySchedule())).andNullSafe(notExists(MapperS.of(commodityBasketUnderlyingByNotional).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityBasketUnderlyingByNotional).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getSettlementPeriodsNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityBasketUnderlyingByNotional).<QuantityReference>map("getQuantityReference", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getQuantityReference()))).getOrDefault(false)) {
					return exists(MapperS.of(commodityBasketUnderlyingByNotional).<BigDecimal>map("getTotalNotionalQuantity", _commodityBasketUnderlyingByNotional -> _commodityBasketUnderlyingByNotional.getTotalNotionalQuantity()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityBasketUnderlyingByNotionalChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByNotional commodityBasketUnderlyingByNotional) {
			return Collections.emptyList();
		}
	}
}
