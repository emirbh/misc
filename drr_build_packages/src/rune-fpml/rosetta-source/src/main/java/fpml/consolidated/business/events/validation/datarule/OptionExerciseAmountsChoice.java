package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.NumberOfOptionsReference;
import fpml.consolidated.shared.NumberOfUnitsReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionExerciseAmountsChoice")
@ImplementedBy(OptionExerciseAmountsChoice.Default.class)
public interface OptionExerciseAmountsChoice extends Validator<OptionExerciseAmounts> {
	
	String NAME = "OptionExerciseAmountsChoice";
	String DEFINITION = "notionalScheduleReference is absent and exerciseInNotionalSchedule is absent and outstandingNotionalSchedule is absent and numberOfOptionsReference is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and numberOfUnitsReference is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or notionalReference is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and numberOfOptionsReference is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and numberOfUnitsReference is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or notionalReference is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and notionalScheduleReference is absent and exerciseInNotionalSchedule is absent and outstandingNotionalSchedule is absent and numberOfUnitsReference is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or notionalReference is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and notionalScheduleReference is absent and exerciseInNotionalSchedule is absent and outstandingNotionalSchedule is absent and numberOfOptionsReference is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent";
	
	class Default implements OptionExerciseAmountsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmounts optionExerciseAmounts) {
			ComparisonResult result = executeDataRule(optionExerciseAmounts);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExerciseAmounts", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExerciseAmounts", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionExerciseAmounts optionExerciseAmounts) {
			try {
				return notExists(MapperS.of(optionExerciseAmounts).<NotionalReference>map("getNotionalScheduleReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNotionalScheduleReference())).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NonNegativeAmountSchedule>map("getExerciseInNotionalSchedule", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNotionalSchedule()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NonNegativeAmountSchedule>map("getOutstandingNotionalSchedule", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNotionalSchedule()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NumberOfOptionsReference>map("getNumberOfOptionsReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNumberOfOptionsReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NumberOfUnitsReference>map("getNumberOfUnitsReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNumberOfUnitsReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNumberOfUnits()))).orNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NotionalReference>map("getNotionalReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNotionalReference())).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<Money>map("getExerciseInNotionalAmount", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<Money>map("getOutstandingNotionalAmount", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NumberOfOptionsReference>map("getNumberOfOptionsReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNumberOfOptionsReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NumberOfUnitsReference>map("getNumberOfUnitsReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNumberOfUnitsReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNumberOfUnits())))).orNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NotionalReference>map("getNotionalReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNotionalReference())).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<Money>map("getExerciseInNotionalAmount", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<Money>map("getOutstandingNotionalAmount", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NotionalReference>map("getNotionalScheduleReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNotionalScheduleReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NonNegativeAmountSchedule>map("getExerciseInNotionalSchedule", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNotionalSchedule()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NonNegativeAmountSchedule>map("getOutstandingNotionalSchedule", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNotionalSchedule()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NumberOfUnitsReference>map("getNumberOfUnitsReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNumberOfUnitsReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNumberOfUnits())))).orNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NotionalReference>map("getNotionalReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNotionalReference())).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<Money>map("getExerciseInNotionalAmount", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<Money>map("getOutstandingNotionalAmount", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NotionalReference>map("getNotionalScheduleReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNotionalScheduleReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NonNegativeAmountSchedule>map("getExerciseInNotionalSchedule", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNotionalSchedule()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NonNegativeAmountSchedule>map("getOutstandingNotionalSchedule", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNotionalSchedule()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<NumberOfOptionsReference>map("getNumberOfOptionsReference", _optionExerciseAmounts -> _optionExerciseAmounts.getNumberOfOptionsReference()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExerciseAmounts -> _optionExerciseAmounts.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExerciseAmounts).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExerciseAmounts -> _optionExerciseAmounts.getOutstandingNumberOfOptions()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseAmountsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmounts optionExerciseAmounts) {
			return Collections.emptyList();
		}
	}
}
