package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityDigitalOption;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.shared.NotionalAmount;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityDigitalOptionChoice1")
@ImplementedBy(CommodityDigitalOptionChoice1.Default.class)
public interface CommodityDigitalOptionChoice1 extends Validator<CommodityDigitalOption> {
	
	String NAME = "CommodityDigitalOptionChoice1";
	String DEFINITION = "if notionalAmount exists then notionalQuantity is absent and totalNotionalQuantity is absent else notionalQuantity exists or totalNotionalQuantity exists";
	
	class Default implements CommodityDigitalOptionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOption commodityDigitalOption) {
			ComparisonResult result = executeDataRule(commodityDigitalOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityDigitalOption commodityDigitalOption) {
			try {
				if (exists(MapperS.of(commodityDigitalOption).<NotionalAmount>map("getNotionalAmount", _commodityDigitalOption -> _commodityDigitalOption.getNotionalAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(commodityDigitalOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityDigitalOption -> _commodityDigitalOption.getNotionalQuantity())).andNullSafe(notExists(MapperS.of(commodityDigitalOption).<BigDecimal>map("getTotalNotionalQuantity", _commodityDigitalOption -> _commodityDigitalOption.getTotalNotionalQuantity())));
				}
				return exists(MapperS.of(commodityDigitalOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityDigitalOption -> _commodityDigitalOption.getNotionalQuantity())).orNullSafe(exists(MapperS.of(commodityDigitalOption).<BigDecimal>map("getTotalNotionalQuantity", _commodityDigitalOption -> _commodityDigitalOption.getTotalNotionalQuantity())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDigitalOptionChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOption commodityDigitalOption) {
			return Collections.emptyList();
		}
	}
}
