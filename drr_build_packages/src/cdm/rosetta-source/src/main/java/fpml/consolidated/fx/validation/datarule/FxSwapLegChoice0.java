package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxSwapLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxSwapLegChoice0")
@ImplementedBy(FxSwapLegChoice0.Default.class)
public interface FxSwapLegChoice0 extends Validator<FxSwapLeg> {
	
	String NAME = "FxSwapLegChoice0";
	String DEFINITION = "optional choice tenorName, tenorPeriod";
	
	class Default implements FxSwapLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSwapLeg fxSwapLeg) {
			ComparisonResult result = executeDataRule(fxSwapLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSwapLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSwapLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxSwapLeg fxSwapLeg) {
			try {
				return choice(MapperS.of(fxSwapLeg), Arrays.asList("tenorName", "tenorPeriod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSwapLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSwapLeg fxSwapLeg) {
			return Collections.emptyList();
		}
	}
}
