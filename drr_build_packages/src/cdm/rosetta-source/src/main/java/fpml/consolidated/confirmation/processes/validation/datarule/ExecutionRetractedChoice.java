package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.ExecutionRetracted;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExecutionRetractedChoice")
@ImplementedBy(ExecutionRetractedChoice.Default.class)
public interface ExecutionRetractedChoice extends Validator<ExecutionRetracted> {
	
	String NAME = "ExecutionRetractedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and additionalEvent is absent and optionExercise is absent else if additionalEvent exists then trade is absent and tradePackage is absent and originatingEvent is absent and optionExercise is absent else if optionExercise exists then trade is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent else trade is absent and additionalEvent is absent and optionExercise is absent and originatingEvent is absent";
	
	class Default implements ExecutionRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionRetracted executionRetracted) {
			ComparisonResult result = executeDataRule(executionRetracted);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionRetracted", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionRetracted", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExecutionRetracted executionRetracted) {
			try {
				if (exists(MapperS.of(executionRetracted).<Trade>map("getTrade", _executionRetracted -> _executionRetracted.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(executionRetracted).<TradePackage>map("getTradePackage", _executionRetracted -> _executionRetracted.getTradePackage())).andNullSafe(notExists(MapperS.of(executionRetracted).<AdditionalEvent>map("getAdditionalEvent", _executionRetracted -> _executionRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(executionRetracted).<OptionExercise>map("getOptionExercise", _executionRetracted -> _executionRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(executionRetracted).<AdditionalEvent>map("getAdditionalEvent", _executionRetracted -> _executionRetracted.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(executionRetracted).<Trade>map("getTrade", _executionRetracted -> _executionRetracted.getTrade())).andNullSafe(notExists(MapperS.of(executionRetracted).<TradePackage>map("getTradePackage", _executionRetracted -> _executionRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(executionRetracted).<OriginatingEvent>map("getOriginatingEvent", _executionRetracted -> _executionRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(executionRetracted).<OptionExercise>map("getOptionExercise", _executionRetracted -> _executionRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(executionRetracted).<OptionExercise>map("getOptionExercise", _executionRetracted -> _executionRetracted.getOptionExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(executionRetracted).<Trade>map("getTrade", _executionRetracted -> _executionRetracted.getTrade())).andNullSafe(notExists(MapperS.of(executionRetracted).<AdditionalEvent>map("getAdditionalEvent", _executionRetracted -> _executionRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(executionRetracted).<TradePackage>map("getTradePackage", _executionRetracted -> _executionRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(executionRetracted).<OriginatingEvent>map("getOriginatingEvent", _executionRetracted -> _executionRetracted.getOriginatingEvent())));
				}
				return notExists(MapperS.of(executionRetracted).<Trade>map("getTrade", _executionRetracted -> _executionRetracted.getTrade())).andNullSafe(notExists(MapperS.of(executionRetracted).<AdditionalEvent>map("getAdditionalEvent", _executionRetracted -> _executionRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(executionRetracted).<OptionExercise>map("getOptionExercise", _executionRetracted -> _executionRetracted.getOptionExercise()))).andNullSafe(notExists(MapperS.of(executionRetracted).<OriginatingEvent>map("getOriginatingEvent", _executionRetracted -> _executionRetracted.getOriginatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionRetracted executionRetracted) {
			return Collections.emptyList();
		}
	}
}
