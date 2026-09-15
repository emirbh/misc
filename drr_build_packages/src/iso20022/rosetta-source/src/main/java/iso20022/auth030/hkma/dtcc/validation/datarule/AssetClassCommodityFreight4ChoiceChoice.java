package iso20022.auth030.hkma.dtcc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityFreight4Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityFreight4ChoiceChoice")
@ImplementedBy(AssetClassCommodityFreight4ChoiceChoice.Default.class)
public interface AssetClassCommodityFreight4ChoiceChoice extends Validator<AssetClassCommodityFreight4Choice> {
	
	String NAME = "AssetClassCommodityFreight4ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityFreight4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFreight4Choice assetClassCommodityFreight4Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityFreight4Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityFreight4Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityFreight4Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityFreight4Choice assetClassCommodityFreight4Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityFreight4Choice), Arrays.asList("dry", "wet", "cntnrShip", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityFreight4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityFreight4Choice assetClassCommodityFreight4Choice) {
			return Collections.emptyList();
		}
	}
}
