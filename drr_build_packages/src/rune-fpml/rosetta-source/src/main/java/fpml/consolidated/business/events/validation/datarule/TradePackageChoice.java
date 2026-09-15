package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradePackage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradePackageChoice")
@ImplementedBy(TradePackageChoice.Default.class)
public interface TradePackageChoice extends Validator<TradePackage> {
	
	String NAME = "TradePackageChoice";
	String DEFINITION = "required choice trade, tradePackageSequence, tradeIdentifier";
	
	class Default implements TradePackageChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradePackage tradePackage) {
			ComparisonResult result = executeDataRule(tradePackage);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradePackage", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradePackage", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradePackage tradePackage) {
			try {
				return choice(MapperS.of(tradePackage), Arrays.asList("trade", "tradePackageSequence", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradePackageChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradePackage tradePackage) {
			return Collections.emptyList();
		}
	}
}
