package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.Clearing;
import fpml.consolidated.confirmation.processes.ClearingConfirmed;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ClearingConfirmedChoice")
@ImplementedBy(ClearingConfirmedChoice.Default.class)
public interface ClearingConfirmedChoice extends Validator<ClearingConfirmed> {
	
	String NAME = "ClearingConfirmedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and additionalEvent is absent and terminatingEvent is absent and termination is absent and deClear is absent and clearing is absent and change is absent else if additionalEvent exists then tradePackage is absent and originatingEvent is absent and terminatingEvent is absent and termination is absent and deClear is absent and clearing is absent and change is absent else if termination exists then tradePackage is absent and originatingEvent is absent and deClear is absent and clearing is absent and change is absent else if deClear exists then tradePackage is absent and originatingEvent is absent and terminatingEvent is absent and clearing is absent and change is absent else if clearing exists then tradePackage is absent and originatingEvent is absent and terminatingEvent is absent and change is absent else originatingEvent is absent and terminatingEvent is absent and change is absent or tradePackage is absent and originatingEvent is absent and terminatingEvent is absent";
	
	class Default implements ClearingConfirmedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingConfirmed clearingConfirmed) {
			ComparisonResult result = executeDataRule(clearingConfirmed);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingConfirmed", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingConfirmed", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ClearingConfirmed clearingConfirmed) {
			try {
				if (exists(MapperS.of(clearingConfirmed).<Trade>map("getTrade", _clearingConfirmed -> _clearingConfirmed.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingConfirmed).<TradePackage>map("getTradePackage", _clearingConfirmed -> _clearingConfirmed.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<AdditionalEvent>map("getAdditionalEvent", _clearingConfirmed -> _clearingConfirmed.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", _clearingConfirmed -> _clearingConfirmed.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeNotionalChange>map("getTermination", _clearingConfirmed -> _clearingConfirmed.getTermination()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<DeClear>map("getDeClear", _clearingConfirmed -> _clearingConfirmed.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<Clearing>map("getClearing", _clearingConfirmed -> _clearingConfirmed.getClearing()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeChangeContent>map("getChange", _clearingConfirmed -> _clearingConfirmed.getChange())));
				}
				if (exists(MapperS.of(clearingConfirmed).<AdditionalEvent>map("getAdditionalEvent", _clearingConfirmed -> _clearingConfirmed.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingConfirmed).<TradePackage>map("getTradePackage", _clearingConfirmed -> _clearingConfirmed.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", _clearingConfirmed -> _clearingConfirmed.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", _clearingConfirmed -> _clearingConfirmed.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeNotionalChange>map("getTermination", _clearingConfirmed -> _clearingConfirmed.getTermination()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<DeClear>map("getDeClear", _clearingConfirmed -> _clearingConfirmed.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<Clearing>map("getClearing", _clearingConfirmed -> _clearingConfirmed.getClearing()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeChangeContent>map("getChange", _clearingConfirmed -> _clearingConfirmed.getChange())));
				}
				if (exists(MapperS.of(clearingConfirmed).<TradeNotionalChange>map("getTermination", _clearingConfirmed -> _clearingConfirmed.getTermination())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingConfirmed).<TradePackage>map("getTradePackage", _clearingConfirmed -> _clearingConfirmed.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", _clearingConfirmed -> _clearingConfirmed.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<DeClear>map("getDeClear", _clearingConfirmed -> _clearingConfirmed.getDeClear()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<Clearing>map("getClearing", _clearingConfirmed -> _clearingConfirmed.getClearing()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeChangeContent>map("getChange", _clearingConfirmed -> _clearingConfirmed.getChange())));
				}
				if (exists(MapperS.of(clearingConfirmed).<DeClear>map("getDeClear", _clearingConfirmed -> _clearingConfirmed.getDeClear())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingConfirmed).<TradePackage>map("getTradePackage", _clearingConfirmed -> _clearingConfirmed.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", _clearingConfirmed -> _clearingConfirmed.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", _clearingConfirmed -> _clearingConfirmed.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<Clearing>map("getClearing", _clearingConfirmed -> _clearingConfirmed.getClearing()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeChangeContent>map("getChange", _clearingConfirmed -> _clearingConfirmed.getChange())));
				}
				if (exists(MapperS.of(clearingConfirmed).<Clearing>map("getClearing", _clearingConfirmed -> _clearingConfirmed.getClearing())).getOrDefault(false)) {
					return notExists(MapperS.of(clearingConfirmed).<TradePackage>map("getTradePackage", _clearingConfirmed -> _clearingConfirmed.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", _clearingConfirmed -> _clearingConfirmed.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", _clearingConfirmed -> _clearingConfirmed.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeChangeContent>map("getChange", _clearingConfirmed -> _clearingConfirmed.getChange())));
				}
				return notExists(MapperS.of(clearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", _clearingConfirmed -> _clearingConfirmed.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", _clearingConfirmed -> _clearingConfirmed.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TradeChangeContent>map("getChange", _clearingConfirmed -> _clearingConfirmed.getChange()))).orNullSafe(notExists(MapperS.of(clearingConfirmed).<TradePackage>map("getTradePackage", _clearingConfirmed -> _clearingConfirmed.getTradePackage())).andNullSafe(notExists(MapperS.of(clearingConfirmed).<OriginatingEvent>map("getOriginatingEvent", _clearingConfirmed -> _clearingConfirmed.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(clearingConfirmed).<TerminatingEvent>map("getTerminatingEvent", _clearingConfirmed -> _clearingConfirmed.getTerminatingEvent()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingConfirmedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingConfirmed clearingConfirmed) {
			return Collections.emptyList();
		}
	}
}
