package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ProductTaxonomyTaxonomySource")
@ImplementedBy(ProductTaxonomyTaxonomySource.Default.class)
public interface ProductTaxonomyTaxonomySource extends Validator<ProductTaxonomy> {
	
	String NAME = "ProductTaxonomyTaxonomySource";
	String DEFINITION = "if source exists then (value exists or productQualifier exists)";
	
	class Default implements ProductTaxonomyTaxonomySource {
	
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
				if (exists(MapperS.of(productTaxonomy).<TaxonomySourceEnum>map("getSource", _productTaxonomy -> _productTaxonomy.getSource())).getOrDefault(false)) {
					return exists(MapperS.of(productTaxonomy).<TaxonomyValue>map("getValue", _productTaxonomy -> _productTaxonomy.getValue())).orNullSafe(exists(MapperS.of(productTaxonomy).<String>map("getProductQualifier", _productTaxonomy -> _productTaxonomy.getProductQualifier())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ProductTaxonomyTaxonomySource {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductTaxonomy productTaxonomy) {
			return Collections.emptyList();
		}
	}
}
