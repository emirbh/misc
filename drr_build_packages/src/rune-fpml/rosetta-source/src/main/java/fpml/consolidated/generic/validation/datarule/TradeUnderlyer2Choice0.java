package fpml.consolidated.generic.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.TradeUnderlyer2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeUnderlyer2Choice0")
@ImplementedBy(TradeUnderlyer2Choice0.Default.class)
public interface TradeUnderlyer2Choice0 extends Validator<TradeUnderlyer2> {
	
	String NAME = "TradeUnderlyer2Choice0";
	String DEFINITION = "optional choice floatingRate, fixedRate, exchangeRate, underlyingAsset, quotedCurrencyPair, referenceEntity, indexReferenceInformation, gas, oil, coal, electricity";
	
	class Default implements TradeUnderlyer2Choice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2) {
			ComparisonResult result = executeDataRule(tradeUnderlyer2);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeUnderlyer2 tradeUnderlyer2) {
			try {
				return choice(MapperS.of(tradeUnderlyer2), Arrays.asList("floatingRate", "fixedRate", "exchangeRate", "underlyingAsset", "quotedCurrencyPair", "referenceEntity", "indexReferenceInformation", "gas", "oil", "coal", "electricity"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeUnderlyer2Choice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2) {
			return Collections.emptyList();
		}
	}
}
