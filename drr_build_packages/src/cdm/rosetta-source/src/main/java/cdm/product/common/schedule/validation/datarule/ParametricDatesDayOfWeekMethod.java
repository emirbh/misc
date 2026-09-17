package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.product.common.schedule.ParametricDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ParametricDatesDayOfWeekMethod")
@ImplementedBy(ParametricDatesDayOfWeekMethod.Default.class)
public interface ParametricDatesDayOfWeekMethod extends Validator<ParametricDates> {
	
	String NAME = "ParametricDatesDayOfWeekMethod";
	String DEFINITION = "if dayOfWeek exists then dayFrequency exists";
	
	class Default implements ParametricDatesDayOfWeekMethod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricDates parametricDates) {
			ComparisonResult result = executeDataRule(parametricDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ParametricDates parametricDates) {
			try {
				if (exists(MapperS.of(parametricDates).<DayOfWeekEnum>mapC("getDayOfWeek", _parametricDates -> _parametricDates.getDayOfWeek())).getOrDefault(false)) {
					return exists(MapperS.of(parametricDates).<BigDecimal>map("getDayFrequency", _parametricDates -> _parametricDates.getDayFrequency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ParametricDatesDayOfWeekMethod {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricDates parametricDates) {
			return Collections.emptyList();
		}
	}
}
