package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ActionOnExpiration;
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
@RosettaDataRule("ActionOnExpirationChoice")
@ImplementedBy(ActionOnExpirationChoice.Default.class)
public interface ActionOnExpirationChoice extends Validator<ActionOnExpiration> {
	
	String NAME = "ActionOnExpirationChoice";
	String DEFINITION = "if exerciseAction exists then expiry is absent and fullExercise is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent and specifiedExercise is absent else if expiry exists then fullExercise is absent and exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent and specifiedExercise is absent else if fullExercise exists then exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent and specifiedExercise is absent else if specifiedExercise exists then exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent else exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfUnits is absent and outstandingNumberOfUnits is absent or exerciseInNotionalAmount is absent and outstandingNotionalAmount is absent and exerciseInNumberOfOptions is absent and outstandingNumberOfOptions is absent";
	
	class Default implements ActionOnExpirationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActionOnExpiration actionOnExpiration) {
			ComparisonResult result = executeDataRule(actionOnExpiration);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ActionOnExpiration", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ActionOnExpiration", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ActionOnExpiration actionOnExpiration) {
			try {
				if (exists(MapperS.of(actionOnExpiration).<ExerciseActionEnum>map("getExerciseAction", _actionOnExpiration -> _actionOnExpiration.getExerciseAction())).getOrDefault(false)) {
					return notExists(MapperS.of(actionOnExpiration).<Boolean>map("getExpiry", _actionOnExpiration -> _actionOnExpiration.getExpiry())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Boolean>map("getFullExercise", _actionOnExpiration -> _actionOnExpiration.getFullExercise()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getExerciseInNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getOutstandingNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _actionOnExpiration -> _actionOnExpiration.getSpecifiedExercise())));
				}
				if (exists(MapperS.of(actionOnExpiration).<Boolean>map("getExpiry", _actionOnExpiration -> _actionOnExpiration.getExpiry())).getOrDefault(false)) {
					return notExists(MapperS.of(actionOnExpiration).<Boolean>map("getFullExercise", _actionOnExpiration -> _actionOnExpiration.getFullExercise())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getExerciseInNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getExerciseInNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getOutstandingNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _actionOnExpiration -> _actionOnExpiration.getSpecifiedExercise())));
				}
				if (exists(MapperS.of(actionOnExpiration).<Boolean>map("getFullExercise", _actionOnExpiration -> _actionOnExpiration.getFullExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(actionOnExpiration).<Money>map("getExerciseInNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getOutstandingNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _actionOnExpiration -> _actionOnExpiration.getSpecifiedExercise())));
				}
				if (exists(MapperS.of(actionOnExpiration).<OptionExerciseAmounts>mapC("getSpecifiedExercise", _actionOnExpiration -> _actionOnExpiration.getSpecifiedExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(actionOnExpiration).<Money>map("getExerciseInNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getOutstandingNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfUnits())));
				}
				return notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfOptions())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfUnits()))).orNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getExerciseInNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getOutstandingNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfUnits", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfUnits())))).orNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getExerciseInNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getExerciseInNotionalAmount())).andNullSafe(notExists(MapperS.of(actionOnExpiration).<Money>map("getOutstandingNotionalAmount", _actionOnExpiration -> _actionOnExpiration.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getExerciseInNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getExerciseInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(actionOnExpiration).<BigDecimal>map("getOutstandingNumberOfOptions", _actionOnExpiration -> _actionOnExpiration.getOutstandingNumberOfOptions()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ActionOnExpirationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActionOnExpiration actionOnExpiration) {
			return Collections.emptyList();
		}
	}
}
