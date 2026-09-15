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
import fpml.consolidated.confirmation.processes.RequestConfirmation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestConfirmationChoice")
@ImplementedBy(RequestConfirmationChoice.Default.class)
public interface RequestConfirmationChoice extends Validator<RequestConfirmation> {
	
	String NAME = "RequestConfirmationChoice";
	String DEFINITION = "if tradePackage exists then originatingEvent is absent and trade is absent and amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and optionExercise is absent else if trade exists then amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and optionExercise is absent else if amendment exists then increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if increase exists then terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if termination exists then novation is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if novation exists then terminatingEvent is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if withdrawal exists then terminatingEvent is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if observation exists then terminatingEvent is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if reset exists then terminatingEvent is absent and originatingEvent is absent and additionalEvent is absent and optionExercise is absent else if additionalEvent exists then reset is absent and originatingEvent is absent and terminatingEvent is absent and optionExercise is absent else if optionExercise exists then reset is absent and additionalEvent is absent and originatingEvent is absent and terminatingEvent is absent else False";
	
	class Default implements RequestConfirmationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestConfirmation requestConfirmation) {
			ComparisonResult result = executeDataRule(requestConfirmation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConfirmation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConfirmation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestConfirmation requestConfirmation) {
			try {
				if (exists(MapperS.of(requestConfirmation).<TradePackage>map("getTradePackage", _requestConfirmation -> _requestConfirmation.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(requestConfirmation).<Trade>map("getTrade", _requestConfirmation -> _requestConfirmation.getTrade()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeAmendmentContent>map("getAmendment", _requestConfirmation -> _requestConfirmation.getAmendment()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getIncrease", _requestConfirmation -> _requestConfirmation.getIncrease()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getTermination", _requestConfirmation -> _requestConfirmation.getTermination()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNovationContent>map("getNovation", _requestConfirmation -> _requestConfirmation.getNovation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<Trade>map("getTrade", _requestConfirmation -> _requestConfirmation.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TradeAmendmentContent>map("getAmendment", _requestConfirmation -> _requestConfirmation.getAmendment())).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getIncrease", _requestConfirmation -> _requestConfirmation.getIncrease()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getTermination", _requestConfirmation -> _requestConfirmation.getTermination()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNovationContent>map("getNovation", _requestConfirmation -> _requestConfirmation.getNovation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<TradeAmendmentContent>map("getAmendment", _requestConfirmation -> _requestConfirmation.getAmendment())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getIncrease", _requestConfirmation -> _requestConfirmation.getIncrease())).andNullSafe(notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getTermination", _requestConfirmation -> _requestConfirmation.getTermination()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNovationContent>map("getNovation", _requestConfirmation -> _requestConfirmation.getNovation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getIncrease", _requestConfirmation -> _requestConfirmation.getIncrease())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getTermination", _requestConfirmation -> _requestConfirmation.getTermination()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TradeNovationContent>map("getNovation", _requestConfirmation -> _requestConfirmation.getNovation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<TradeNotionalChange>map("getTermination", _requestConfirmation -> _requestConfirmation.getTermination())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TradeNovationContent>map("getNovation", _requestConfirmation -> _requestConfirmation.getNovation())).andNullSafe(notExists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<TradeNovationContent>map("getNovation", _requestConfirmation -> _requestConfirmation.getNovation())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<Withdrawal>map("getWithdrawal", _requestConfirmation -> _requestConfirmation.getWithdrawal())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<ObservationEvent>mapC("getObservation", _requestConfirmation -> _requestConfirmation.getObservation())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset())).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())));
				}
				if (exists(MapperS.of(requestConfirmation).<OptionExercise>map("getOptionExercise", _requestConfirmation -> _requestConfirmation.getOptionExercise())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConfirmation).<ResetEvent>mapC("getReset", _requestConfirmation -> _requestConfirmation.getReset())).andNullSafe(notExists(MapperS.of(requestConfirmation).<AdditionalEvent>map("getAdditionalEvent", _requestConfirmation -> _requestConfirmation.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<OriginatingEvent>map("getOriginatingEvent", _requestConfirmation -> _requestConfirmation.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConfirmation).<TerminatingEvent>map("getTerminatingEvent", _requestConfirmation -> _requestConfirmation.getTerminatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestConfirmationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestConfirmation requestConfirmation) {
			return Collections.emptyList();
		}
	}
}
