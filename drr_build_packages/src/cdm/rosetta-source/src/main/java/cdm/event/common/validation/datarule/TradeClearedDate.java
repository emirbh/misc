package cdm.event.common.validation.datarule;

import cdm.event.common.Trade;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("TradeClearedDate")
@ImplementedBy(TradeClearedDate.Default.class)
public interface TradeClearedDate extends Validator<Trade> {
	
	String NAME = "TradeClearedDate";
	String DEFINITION = "if clearedDate exists then clearedDate >= tradeDate";
	
	class Default implements TradeClearedDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			ComparisonResult result = executeDataRule(trade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Trade trade) {
			try {
				if (exists(MapperS.of(trade).<Date>map("getClearedDate", _trade -> _trade.getClearedDate())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(trade).<Date>map("getClearedDate", _trade -> _trade.getClearedDate()), MapperS.of(trade).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("Type coercion", fieldWithMetaDate -> fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeClearedDate {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trade trade) {
			return Collections.emptyList();
		}
	}
}
