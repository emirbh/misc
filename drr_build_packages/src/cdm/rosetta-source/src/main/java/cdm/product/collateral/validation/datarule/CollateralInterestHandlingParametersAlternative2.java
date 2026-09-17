package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.AlternativeToInterestAmountEnum;
import cdm.product.collateral.CollateralInterestHandlingParameters;
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
@RosettaDataRule("CollateralInterestHandlingParametersAlternative2")
@ImplementedBy(CollateralInterestHandlingParametersAlternative2.Default.class)
public interface CollateralInterestHandlingParametersAlternative2 extends Validator<CollateralInterestHandlingParameters> {
	
	String NAME = "CollateralInterestHandlingParametersAlternative2";
	String DEFINITION = "if alternativeToInterestAmount <> AlternativeToInterestAmountEnum -> Other then alternativeProvision is absent";
	
	class Default implements CollateralInterestHandlingParametersAlternative2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralInterestHandlingParameters collateralInterestHandlingParameters) {
			ComparisonResult result = executeDataRule(collateralInterestHandlingParameters);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralInterestHandlingParameters", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralInterestHandlingParameters", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralInterestHandlingParameters collateralInterestHandlingParameters) {
			try {
				if (notEqual(MapperS.of(collateralInterestHandlingParameters).<AlternativeToInterestAmountEnum>map("getAlternativeToInterestAmount", _collateralInterestHandlingParameters -> _collateralInterestHandlingParameters.getAlternativeToInterestAmount()), MapperS.of(AlternativeToInterestAmountEnum.OTHER), CardinalityOperator.Any).getOrDefault(false)) {
					return notExists(MapperS.of(collateralInterestHandlingParameters).<String>map("getAlternativeProvision", _collateralInterestHandlingParameters -> _collateralInterestHandlingParameters.getAlternativeProvision()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralInterestHandlingParametersAlternative2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralInterestHandlingParameters collateralInterestHandlingParameters) {
			return Collections.emptyList();
		}
	}
}
