package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
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
@RosettaDataRule("PeriodDayPeriod")
@ImplementedBy(PeriodDayPeriod.Default.class)
public interface PeriodDayPeriod extends Validator<Period> {
	
	String NAME = "PeriodDayPeriod";
	String DEFINITION = "if periodMultiplier = 0 then period = PeriodEnum -> D";
	
	class Default implements PeriodDayPeriod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Period period) {
			ComparisonResult result = executeDataRule(period);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Period", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Period", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Period period) {
			try {
				if (areEqual(MapperS.of(period).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier()), MapperS.of(0), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(period).<PeriodEnum>map("getPeriod", _period -> _period.getPeriod()), MapperS.of(PeriodEnum.D), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PeriodDayPeriod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Period period) {
			return Collections.emptyList();
		}
	}
}
