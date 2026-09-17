package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.FxTouch;
import fpml.consolidated.fx.FxTrigger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxDigitalOptionChoice")
@ImplementedBy(FxDigitalOptionChoice.Default.class)
public interface FxDigitalOptionChoice extends Validator<FxDigitalOption> {
	
	String NAME = "FxDigitalOptionChoice";
	String DEFINITION = "if americanExercise exists then touch exists and europeanExercise is absent and trigger is absent else europeanExercise exists and trigger exists and touch is absent";
	
	class Default implements FxDigitalOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDigitalOption fxDigitalOption) {
			ComparisonResult result = executeDataRule(fxDigitalOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxDigitalOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxDigitalOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxDigitalOption fxDigitalOption) {
			try {
				if (exists(MapperS.of(fxDigitalOption).<FxDigitalAmericanExercise>map("getAmericanExercise", _fxDigitalOption -> _fxDigitalOption.getAmericanExercise())).getOrDefault(false)) {
					return exists(MapperS.of(fxDigitalOption).<FxTouch>mapC("getTouch", _fxDigitalOption -> _fxDigitalOption.getTouch())).andNullSafe(notExists(MapperS.of(fxDigitalOption).<FxEuropeanExercise>map("getEuropeanExercise", _fxDigitalOption -> _fxDigitalOption.getEuropeanExercise()))).andNullSafe(notExists(MapperS.of(fxDigitalOption).<FxTrigger>mapC("getTrigger", _fxDigitalOption -> _fxDigitalOption.getTrigger())));
				}
				return exists(MapperS.of(fxDigitalOption).<FxEuropeanExercise>map("getEuropeanExercise", _fxDigitalOption -> _fxDigitalOption.getEuropeanExercise())).andNullSafe(exists(MapperS.of(fxDigitalOption).<FxTrigger>mapC("getTrigger", _fxDigitalOption -> _fxDigitalOption.getTrigger()))).andNullSafe(notExists(MapperS.of(fxDigitalOption).<FxTouch>mapC("getTouch", _fxDigitalOption -> _fxDigitalOption.getTouch())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxDigitalOptionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDigitalOption fxDigitalOption) {
			return Collections.emptyList();
		}
	}
}
