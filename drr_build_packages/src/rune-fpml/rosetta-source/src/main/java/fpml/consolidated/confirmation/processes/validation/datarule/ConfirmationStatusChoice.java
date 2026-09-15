package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.EventProposedMatch;
import fpml.consolidated.business.events.EventsChoice;
import fpml.consolidated.confirmation.processes.ConfirmationStatus;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ConfirmationStatusChoice")
@ImplementedBy(ConfirmationStatusChoice.Default.class)
public interface ConfirmationStatusChoice extends Validator<ConfirmationStatus> {
	
	String NAME = "ConfirmationStatusChoice";
	String DEFINITION = "if assertedEvent exists then allegedEvent is absent else if allegedEvent exists then assertedEvent is absent and proposedMatch is absent else False";
	
	class Default implements ConfirmationStatusChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationStatus confirmationStatus) {
			ComparisonResult result = executeDataRule(confirmationStatus);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationStatus", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationStatus", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConfirmationStatus confirmationStatus) {
			try {
				if (exists(MapperS.of(confirmationStatus).<EventsChoice>map("getAssertedEvent", _confirmationStatus -> _confirmationStatus.getAssertedEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationStatus).<EventsChoice>map("getAllegedEvent", _confirmationStatus -> _confirmationStatus.getAllegedEvent()));
				}
				if (exists(MapperS.of(confirmationStatus).<EventsChoice>map("getAllegedEvent", _confirmationStatus -> _confirmationStatus.getAllegedEvent())).getOrDefault(false)) {
					return notExists(MapperS.of(confirmationStatus).<EventsChoice>map("getAssertedEvent", _confirmationStatus -> _confirmationStatus.getAssertedEvent())).andNullSafe(notExists(MapperS.of(confirmationStatus).<EventProposedMatch>mapC("getProposedMatch", _confirmationStatus -> _confirmationStatus.getProposedMatch())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConfirmationStatusChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationStatus confirmationStatus) {
			return Collections.emptyList();
		}
	}
}
