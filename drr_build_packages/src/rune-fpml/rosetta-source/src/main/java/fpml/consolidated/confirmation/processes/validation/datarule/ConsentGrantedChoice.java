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
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.TradeReferenceInformation;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.confirmation.processes.ConsentGranted;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ConsentGrantedChoice")
@ImplementedBy(ConsentGrantedChoice.Default.class)
public interface ConsentGrantedChoice extends Validator<ConsentGranted> {
	
	String NAME = "ConsentGrantedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and tradeReferenceInformation is absent else if amendment exists then increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if increase exists then terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if termination exists then novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if novation exists then terminatingEvent is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if withdrawal exists then terminatingEvent is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if observation exists then terminatingEvent is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if reset exists then terminatingEvent is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if additionalEvent exists then reset is absent and tradePackage is absent and originatingEvent is absent and terminatingEvent is absent and tradeReferenceInformation is absent else if tradeReferenceInformation exists then reset is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent and terminatingEvent is absent else reset is absent and additionalEvent is absent and tradeReferenceInformation is absent and originatingEvent is absent and terminatingEvent is absent";
	
	class Default implements ConsentGrantedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentGranted consentGranted) {
			ComparisonResult result = executeDataRule(consentGranted);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConsentGranted", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConsentGranted", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConsentGranted consentGranted) {
			try {
				if (exists(MapperS.of(consentGranted).<Trade>map("getTrade", _consentGranted -> _consentGranted.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage())).andNullSafe(notExists(MapperS.of(consentGranted).<TradeAmendmentContent>map("getAmendment", _consentGranted -> _consentGranted.getAmendment()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNotionalChange>map("getIncrease", _consentGranted -> _consentGranted.getIncrease()))).andNullSafe(notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNotionalChange>map("getTermination", _consentGranted -> _consentGranted.getTermination()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNovationContent>map("getNovation", _consentGranted -> _consentGranted.getNovation()))).andNullSafe(notExists(MapperS.of(consentGranted).<Withdrawal>map("getWithdrawal", _consentGranted -> _consentGranted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation()))).andNullSafe(notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<TradeAmendmentContent>map("getAmendment", _consentGranted -> _consentGranted.getAmendment())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TradeNotionalChange>map("getIncrease", _consentGranted -> _consentGranted.getIncrease())).andNullSafe(notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNotionalChange>map("getTermination", _consentGranted -> _consentGranted.getTermination()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNovationContent>map("getNovation", _consentGranted -> _consentGranted.getNovation()))).andNullSafe(notExists(MapperS.of(consentGranted).<Withdrawal>map("getWithdrawal", _consentGranted -> _consentGranted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation()))).andNullSafe(notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<TradeNotionalChange>map("getIncrease", _consentGranted -> _consentGranted.getIncrease())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNotionalChange>map("getTermination", _consentGranted -> _consentGranted.getTermination()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeNovationContent>map("getNovation", _consentGranted -> _consentGranted.getNovation()))).andNullSafe(notExists(MapperS.of(consentGranted).<Withdrawal>map("getWithdrawal", _consentGranted -> _consentGranted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation()))).andNullSafe(notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<TradeNotionalChange>map("getTermination", _consentGranted -> _consentGranted.getTermination())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TradeNovationContent>map("getNovation", _consentGranted -> _consentGranted.getNovation())).andNullSafe(notExists(MapperS.of(consentGranted).<Withdrawal>map("getWithdrawal", _consentGranted -> _consentGranted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation()))).andNullSafe(notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<TradeNovationContent>map("getNovation", _consentGranted -> _consentGranted.getNovation())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentGranted).<Withdrawal>map("getWithdrawal", _consentGranted -> _consentGranted.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation()))).andNullSafe(notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<Withdrawal>map("getWithdrawal", _consentGranted -> _consentGranted.getWithdrawal())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation()))).andNullSafe(notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<ObservationEvent>mapC("getObservation", _consentGranted -> _consentGranted.getObservation())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset())).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation())).getOrDefault(false)) {
					return notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset())).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradePackage>map("getTradePackage", _consentGranted -> _consentGranted.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())));
				}
				return notExists(MapperS.of(consentGranted).<ResetEvent>mapC("getReset", _consentGranted -> _consentGranted.getReset())).andNullSafe(notExists(MapperS.of(consentGranted).<AdditionalEvent>map("getAdditionalEvent", _consentGranted -> _consentGranted.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentGranted -> _consentGranted.getTradeReferenceInformation()))).andNullSafe(notExists(MapperS.of(consentGranted).<OriginatingEvent>map("getOriginatingEvent", _consentGranted -> _consentGranted.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentGranted).<TerminatingEvent>map("getTerminatingEvent", _consentGranted -> _consentGranted.getTerminatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConsentGrantedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentGranted consentGranted) {
			return Collections.emptyList();
		}
	}
}
