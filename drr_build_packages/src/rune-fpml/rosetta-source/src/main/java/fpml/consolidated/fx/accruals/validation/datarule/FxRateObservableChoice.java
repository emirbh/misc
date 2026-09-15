package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxRateObservable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxRateObservableChoice")
@ImplementedBy(FxRateObservableChoice.Default.class)
public interface FxRateObservableChoice extends Validator<FxRateObservable> {
	
	String NAME = "FxRateObservableChoice";
	String DEFINITION = "required choice informationSource, crossRate";
	
	class Default implements FxRateObservableChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRateObservable fxRateObservable) {
			ComparisonResult result = executeDataRule(fxRateObservable);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxRateObservable", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxRateObservable", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxRateObservable fxRateObservable) {
			try {
				return choice(MapperS.of(fxRateObservable), Arrays.asList("informationSource", "crossRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxRateObservableChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRateObservable fxRateObservable) {
			return Collections.emptyList();
		}
	}
}
