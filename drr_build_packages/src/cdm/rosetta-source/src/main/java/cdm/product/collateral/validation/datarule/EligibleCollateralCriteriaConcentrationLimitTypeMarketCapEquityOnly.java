package cdm.product.collateral.validation.datarule;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.ConcentrationLimit;
import cdm.product.collateral.ConcentrationLimitCriteria;
import cdm.product.collateral.ConcentrationLimitTypeEnum;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.functions.CriteriaMatchesAssetType;
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
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("EligibleCollateralCriteriaConcentrationLimitTypeMarketCapEquityOnly")
@ImplementedBy(EligibleCollateralCriteriaConcentrationLimitTypeMarketCapEquityOnly.Default.class)
public interface EligibleCollateralCriteriaConcentrationLimitTypeMarketCapEquityOnly extends Validator<EligibleCollateralCriteria> {
	
	String NAME = "EligibleCollateralCriteriaConcentrationLimitTypeMarketCapEquityOnly";
	String DEFINITION = "if treatment -> concentrationLimit -> concentrationLimitCriteria -> concentrationLimitType only-element = ConcentrationLimitTypeEnum -> MarketCapitalisation then CriteriaMatchesAssetType(collateralCriteria, Equity) or (treatment -> concentrationLimit extract CriteriaMatchesAssetType( item -> concentrationLimitCriteria -> collateralCriteria, Equity )) all = True";
	
	class Default implements EligibleCollateralCriteriaConcentrationLimitTypeMarketCapEquityOnly {
	
		@Inject protected CriteriaMatchesAssetType criteriaMatchesAssetType;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibleCollateralCriteria eligibleCollateralCriteria) {
			ComparisonResult result = executeDataRule(eligibleCollateralCriteria);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EligibleCollateralCriteria", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EligibleCollateralCriteria", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EligibleCollateralCriteria eligibleCollateralCriteria) {
			try {
				if (areEqual(MapperS.of(MapperS.of(eligibleCollateralCriteria).<CollateralTreatment>map("getTreatment", _eligibleCollateralCriteria -> _eligibleCollateralCriteria.getTreatment()).<ConcentrationLimit>mapC("getConcentrationLimit", collateralTreatment -> collateralTreatment.getConcentrationLimit()).<ConcentrationLimitCriteria>map("getConcentrationLimitCriteria", concentrationLimit -> concentrationLimit.getConcentrationLimitCriteria()).<ConcentrationLimitTypeEnum>map("getConcentrationLimitType", concentrationLimitCriteria -> concentrationLimitCriteria.getConcentrationLimitType()).get()), MapperS.of(ConcentrationLimitTypeEnum.MARKET_CAPITALISATION), CardinalityOperator.All).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(criteriaMatchesAssetType.evaluate(MapperS.of(eligibleCollateralCriteria).<CollateralCriteria>map("getCollateralCriteria", _eligibleCollateralCriteria -> _eligibleCollateralCriteria.getCollateralCriteria()).get(), InstrumentTypeEnum.EQUITY))).orNullSafe(areEqual(MapperS.of(eligibleCollateralCriteria).<CollateralTreatment>map("getTreatment", _eligibleCollateralCriteria -> _eligibleCollateralCriteria.getTreatment()).<ConcentrationLimit>mapC("getConcentrationLimit", collateralTreatment -> collateralTreatment.getConcentrationLimit())
						.mapItem(item -> MapperS.of(criteriaMatchesAssetType.evaluate(item.<ConcentrationLimitCriteria>map("getConcentrationLimitCriteria", concentrationLimit -> concentrationLimit.getConcentrationLimitCriteria()).<CollateralCriteria>map("getCollateralCriteria", concentrationLimitCriteria -> concentrationLimitCriteria.getCollateralCriteria()).get(), InstrumentTypeEnum.EQUITY))), MapperS.of(true), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EligibleCollateralCriteriaConcentrationLimitTypeMarketCapEquityOnly {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EligibleCollateralCriteria eligibleCollateralCriteria) {
			return Collections.emptyList();
		}
	}
}
