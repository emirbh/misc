package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.UK_EMIR_EligibleCollateralEnum;
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
@RosettaDataRule("CollateralTaxonomyUkEligibleCollateralTaxonomy")
@ImplementedBy(CollateralTaxonomyUkEligibleCollateralTaxonomy.Default.class)
public interface CollateralTaxonomyUkEligibleCollateralTaxonomy extends Validator<CollateralTaxonomy> {
	
	String NAME = "CollateralTaxonomyUkEligibleCollateralTaxonomy";
	String DEFINITION = "if taxonomySource = TaxonomySourceEnum -> UK_EMIR_EligibleCollateralAssetClass then taxonomyValue -> uk_EMIR_EligibleCollateral exists";
	
	class Default implements CollateralTaxonomyUkEligibleCollateralTaxonomy {
	
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
				if (areEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(collateralTaxonomy).<CollateralTaxonomyValue>map("getTaxonomyValue", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomyValue()).<UK_EMIR_EligibleCollateralEnum>mapC("getUk_EMIR_EligibleCollateral", collateralTaxonomyValue -> collateralTaxonomyValue.getUk_EMIR_EligibleCollateral()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralTaxonomyUkEligibleCollateralTaxonomy {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralTaxonomy collateralTaxonomy) {
			return Collections.emptyList();
		}
	}
}
