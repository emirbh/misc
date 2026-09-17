package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.PhysicalSettlement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PhysicalSettlementChoice")
@ImplementedBy(PhysicalSettlementChoice.Default.class)
public interface PhysicalSettlementChoice extends Validator<PhysicalSettlement> {
	
	String NAME = "PhysicalSettlementChoice";
	String DEFINITION = "one-of";
	
	class Default implements PhysicalSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlement physicalSettlement) {
			ComparisonResult result = executeDataRule(physicalSettlement);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlement", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlement", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PhysicalSettlement physicalSettlement) {
			try {
				return choice(MapperS.of(physicalSettlement), Arrays.asList("resultingTradeIdentifier", "resultingTrade", "product"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PhysicalSettlementChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlement physicalSettlement) {
			return Collections.emptyList();
		}
	}
}
