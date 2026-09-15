package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodityPaper4ChoiceChoice")
@ImplementedBy(AssetClassCommodityPaper4ChoiceChoice.Default.class)
public interface AssetClassCommodityPaper4ChoiceChoice extends Validator<AssetClassCommodityPaper4Choice> {
	
	String NAME = "AssetClassCommodityPaper4ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodityPaper4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper4Choice assetClassCommodityPaper4Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodityPaper4Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityPaper4Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodityPaper4Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodityPaper4Choice assetClassCommodityPaper4Choice) {
			try {
				return choice(MapperS.of(assetClassCommodityPaper4Choice), Arrays.asList("cntnrBrd", "nwsprnt", "pulp", "rcvrdPpr", "othr"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodityPaper4ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodityPaper4Choice assetClassCommodityPaper4Choice) {
			return Collections.emptyList();
		}
	}
}
