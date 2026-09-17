package fpml.consolidated.msg.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.EventIdentifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EventIdentifierChoice")
@ImplementedBy(EventIdentifierChoice.Default.class)
public interface EventIdentifierChoice extends Validator<EventIdentifier> {
	
	String NAME = "EventIdentifierChoice";
	String DEFINITION = "tradeIdentifier is absent or correlationId is absent and sequenceNumber is absent";
	
	class Default implements EventIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventIdentifier eventIdentifier) {
			ComparisonResult result = executeDataRule(eventIdentifier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventIdentifier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EventIdentifier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EventIdentifier eventIdentifier) {
			try {
				return notExists(MapperS.of(eventIdentifier).<TradeIdentifier>map("getTradeIdentifier", _eventIdentifier -> _eventIdentifier.getTradeIdentifier())).orNullSafe(notExists(MapperS.of(eventIdentifier).<CorrelationId>mapC("getCorrelationId", _eventIdentifier -> _eventIdentifier.getCorrelationId())).andNullSafe(notExists(MapperS.of(eventIdentifier).<Integer>map("getSequenceNumber", _eventIdentifier -> _eventIdentifier.getSequenceNumber()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EventIdentifierChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventIdentifier eventIdentifier) {
			return Collections.emptyList();
		}
	}
}
