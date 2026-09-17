package fpml.consolidated.business.events.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.NoTouchLowerBarrierObservation;
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
@RosettaDataRule("NoTouchLowerBarrierObservationChoice")
@ImplementedBy(NoTouchLowerBarrierObservationChoice.Default.class)
public interface NoTouchLowerBarrierObservationChoice extends Validator<NoTouchLowerBarrierObservation> {
	
	String NAME = "NoTouchLowerBarrierObservationChoice";
	String DEFINITION = "triggerPrice is absent and minimumObservedPrice is absent or triggerRate is absent and quotedCurrencyPair is absent and minimumObservedRate is absent";
	
	class Default implements NoTouchLowerBarrierObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchLowerBarrierObservation noTouchLowerBarrierObservation) {
			ComparisonResult result = executeDataRule(noTouchLowerBarrierObservation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchLowerBarrierObservation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchLowerBarrierObservation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NoTouchLowerBarrierObservation noTouchLowerBarrierObservation) {
			try {
				return notExists(MapperS.of(noTouchLowerBarrierObservation).<PositiveMoney>map("getTriggerPrice", _noTouchLowerBarrierObservation -> _noTouchLowerBarrierObservation.getTriggerPrice())).andNullSafe(notExists(MapperS.of(noTouchLowerBarrierObservation).<ObservedPrice>map("getMinimumObservedPrice", _noTouchLowerBarrierObservation -> _noTouchLowerBarrierObservation.getMinimumObservedPrice()))).orNullSafe(notExists(MapperS.of(noTouchLowerBarrierObservation).<BigDecimal>map("getTriggerRate", _noTouchLowerBarrierObservation -> _noTouchLowerBarrierObservation.getTriggerRate())).andNullSafe(notExists(MapperS.of(noTouchLowerBarrierObservation).<QuotedCurrencyPair>map("getQuotedCurrencyPair", _noTouchLowerBarrierObservation -> _noTouchLowerBarrierObservation.getQuotedCurrencyPair()))).andNullSafe(notExists(MapperS.of(noTouchLowerBarrierObservation).<ObservedRate>map("getMinimumObservedRate", _noTouchLowerBarrierObservation -> _noTouchLowerBarrierObservation.getMinimumObservedRate()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchLowerBarrierObservationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchLowerBarrierObservation noTouchLowerBarrierObservation) {
			return Collections.emptyList();
		}
	}
}
