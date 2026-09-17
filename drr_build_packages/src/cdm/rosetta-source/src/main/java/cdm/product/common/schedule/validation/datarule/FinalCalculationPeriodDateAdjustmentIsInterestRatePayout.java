package cdm.product.common.schedule.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("FinalCalculationPeriodDateAdjustmentIsInterestRatePayout")
@ImplementedBy(FinalCalculationPeriodDateAdjustmentIsInterestRatePayout.Default.class)
public interface FinalCalculationPeriodDateAdjustmentIsInterestRatePayout extends Validator<FinalCalculationPeriodDateAdjustment> {
	
	String NAME = "FinalCalculationPeriodDateAdjustmentIsInterestRatePayout";
	String DEFINITION = "swapStreamReference switch InterestRatePayout then item exists, default False";
	
	class Default implements FinalCalculationPeriodDateAdjustmentIsInterestRatePayout {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment) {
			ComparisonResult result = executeDataRule(finalCalculationPeriodDateAdjustment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FinalCalculationPeriodDateAdjustment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FinalCalculationPeriodDateAdjustment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment) {
			try {
				final MapperS<Payout> switchArgument = MapperS.of(finalCalculationPeriodDateAdjustment).<ReferenceWithMetaPayout>map("getSwapStreamReference", _finalCalculationPeriodDateAdjustment -> _finalCalculationPeriodDateAdjustment.getSwapStreamReference()).<Payout>map("Type coercion", referenceWithMetaPayout -> referenceWithMetaPayout == null ? null : referenceWithMetaPayout.getValue());
				if (switchArgument.get() == null) {
					return ComparisonResult.ofEmpty();
				}
				if (switchArgument.<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get() != null) {
					final MapperS<InterestRatePayout> interestRatePayout = switchArgument.<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout());
					return exists(interestRatePayout);
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FinalCalculationPeriodDateAdjustmentIsInterestRatePayout {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment) {
			return Collections.emptyList();
		}
	}
}
