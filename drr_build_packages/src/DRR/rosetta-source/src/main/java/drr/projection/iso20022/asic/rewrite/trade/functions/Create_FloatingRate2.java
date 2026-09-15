package drr.projection.iso20022.asic.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.asic.AmountAndDirection106__1;
import iso20022.auth030.asic.FloatingRate13__2;
import iso20022.auth030.asic.FloatingRateIdentification8Choice__1;
import iso20022.auth030.asic.Frequency13Code__1;
import iso20022.auth030.asic.Frequency13Code__2;
import iso20022.auth030.asic.InterestComputationMethod4Code;
import iso20022.auth030.asic.InterestComputationMethodFormat7__1;
import iso20022.auth030.asic.InterestRateContractTerm4__1;
import iso20022.auth030.asic.InterestRateContractTerm4__2;
import iso20022.auth030.asic.InterestRateFrequency3Choice__1;
import iso20022.auth030.asic.SecuritiesTransactionPrice20Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_FloatingRate2.Create_FloatingRate2Default.class)
public abstract class Create_FloatingRate2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param indicatorOfTheFloatingRate 
	* @param floatingRateReferencePeriodTimePeriod 
	* @param floatingRateReferencePeriodMultiplier 
	* @param spreadOfLeg2Monetary 
	* @param spreadOfLeg2Decimal 
	* @param spreadOfLeg2Basis 
	* @param spreadCurrencyOfLeg2 
	* @param floatingRateDayCountConvention 
	* @param floatingRatePaymentFrequencyPeriod 
	* @param floatingRatePaymentFrequencyPeriodMultiplier 
	* @return out 
	*/
	public FloatingRate13__2 evaluate(String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg2Monetary, BigDecimal spreadOfLeg2Decimal, BigDecimal spreadOfLeg2Basis, String spreadCurrencyOfLeg2, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier) {
		FloatingRate13__2.FloatingRate13__2Builder outBuilder = doEvaluate(indicatorOfTheFloatingRate, floatingRateReferencePeriodTimePeriod, floatingRateReferencePeriodMultiplier, spreadOfLeg2Monetary, spreadOfLeg2Decimal, spreadOfLeg2Basis, spreadCurrencyOfLeg2, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier);
		
		final FloatingRate13__2 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FloatingRate13__2.class, out);
		}
		
		return out;
	}

	protected abstract FloatingRate13__2.FloatingRate13__2Builder doEvaluate(String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg2Monetary, BigDecimal spreadOfLeg2Decimal, BigDecimal spreadOfLeg2Basis, String spreadCurrencyOfLeg2, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier);

	public static class Create_FloatingRate2Default extends Create_FloatingRate2 {
		@Override
		protected FloatingRate13__2.FloatingRate13__2Builder doEvaluate(String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg2Monetary, BigDecimal spreadOfLeg2Decimal, BigDecimal spreadOfLeg2Basis, String spreadCurrencyOfLeg2, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier) {
			FloatingRate13__2.FloatingRate13__2Builder out = FloatingRate13__2.builder();
			return assignOutput(out, indicatorOfTheFloatingRate, floatingRateReferencePeriodTimePeriod, floatingRateReferencePeriodMultiplier, spreadOfLeg2Monetary, spreadOfLeg2Decimal, spreadOfLeg2Basis, spreadCurrencyOfLeg2, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier);
		}
		
		protected FloatingRate13__2.FloatingRate13__2Builder assignOutput(FloatingRate13__2.FloatingRate13__2Builder out, String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg2Monetary, BigDecimal spreadOfLeg2Decimal, BigDecimal spreadOfLeg2Basis, String spreadCurrencyOfLeg2, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(spreadOfLeg2Monetary), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			out = toBuilder(FloatingRate13__2.builder()
				.setRate(FloatingRateIdentification8Choice__1.builder()
					.setCd(indicatorOfTheFloatingRate)
					.build())
				.setRefPrd(InterestRateContractTerm4__2.builder()
					.setUnit(MapperS.of(floatingRateReferencePeriodTimePeriod).checkedMap("to-enum", Frequency13Code__2::fromDisplayName, IllegalArgumentException.class).get())
					.setVal(floatingRateReferencePeriodMultiplier)
					.build())
				.setSprd(SecuritiesTransactionPrice20Choice__1.builder()
					.setMntryVal(AmountAndDirection106__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
							.setValue(abs.evaluate(spreadOfLeg2Monetary))
							.setCcy(MapperS.of(spreadCurrencyOfLeg2).map("to-string", Object::toString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setDcml(spreadOfLeg2Decimal)
					.setBsisPtSprd((spreadOfLeg2Basis == null ? null : spreadOfLeg2Basis.intValueExact()))
					.build())
				.setDayCnt(InterestComputationMethodFormat7__1.builder()
					.setCd(floatingRateDayCountConvention)
					.build())
				.setPmtFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(MapperS.of(floatingRatePaymentFrequencyPeriod).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
						.setVal(floatingRatePaymentFrequencyPeriodMultiplier)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
