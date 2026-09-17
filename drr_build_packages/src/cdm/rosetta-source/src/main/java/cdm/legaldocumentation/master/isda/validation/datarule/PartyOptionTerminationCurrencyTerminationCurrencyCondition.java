package cdm.legaldocumentation.master.isda.validation.datarule;

import cdm.legaldocumentation.common.TerminationCurrencyConditionEnum;
import cdm.legaldocumentation.master.isda.PartyOptionTerminationCurrency;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PartyOptionTerminationCurrencyTerminationCurrencyCondition")
@ImplementedBy(PartyOptionTerminationCurrencyTerminationCurrencyCondition.Default.class)
public interface PartyOptionTerminationCurrencyTerminationCurrencyCondition extends Validator<PartyOptionTerminationCurrency> {
	
	String NAME = "PartyOptionTerminationCurrencyTerminationCurrencyCondition";
	String DEFINITION = "if terminationCurrencyCondition = TerminationCurrencyConditionEnum -> Specified then terminationCurrencySpecifiedCondition exists";
	
	class Default implements PartyOptionTerminationCurrencyTerminationCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
			ComparisonResult result = executeDataRule(partyOptionTerminationCurrency);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyOptionTerminationCurrency", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyOptionTerminationCurrency", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
			try {
				if (areEqual(MapperS.of(partyOptionTerminationCurrency).<TerminationCurrencyConditionEnum>map("getTerminationCurrencyCondition", _partyOptionTerminationCurrency -> _partyOptionTerminationCurrency.getTerminationCurrencyCondition()), MapperS.of(TerminationCurrencyConditionEnum.SPECIFIED), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(partyOptionTerminationCurrency).<String>map("getTerminationCurrencySpecifiedCondition", _partyOptionTerminationCurrency -> _partyOptionTerminationCurrency.getTerminationCurrencySpecifiedCondition()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyOptionTerminationCurrencyTerminationCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyOptionTerminationCurrency partyOptionTerminationCurrency) {
			return Collections.emptyList();
		}
	}
}
