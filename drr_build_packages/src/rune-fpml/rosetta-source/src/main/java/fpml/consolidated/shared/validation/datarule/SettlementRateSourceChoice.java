package fpml.consolidated.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SettlementRateSourceChoice")
@ImplementedBy(SettlementRateSourceChoice.Default.class)
public interface SettlementRateSourceChoice extends Validator<SettlementRateSource> {
	
	String NAME = "SettlementRateSourceChoice";
	String DEFINITION = "one-of";
	
	class Default implements SettlementRateSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementRateSource settlementRateSource) {
			ComparisonResult result = executeDataRule(settlementRateSource);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementRateSource", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementRateSource", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementRateSource settlementRateSource) {
			try {
				return choice(MapperS.of(settlementRateSource), Arrays.asList("informationSource", "cashSettlementReferenceBanks"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementRateSourceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementRateSource settlementRateSource) {
			return Collections.emptyList();
		}
	}
}
