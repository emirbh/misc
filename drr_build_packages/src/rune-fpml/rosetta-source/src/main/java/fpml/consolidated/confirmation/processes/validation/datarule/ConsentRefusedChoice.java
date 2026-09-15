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
import fpml.consolidated.confirmation.processes.ConsentRefused;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.OriginatingEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ConsentRefusedChoice")
@ImplementedBy(ConsentRefusedChoice.Default.class)
public interface ConsentRefusedChoice extends Validator<ConsentRefused> {
	
	String NAME = "ConsentRefusedChoice";
	String DEFINITION = "if trade exists then tradePackage is absent and amendment is absent and increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and additionalEvent is absent and tradeReferenceInformation is absent else if amendment exists then increase is absent and terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if increase exists then terminatingEvent is absent and termination is absent and novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if termination exists then novation is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if novation exists then terminatingEvent is absent and withdrawal is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if withdrawal exists then terminatingEvent is absent and observation is absent and reset is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if observation exists then terminatingEvent is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if reset exists then terminatingEvent is absent and tradePackage is absent and originatingEvent is absent and additionalEvent is absent and tradeReferenceInformation is absent else if additionalEvent exists then reset is absent and tradePackage is absent and originatingEvent is absent and terminatingEvent is absent and tradeReferenceInformation is absent else if tradeReferenceInformation exists then reset is absent and additionalEvent is absent and tradePackage is absent and originatingEvent is absent and terminatingEvent is absent else reset is absent and additionalEvent is absent and tradeReferenceInformation is absent and originatingEvent is absent and terminatingEvent is absent";
	
	class Default implements ConsentRefusedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentRefused consentRefused) {
			ComparisonResult result = executeDataRule(consentRefused);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConsentRefused", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConsentRefused", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConsentRefused consentRefused) {
			try {
				if (exists(MapperS.of(consentRefused).<Trade>map("getTrade", _consentRefused -> _consentRefused.getTrade())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage())).andNullSafe(notExists(MapperS.of(consentRefused).<TradeAmendmentContent>map("getAmendment", _consentRefused -> _consentRefused.getAmendment()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNotionalChange>map("getIncrease", _consentRefused -> _consentRefused.getIncrease()))).andNullSafe(notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNotionalChange>map("getTermination", _consentRefused -> _consentRefused.getTermination()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNovationContent>map("getNovation", _consentRefused -> _consentRefused.getNovation()))).andNullSafe(notExists(MapperS.of(consentRefused).<Withdrawal>map("getWithdrawal", _consentRefused -> _consentRefused.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation()))).andNullSafe(notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<TradeAmendmentContent>map("getAmendment", _consentRefused -> _consentRefused.getAmendment())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TradeNotionalChange>map("getIncrease", _consentRefused -> _consentRefused.getIncrease())).andNullSafe(notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNotionalChange>map("getTermination", _consentRefused -> _consentRefused.getTermination()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNovationContent>map("getNovation", _consentRefused -> _consentRefused.getNovation()))).andNullSafe(notExists(MapperS.of(consentRefused).<Withdrawal>map("getWithdrawal", _consentRefused -> _consentRefused.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation()))).andNullSafe(notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<TradeNotionalChange>map("getIncrease", _consentRefused -> _consentRefused.getIncrease())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNotionalChange>map("getTermination", _consentRefused -> _consentRefused.getTermination()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeNovationContent>map("getNovation", _consentRefused -> _consentRefused.getNovation()))).andNullSafe(notExists(MapperS.of(consentRefused).<Withdrawal>map("getWithdrawal", _consentRefused -> _consentRefused.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation()))).andNullSafe(notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<TradeNotionalChange>map("getTermination", _consentRefused -> _consentRefused.getTermination())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TradeNovationContent>map("getNovation", _consentRefused -> _consentRefused.getNovation())).andNullSafe(notExists(MapperS.of(consentRefused).<Withdrawal>map("getWithdrawal", _consentRefused -> _consentRefused.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation()))).andNullSafe(notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<TradeNovationContent>map("getNovation", _consentRefused -> _consentRefused.getNovation())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentRefused).<Withdrawal>map("getWithdrawal", _consentRefused -> _consentRefused.getWithdrawal()))).andNullSafe(notExists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation()))).andNullSafe(notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<Withdrawal>map("getWithdrawal", _consentRefused -> _consentRefused.getWithdrawal())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation()))).andNullSafe(notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<ObservationEvent>mapC("getObservation", _consentRefused -> _consentRefused.getObservation())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset())).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())));
				}
				if (exists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation())).getOrDefault(false)) {
					return notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset())).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradePackage>map("getTradePackage", _consentRefused -> _consentRefused.getTradePackage()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())));
				}
				return notExists(MapperS.of(consentRefused).<ResetEvent>mapC("getReset", _consentRefused -> _consentRefused.getReset())).andNullSafe(notExists(MapperS.of(consentRefused).<AdditionalEvent>map("getAdditionalEvent", _consentRefused -> _consentRefused.getAdditionalEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TradeReferenceInformation>map("getTradeReferenceInformation", _consentRefused -> _consentRefused.getTradeReferenceInformation()))).andNullSafe(notExists(MapperS.of(consentRefused).<OriginatingEvent>map("getOriginatingEvent", _consentRefused -> _consentRefused.getOriginatingEvent()))).andNullSafe(notExists(MapperS.of(consentRefused).<TerminatingEvent>map("getTerminatingEvent", _consentRefused -> _consentRefused.getTerminatingEvent())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConsentRefusedChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentRefused consentRefused) {
			return Collections.emptyList();
		}
	}
}
