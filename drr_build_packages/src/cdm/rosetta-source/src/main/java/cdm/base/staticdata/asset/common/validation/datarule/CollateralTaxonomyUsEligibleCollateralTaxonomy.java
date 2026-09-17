package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.US_CFTC_PR_EligibleCollateralEnum;
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
@RosettaDataRule("CollateralTaxonomyUsEligibleCollateralTaxonomy")
@ImplementedBy(CollateralTaxonomyUsEligibleCollateralTaxonomy.Default.class)
public interface CollateralTaxonomyUsEligibleCollateralTaxonomy extends Validator<CollateralTaxonomy> {
	
	String NAME = "CollateralTaxonomyUsEligibleCollateralTaxonomy";
	String DEFINITION = "if taxonomySource = TaxonomySourceEnum -> US_CFTC_PR_EligibleCollateralAssetClass then taxonomyValue -> us_CFTC_PR_EligibleCollateral exists";
	
	class Default implements CollateralTaxonomyUsEligibleCollateralTaxonomy {
	
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
				if (areEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(collateralTaxonomy).<CollateralTaxonomyValue>map("getTaxonomyValue", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomyValue()).<US_CFTC_PR_EligibleCollateralEnum>mapC("getUs_CFTC_PR_EligibleCollateral", collateralTaxonomyValue -> collateralTaxonomyValue.getUs_CFTC_PR_EligibleCollateral()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralTaxonomyUsEligibleCollateralTaxonomy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomy collateralTaxonomy) {
			return Collections.emptyList();
		}
	}
}
