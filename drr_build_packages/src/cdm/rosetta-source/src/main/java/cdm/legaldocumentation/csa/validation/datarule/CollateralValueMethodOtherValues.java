package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CollateralValueMethod;
import cdm.legaldocumentation.csa.ValueCashEnum;
import cdm.legaldocumentation.csa.ValueSecuritiesEnum;
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
@RosettaDataRule("CollateralValueMethodOtherValues")
@ImplementedBy(CollateralValueMethodOtherValues.Default.class)
public interface CollateralValueMethodOtherValues extends Validator<CollateralValueMethod> {
	
	String NAME = "CollateralValueMethodOtherValues";
	String DEFINITION = "if cashCollateral = ValueCashEnum -> Other or securitiesCollateral = ValueSecuritiesEnum -> Other then additionalLanguage exists";
	
	class Default implements CollateralValueMethodOtherValues {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValueMethod collateralValueMethod) {
			ComparisonResult result = executeDataRule(collateralValueMethod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValueMethod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValueMethod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralValueMethod collateralValueMethod) {
			try {
				if (areEqual(MapperS.of(collateralValueMethod).<ValueCashEnum>map("getCashCollateral", _collateralValueMethod -> _collateralValueMethod.getCashCollateral()), MapperS.of(ValueCashEnum.OTHER), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(collateralValueMethod).<ValueSecuritiesEnum>map("getSecuritiesCollateral", _collateralValueMethod -> _collateralValueMethod.getSecuritiesCollateral()), MapperS.of(ValueSecuritiesEnum.OTHER), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(collateralValueMethod).<String>map("getAdditionalLanguage", _collateralValueMethod -> _collateralValueMethod.getAdditionalLanguage()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValueMethodOtherValues {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValueMethod collateralValueMethod) {
			return Collections.emptyList();
		}
	}
}
