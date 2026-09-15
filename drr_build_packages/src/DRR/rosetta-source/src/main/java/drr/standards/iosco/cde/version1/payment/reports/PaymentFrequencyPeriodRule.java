package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDateSchedule;
import cdm.product.common.schedule.PaymentDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.functions.ConvertPeriodtoISOFrequencyPeriod;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PaymentFrequencyPeriodRule.PaymentFrequencyPeriodRuleDefault.class)
public abstract class PaymentFrequencyPeriodRule implements ReportFunction<InterestRatePayout, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertPeriodtoISOFrequencyPeriod convertPeriodtoISOFrequencyPeriod;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(InterestRatePayout input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(InterestRatePayout input);

	public static class PaymentFrequencyPeriodRuleDefault extends PaymentFrequencyPeriodRule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(InterestRatePayout input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, InterestRatePayout input) {
			if (exists(MapperS.of(input).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod())).getOrDefault(false)) {
				if (areEqual(MapperS.of(input).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.C), CardinalityOperator.All).getOrDefault(false)) {
					output = convertPeriodtoISOFrequencyPeriod.evaluate(MapperS.of(input).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get());
				} else {
					output = convertPeriodtoISOFrequencyPeriod.evaluate(MapperS.of(input).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get());
				}
			} else if (notExists(MapperS.of(input).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency())).andNullSafe(exists(MapperS.of(input).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<PaymentDateSchedule>map("getPaymentDateSchedule", paymentDates -> paymentDates.getPaymentDateSchedule()))).getOrDefault(false)) {
				output = FrequencyPeriodEnum.ADHO;
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
