package cdm.product.collateral.validation.datarule;

import cdm.base.datetime.daycount.DayCountFractionEnum;
import cdm.product.collateral.CollateralInterestCalculationParameters;
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
@RosettaDataRule("CollateralInterestCalculationParametersDCF")
@ImplementedBy(CollateralInterestCalculationParametersDCF.Default.class)
public interface CollateralInterestCalculationParametersDCF extends Validator<CollateralInterestCalculationParameters> {
	
	String NAME = "CollateralInterestCalculationParametersDCF";
	String DEFINITION = "dayCountFraction = DayCountFractionEnum -> ACT_360 or dayCountFraction = DayCountFractionEnum -> ACT_365_FIXED";
	
	class Default implements CollateralInterestCalculationParametersDCF {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralInterestCalculationParameters collateralInterestCalculationParameters) {
			ComparisonResult result = executeDataRule(collateralInterestCalculationParameters);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralInterestCalculationParameters", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralInterestCalculationParameters", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralInterestCalculationParameters collateralInterestCalculationParameters) {
			try {
				return areEqual(MapperS.of(collateralInterestCalculationParameters).<DayCountFractionEnum>map("getDayCountFraction", _collateralInterestCalculationParameters -> _collateralInterestCalculationParameters.getDayCountFraction()), MapperS.of(DayCountFractionEnum.ACT_360), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(collateralInterestCalculationParameters).<DayCountFractionEnum>map("getDayCountFraction", _collateralInterestCalculationParameters -> _collateralInterestCalculationParameters.getDayCountFraction()), MapperS.of(DayCountFractionEnum.ACT_365_FIXED), CardinalityOperator.All));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralInterestCalculationParametersDCF {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralInterestCalculationParameters collateralInterestCalculationParameters) {
			return Collections.emptyList();
		}
	}
}
