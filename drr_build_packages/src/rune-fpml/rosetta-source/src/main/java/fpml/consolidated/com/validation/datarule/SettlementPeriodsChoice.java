package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.SettlementPeriods;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SettlementPeriodsChoice")
@ImplementedBy(SettlementPeriodsChoice.Default.class)
public interface SettlementPeriodsChoice extends Validator<SettlementPeriods> {
	
	String NAME = "SettlementPeriodsChoice";
	String DEFINITION = "optional choice excludeHolidays, includeHolidays";
	
	class Default implements SettlementPeriodsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriods settlementPeriods) {
			ComparisonResult result = executeDataRule(settlementPeriods);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriods", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriods", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementPeriods settlementPeriods) {
			try {
				return choice(MapperS.of(settlementPeriods), Arrays.asList("excludeHolidays", "includeHolidays"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriods settlementPeriods) {
			return Collections.emptyList();
		}
	}
}
