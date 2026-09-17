package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("WithdrawalChoice")
@ImplementedBy(WithdrawalChoice.Default.class)
public interface WithdrawalChoice extends Validator<Withdrawal> {
	
	String NAME = "WithdrawalChoice";
	String DEFINITION = "trade is absent or partyTradeIdentifier is absent and partyTradeInformation is absent";
	
	class Default implements WithdrawalChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Withdrawal withdrawal) {
			ComparisonResult result = executeDataRule(withdrawal);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Withdrawal", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Withdrawal", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Withdrawal withdrawal) {
			try {
				return notExists(MapperS.of(withdrawal).<Trade>map("getTrade", _withdrawal -> _withdrawal.getTrade())).orNullSafe(notExists(MapperS.of(withdrawal).<PartyTradeIdentifier>mapC("getPartyTradeIdentifier", _withdrawal -> _withdrawal.getPartyTradeIdentifier())).andNullSafe(notExists(MapperS.of(withdrawal).<WithdrawalPartyTradeInformation>mapC("getPartyTradeInformation", _withdrawal -> _withdrawal.getPartyTradeInformation()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WithdrawalChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Withdrawal withdrawal) {
			return Collections.emptyList();
		}
	}
}
