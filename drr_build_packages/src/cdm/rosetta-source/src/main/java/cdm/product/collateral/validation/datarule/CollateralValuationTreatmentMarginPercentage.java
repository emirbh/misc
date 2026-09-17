package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.CollateralValuationTreatment;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CollateralValuationTreatmentMarginPercentage")
@ImplementedBy(CollateralValuationTreatmentMarginPercentage.Default.class)
public interface CollateralValuationTreatmentMarginPercentage extends Validator<CollateralValuationTreatment> {
	
	String NAME = "CollateralValuationTreatmentMarginPercentage";
	String DEFINITION = "if marginPercentage exists then marginPercentage >= 1";
	
	class Default implements CollateralValuationTreatmentMarginPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuationTreatment collateralValuationTreatment) {
			ComparisonResult result = executeDataRule(collateralValuationTreatment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuationTreatment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuationTreatment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralValuationTreatment collateralValuationTreatment) {
			try {
				if (exists(MapperS.of(collateralValuationTreatment).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(collateralValuationTreatment).<BigDecimal>map("getMarginPercentage", _collateralValuationTreatment -> _collateralValuationTreatment.getMarginPercentage()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValuationTreatmentMarginPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuationTreatment collateralValuationTreatment) {
			return Collections.emptyList();
		}
	}
}
