package cdm.product.asset.validation.datarule;

import cdm.product.asset.FutureValueAmount;
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
@RosettaDataRule("FutureValueAmountPositiveCalculationPeriodNumberOfDays")
@ImplementedBy(FutureValueAmountPositiveCalculationPeriodNumberOfDays.Default.class)
public interface FutureValueAmountPositiveCalculationPeriodNumberOfDays extends Validator<FutureValueAmount> {
	
	String NAME = "FutureValueAmountPositiveCalculationPeriodNumberOfDays";
	String DEFINITION = "calculationPeriodNumberOfDays >= 0";
	
	class Default implements FutureValueAmountPositiveCalculationPeriodNumberOfDays {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FutureValueAmount futureValueAmount) {
			ComparisonResult result = executeDataRule(futureValueAmount);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FutureValueAmount", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FutureValueAmount", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FutureValueAmount futureValueAmount) {
			try {
				return greaterThanEquals(MapperS.of(futureValueAmount).<Integer>map("getCalculationPeriodNumberOfDays", _futureValueAmount -> _futureValueAmount.getCalculationPeriodNumberOfDays()), MapperS.of(0), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FutureValueAmountPositiveCalculationPeriodNumberOfDays {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FutureValueAmount futureValueAmount) {
			return Collections.emptyList();
		}
	}
}
