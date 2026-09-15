package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.shared.FutureValueAmount;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CalculationChoice1")
@ImplementedBy(CalculationChoice1.Default.class)
public interface CalculationChoice1 extends Validator<Calculation> {
	
	String NAME = "CalculationChoice1";
	String DEFINITION = "if notionalSchedule exists then if fixedRateSchedule exists then rateCalculation is absent else fixedRateSchedule is absent and futureValueNotional is absent";
	
	class Default implements CalculationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Calculation calculation) {
			ComparisonResult result = executeDataRule(calculation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Calculation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Calculation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Calculation calculation) {
			try {
				if (exists(MapperS.of(calculation).<Notional>map("getNotionalSchedule", _calculation -> _calculation.getNotionalSchedule())).getOrDefault(false)) {
					if (exists(MapperS.of(calculation).<Schedule>map("getFixedRateSchedule", _calculation -> _calculation.getFixedRateSchedule())).getOrDefault(false)) {
						return notExists(MapperS.of(calculation).<Rate>map("getRateCalculation", _calculation -> _calculation.getRateCalculation()));
					}
					return notExists(MapperS.of(calculation).<Schedule>map("getFixedRateSchedule", _calculation -> _calculation.getFixedRateSchedule())).andNullSafe(notExists(MapperS.of(calculation).<FutureValueAmount>map("getFutureValueNotional", _calculation -> _calculation.getFutureValueNotional())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Calculation calculation) {
			return Collections.emptyList();
		}
	}
}
