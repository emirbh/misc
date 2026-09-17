package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Index;
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
@RosettaDataRule("IndexChoice")
@ImplementedBy(IndexChoice.Default.class)
public interface IndexChoice extends Validator<Index> {
	
	String NAME = "IndexChoice";
	String DEFINITION = "";
	
	class Default implements IndexChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Index index) {
			ComparisonResult result = executeDataRule(index);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Index", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Index", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Index index) {
			try {
				return choice(MapperS.of(index), Arrays.asList("CreditIndex", "EquityIndex", "InterestRateIndex", "ForeignExchangeRateIndex", "OtherIndex"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements IndexChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Index index) {
			return Collections.emptyList();
		}
	}
}
