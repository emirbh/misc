package drr.regulation.common.trade.payment.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.PeriodicPayment;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PeriodicPaymentToCommonPeriodicPayment.PeriodicPaymentToCommonPeriodicPaymentDefault.class)
public abstract class PeriodicPaymentToCommonPeriodicPayment implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param periodicPayment 
	* @return commonPeriodicPayment 
	*/
	public CommonPeriodicPayment evaluate(PeriodicPayment periodicPayment) {
		CommonPeriodicPayment.CommonPeriodicPaymentBuilder commonPeriodicPaymentBuilder = doEvaluate(periodicPayment);
		
		final CommonPeriodicPayment commonPeriodicPayment;
		if (commonPeriodicPaymentBuilder == null) {
			commonPeriodicPayment = null;
		} else {
			commonPeriodicPayment = commonPeriodicPaymentBuilder.build();
			objectValidator.validate(CommonPeriodicPayment.class, commonPeriodicPayment);
		}
		
		return commonPeriodicPayment;
	}

	protected abstract CommonPeriodicPayment.CommonPeriodicPaymentBuilder doEvaluate(PeriodicPayment periodicPayment);

	public static class PeriodicPaymentToCommonPeriodicPaymentDefault extends PeriodicPaymentToCommonPeriodicPayment {
		@Override
		protected CommonPeriodicPayment.CommonPeriodicPaymentBuilder doEvaluate(PeriodicPayment periodicPayment) {
			CommonPeriodicPayment.CommonPeriodicPaymentBuilder commonPeriodicPayment = CommonPeriodicPayment.builder();
			return assignOutput(commonPeriodicPayment, periodicPayment);
		}
		
		protected CommonPeriodicPayment.CommonPeriodicPaymentBuilder assignOutput(CommonPeriodicPayment.CommonPeriodicPaymentBuilder commonPeriodicPayment, PeriodicPayment periodicPayment) {
			commonPeriodicPayment = toBuilder(CommonPeriodicPayment.builder()
				.setFixedRateDayCountConvention(MapperS.of(periodicPayment).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", _periodicPayment -> _periodicPayment.getFixedRateDayCountConvention()).get())
				.setFloatingRateDayCountConvention(MapperS.of(periodicPayment).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", _periodicPayment -> _periodicPayment.getFloatingRateDayCountConvention()).get())
				.setFixedRatePaymentFrequencyPeriod(MapperS.of(periodicPayment).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", _periodicPayment -> _periodicPayment.getFixedRatePaymentFrequencyPeriod()).get())
				.setFloatingRatePaymentFrequencyPeriod(MapperS.of(periodicPayment).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", _periodicPayment -> _periodicPayment.getFloatingRatePaymentFrequencyPeriod()).get())
				.setFixedRatePaymentFrequencyPeriodMultiplier(MapperS.of(periodicPayment).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", _periodicPayment -> _periodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get())
				.setFloatingRatePaymentFrequencyPeriodMultiplier(MapperS.of(periodicPayment).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", _periodicPayment -> _periodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get())
				.build());
			
			return Optional.ofNullable(commonPeriodicPayment)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
