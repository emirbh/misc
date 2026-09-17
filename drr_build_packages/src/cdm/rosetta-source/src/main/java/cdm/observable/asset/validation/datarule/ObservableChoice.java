package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Observable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ObservableChoice")
@ImplementedBy(ObservableChoice.Default.class)
public interface ObservableChoice extends Validator<Observable> {
	
	String NAME = "ObservableChoice";
	String DEFINITION = "";
	
	class Default implements ObservableChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Observable observable) {
			ComparisonResult result = executeDataRule(observable);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Observable", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Observable", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Observable observable) {
			try {
				return choice(MapperS.of(observable), Arrays.asList("Asset", "Basket", "Index"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ObservableChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Observable observable) {
			return Collections.emptyList();
		}
	}
}
