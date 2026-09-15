package iso20022.auth030.hkma.dtcc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityAgricultural6Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityAgricultural6ChoiceChoice")
@ImplementedBy(AssetClassCommodityAgricultural6ChoiceChoice.Default.class)
public interface AssetClassCommodityAgricultural6ChoiceChoice extends Validator<AssetClassCommodityAgricultural6Choice> {
	
	String NAME = "AssetClassCommodityAgricultural6ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityAgricultural6ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityAgricultural6Choice assetClassCommodityAgricultural6Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityAgricultural6Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityAgricultural6Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityAgricultural6Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityAgricultural6Choice assetClassCommodityAgricultural6Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityAgricultural6Choice), Arrays.asList("grnOilSeed", "soft", "ptt", "olvOil", "dairy", "frstry", "sfd", "liveStock", "grn", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityAgricultural6ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityAgricultural6Choice assetClassCommodityAgricultural6Choice) {
			return Collections.emptyList();
		}
	}
}
