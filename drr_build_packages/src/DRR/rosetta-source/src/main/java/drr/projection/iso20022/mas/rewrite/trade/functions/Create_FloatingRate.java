package drr.projection.iso20022.mas.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import iso20022.auth030.mas.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.mas.AmountAndDirection106__1;
import iso20022.auth030.mas.FloatingRate13__1;
import iso20022.auth030.mas.Frequency13Code__1;
import iso20022.auth030.mas.InterestComputationMethod4Code;
import iso20022.auth030.mas.InterestComputationMethodFormat7__1;
import iso20022.auth030.mas.InterestRateContractTerm4__1;
import iso20022.auth030.mas.InterestRateFrequency3Choice__1;
import iso20022.auth030.mas.SecuritiesTransactionPrice20Choice__1;
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
	* @param spread 
	* @param spreadCurrency 
	* @param floatingRateDayCountConvention 
	* @param floatingRatePaymentFrequencyPeriod 
	* @param floatingRatePaymentFrequencyPeriodMultiplier 
	* @param nameOfTheFloatingRate 
	* @param floatingRateResetFrequencyPeriod 
	* @param floatingRateResetFrequencyPeriodMultiplier 
	* @return out 
	*/
	public FloatingRate13__1 evaluate(String identifierOfFloatingRate, PriceFormat spread, String spreadCurrency, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String nameOfTheFloatingRate, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
		FloatingRate13__1.FloatingRate13__1Builder outBuilder = doEvaluate(identifierOfFloatingRate, spread, spreadCurrency, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier, nameOfTheFloatingRate, floatingRateResetFrequencyPeriod, floatingRateResetFrequencyPeriodMultiplier);
		
		final FloatingRate13__1 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FloatingRate13__1.class, out);
		}
		
		return out;
	}

	protected abstract FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String identifierOfFloatingRate, PriceFormat spread, String spreadCurrency, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String nameOfTheFloatingRate, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier);

	public static class Create_FloatingRateDefault extends Create_FloatingRate {
		@Override
		protected FloatingRate13__1.FloatingRate13__1Builder doEvaluate(String identifierOfFloatingRate, PriceFormat spread, String spreadCurrency, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String nameOfTheFloatingRate, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
			FloatingRate13__1.FloatingRate13__1Builder out = FloatingRate13__1.builder();
			return assignOutput(out, identifierOfFloatingRate, spread, spreadCurrency, floatingRateDayCountConvention, floatingRatePaymentFrequencyPeriod, floatingRatePaymentFrequencyPeriodMultiplier, nameOfTheFloatingRate, floatingRateResetFrequencyPeriod, floatingRateResetFrequencyPeriodMultiplier);
		}
		
		protected FloatingRate13__1.FloatingRate13__1Builder assignOutput(FloatingRate13__1.FloatingRate13__1Builder out, String identifierOfFloatingRate, PriceFormat spread, String spreadCurrency, InterestComputationMethod4Code floatingRateDayCountConvention, Frequency13Code__1 floatingRatePaymentFrequencyPeriod, Integer floatingRatePaymentFrequencyPeriodMultiplier, String nameOfTheFloatingRate, String floatingRateResetFrequencyPeriod, Integer floatingRateResetFrequencyPeriodMultiplier) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(spread).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			final BigDecimal bigDecimal = MapperS.of(spread).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get();
			out = toBuilder(FloatingRate13__1.builder()
				.setSprd(SecuritiesTransactionPrice20Choice__1.builder()
					.setMntryVal(AmountAndDirection106__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(spread).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
							.setCcy(MapperS.of(spreadCurrency).map("to-string", Object::toString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setDcml(MapperS.of(spread).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
					.setBsisPtSprd((bigDecimal == null ? null : bigDecimal.intValueExact()))
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
				.setNm(nameOfTheFloatingRate)
				.setRstFrqcy(InterestRateFrequency3Choice__1.builder()
					.setTerm(InterestRateContractTerm4__1.builder()
						.setUnit(MapperS.of(floatingRateResetFrequencyPeriod).checkedMap("to-enum", Frequency13Code__1::fromDisplayName, IllegalArgumentException.class).get())
						.setVal(floatingRateResetFrequencyPeriodMultiplier)
						.build())
					.build())
				.setId(identifierOfFloatingRate)
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
