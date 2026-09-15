package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.StepRelativeToEnum;
import fpml.consolidated.ird.NotionalStepRule;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("NotionalStepRuleChoice")
@ImplementedBy(NotionalStepRuleChoice.Default.class)
public interface NotionalStepRuleChoice extends Validator<NotionalStepRule> {
	
	String NAME = "NotionalStepRuleChoice";
	String DEFINITION = "notionalStepAmount is absent or notionalStepRate is absent and stepRelativeTo is absent";
	
	class Default implements NotionalStepRuleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalStepRule notionalStepRule) {
			ComparisonResult result = executeDataRule(notionalStepRule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NotionalStepRule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NotionalStepRule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NotionalStepRule notionalStepRule) {
			try {
				return notExists(MapperS.of(notionalStepRule).<BigDecimal>map("getNotionalStepAmount", _notionalStepRule -> _notionalStepRule.getNotionalStepAmount())).orNullSafe(notExists(MapperS.of(notionalStepRule).<BigDecimal>map("getNotionalStepRate", _notionalStepRule -> _notionalStepRule.getNotionalStepRate())).andNullSafe(notExists(MapperS.of(notionalStepRule).<StepRelativeToEnum>map("getStepRelativeTo", _notionalStepRule -> _notionalStepRule.getStepRelativeTo()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NotionalStepRuleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalStepRule notionalStepRule) {
			return Collections.emptyList();
		}
	}
}
