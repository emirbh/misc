package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.IndexEnum;
import iso20022.auth030.hkma.tr.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.hkma.tr.AmountAndDirection106__1;
import iso20022.auth030.hkma.tr.FloatingRate13__1;
import iso20022.auth030.hkma.tr.FloatingRateIdentification8Choice__1;
import iso20022.auth030.hkma.tr.Frequency13Code__1;
import iso20022.auth030.hkma.tr.InterestComputationMethod4Code;
import iso20022.auth030.hkma.tr.InterestComputationMethodFormat7__1;
import iso20022.auth030.hkma.tr.InterestRateContractTerm4__1;
import iso20022.auth030.hkma.tr.InterestRateFrequency3Choice__1;
import iso20022.auth030.hkma.tr.SecuritiesTransactionPrice20Choice__1;
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
	* @param spreadOfLeg1Monetary 
	* @param spreadOfLeg1Decimal 
	* @param spreadOfLeg1Basis 
	* @param spreadCurrencyOfLeg1 
	* @param floatingRateDayCountConvention 
	* @param floatingRatePaymentFrequencyPeriod 
	* @param floatingRatePaymentFrequencyPeriodMultiplier 
	* @return out 
	*/
	public FloatingRate13__1 evaluate(String identifierOfFloatingRate, String nameOfTheFloatingRate, IndexEnum indicatorOfTheFloatingRate, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Decimal, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier) {
		FloatingRate13__1.FloatingRate13__1Builder outBuilder = doEvaluate(identifierOfFloatingRate, nameOfTheFloatingRate, indicatorOfTheFloatingRate, spreadOfLeg1Monetary, spreadOfLeg1Decimal, spreadOfLeg1Basis, spreadCurrencyOfLeg1, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier);
		
		final FloatingRate13__1 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FloatingRate13__1.class, out);
		}
		
		return out;
	}

	protected abstract FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String identifierOfFloatingRate, String nameOfTheFloatingRate, IndexEnum indicatorOfTheFloatingRate, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Decimal, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier);

	public static class Create_FloatingRateDefault extends Create_FloatingRate {
		@Override
		protected FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String identifierOfFloatingRate, String nameOfTheFloatingRate, IndexEnum indicatorOfTheFloatingRate, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Decimal, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier) {
			FloatingRate13__1.FloatingRate13__1Builder out = FloatingRate13__1.builder();
			return assignOutput(out, identifierOfFloatingRate, nameOfTheFloatingRate, indicatorOfTheFloatingRate, spreadOfLeg1Monetary, spreadOfLeg1Decimal, spreadOfLeg1Basis, spreadCurrencyOfLeg1, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier);
		}
		
		protected FloatingRate13__1.FloatingRate13__1Builder assignOutput(FloatingRate13__1.FloatingRate13__1Builder out, String identifierOfFloatingRate, String nameOfTheFloatingRate, IndexEnum indicatorOfTheFloatingRate, BigDecimal spreadOfLeg1Monetary, BigDecimal spreadOfLeg1Decimal, BigDecimal spreadOfLeg1Basis, String spreadCurrencyOfLeg1, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(spreadOfLeg1Monetary), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			out = toBuilder(FloatingRate13__1.builder()
				.setSprd(SecuritiesTransactionPrice20Choice__1.builder()
					.setMntryVal(AmountAndDirection106__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
							.setValue(abs.evaluate(spreadOfLeg1Monetary))
							.setCcy(MapperS.of(spreadCurrencyOfLeg1).map("to-string", Object::toString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setDcml(spreadOfLeg1Decimal)
					.setBsisPtSprd((spreadOfLeg1Basis == null ? null : spreadOfLeg1Basis.intValueExact()))
					.build())
				.setDayCnt(InterestComputationMethodFormat7__1.builder()
					.setCd(floatingRateDayCountConvention)
					.build())
				.setPmtFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(floatingRatePaymentFrequencyPeriod)
						.setVal(floatingRatePaymentFrequencyPeriodMultiplier)
						.build())
					.build())
				.setId(identifierOfFloatingRate)
				.setNm(nameOfTheFloatingRate)
				.setRate(FloatingRateIdentification8Choice__1.builder()
					.setCd(MapperS.of(indicatorOfTheFloatingRate).map("to-string", IndexEnum::toDisplayString).get())
					.build())
				.setRefPrd(InterestRateContractTerm4__1.builder()
					.setUnit(MapperS.of(floatingRatePaymentFrequencyPeriod).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
					.setVal(floatingRatePaymentFrequencyPeriodMultiplier)
					.build())
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
