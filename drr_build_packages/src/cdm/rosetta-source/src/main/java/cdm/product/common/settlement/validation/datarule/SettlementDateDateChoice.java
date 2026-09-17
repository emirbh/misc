package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.SettlementDate;
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
@RosettaDataRule("SettlementDateDateChoice")
@ImplementedBy(SettlementDateDateChoice.Default.class)
public interface SettlementDateDateChoice extends Validator<SettlementDate> {
	
	String NAME = "SettlementDateDateChoice";
	String DEFINITION = "optional choice adjustableOrRelativeDate, valueDate, adjustableDates, businessDateRange";
	
	class Default implements SettlementDateDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementDate settlementDate) {
			ComparisonResult result = executeDataRule(settlementDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementDate settlementDate) {
			try {
				return choice(MapperS.of(settlementDate), Arrays.asList("adjustableOrRelativeDate", "valueDate", "adjustableDates", "businessDateRange"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementDateDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementDate settlementDate) {
			return Collections.emptyList();
		}
	}
}
