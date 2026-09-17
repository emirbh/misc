package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.EU_EMIR_EligibleCollateralEnum;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
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
@RosettaDataRule("CollateralTaxonomyEu_EligibleCollateralTaxonomy")
@ImplementedBy(CollateralTaxonomyEu_EligibleCollateralTaxonomy.Default.class)
public interface CollateralTaxonomyEu_EligibleCollateralTaxonomy extends Validator<CollateralTaxonomy> {
	
	String NAME = "CollateralTaxonomyEu_EligibleCollateralTaxonomy";
	String DEFINITION = "if taxonomySource = TaxonomySourceEnum -> EU_EMIR_EligibleCollateralAssetClass then taxonomyValue -> eu_EMIR_EligibleCollateral exists";
	
	class Default implements CollateralTaxonomyEu_EligibleCollateralTaxonomy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomy collateralTaxonomy) {
			ComparisonResult result = executeDataRule(collateralTaxonomy);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralTaxonomy", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralTaxonomy", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralTaxonomy collateralTaxonomy) {
			try {
				if (areEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(collateralTaxonomy).<CollateralTaxonomyValue>map("getTaxonomyValue", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomyValue()).<EU_EMIR_EligibleCollateralEnum>mapC("getEu_EMIR_EligibleCollateral", collateralTaxonomyValue -> collateralTaxonomyValue.getEu_EMIR_EligibleCollateral()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralTaxonomyEu_EligibleCollateralTaxonomy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomy collateralTaxonomy) {
			return Collections.emptyList();
		}
	}
}
