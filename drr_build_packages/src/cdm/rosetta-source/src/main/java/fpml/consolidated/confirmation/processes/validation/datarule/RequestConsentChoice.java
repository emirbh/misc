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
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.RequestConsent;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RequestConsentChoice")
@ImplementedBy(RequestConsentChoice.Default.class)
public interface RequestConsentChoice extends Validator<RequestConsent> {
	
	String NAME = "RequestConsentChoice";
	String DEFINITION = "if tradePackage exists then originatingEvent is absent and trade is absent and amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and deClear is absent else if trade exists then amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and deClear is absent else if amendment exists then increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if increase exists then terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if termination exists then novation is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if novation exists then terminatingEvent is absent and withdrawal is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if withdrawal exists then terminatingEvent is absent and observation is absent and reset is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if observation exists then terminatingEvent is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if reset exists then terminatingEvent is absent and originatingEvent is absent and additionalEvent is absent and deClear is absent else if additionalEvent exists then reset is absent and originatingEvent is absent and terminatingEvent is absent and deClear is absent else if deClear exists then reset is absent and additionalEvent is absent and originatingEvent is absent and terminatingEvent is absent else False";
	
	class Default implements RequestConsentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestConsent requestConsent) {
			ComparisonResult result = executeDataRule(requestConsent);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConsent", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConsent", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RequestConsent requestConsent) {
			try {
				if (exists(MapperS.of(requestConsent).<TradePackage>map("getTradePackage", _requestConsent -> _requestConsent.getTradePackage())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent())).andNullSafe(notExists(MapperS.of(requestConsent).<Trade>map("getTrade", _requestConsent -> _requestConsent.getTrade()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeAmendmentContent>map("getAmendment", _requestConsent -> _requestConsent.getAmendment()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getIncrease", _requestConsent -> _requestConsent.getIncrease()))).andNullSafe(notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getTermination", _requestConsent -> _requestConsent.getTermination()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNovationContent>map("getNovation", _requestConsent -> _requestConsent.getNovation()))).andNullSafe(notExists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<Trade>map("getTrade", _requestConsent -> _requestConsent.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TradeAmendmentContent>map("getAmendment", _requestConsent -> _requestConsent.getAmendment())).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getIncrease", _requestConsent -> _requestConsent.getIncrease()))).andNullSafe(notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getTermination", _requestConsent -> _requestConsent.getTermination()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNovationContent>map("getNovation", _requestConsent -> _requestConsent.getNovation()))).andNullSafe(notExists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<TradeAmendmentContent>map("getAmendment", _requestConsent -> _requestConsent.getAmendment())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getIncrease", _requestConsent -> _requestConsent.getIncrease())).andNullSafe(notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getTermination", _requestConsent -> _requestConsent.getTermination()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNovationContent>map("getNovation", _requestConsent -> _requestConsent.getNovation()))).andNullSafe(notExists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<TradeNotionalChange>map("getIncrease", _requestConsent -> _requestConsent.getIncrease())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNotionalChange>map("getTermination", _requestConsent -> _requestConsent.getTermination()))).andNullSafe(notExists(MapperS.of(requestConsent).<TradeNovationContent>map("getNovation", _requestConsent -> _requestConsent.getNovation()))).andNullSafe(notExists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<TradeNotionalChange>map("getTermination", _requestConsent -> _requestConsent.getTermination())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TradeNovationContent>map("getNovation", _requestConsent -> _requestConsent.getNovation())).andNullSafe(notExists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<TradeNovationContent>map("getNovation", _requestConsent -> _requestConsent.getNovation())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal()))).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<Withdrawal>map("getWithdrawal", _requestConsent -> _requestConsent.getWithdrawal())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation()))).andNullSafe(notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset()))).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<ObservationEvent>mapC("getObservation", _requestConsent -> _requestConsent.getObservation())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset())).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())));
				}
				if (exists(MapperS.of(requestConsent).<DeClear>map("getDeClear", _requestConsent -> _requestConsent.getDeClear())).getOrDefault(false)) {
					return notExists(MapperS.of(requestConsent).<ResetEvent>mapC("getReset", _requestConsent -> _requestConsent.getReset())).andNullSafe(notExists(MapperS.of(requestConsent).<AdditionalEvent>map("getAdditionalEvent", _requestConsent -> _requestConsent.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<OriginatingEvent>map("getOriginatingEvent", _requestConsent -> _requestConsent.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(requestConsent).<TerminatingEvent>map("getTerminatingEvent", _requestConsent -> _requestConsent.getTerminatingEvent())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestConsentChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestConsent requestConsent) {
			return Collections.emptyList();
		}
	}
}
