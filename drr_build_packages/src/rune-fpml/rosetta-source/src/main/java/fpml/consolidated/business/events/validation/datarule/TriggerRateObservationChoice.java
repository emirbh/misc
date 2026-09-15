package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TriggerRateObservation;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TriggerRateObservationChoice")
@ImplementedBy(TriggerRateObservationChoice.Default.class)
public interface TriggerRateObservationChoice extends Validator<TriggerRateObservation> {
	
	String NAME = "TriggerRateObservationChoice";
	String DEFINITION = "triggerPrice is absent and observedPrice is absent or triggerRate is absent and quotedCurrencyPair is absent and observedRate is absent";
	
	class Default implements TriggerRateObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservation triggerRateObservation) {
			ComparisonResult result = executeDataRule(triggerRateObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TriggerRateObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TriggerRateObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TriggerRateObservation triggerRateObservation) {
			try {
				return notExists(MapperS.of(triggerRateObservation).<PositiveMoney>map("getTriggerPrice", _triggerRateObservation -> _triggerRateObservation.getTriggerPrice())).andNullSafe(notExists(MapperS.of(triggerRateObservation).<PositiveMoney>map("getObservedPrice", _triggerRateObservation -> _triggerRateObservation.getObservedPrice()))).orNullSafe(notExists(MapperS.of(triggerRateObservation).<BigDecimal>map("getTriggerRate", _triggerRateObservation -> _triggerRateObservation.getTriggerRate())).andNullSafe(notExists(MapperS.of(triggerRateObservation).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _triggerRateObservation -> _triggerRateObservation.getQuotedCurrencyPair()))).andNullSafe(notExists(MapperS.of(triggerRateObservation).<BigDecimal>map("getObservedRate", _triggerRateObservation -> _triggerRateObservation.getObservedRate()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TriggerRateObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservation triggerRateObservation) {
			return Collections.emptyList();
		}
	}
}
