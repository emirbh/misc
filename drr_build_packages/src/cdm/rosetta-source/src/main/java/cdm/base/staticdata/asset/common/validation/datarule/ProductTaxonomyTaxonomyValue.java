package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
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
@RosettaDataRule("ProductTaxonomyTaxonomyValue")
@ImplementedBy(ProductTaxonomyTaxonomyValue.Default.class)
public interface ProductTaxonomyTaxonomyValue extends Validator<ProductTaxonomy> {
	
	String NAME = "ProductTaxonomyTaxonomyValue";
	String DEFINITION = "optional choice value, productQualifier";
	
	class Default implements ProductTaxonomyTaxonomyValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductTaxonomy productTaxonomy) {
			ComparisonResult result = executeDataRule(productTaxonomy);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ProductTaxonomy", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ProductTaxonomy", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ProductTaxonomy productTaxonomy) {
			try {
				return choice(MapperS.of(productTaxonomy), Arrays.asList("value", "productQualifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ProductTaxonomyTaxonomyValue {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductTaxonomy productTaxonomy) {
			return Collections.emptyList();
		}
	}
}
