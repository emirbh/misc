package cdm.product.template.validation.datarule;

import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.AssetPayout;
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
@RosettaDataRule("AssetPayoutQuantity")
@ImplementedBy(AssetPayoutQuantity.Default.class)
public interface AssetPayoutQuantity extends Validator<AssetPayout> {
	
	String NAME = "AssetPayoutQuantity";
	String DEFINITION = "priceQuantity exists";
	
	class Default implements AssetPayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetPayout assetPayout) {
			ComparisonResult result = executeDataRule(assetPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetPayout assetPayout) {
			try {
				return exists(MapperS.of(assetPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _assetPayout -> _assetPayout.getPriceQuantity()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetPayoutQuantity {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetPayout assetPayout) {
			return Collections.emptyList();
		}
	}
}
