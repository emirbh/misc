package cdm.observable.asset.validation.datarule;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.PriceSchedule;
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
@RosettaDataRule("PriceScheduleArithmeticOperator")
@ImplementedBy(PriceScheduleArithmeticOperator.Default.class)
public interface PriceScheduleArithmeticOperator extends Validator<PriceSchedule> {
	
	String NAME = "PriceScheduleArithmeticOperator";
	String DEFINITION = "arithmeticOperator <> ArithmeticOperationEnum -> Subtract and arithmeticOperator <> ArithmeticOperationEnum -> Divide";
	
	class Default implements PriceScheduleArithmeticOperator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			ComparisonResult result = executeDataRule(priceSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PriceSchedule priceSchedule) {
			try {
				return notEqual(MapperS.of(priceSchedule).<ArithmeticOperationEnum>map("getArithmeticOperator", _priceSchedule -> _priceSchedule.getArithmeticOperator()), MapperS.of(ArithmeticOperationEnum.SUBTRACT), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(priceSchedule).<ArithmeticOperationEnum>map("getArithmeticOperator", _priceSchedule -> _priceSchedule.getArithmeticOperator()), MapperS.of(ArithmeticOperationEnum.DIVIDE), CardinalityOperator.Any));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceScheduleArithmeticOperator {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule priceSchedule) {
			return Collections.emptyList();
		}
	}
}
