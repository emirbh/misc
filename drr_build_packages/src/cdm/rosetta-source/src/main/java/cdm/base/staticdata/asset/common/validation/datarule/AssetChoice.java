package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Asset;
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
@RosettaDataRule("AssetChoice")
@ImplementedBy(AssetChoice.Default.class)
public interface AssetChoice extends Validator<Asset> {
	
	String NAME = "AssetChoice";
	String DEFINITION = "";
	
	class Default implements AssetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Asset asset) {
			ComparisonResult result = executeDataRule(asset);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Asset", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Asset", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Asset asset) {
			try {
				return choice(MapperS.of(asset), Arrays.asList("Cash", "Commodity", "DigitalAsset", "Instrument"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Asset asset) {
			return Collections.emptyList();
		}
	}
}
