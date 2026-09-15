package iso20022.auth030.hkma.dtcc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityPaper5Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityPaper5ChoiceChoice")
@ImplementedBy(AssetClassCommodityPaper5ChoiceChoice.Default.class)
public interface AssetClassCommodityPaper5ChoiceChoice extends Validator<AssetClassCommodityPaper5Choice> {
	
	String NAME = "AssetClassCommodityPaper5ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityPaper5ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper5Choice assetClassCommodityPaper5Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityPaper5Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityPaper5Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityPaper5Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityPaper5Choice assetClassCommodityPaper5Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityPaper5Choice), Arrays.asList("cntnrBrd", "nwsprnt", "pulp", "rcvrdPpr", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityPaper5ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper5Choice assetClassCommodityPaper5Choice) {
			return Collections.emptyList();
		}
	}
}
