package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityPolypropylene4Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityPolypropylene4ChoiceChoice")
@ImplementedBy(AssetClassCommodityPolypropylene4ChoiceChoice.Default.class)
public interface AssetClassCommodityPolypropylene4ChoiceChoice extends Validator<AssetClassCommodityPolypropylene4Choice> {
	
	String NAME = "AssetClassCommodityPolypropylene4ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityPolypropylene4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPolypropylene4Choice assetClassCommodityPolypropylene4Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityPolypropylene4Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityPolypropylene4Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityPolypropylene4Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityPolypropylene4Choice assetClassCommodityPolypropylene4Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityPolypropylene4Choice), Arrays.asList("plstc", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityPolypropylene4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPolypropylene4Choice assetClassCommodityPolypropylene4Choice) {
			return Collections.emptyList();
		}
	}
}
