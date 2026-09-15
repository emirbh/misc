package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.jfsa.FixedRate10__1;
import iso20022.auth030.jfsa.Frequency13Code__1;
import iso20022.auth030.jfsa.InterestComputationMethod4Code;
import iso20022.auth030.jfsa.InterestComputationMethodFormat7__1;
import iso20022.auth030.jfsa.InterestRateContractTerm4__1;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice14Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FixedRate10__1.Create_FixedRate10__1Default.class)
public abstract class Create_FixedRate10__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fixedRate 
	* @param fixedRateDayCountConvention 
	* @param fixedRatePaymentFrequencyPeriod 
	* @param fixedRatePaymentFrequencyPeriodMultiplier 
	* @return fxd 
	*/
	public FixedRate10__1 evaluate(BigDecimal fixedRate, String fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier) {
		FixedRate10__1.FixedRate10__1Builder fxdBuilder = doEvaluate(fixedRate, fixedRateDayCountConvention, fixedRatePaymentFrequencyPeriod, fixedRatePaymentFrequencyPeriodMultiplier);
		
		final FixedRate10__1 fxd;
		if (fxdBuilder == null) {
			fxd = null;
		} else {
			fxd = fxdBuilder.build();
			objectValidator.validate(FixedRate10__1.class, fxd);
		}
		
		return fxd;
	}

	protected abstract FixedRate10__1.FixedRate10__1Builder doEvaluate(BigDecimal fixedRate, String fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier);

	public static class Create_FixedRate10__1Default extends Create_FixedRate10__1 {
		@Override
		protected FixedRate10__1.FixedRate10__1Builder doEvaluate(BigDecimal fixedRate, String fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier) {
			FixedRate10__1.FixedRate10__1Builder fxd = FixedRate10__1.builder();
			return assignOutput(fxd, fixedRate, fixedRateDayCountConvention, fixedRatePaymentFrequencyPeriod, fixedRatePaymentFrequencyPeriodMultiplier);
		}
		
		protected FixedRate10__1.FixedRate10__1Builder assignOutput(FixedRate10__1.FixedRate10__1Builder fxd, BigDecimal fixedRate, String fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier) {
			fxd = toBuilder(FixedRate10__1.builder()
				.setRate(SecuritiesTransactionPrice14Choice__1.builder()
					.setDcml(fixedRate)
					.build())
				.setDayCnt(InterestComputationMethodFormat7__1.builder()
					.setCd(MapperS.of(fixedRateDayCountConvention).checkedMap("to-enum", InterestComputationMethod4Code::fromDisplayName, IllegalArgumentException.class).get())
					.build())
				.setPmtFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(MapperS.of(fixedRatePaymentFrequencyPeriod).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
						.setVal(fixedRatePaymentFrequencyPeriodMultiplier)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(fxd)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
