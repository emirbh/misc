package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeNovationContentChoice4")
@ImplementedBy(TradeNovationContentChoice4.Default.class)
public interface TradeNovationContentChoice4 extends Validator<TradeNovationContent> {
	
	String NAME = "TradeNovationContentChoice4";
	String DEFINITION = "if novatedNumberOfUnits exists then remainingAmount is absent and remainingNumberOfOptions is absent and optional choice oldTradeIdentifier, oldTrade and if oldTradeIdentifier exists then optional choice feeTradeIdentifier, feeTrade and if oldTrade exists then optional choice feeTradeIdentifier, feeTrade and if oldTradeIdentifier is absent and oldTrade is absent then optional choice feeTradeIdentifier, feeTrade";
	
	class Default implements TradeNovationContentChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent tradeNovationContent) {
			ComparisonResult result = executeDataRule(tradeNovationContent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeNovationContent tradeNovationContent) {
			try {
				if (exists(MapperS.of(tradeNovationContent).<BigDecimal>map("getNovatedNumberOfUnits", _tradeNovationContent -> _tradeNovationContent.getNovatedNumberOfUnits())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult2;
					if (exists(MapperS.of(tradeNovationContent).<PartyTradeIdentifier>mapC("getOldTradeIdentifier", _tradeNovationContent -> _tradeNovationContent.getOldTradeIdentifier())).getOrDefault(false)) {
						final ComparisonResult ifThenElseResult1;
						if (exists(MapperS.of(tradeNovationContent).<Trade>map("getOldTrade", _tradeNovationContent -> _tradeNovationContent.getOldTrade())).getOrDefault(false)) {
							final ComparisonResult ifThenElseResult0;
							if (notExists(MapperS.of(tradeNovationContent).<PartyTradeIdentifier>mapC("getOldTradeIdentifier", _tradeNovationContent -> _tradeNovationContent.getOldTradeIdentifier())).andNullSafe(notExists(MapperS.of(tradeNovationContent).<Trade>map("getOldTrade", _tradeNovationContent -> _tradeNovationContent.getOldTrade()))).getOrDefault(false)) {
								ifThenElseResult0 = choice(MapperS.of(tradeNovationContent), Arrays.asList("feeTradeIdentifier", "feeTrade"), ChoiceRuleValidationMethod.OPTIONAL);
							} else {
								ifThenElseResult0 = ComparisonResult.ofEmpty();
							}
							ifThenElseResult1 = choice(MapperS.of(tradeNovationContent), Arrays.asList("feeTradeIdentifier", "feeTrade"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult0);
						} else {
							ifThenElseResult1 = ComparisonResult.ofEmpty();
						}
						ifThenElseResult2 = choice(MapperS.of(tradeNovationContent), Arrays.asList("feeTradeIdentifier", "feeTrade"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult1);
					} else {
						ifThenElseResult2 = ComparisonResult.ofEmpty();
					}
					return notExists(MapperS.of(tradeNovationContent).<Money>mapC("getRemainingAmount", _tradeNovationContent -> _tradeNovationContent.getRemainingAmount())).andNullSafe(notExists(MapperS.of(tradeNovationContent).<BigDecimal>map("getRemainingNumberOfOptions", _tradeNovationContent -> _tradeNovationContent.getRemainingNumberOfOptions()))).andNullSafe(choice(MapperS.of(tradeNovationContent), Arrays.asList("oldTradeIdentifier", "oldTrade"), ChoiceRuleValidationMethod.OPTIONAL)).andNullSafe(ifThenElseResult2);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNovationContentChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent tradeNovationContent) {
			return Collections.emptyList();
		}
	}
}
