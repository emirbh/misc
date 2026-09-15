package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__1;
import iso20022.auth030.jfsa.FloatingRate13__1;
import iso20022.auth030.jfsa.FloatingRateIdentification8Choice__1;
import iso20022.auth030.jfsa.FloatingRateIndex1Code;
import iso20022.auth030.jfsa.Frequency13Code__1;
import iso20022.auth030.jfsa.InterestComputationMethod4Code;
import iso20022.auth030.jfsa.InterestComputationMethodFormat7__1;
import iso20022.auth030.jfsa.InterestRateContractTerm4__1;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice20Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_FloatingRate13__1.Create_FloatingRate13__1Default.class)
public abstract class Create_FloatingRate13__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param nameOfTheFloatingRate 
	* @param indicatorOfTheFloatingRate 
	* @param floatingRateReferencePeriodTimePeriod 
	* @param floatingRateReferencePeriodMultiplier 
	* @param spreadLeg1Monetary 
	* @param spreadLeg1Decimal 
	* @param spreadLeg1Basis 
	* @param spreadCurrencyOfLeg1 
	* @param floatingRateDayCountConvention 
	* @param floatingRatePaymentFrequencyPeriod 
	* @param floatingRatePaymentFrequencyPeriodMultiplier 
	* @param floatingRateResetFrequencyPeriod 
	* @param floatingRateResetFrequencyPeriodMultiplier 
	* @return fltg 
	*/
	public FloatingRate13__1 evaluate(String nameOfTheFloatingRate, FloatingRateIndex1Code indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadLeg1Monetary, BigDecimal spreadLeg1Decimal, BigDecimal spreadLeg1Basis, String spreadCurrencyOfLeg1, String floatingRateDayCountConvention, String floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
		FloatingRate13__1.FloatingRate13__1Builder fltgBuilder = doEvaluate(nameOfTheFloatingRate, indicatorOfTheFloatingRate, floatingRateReferencePeriodTimePeriod, floatingRateReferencePeriodMultiplier, spreadLeg1Monetary, spreadLeg1Decimal, spreadLeg1Basis, spreadCurrencyOfLeg1, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier, floatingRateResetFrequencyPeriod, floatingRateResetFrequencyPeriodMultiplier);
		
		final FloatingRate13__1 fltg;
		if (fltgBuilder == null) {
			fltg = null;
		} else {
			fltg = fltgBuilder.build();
			objectValidator.validate(FloatingRate13__1.class, fltg);
		}
		
		return fltg;
	}

	protected abstract FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String nameOfTheFloatingRate, FloatingRateIndex1Code indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadLeg1Monetary, BigDecimal spreadLeg1Decimal, BigDecimal spreadLeg1Basis, String spreadCurrencyOfLeg1, String floatingRateDayCountConvention, String floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier);

	public static class Create_FloatingRate13__1Default extends Create_FloatingRate13__1 {
		@Override
		protected FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String nameOfTheFloatingRate, FloatingRateIndex1Code indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadLeg1Monetary, BigDecimal spreadLeg1Decimal, BigDecimal spreadLeg1Basis, String spreadCurrencyOfLeg1, String floatingRateDayCountConvention, String floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
			FloatingRate13__1.FloatingRate13__1Builder fltg = FloatingRate13__1.builder();
			return assignOutput(fltg, nameOfTheFloatingRate, indicatorOfTheFloatingRate, floatingRateReferencePeriodTimePeriod, floatingRateReferencePeriodMultiplier, spreadLeg1Monetary, spreadLeg1Decimal, spreadLeg1Basis, spreadCurrencyOfLeg1, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier, floatingRateResetFrequencyPeriod, floatingRateResetFrequencyPeriodMultiplier);
		}
		
		protected FloatingRate13__1.FloatingRate13__1Builder assignOutput(FloatingRate13__1.FloatingRate13__1Builder fltg, String nameOfTheFloatingRate, FloatingRateIndex1Code indicatorOfTheFloatingRate, String floatingRateReferencePeriodTimePeriod, Integer floatingRateReferencePeriodMultiplier, BigDecimal spreadLeg1Monetary, BigDecimal spreadLeg1Decimal, BigDecimal spreadLeg1Basis, String spreadCurrencyOfLeg1, String floatingRateDayCountConvention, String floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(spreadLeg1Monetary), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			fltg = toBuilder(FloatingRate13__1.builder()
				.setNm(nameOfTheFloatingRate)
				.setRate(FloatingRateIdentification8Choice__1.builder()
					.setCd(indicatorOfTheFloatingRate)
					.build())
				.setRefPrd(InterestRateContractTerm4__1.builder()
					.setUnit(MapperS.of(floatingRateReferencePeriodTimePeriod).checkedMap("to-enum", Frequency13Code__1::fromDisplayName, IllegalArgumentException.class).get())
					.setVal(floatingRateReferencePeriodMultiplier)
					.build())
				.setSprd(SecuritiesTransactionPrice20Choice__1.builder()
					.setMntryVal(AmountAndDirection106__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
							.setValue(abs.evaluate(spreadLeg1Monetary))
							.setCcy(MapperS.of(spreadCurrencyOfLeg1).map("to-string", Object::toString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setDcml(spreadLeg1Decimal)
					.setBsisPtSprd((spreadLeg1Basis == null ? null : spreadLeg1Basis.intValueExact()))
					.build())
				.setDayCnt(InterestComputationMethodFormat7__1.builder()
					.setCd(MapperS.of(floatingRateDayCountConvention).checkedMap("to-enum", InterestComputationMethod4Code::fromDisplayName, IllegalArgumentException.class).get())
					.build())
				.setPmtFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(MapperS.of(floatingRatePaymentFrequencyPeriod).checkedMap("to-enum", Frequency13Code__1::fromDisplayName, IllegalArgumentException.class).get())
						.setVal(floatingRatePaymentFrequencyPeriodMultiplier)
						.build())
					.build())
				.setRstFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(MapperS.of(floatingRateResetFrequencyPeriod).checkedMap("to-enum", Frequency13Code__1::fromDisplayName, IllegalArgumentException.class).get())
						.setVal(floatingRateResetFrequencyPeriodMultiplier)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(fltg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
