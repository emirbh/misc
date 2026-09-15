package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxRangeAccrual;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxRangeAccrualChoice1")
@ImplementedBy(FxRangeAccrualChoice1.Default.class)
public interface FxRangeAccrualChoice1 extends Validator<FxRangeAccrual> {
	
	String NAME = "FxRangeAccrualChoice1";
	String DEFINITION = "required choice settlementDate, settlementSchedule";
	
	class Default implements FxRangeAccrualChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRangeAccrual fxRangeAccrual) {
			ComparisonResult result = executeDataRule(fxRangeAccrual);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxRangeAccrual", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxRangeAccrual", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxRangeAccrual fxRangeAccrual) {
			try {
				return choice(MapperS.of(fxRangeAccrual), Arrays.asList("settlementDate", "settlementSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxRangeAccrualChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRangeAccrual fxRangeAccrual) {
			return Collections.emptyList();
		}
	}
}
