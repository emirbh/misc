package fpml.consolidated.fx.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxSingleLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxSingleLegChoice0")
@ImplementedBy(FxSingleLegChoice0.Default.class)
public interface FxSingleLegChoice0 extends Validator<FxSingleLeg> {
	
	String NAME = "FxSingleLegChoice0";
	String DEFINITION = "optional choice tenorName, tenorPeriod";
	
	class Default implements FxSingleLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSingleLeg fxSingleLeg) {
			ComparisonResult result = executeDataRule(fxSingleLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSingleLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSingleLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxSingleLeg fxSingleLeg) {
			try {
				return choice(MapperS.of(fxSingleLeg), Arrays.asList("tenorName", "tenorPeriod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSingleLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSingleLeg fxSingleLeg) {
			return Collections.emptyList();
		}
	}
}
