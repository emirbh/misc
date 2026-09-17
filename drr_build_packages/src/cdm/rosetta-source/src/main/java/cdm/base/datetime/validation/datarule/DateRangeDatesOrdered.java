package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.DateRange;
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
@RosettaDataRule("DateRangeDatesOrdered")
@ImplementedBy(DateRangeDatesOrdered.Default.class)
public interface DateRangeDatesOrdered extends Validator<DateRange> {
	
	String NAME = "DateRangeDatesOrdered";
	String DEFINITION = "startDate <= endDate";
	
	class Default implements DateRangeDatesOrdered {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DateRange dateRange) {
			ComparisonResult result = executeDataRule(dateRange);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DateRange", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DateRange", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DateRange dateRange) {
			try {
				return lessThanEquals(MapperS.of(dateRange).<Date>map("getStartDate", _dateRange -> _dateRange.getStartDate()), MapperS.of(dateRange).<Date>map("getEndDate", _dateRange -> _dateRange.getEndDate()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DateRangeDatesOrdered {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DateRange dateRange) {
			return Collections.emptyList();
		}
	}
}
