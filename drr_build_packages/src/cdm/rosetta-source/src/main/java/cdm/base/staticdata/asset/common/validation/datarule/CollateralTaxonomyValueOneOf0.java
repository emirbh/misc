package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
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
@RosettaDataRule("CollateralTaxonomyValueOneOf0")
@ImplementedBy(CollateralTaxonomyValueOneOf0.Default.class)
public interface CollateralTaxonomyValueOneOf0 extends Validator<CollateralTaxonomyValue> {
	
	String NAME = "CollateralTaxonomyValueOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements CollateralTaxonomyValueOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomyValue collateralTaxonomyValue) {
			ComparisonResult result = executeDataRule(collateralTaxonomyValue);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralTaxonomyValue", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralTaxonomyValue", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralTaxonomyValue collateralTaxonomyValue) {
			try {
				return choice(MapperS.of(collateralTaxonomyValue), Arrays.asList("eu_EMIR_EligibleCollateral", "uk_EMIR_EligibleCollateral", "us_CFTC_PR_EligibleCollateral", "nonEnumeratedTaxonomyValue"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralTaxonomyValueOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomyValue collateralTaxonomyValue) {
			return Collections.emptyList();
		}
	}
}
