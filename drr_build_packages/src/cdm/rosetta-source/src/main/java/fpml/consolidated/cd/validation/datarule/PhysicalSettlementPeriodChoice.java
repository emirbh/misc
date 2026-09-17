package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.PhysicalSettlementPeriod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PhysicalSettlementPeriodChoice")
@ImplementedBy(PhysicalSettlementPeriodChoice.Default.class)
public interface PhysicalSettlementPeriodChoice extends Validator<PhysicalSettlementPeriod> {
	
	String NAME = "PhysicalSettlementPeriodChoice";
	String DEFINITION = "one-of";
	
	class Default implements PhysicalSettlementPeriodChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod physicalSettlementPeriod) {
			ComparisonResult result = executeDataRule(physicalSettlementPeriod);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementPeriod", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementPeriod", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PhysicalSettlementPeriod physicalSettlementPeriod) {
			try {
				return choice(MapperS.of(physicalSettlementPeriod), Arrays.asList("businessDaysNotSpecified", "businessDays", "maximumBusinessDays"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PhysicalSettlementPeriodChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod physicalSettlementPeriod) {
			return Collections.emptyList();
		}
	}
}
