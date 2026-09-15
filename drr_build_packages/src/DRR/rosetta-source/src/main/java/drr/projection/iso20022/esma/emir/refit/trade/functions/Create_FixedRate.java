package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.FixedRate10__1;
import iso20022.auth030.esma.Frequency13Code__1;
import iso20022.auth030.esma.InterestComputationMethod4Code;
import iso20022.auth030.esma.InterestComputationMethodFormat7__1;
import iso20022.auth030.esma.InterestRateContractTerm4__1;
import iso20022.auth030.esma.InterestRateFrequency3Choice__1;
import iso20022.auth030.esma.SecuritiesTransactionPrice14Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FixedRate.Create_FixedRateDefault.class)
public abstract class Create_FixedRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fixedRate 
	* @param fixedRateDayCountConvention 
	* @param fixedRatePaymentFrequencyPeriod 
	* @param fixedRatePaymentFrequencyPeriodMultiplier 
	* @return out 
	*/
	public FixedRate10__1 evaluate(BigDecimal fixedRate, InterestComputationMethod4Code fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier) {
		FixedRate10__1.FixedRate10__1Builder outBuilder = doEvaluate(fixedRate, fixedRateDayCountConvention, fixedRatePaymentFrequencyPeriod, fixedRatePaymentFrequencyPeriodMultiplier);
		
		final FixedRate10__1 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FixedRate10__1.class, out);
		}
		
		return out;
	}

	protected abstract FixedRate10__1.FixedRate10__1Builder doEvaluate(BigDecimal fixedRate, InterestComputationMethod4Code fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier);

	public static class Create_FixedRateDefault extends Create_FixedRate {
		@Override
		protected FixedRate10__1.FixedRate10__1Builder doEvaluate(BigDecimal fixedRate, InterestComputationMethod4Code fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier) {
			FixedRate10__1.FixedRate10__1Builder out = FixedRate10__1.builder();
			return assignOutput(out, fixedRate, fixedRateDayCountConvention, fixedRatePaymentFrequencyPeriod, fixedRatePaymentFrequencyPeriodMultiplier);
		}
		
		protected FixedRate10__1.FixedRate10__1Builder assignOutput(FixedRate10__1.FixedRate10__1Builder out, BigDecimal fixedRate, InterestComputationMethod4Code fixedRateDayCountConvention, Frequency13Code__1 fixedRatePaymentFrequencyPeriod, Integer fixedRatePaymentFrequencyPeriodMultiplier) {
			out = toBuilder(FixedRate10__1.builder()
				.setRate(SecuritiesTransactionPrice14Choice__1.builder()
					.setRate(fixedRate)
					.build())
				.setDayCnt(InterestComputationMethodFormat7__1.builder()
					.setCd(fixedRateDayCountConvention)
					.build())
				.setPmtFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(MapperS.of(fixedRatePaymentFrequencyPeriod).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
						.setVal(fixedRatePaymentFrequencyPeriodMultiplier)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
