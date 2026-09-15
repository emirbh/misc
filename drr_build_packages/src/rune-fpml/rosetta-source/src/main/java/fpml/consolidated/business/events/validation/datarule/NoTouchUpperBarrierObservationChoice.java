package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.NoTouchUpperBarrierObservation;
import fpml.consolidated.business.events.ObservedPrice;
import fpml.consolidated.business.events.ObservedRate;
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
@RosettaDataRule("NoTouchUpperBarrierObservationChoice")
@ImplementedBy(NoTouchUpperBarrierObservationChoice.Default.class)
public interface NoTouchUpperBarrierObservationChoice extends Validator<NoTouchUpperBarrierObservation> {
	
	String NAME = "NoTouchUpperBarrierObservationChoice";
	String DEFINITION = "triggerPrice is absent and maximumObservedPrice is absent or triggerRate is absent and quotedCurrencyPair is absent and maximumObservedRate is absent";
	
	class Default implements NoTouchUpperBarrierObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchUpperBarrierObservation noTouchUpperBarrierObservation) {
			ComparisonResult result = executeDataRule(noTouchUpperBarrierObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchUpperBarrierObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchUpperBarrierObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NoTouchUpperBarrierObservation noTouchUpperBarrierObservation) {
			try {
				return notExists(MapperS.of(noTouchUpperBarrierObservation).<PositiveMoney>map("getTriggerPrice", _noTouchUpperBarrierObservation -> _noTouchUpperBarrierObservation.getTriggerPrice())).andNullSafe(notExists(MapperS.of(noTouchUpperBarrierObservation).<ObservedPrice>map("getMaximumObservedPrice", _noTouchUpperBarrierObservation -> _noTouchUpperBarrierObservation.getMaximumObservedPrice()))).orNullSafe(notExists(MapperS.of(noTouchUpperBarrierObservation).<BigDecimal>map("getTriggerRate", _noTouchUpperBarrierObservation -> _noTouchUpperBarrierObservation.getTriggerRate())).andNullSafe(notExists(MapperS.of(noTouchUpperBarrierObservation).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _noTouchUpperBarrierObservation -> _noTouchUpperBarrierObservation.getQuotedCurrencyPair()))).andNullSafe(notExists(MapperS.of(noTouchUpperBarrierObservation).<ObservedRate>map("getMaximumObservedRate", _noTouchUpperBarrierObservation -> _noTouchUpperBarrierObservation.getMaximumObservedRate()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchUpperBarrierObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchUpperBarrierObservation noTouchUpperBarrierObservation) {
			return Collections.emptyList();
		}
	}
}
