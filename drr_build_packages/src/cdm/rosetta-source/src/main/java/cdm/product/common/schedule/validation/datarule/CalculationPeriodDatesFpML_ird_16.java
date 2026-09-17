package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CalculationPeriodDatesFpML_ird_16")
@ImplementedBy(CalculationPeriodDatesFpML_ird_16.Default.class)
public interface CalculationPeriodDatesFpML_ird_16 extends Validator<CalculationPeriodDates> {
	
	String NAME = "CalculationPeriodDatesFpML_ird_16";
	String DEFINITION = "if firstRegularPeriodStartDate exists then terminationDate -> adjustableDate -> unadjustedDate > firstRegularPeriodStartDate";
	
	class Default implements CalculationPeriodDatesFpML_ird_16 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodDates calculationPeriodDates) {
			ComparisonResult result = executeDataRule(calculationPeriodDates);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodDates", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodDates", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CalculationPeriodDates calculationPeriodDates) {
			try {
				if (exists(MapperS.of(calculationPeriodDates).<Date>map("getFirstRegularPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstRegularPeriodStartDate())).getOrDefault(false)) {
					return greaterThan(MapperS.of(calculationPeriodDates).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()), MapperS.of(calculationPeriodDates).<Date>map("getFirstRegularPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstRegularPeriodStartDate()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationPeriodDatesFpML_ird_16 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodDates calculationPeriodDates) {
			return Collections.emptyList();
		}
	}
}
