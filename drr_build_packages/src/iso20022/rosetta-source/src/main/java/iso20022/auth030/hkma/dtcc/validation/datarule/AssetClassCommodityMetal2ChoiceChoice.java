package iso20022.auth030.hkma.dtcc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityMetal2Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityMetal2ChoiceChoice")
@ImplementedBy(AssetClassCommodityMetal2ChoiceChoice.Default.class)
public interface AssetClassCommodityMetal2ChoiceChoice extends Validator<AssetClassCommodityMetal2Choice> {
	
	String NAME = "AssetClassCommodityMetal2ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityMetal2ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityMetal2Choice assetClassCommodityMetal2Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityMetal2Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityMetal2Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityMetal2Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityMetal2Choice assetClassCommodityMetal2Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityMetal2Choice), Arrays.asList("nonPrcs", "prcs"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityMetal2ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityMetal2Choice assetClassCommodityMetal2Choice) {
			return Collections.emptyList();
		}
	}
}
