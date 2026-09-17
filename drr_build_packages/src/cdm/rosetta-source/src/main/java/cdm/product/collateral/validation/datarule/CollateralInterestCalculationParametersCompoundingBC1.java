package cdm.product.collateral.validation.datarule;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.CompoundingTypeEnum;
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
@RosettaDataRule("CollateralInterestCalculationParametersCompoundingBC1")
@ImplementedBy(CollateralInterestCalculationParametersCompoundingBC1.Default.class)
public interface CollateralInterestCalculationParametersCompoundingBC1 extends Validator<CollateralInterestCalculationParameters> {
	
	String NAME = "CollateralInterestCalculationParametersCompoundingBC1";
	String DEFINITION = "if compoundingType = CompoundingTypeEnum -> Business then compoundingBusinessCenter exists";
	
	class Default implements CollateralInterestCalculationParametersCompoundingBC1 {
	
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
				if (areEqual(MapperS.of(collateralInterestCalculationParameters).<CompoundingTypeEnum>map("getCompoundingType", _collateralInterestCalculationParameters -> _collateralInterestCalculationParameters.getCompoundingType()), MapperS.of(CompoundingTypeEnum.BUSINESS), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(collateralInterestCalculationParameters).<BusinessCenterEnum>mapC("getCompoundingBusinessCenter", _collateralInterestCalculationParameters -> _collateralInterestCalculationParameters.getCompoundingBusinessCenter()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralInterestCalculationParametersCompoundingBC1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralInterestCalculationParameters collateralInterestCalculationParameters) {
			return Collections.emptyList();
		}
	}
}
