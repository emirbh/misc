package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.OptionExercise;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.ConfirmationRetracted;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ConfirmationRetractedChoice")
@ImplementedBy(ConfirmationRetractedChoice.Default.class)
public interface ConfirmationRetractedChoice extends Validator<ConfirmationRetracted> {
	
	String NAME = "ConfirmationRetractedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and optionExercise is absent else if amendment exists then increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if increase exists then terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if termination exists then novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if novation exists then terminatingEvent is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if withdrawal exists then terminatingEvent is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if observation exists then terminatingEvent is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if reset exists then terminatingEvent is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if additionalEvent exists then reset is absent and tradePackage is absent and originatingEvent is absent and terminatingEvent is absent and optionExercise is absent else if optionExercise exists then reset is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent and terminatingEvent is absent else reset is absent and additionalEvent is absent and optionExercise is absent and originatingEvent is absent and terminatingEvent is absent";
	
	class Default implements ConfirmationRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationRetracted confirmationRetracted) {
			ComparisonResult result = executeDataRule(confirmationRetracted);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationRetracted", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationRetracted", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConfirmationRetracted confirmationRetracted) {
			try {
				if (exists(MapperS.of(confirmationRetracted).<Trade>map("getTrade", _confirmationRetracted -> _confirmationRetracted.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeAmendmentContent>map("getAmendment", _confirmationRetracted -> _confirmationRetracted.getAmendment()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getIncrease", _confirmationRetracted -> _confirmationRetracted.getIncrease()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getTermination", _confirmationRetracted -> _confirmationRetracted.getTermination()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNovationContent>map("getNovation", _confirmationRetracted -> _confirmationRetracted.getNovation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<Withdrawal>map("getWithdrawal", _confirmationRetracted -> _confirmationRetracted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<TradeAmendmentContent>map("getAmendment", _confirmationRetracted -> _confirmationRetracted.getAmendment())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getIncrease", _confirmationRetracted -> _confirmationRetracted.getIncrease())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getTermination", _confirmationRetracted -> _confirmationRetracted.getTermination()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNovationContent>map("getNovation", _confirmationRetracted -> _confirmationRetracted.getNovation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<Withdrawal>map("getWithdrawal", _confirmationRetracted -> _confirmationRetracted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getIncrease", _confirmationRetracted -> _confirmationRetracted.getIncrease())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getTermination", _confirmationRetracted -> _confirmationRetracted.getTermination()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradeNovationContent>map("getNovation", _confirmationRetracted -> _confirmationRetracted.getNovation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<Withdrawal>map("getWithdrawal", _confirmationRetracted -> _confirmationRetracted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<TradeNotionalChange>map("getTermination", _confirmationRetracted -> _confirmationRetracted.getTermination())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TradeNovationContent>map("getNovation", _confirmationRetracted -> _confirmationRetracted.getNovation())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<Withdrawal>map("getWithdrawal", _confirmationRetracted -> _confirmationRetracted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<TradeNovationContent>map("getNovation", _confirmationRetracted -> _confirmationRetracted.getNovation())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<Withdrawal>map("getWithdrawal", _confirmationRetracted -> _confirmationRetracted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<Withdrawal>map("getWithdrawal", _confirmationRetracted -> _confirmationRetracted.getWithdrawal())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<ObservationEvent>mapC("getObservation", _confirmationRetracted -> _confirmationRetracted.getObservation())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())));
				}
				if (exists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TradePackage>map("getTradePackage", _confirmationRetracted -> _confirmationRetracted.getTradePackage()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())));
				}
				return notExists(MapperS.of(confirmationRetracted).<ResetEvent>mapC("getReset", _confirmationRetracted -> _confirmationRetracted.getReset())).andNullSafe(notExists(MapperS.of(confirmationRetracted).<AdditionalEvent>map("getAdditionalEvent", _confirmationRetracted -> _confirmationRetracted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OptionExercise>map("getOptionExercise", _confirmationRetracted -> _confirmationRetracted.getOptionExercise()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<OriginatingEvent>map("getOriginatingEvent", _confirmationRetracted -> _confirmationRetracted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(confirmationRetracted).<TerminatingEvent>map("getTerminatingEvent", _confirmationRetracted -> _confirmationRetracted.getTerminatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConfirmationRetractedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationRetracted confirmationRetracted) {
			return Collections.emptyList();
		}
	}
}
