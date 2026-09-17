package fpml.consolidated.ird.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.MidMarketValuation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("MidMarketValuationChoice")
@ImplementedBy(MidMarketValuationChoice.Default.class)
public interface MidMarketValuationChoice extends Validator<MidMarketValuation> {
	
	String NAME = "MidMarketValuationChoice";
	String DEFINITION = "one-of";
	
	class Default implements MidMarketValuationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MidMarketValuation midMarketValuation) {
			ComparisonResult result = executeDataRule(midMarketValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MidMarketValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MidMarketValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MidMarketValuation midMarketValuation) {
			try {
				return choice(MapperS.of(midMarketValuation), Arrays.asList("indicativeQuotations", "indicativeQuotationsAlternate", "calculationAgentDetermination"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MidMarketValuationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MidMarketValuation midMarketValuation) {
			return Collections.emptyList();
		}
	}
}
