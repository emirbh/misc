package iso20022.auth030.hkma.dtcc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.AssetClassCommodity7Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetClassCommodity7ChoiceChoice")
@ImplementedBy(AssetClassCommodity7ChoiceChoice.Default.class)
public interface AssetClassCommodity7ChoiceChoice extends Validator<AssetClassCommodity7Choice> {
	
	String NAME = "AssetClassCommodity7ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements AssetClassCommodity7ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodity7Choice assetClassCommodity7Choice) {
			ComparisonResult result = executeDataRule(assetClassCommodity7Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodity7Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetClassCommodity7Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetClassCommodity7Choice assetClassCommodity7Choice) {
			try {
				return choice(MapperS.of(assetClassCommodity7Choice), Arrays.asList("agrcltrl", "nrgy", "envttl", "frtlzr", "frght", "indx", "indstrlPdct", "infltn", "metl", "multiCmmdtyExtc", "offclEcnmcSttstcs", "othr", "othrC10", "ppr", "plprpln"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetClassCommodity7ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetClassCommodity7Choice assetClassCommodity7Choice) {
			return Collections.emptyList();
		}
	}
}
