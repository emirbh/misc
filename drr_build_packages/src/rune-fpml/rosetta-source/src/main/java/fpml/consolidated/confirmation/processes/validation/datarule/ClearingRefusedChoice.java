package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.ClearingRefused;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ClearingRefusedChoice")
@ImplementedBy(ClearingRefusedChoice.Default.class)
public interface ClearingRefusedChoice extends Validator<ClearingRefused> {
	
	String NAME = "ClearingRefusedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and additionalEvent is absent else if additionalEvent exists then trade is absent and tradePackage is absent and originatingEvent is absent else trade is absent and additionalEvent is absent and originatingEvent is absent";
	
	class Default implements ClearingRefusedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingRefused clearingRefused) {
			ComparisonResult result = executeDataRule(clearingRefused);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingRefused", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingRefused", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ClearingRefused clearingRefused) {
			try {
				if (exists(MapperS.of(clearingRefused).<Trade>map("getTrade", _clearingRefused -> _clearingRefused.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingRefused).<TradePackage>map("getTradePackage", _clearingRefused -> _clearingRefused.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingRefused).<AdditionalEvent>map("getAdditionalEvent", _clearingRefused -> _clearingRefused.getAdditionalEvent())));
				}
				if (exists(MapperS.of(clearingRefused).<AdditionalEvent>map("getAdditionalEvent", _clearingRefused -> _clearingRefused.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingRefused).<Trade>map("getTrade", _clearingRefused -> _clearingRefused.getTrade())).andNullSafe(notExists(MapperS.of(clearingRefused).<TradePackage>map("getTradePackage", _clearingRefused -> _clearingRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(clearingRefused).<OriginatingEvent>map("getOriginatingEvent", _clearingRefused -> _clearingRefused.getOriginatingEvent())));
				}
				return notExists(MapperS.of(clearingRefused).<Trade>map("getTrade", _clearingRefused -> _clearingRefused.getTrade())).andNullSafe(notExists(MapperS.of(clearingRefused).<AdditionalEvent>map("getAdditionalEvent", _clearingRefused -> _clearingRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(clearingRefused).<OriginatingEvent>map("getOriginatingEvent", _clearingRefused -> _clearingRefused.getOriginatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingRefusedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingRefused clearingRefused) {
			return Collections.emptyList();
		}
	}
}
