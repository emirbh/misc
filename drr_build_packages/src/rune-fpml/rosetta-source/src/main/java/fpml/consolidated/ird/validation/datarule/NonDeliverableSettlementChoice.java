package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.NonDeliverableSettlement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("NonDeliverableSettlementChoice")
@ImplementedBy(NonDeliverableSettlementChoice.Default.class)
public interface NonDeliverableSettlementChoice extends Validator<NonDeliverableSettlement> {
	
	String NAME = "NonDeliverableSettlementChoice";
	String DEFINITION = "optional choice fxFixingDate, fxFixingSchedule";
	
	class Default implements NonDeliverableSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSettlement nonDeliverableSettlement) {
			ComparisonResult result = executeDataRule(nonDeliverableSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonDeliverableSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonDeliverableSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NonDeliverableSettlement nonDeliverableSettlement) {
			try {
				return choice(MapperS.of(nonDeliverableSettlement), Arrays.asList("fxFixingDate", "fxFixingSchedule"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonDeliverableSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSettlement nonDeliverableSettlement) {
			return Collections.emptyList();
		}
	}
}
