package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.IssuerTradeId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeHeaderChoice")
@ImplementedBy(TradeHeaderChoice.Default.class)
public interface TradeHeaderChoice extends Validator<TradeHeader> {
	
	String NAME = "TradeHeaderChoice";
	String DEFINITION = "if uniqueSwapIdentifier exists then True else uniqueTransactionIdentifier exists or partyTradeIdentifier exists";
	
	class Default implements TradeHeaderChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeHeader tradeHeader) {
			ComparisonResult result = executeDataRule(tradeHeader);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeHeader", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeHeader", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeHeader tradeHeader) {
			try {
				if (exists(MapperS.of(tradeHeader).<IssuerTradeId>map("getUniqueSwapIdentifier", _tradeHeader -> _tradeHeader.getUniqueSwapIdentifier())).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return exists(MapperS.of(tradeHeader).<IssuerTradeId>map("getUniqueTransactionIdentifier", _tradeHeader -> _tradeHeader.getUniqueTransactionIdentifier())).orNullSafe(exists(MapperS.of(tradeHeader).<PartyTradeIdentifier>mapC("getPartyTradeIdentifier", _tradeHeader -> _tradeHeader.getPartyTradeIdentifier())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeHeaderChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeHeader tradeHeader) {
			return Collections.emptyList();
		}
	}
}
