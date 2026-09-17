package cdm.product.asset.validation.datarule;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.CompoundingMethodEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("InterestRatePayoutFpML_ird_7_2")
@ImplementedBy(InterestRatePayoutFpML_ird_7_2.Default.class)
public interface InterestRatePayoutFpML_ird_7_2 extends Validator<InterestRatePayout> {
	
	String NAME = "InterestRatePayoutFpML_ird_7_2";
	String DEFINITION = "if (paymentDates -> paymentFrequency -> period exists and calculationPeriodDates -> calculationPeriodFrequency -> period exists and paymentDates -> paymentFrequency -> period <> calculationPeriodDates -> calculationPeriodFrequency -> period) or (paymentDates -> paymentFrequency -> periodMultiplier exists and calculationPeriodDates -> calculationPeriodFrequency -> periodMultiplier exists and paymentDates -> paymentFrequency -> periodMultiplier <> calculationPeriodDates -> calculationPeriodFrequency -> periodMultiplier) then compoundingMethod exists";
	
	class Default implements InterestRatePayoutFpML_ird_7_2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout interestRatePayout) {
			ComparisonResult result = executeDataRule(interestRatePayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InterestRatePayout interestRatePayout) {
			try {
				if (exists(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod())).andNullSafe(exists(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()))).andNullSafe(notEqual(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()), CardinalityOperator.Any)).orNullSafe(exists(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier())).andNullSafe(exists(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier()))).andNullSafe(notEqual(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier()), MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier()), CardinalityOperator.Any))).getOrDefault(false)) {
					return exists(MapperS.of(interestRatePayout).<CompoundingMethodEnum>map("getCompoundingMethod", _interestRatePayout -> _interestRatePayout.getCompoundingMethod()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestRatePayoutFpML_ird_7_2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout interestRatePayout) {
			return Collections.emptyList();
		}
	}
}
