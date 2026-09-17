package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.OptionExerciseAmounts;
import fpml.consolidated.fpmlenum.ExerciseActionEnum;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OptionExerciseChoice3")
@ImplementedBy(OptionExerciseChoice3.Default.class)
public interface OptionExerciseChoice3 extends Validator<OptionExercise> {
	
	String NAME = "OptionExerciseChoice3";
	String DEFINITION = "if exerciseAction exists then expiry is absent and fullExercise is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent and specifiedExercise is absent else if expiry exists then fullExercise is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent and specifiedExercise is absent else if fullExercise exists then exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent and specifiedExercise is absent else if specifiedExercise exists then exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent else exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent";
	
	class Default implements OptionExerciseChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise optionExercise) {
			ComparisonResult result = executeDataRule(optionExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OptionExercise optionExercise) {
			try {
				if (exists(MapperS.of(optionExercise).<ExerciseActionEnum>map("getExerciseAction", _optionExercise -> _optionExercise.getExerciseAction())).getOrDefault(false)) {
					return notExists(MapperS.of(optionExercise).<Boolean>map("getExpiry", _optionExercise -> _optionExercise.getExpiry())).andNullSafe(notExists(MapperS.of(optionExercise).<Boolean>map("getFullExercise", _optionExercise -> _optionExercise.getFullExercise()))).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getExerciseInNotionalAmount", _optionExercise -> _optionExercise.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getOutstandingNotionalAmount", _optionExercise -> _optionExercise.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExercise -> _optionExercise.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExercise -> _optionExercise.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExercise -> _optionExercise.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExercise -> _optionExercise.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _optionExercise -> _optionExercise.getSpecifiedExercise())));
				}
				if (exists(MapperS.of(optionExercise).<Boolean>map("getExpiry", _optionExercise -> _optionExercise.getExpiry())).getOrDefault(false)) {
					return notExists(MapperS.of(optionExercise).<Boolean>map("getFullExercise", _optionExercise -> _optionExercise.getFullExercise())).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getExerciseInNotionalAmount", _optionExercise -> _optionExercise.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getOutstandingNotionalAmount", _optionExercise -> _optionExercise.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExercise -> _optionExercise.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExercise -> _optionExercise.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExercise -> _optionExercise.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExercise -> _optionExercise.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _optionExercise -> _optionExercise.getSpecifiedExercise())));
				}
				if (exists(MapperS.of(optionExercise).<Boolean>map("getFullExercise", _optionExercise -> _optionExercise.getFullExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(optionExercise).<Money>map("getExerciseInNotionalAmount", _optionExercise -> _optionExercise.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getOutstandingNotionalAmount", _optionExercise -> _optionExercise.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExercise -> _optionExercise.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExercise -> _optionExercise.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExercise -> _optionExercise.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExercise -> _optionExercise.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _optionExercise -> _optionExercise.getSpecifiedExercise())));
				}
				if (exists(MapperS.of(optionExercise).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _optionExercise -> _optionExercise.getSpecifiedExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(optionExercise).<Money>map("getExerciseInNotionalAmount", _optionExercise -> _optionExercise.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getOutstandingNotionalAmount", _optionExercise -> _optionExercise.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExercise -> _optionExercise.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExercise -> _optionExercise.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExercise -> _optionExercise.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExercise -> _optionExercise.getOutstandingNumberOfUnits())));
				}
				return notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExercise -> _optionExercise.getExerciseInNumberOfOptions())).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExercise -> _optionExercise.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExercise -> _optionExercise.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExercise -> _optionExercise.getOutstandingNumberOfUnits()))).orNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getExerciseInNotionalAmount", _optionExercise -> _optionExercise.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getOutstandingNotionalAmount", _optionExercise -> _optionExercise.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfUnits", _optionExercise -> _optionExercise.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfUnits", _optionExercise -> _optionExercise.getOutstandingNumberOfUnits())))).orNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getExerciseInNotionalAmount", _optionExercise -> _optionExercise.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(optionExercise).<Money>map("getOutstandingNotionalAmount", _optionExercise -> _optionExercise.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getExerciseInNumberOfOptions", _optionExercise -> _optionExercise.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(optionExercise).<BigDecimal>map("getOutstandingNumberOfOptions", _optionExercise -> _optionExercise.getOutstandingNumberOfOptions()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExercise optionExercise) {
			return Collections.emptyList();
		}
	}
}
