package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeNovationContentChoice6")
@ImplementedBy(TradeNovationContentChoice6.Default.class)
public interface TradeNovationContentChoice6 extends Validator<TradeNovationContent> {
	
	String NAME = "TradeNovationContentChoice6";
	String DEFINITION = "if novatedAmount is absent and novatedNumberOfOptions is absent and novatedNumberOfUnits is absent and novationAmount is absent then remainingAmount is absent and remainingNumberOfOptions is absent and remainingNumberOfUnits is absent and optional choice oldTradeIdentifier, oldTrade and optional choice feeTradeIdentifier, feeTrade";
	
	class Default implements TradeNovationContentChoice6 {
	
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
				if (notExists(MapperS.of(tradeNovationContent).<Money>mapC("getNovatedAmount", _tradeNovationContent -> _tradeNovationContent.getNovatedAmount())).andNullSafe(notExists(MapperS.of(tradeNovationContent).<BigDecimal>map("getNovatedNumberOfOptions", _tradeNovationContent -> _tradeNovationContent.getNovatedNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNovationContent).<BigDecimal>map("getNovatedNumberOfUnits", _tradeNovationContent -> _tradeNovationContent.getNovatedNumberOfUnits()))).andNullSafe(notExists(MapperS.of(tradeNovationContent).<TradeLegSizeChange>mapC("getNovationAmount", _tradeNovationContent -> _tradeNovationContent.getNovationAmount()))).getOrDefault(false)) {
					return notExists(MapperS.of(tradeNovationContent).<Money>mapC("getRemainingAmount", _tradeNovationContent -> _tradeNovationContent.getRemainingAmount())).andNullSafe(notExists(MapperS.of(tradeNovationContent).<BigDecimal>map("getRemainingNumberOfOptions", _tradeNovationContent -> _tradeNovationContent.getRemainingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNovationContent).<BigDecimal>map("getRemainingNumberOfUnits", _tradeNovationContent -> _tradeNovationContent.getRemainingNumberOfUnits()))).andNullSafe(choice(MapperS.of(tradeNovationContent), Arrays.asList("oldTradeIdentifier", "oldTrade"), ChoiceRuleValidationMethod.OPTIONAL)).andNullSafe(choice(MapperS.of(tradeNovationContent), Arrays.asList("feeTradeIdentifier", "feeTrade"), ChoiceRuleValidationMethod.OPTIONAL));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNovationContentChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNovationContent tradeNovationContent) {
			return Collections.emptyList();
		}
	}
}
