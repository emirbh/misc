package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import iso20022.auth030.fca.AmountAndDirection106__1;
import iso20022.auth030.fca.FloatingRate13__1;
import iso20022.auth030.fca.FloatingRateIdentification8Choice__1;
import iso20022.auth030.fca.Frequency13Code__1;
import iso20022.auth030.fca.InterestComputationMethod4Code;
import iso20022.auth030.fca.InterestComputationMethodFormat7__1;
import iso20022.auth030.fca.InterestRateContractTerm4__2;
import iso20022.auth030.fca.InterestRateFrequency3Choice__2;
import iso20022.auth030.fca.SecuritiesTransactionPrice20Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_FloatingRate.Create_FloatingRateDefault.class)
public abstract class Create_FloatingRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param identifierOfFloatingRate 
	* @param nameOfTheFloatingRate 
	* @param indicatorOfTheFloatingRate 
	* @param floatingRateReferencePeriodTimePeriod 
	* @param floatingRateReferencePeriodMultiplier 
	* @param spreadOfLeg1Monetary 
	* @param spreadOfLeg1Percentage 
	* @param spreadOfLeg1Basis 
	* @param spreadCurrencyOfLeg1 
	* @param floatingRateDayCountConvention 
	* @param floatingRatePaymentFrequencyPeriod 
	* @param floatingRatePaymentFrequencyPeriodMultiplier 
	* @param floatingRateResetFrequencyPeriod 
	* @param floatingRateResetFrequencyPeriodMultiplier 
	* @return out 
	*/
	public FloatingRate13__1 evaluate(String identifierOfFloatingRate, String nameOfTheFloatingRate, String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Percentage, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
		FloatingRate13__1.FloatingRate13__1Builder outBuilder = doEvaluate(identifierOfFloatingRate, nameOfTheFloatingRate, indicatorOfTheFloatingRate, floatingRateReferencePeriodTimePeriod, floatingRateReferencePeriodMultiplier, spreadOfLeg1Monetary, spreadOfLeg1Percentage, spreadOfLeg1Basis, spreadCurrencyOfLeg1, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier, floatingRateResetFrequencyPeriod, floatingRateResetFrequencyPeriodMultiplier);
		
		final FloatingRate13__1 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FloatingRate13__1.class, out);
		}
		
		return out;
	}

	protected abstract FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String identifierOfFloatingRate, String nameOfTheFloatingRate, String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Percentage, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier);

	public static class Create_FloatingRateDefault extends Create_FloatingRate {
		@Override
		protected FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String identifierOfFloatingRate, String nameOfTheFloatingRate, String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Percentage, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
			FloatingRate13__1.FloatingRate13__1Builder out = FloatingRate13__1.builder();
			return assignOutput(out, identifierOfFloatingRate, nameOfTheFloatingRate, indicatorOfTheFloatingRate, floatingRateReferencePeriodTimePeriod, floatingRateReferencePeriodMultiplier, spreadOfLeg1Monetary, spreadOfLeg1Percentage, spreadOfLeg1Basis, spreadCurrencyOfLeg1, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier, floatingRateResetFrequencyPeriod, floatingRateResetFrequencyPeriodMultiplier);
		}
		
		protected FloatingRate13__1.FloatingRate13__1Builder assignOutput(FloatingRate13__1.FloatingRate13__1Builder out, String identifierOfFloatingRate, String nameOfTheFloatingRate, String indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Percentage, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(spreadOfLeg1Monetary), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			out = toBuilder(FloatingRate13__1.builder()
				.setId(identifierOfFloatingRate)
				.setNm(nameOfTheFloatingRate)
				.setRate(FloatingRateIdentification8Choice__1.builder()
					.setCd(indicatorOfTheFloatingRate)
					.build())
				.setRefPrd(InterestRateContractTerm4__2.builder()
					.setUnit(MapperS.of(floatingRateReferencePeriodTimePeriod).checkedMap("to-enum", Frequency13Code__1::fromDisplayName, IllegalArgumentException.class).get())
					.setVal(floatingRateReferencePeriodMultiplier)
					.build())
				.setSprd(SecuritiesTransactionPrice20Choice__1.builder()
					.setMntryVal(AmountAndDirection106__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
							.setValue(abs.evaluate(spreadOfLeg1Monetary))
							.setCcy(MapperS.of(spreadCurrencyOfLeg1).map("to-string", Object::toString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setPctg(spreadOfLeg1Percentage)
					.setBsisPtSprd((spreadOfLeg1Basis == null ? null : spreadOfLeg1Basis.intValueExact()))
					.build())
				.setDayCnt(InterestComputationMethodFormat7__1.builder()
					.setCd(floatingRateDayCountConvention)
					.build())
				.setPmtFrqcy(InterestRateFrequency3Choice__2.builder()
					.setTerm(InterestRateContractTerm4__2.builder()
						.setUnit(floatingRatePaymentFrequencyPeriod)
						.setVal(floatingRatePaymentFrequencyPeriodMultiplier)
						.build())
					.build())
				.setRstFrqcy(InterestRateFrequency3Choice__2.builder()
					.setTerm(InterestRateContractTerm4__2.builder()
						.setUnit(MapperS.of(floatingRateResetFrequencyPeriod).checkedMap("to-enum", Frequency13Code__1::fromDisplayName, IllegalArgumentException.class).get())
						.setVal(floatingRateResetFrequencyPeriodMultiplier)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
