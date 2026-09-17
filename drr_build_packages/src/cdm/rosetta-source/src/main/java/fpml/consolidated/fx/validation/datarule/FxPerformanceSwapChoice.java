package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxPerformanceSwap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxPerformanceSwapChoice")
@ImplementedBy(FxPerformanceSwapChoice.Default.class)
public interface FxPerformanceSwapChoice extends Validator<FxPerformanceSwap> {
	
	String NAME = "FxPerformanceSwapChoice";
	String DEFINITION = "optional choice valuationDate, valuationDateOffset";
	
	class Default implements FxPerformanceSwapChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceSwap fxPerformanceSwap) {
			ComparisonResult result = executeDataRule(fxPerformanceSwap);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxPerformanceSwap", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxPerformanceSwap", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxPerformanceSwap fxPerformanceSwap) {
			try {
				return choice(MapperS.of(fxPerformanceSwap), Arrays.asList("valuationDate", "valuationDateOffset"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxPerformanceSwapChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceSwap fxPerformanceSwap) {
			return Collections.emptyList();
		}
	}
}
