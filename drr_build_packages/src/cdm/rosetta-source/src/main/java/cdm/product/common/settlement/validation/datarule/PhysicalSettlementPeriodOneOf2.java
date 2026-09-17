package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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
@RosettaDataRule("PhysicalSettlementPeriodOneOf2")
@ImplementedBy(PhysicalSettlementPeriodOneOf2.Default.class)
public interface PhysicalSettlementPeriodOneOf2 extends Validator<PhysicalSettlementPeriod> {
	
	String NAME = "PhysicalSettlementPeriodOneOf2";
	String DEFINITION = "one-of";
	
	class Default implements PhysicalSettlementPeriodOneOf2 {
	
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
	class NoOp implements PhysicalSettlementPeriodOneOf2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PhysicalSettlementPeriod physicalSettlementPeriod) {
			return Collections.emptyList();
		}
	}
}
