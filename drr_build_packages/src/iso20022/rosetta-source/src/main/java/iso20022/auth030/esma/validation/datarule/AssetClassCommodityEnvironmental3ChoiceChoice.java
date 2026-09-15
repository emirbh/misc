package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityEnvironmental3Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityEnvironmental3ChoiceChoice")
@ImplementedBy(AssetClassCommodityEnvironmental3ChoiceChoice.Default.class)
public interface AssetClassCommodityEnvironmental3ChoiceChoice extends Validator<AssetClassCommodityEnvironmental3Choice> {
	
	String NAME = "AssetClassCommodityEnvironmental3ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityEnvironmental3ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnvironmental3Choice assetClassCommodityEnvironmental3Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityEnvironmental3Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityEnvironmental3Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityEnvironmental3Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityEnvironmental3Choice assetClassCommodityEnvironmental3Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityEnvironmental3Choice), Arrays.asList("emssns", "wthr", "crbnRltd", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityEnvironmental3ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityEnvironmental3Choice assetClassCommodityEnvironmental3Choice) {
			return Collections.emptyList();
		}
	}
}
