package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapScheduleToInterestRatePriceSchedule.MapScheduleToInterestRatePriceScheduleDefault.class)
public abstract class MapScheduleToInterestRatePriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInterestRatePriceSchedule mapInterestRatePriceSchedule;

	/**
	* @param fpmlSchedule 
	* @param fpmlCurrency 
	* @param arithmeticOperator 
	* @return priceSchedule 
	*/
	public PriceSchedule evaluate(Schedule fpmlSchedule, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
		PriceSchedule.PriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlSchedule, fpmlCurrency, arithmeticOperator);
		
		final PriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(PriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(Schedule fpmlSchedule, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator);

	public static class MapScheduleToInterestRatePriceScheduleDefault extends MapScheduleToInterestRatePriceSchedule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(Schedule fpmlSchedule, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
			PriceSchedule.PriceScheduleBuilder priceSchedule = PriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlSchedule, fpmlCurrency, arithmeticOperator);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder priceSchedule, Schedule fpmlSchedule, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
			priceSchedule = toBuilder(mapInterestRatePriceSchedule.evaluate(MapperS.of(fpmlSchedule).<BigDecimal>map("getInitialValue", schedule -> schedule.getInitialValue()).get(), MapperS.of(fpmlSchedule).<Step>mapC("getStep", schedule -> schedule.getStep()).getMulti(), fpmlCurrency, arithmeticOperator));
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
