package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.LegacyValuationDate;
import cdm.legaldocumentation.csa.ValuationDateDateEnum;
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
@RosettaDataRule("LegacyValuationDateCalendarDay")
@ImplementedBy(LegacyValuationDateCalendarDay.Default.class)
public interface LegacyValuationDateCalendarDay extends Validator<LegacyValuationDate> {
	
	String NAME = "LegacyValuationDateCalendarDay";
	String DEFINITION = "if date = ValuationDateDateEnum -> CalendarDay then calendarDay exists else calendarDay is absent";
	
	class Default implements LegacyValuationDateCalendarDay {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationDate legacyValuationDate) {
			ComparisonResult result = executeDataRule(legacyValuationDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegacyValuationDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegacyValuationDate legacyValuationDate) {
			try {
				if (areEqual(MapperS.of(legacyValuationDate).<ValuationDateDateEnum>map("getDate", _legacyValuationDate -> _legacyValuationDate.getDate()), MapperS.of(ValuationDateDateEnum.CALENDAR_DAY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(legacyValuationDate).<BigDecimal>map("getCalendarDay", _legacyValuationDate -> _legacyValuationDate.getCalendarDay()));
				}
				return notExists(MapperS.of(legacyValuationDate).<BigDecimal>map("getCalendarDay", _legacyValuationDate -> _legacyValuationDate.getCalendarDay()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegacyValuationDateCalendarDay {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegacyValuationDate legacyValuationDate) {
			return Collections.emptyList();
		}
	}
}
