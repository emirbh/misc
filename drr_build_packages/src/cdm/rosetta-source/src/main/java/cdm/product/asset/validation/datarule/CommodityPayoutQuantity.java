package cdm.product.asset.validation.datarule;

import cdm.product.asset.CommodityPayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CommodityPayoutQuantity")
@ImplementedBy(CommodityPayoutQuantity.Default.class)
public interface CommodityPayoutQuantity extends Validator<CommodityPayout> {
	
	String NAME = "CommodityPayoutQuantity";
	String DEFINITION = "priceQuantity exists";
	
	class Default implements CommodityPayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPayout commodityPayout) {
			ComparisonResult result = executeDataRule(commodityPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityPayout commodityPayout) {
			try {
				return exists(MapperS.of(commodityPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _commodityPayout -> _commodityPayout.getPriceQuantity()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPayout commodityPayout) {
			return Collections.emptyList();
		}
	}
}
