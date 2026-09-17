package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FxCashSettlement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxCashSettlementChoice")
@ImplementedBy(FxCashSettlementChoice.Default.class)
public interface FxCashSettlementChoice extends Validator<FxCashSettlement> {
	
	String NAME = "FxCashSettlementChoice";
	String DEFINITION = "optional choice fixing, rateSourceFixing";
	
	class Default implements FxCashSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCashSettlement fxCashSettlement) {
			ComparisonResult result = executeDataRule(fxCashSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxCashSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxCashSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxCashSettlement fxCashSettlement) {
			try {
				return choice(MapperS.of(fxCashSettlement), Arrays.asList("fixing", "rateSourceFixing"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxCashSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCashSettlement fxCashSettlement) {
			return Collections.emptyList();
		}
	}
}
