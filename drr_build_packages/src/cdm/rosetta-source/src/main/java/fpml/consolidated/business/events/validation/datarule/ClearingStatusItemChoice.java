package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ClearingStatusItem;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ClearingStatusItemChoice")
@ImplementedBy(ClearingStatusItemChoice.Default.class)
public interface ClearingStatusItemChoice extends Validator<ClearingStatusItem> {
	
	String NAME = "ClearingStatusItemChoice";
	String DEFINITION = "required choice tradeIdentifier, tradeReferenceInformation, trade, tradePackage";
	
	class Default implements ClearingStatusItemChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingStatusItem clearingStatusItem) {
			ComparisonResult result = executeDataRule(clearingStatusItem);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingStatusItem", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingStatusItem", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ClearingStatusItem clearingStatusItem) {
			try {
				return choice(MapperS.of(clearingStatusItem), Arrays.asList("tradeIdentifier", "tradeReferenceInformation", "trade", "tradePackage"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingStatusItemChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingStatusItem clearingStatusItem) {
			return Collections.emptyList();
		}
	}
}
