package iso20022.auth030.hkma.tr.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndustrialProduct2Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityIndustrialProduct2ChoiceChoice")
@ImplementedBy(AssetClassCommodityIndustrialProduct2ChoiceChoice.Default.class)
public interface AssetClassCommodityIndustrialProduct2ChoiceChoice extends Validator<AssetClassCommodityIndustrialProduct2Choice> {
	
	String NAME = "AssetClassCommodityIndustrialProduct2ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityIndustrialProduct2ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityIndustrialProduct2Choice assetClassCommodityIndustrialProduct2Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityIndustrialProduct2Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityIndustrialProduct2Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityIndustrialProduct2Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityIndustrialProduct2Choice assetClassCommodityIndustrialProduct2Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityIndustrialProduct2Choice), Arrays.asList("cnstrctn", "manfctg"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityIndustrialProduct2ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityIndustrialProduct2Choice assetClassCommodityIndustrialProduct2Choice) {
			return Collections.emptyList();
		}
	}
}
