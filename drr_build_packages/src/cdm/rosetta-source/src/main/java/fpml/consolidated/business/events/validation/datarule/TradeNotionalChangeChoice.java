package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeNotionalChangeChoice")
@ImplementedBy(TradeNotionalChangeChoice.Default.class)
public interface TradeNotionalChangeChoice extends Validator<TradeNotionalChange> {
	
	String NAME = "TradeNotionalChangeChoice";
	String DEFINITION = "if changeInNotionalAmount exists then changeInNumberOfOptions is absent and outstandingNumberOfOptions is absent and changeInNumberOfUnits is absent and outstandingNumberOfUnits is absent and sizeChange is absent else if changeInNumberOfOptions exists then changeInNotionalAmount is absent and outstandingNotionalAmount is absent and changeInNumberOfUnits is absent and outstandingNumberOfUnits is absent and sizeChange is absent else if changeInNumberOfUnits exists then changeInNotionalAmount is absent and changeInNumberOfOptions is absent and outstandingNotionalAmount is absent and outstandingNumberOfOptions is absent and sizeChange is absent else changeInNotionalAmount is absent and changeInNumberOfOptions is absent and changeInNumberOfUnits is absent and outstandingNotionalAmount is absent and outstandingNumberOfOptions is absent and outstandingNumberOfUnits is absent";
	
	class Default implements TradeNotionalChangeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChange tradeNotionalChange) {
			ComparisonResult result = executeDataRule(tradeNotionalChange);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNotionalChange", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNotionalChange", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeNotionalChange tradeNotionalChange) {
			try {
				if (exists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getChangeInNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNotionalAmount())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfOptions())).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getOutstandingNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getOutstandingNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<TradeLegSizeChange>mapC("getSizeChange", _tradeNotionalChange -> _tradeNotionalChange.getSizeChange())));
				}
				if (exists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfOptions())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getChangeInNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNotionalAmount())).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getOutstandingNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getOutstandingNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNumberOfUnits()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<TradeLegSizeChange>mapC("getSizeChange", _tradeNotionalChange -> _tradeNotionalChange.getSizeChange())));
				}
				if (exists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfUnits())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getChangeInNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNotionalAmount())).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getOutstandingNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getOutstandingNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<TradeLegSizeChange>mapC("getSizeChange", _tradeNotionalChange -> _tradeNotionalChange.getSizeChange())));
				}
				return notExists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getChangeInNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNotionalAmount())).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getChangeInNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getChangeInNumberOfUnits()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<NonNegativeMoney>mapC("getOutstandingNotionalAmount", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNotionalAmount()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getOutstandingNumberOfOptions", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNumberOfOptions()))).andNullSafe(notExists(MapperS.of(tradeNotionalChange).<BigDecimal>map("getOutstandingNumberOfUnits", _tradeNotionalChange -> _tradeNotionalChange.getOutstandingNumberOfUnits())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNotionalChangeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChange tradeNotionalChange) {
			return Collections.emptyList();
		}
	}
}
