package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SettlementInformation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SettlementInformationChoice")
@ImplementedBy(SettlementInformationChoice.Default.class)
public interface SettlementInformationChoice extends Validator<SettlementInformation> {
	
	String NAME = "SettlementInformationChoice";
	String DEFINITION = "one-of";
	
	class Default implements SettlementInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInformation settlementInformation) {
			ComparisonResult result = executeDataRule(settlementInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementInformation settlementInformation) {
			try {
				return choice(MapperS.of(settlementInformation), Arrays.asList("standardSettlementStyle", "settlementInstruction"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementInformationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementInformation settlementInformation) {
			return Collections.emptyList();
		}
	}
}
