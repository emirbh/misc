package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.confirmation.processes.TradeWrapper;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TradeWrapperChoice")
@ImplementedBy(TradeWrapperChoice.Default.class)
public interface TradeWrapperChoice extends Validator<TradeWrapper> {
	
	String NAME = "TradeWrapperChoice";
	String DEFINITION = "if trade exists then tradeReferenceInformation is absent and tradePackage is absent else if tradeReferenceInformation exists then trade is absent and originatingEvent is absent and tradePackage is absent else if tradePackage exists then trade is absent and tradeReferenceInformation is absent and originatingEvent is absent else False";
	
	class Default implements TradeWrapperChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeWrapper tradeWrapper) {
			ComparisonResult result = executeDataRule(tradeWrapper);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeWrapper", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeWrapper", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TradeWrapper tradeWrapper) {
			try {
				if (exists(MapperS.of(tradeWrapper).<Trade>map("getTrade", _tradeWrapper -> _tradeWrapper.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeWrapper).<TradeReferenceInformation>map("getTradeReferenceInformation", _tradeWrapper -> _tradeWrapper.getTradeReferenceInformation())).andNullSafe(notExists(MapperS.of(tradeWrapper).<TradePackage>map("getTradePackage", _tradeWrapper -> _tradeWrapper.getTradePackage())));
				}
				if (exists(MapperS.of(tradeWrapper).<TradeReferenceInformation>map("getTradeReferenceInformation", _tradeWrapper -> _tradeWrapper.getTradeReferenceInformation())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeWrapper).<Trade>map("getTrade", _tradeWrapper -> _tradeWrapper.getTrade())).andNullSafe(notExists(MapperS.of(tradeWrapper).<OriginatingEvent>map("getOriginatingEvent", _tradeWrapper -> _tradeWrapper.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(tradeWrapper).<TradePackage>map("getTradePackage", _tradeWrapper -> _tradeWrapper.getTradePackage())));
				}
				if (exists(MapperS.of(tradeWrapper).<TradePackage>map("getTradePackage", _tradeWrapper -> _tradeWrapper.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(tradeWrapper).<Trade>map("getTrade", _tradeWrapper -> _tradeWrapper.getTrade())).andNullSafe(notExists(MapperS.of(tradeWrapper).<TradeReferenceInformation>map("getTradeReferenceInformation", _tradeWrapper -> _tradeWrapper.getTradeReferenceInformation()))).andNullSafe(notExists(MapperS.of(tradeWrapper).<OriginatingEvent>map("getOriginatingEvent", _tradeWrapper -> _tradeWrapper.getOriginatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeWrapperChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeWrapper tradeWrapper) {
			return Collections.emptyList();
		}
	}
}
