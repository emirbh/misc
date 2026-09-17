package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.CommodityTrigger;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityTriggerChoice")
@ImplementedBy(CommodityTriggerChoice.Default.class)
public interface CommodityTriggerChoice extends Validator<CommodityTrigger> {
	
	String NAME = "CommodityTriggerChoice";
	String DEFINITION = "if levelQuantity exists or levelUnit exists then levelQuantity exists and levelUnit exists and levelPercentage is absent and levelPrice is absent else if levelPercentage exists then levelQuantity is absent and levelUnit is absent and levelPrice is absent else if levelPrice exists then levelQuantity is absent and levelUnit is absent and levelPercentage is absent else False";
	
	class Default implements CommodityTriggerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityTrigger commodityTrigger) {
			ComparisonResult result = executeDataRule(commodityTrigger);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityTrigger", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityTrigger", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityTrigger commodityTrigger) {
			try {
				if (exists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelQuantity", _commodityTrigger -> _commodityTrigger.getLevelQuantity())).orNullSafe(exists(MapperS.of(commodityTrigger).<QuantityUnit>map("getLevelUnit", _commodityTrigger -> _commodityTrigger.getLevelUnit()))).getOrDefault(false)) {
					return exists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelQuantity", _commodityTrigger -> _commodityTrigger.getLevelQuantity())).andNullSafe(exists(MapperS.of(commodityTrigger).<QuantityUnit>map("getLevelUnit", _commodityTrigger -> _commodityTrigger.getLevelUnit()))).andNullSafe(notExists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelPercentage", _commodityTrigger -> _commodityTrigger.getLevelPercentage()))).andNullSafe(notExists(MapperS.of(commodityTrigger).<CommodityFixedPrice>map("getLevelPrice", _commodityTrigger -> _commodityTrigger.getLevelPrice())));
				}
				if (exists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelPercentage", _commodityTrigger -> _commodityTrigger.getLevelPercentage())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelQuantity", _commodityTrigger -> _commodityTrigger.getLevelQuantity())).andNullSafe(notExists(MapperS.of(commodityTrigger).<QuantityUnit>map("getLevelUnit", _commodityTrigger -> _commodityTrigger.getLevelUnit()))).andNullSafe(notExists(MapperS.of(commodityTrigger).<CommodityFixedPrice>map("getLevelPrice", _commodityTrigger -> _commodityTrigger.getLevelPrice())));
				}
				if (exists(MapperS.of(commodityTrigger).<CommodityFixedPrice>map("getLevelPrice", _commodityTrigger -> _commodityTrigger.getLevelPrice())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelQuantity", _commodityTrigger -> _commodityTrigger.getLevelQuantity())).andNullSafe(notExists(MapperS.of(commodityTrigger).<QuantityUnit>map("getLevelUnit", _commodityTrigger -> _commodityTrigger.getLevelUnit()))).andNullSafe(notExists(MapperS.of(commodityTrigger).<BigDecimal>map("getLevelPercentage", _commodityTrigger -> _commodityTrigger.getLevelPercentage())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityTriggerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityTrigger commodityTrigger) {
			return Collections.emptyList();
		}
	}
}
