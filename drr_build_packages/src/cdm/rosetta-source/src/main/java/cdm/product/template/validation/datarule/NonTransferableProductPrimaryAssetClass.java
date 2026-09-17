package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("NonTransferableProductPrimaryAssetClass")
@ImplementedBy(NonTransferableProductPrimaryAssetClass.Default.class)
public interface NonTransferableProductPrimaryAssetClass extends Validator<NonTransferableProduct> {
	
	String NAME = "NonTransferableProductPrimaryAssetClass";
	String DEFINITION = "if economicTerms -> nonStandardisedTerms = True then taxonomy -> primaryAssetClass exists";
	
	class Default implements NonTransferableProductPrimaryAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonTransferableProduct nonTransferableProduct) {
			ComparisonResult result = executeDataRule(nonTransferableProduct);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonTransferableProduct", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonTransferableProduct", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NonTransferableProduct nonTransferableProduct) {
			try {
				if (areEqual(MapperS.of(nonTransferableProduct).<EconomicTerms>map("getEconomicTerms", _nonTransferableProduct -> _nonTransferableProduct.getEconomicTerms()).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(nonTransferableProduct).<ProductTaxonomy>mapC("getTaxonomy", _nonTransferableProduct -> _nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>map("getPrimaryAssetClass", productTaxonomy -> productTaxonomy.getPrimaryAssetClass()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonTransferableProductPrimaryAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonTransferableProduct nonTransferableProduct) {
			return Collections.emptyList();
		}
	}
}
