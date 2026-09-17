package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapInterestRatePriceSchedule.MapInterestRatePriceScheduleDefault.class)
public abstract class MapInterestRatePriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapScheduleToDatedValueList mapScheduleToDatedValueList;

	/**
	* @param fpmlRate 
	* @param fpmlStepList 
	* @param fpmlCurrency 
	* @param arithmeticOperator 
	* @return priceSchedule 
	*/
	public PriceSchedule evaluate(BigDecimal fpmlRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
		PriceSchedule.PriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlRate, fpmlStepList, fpmlCurrency, arithmeticOperator);
		
		final PriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(PriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(BigDecimal fpmlRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator);

	protected abstract MapperS<? extends UnitType> priceUnits(BigDecimal fpmlRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator);

	public static class MapInterestRatePriceScheduleDefault extends MapInterestRatePriceSchedule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(BigDecimal fpmlRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
			if (fpmlStepList == null) {
				fpmlStepList = Collections.emptyList();
			}
			PriceSchedule.PriceScheduleBuilder priceSchedule = PriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlRate, fpmlStepList, fpmlCurrency, arithmeticOperator);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder priceSchedule, BigDecimal fpmlRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
			if (exists(MapperS.of(fpmlRate)).getOrDefault(false)) {
				priceSchedule = toBuilder(PriceSchedule.builder()
					.setValue(fpmlRate)
					.setDatedValue(new ArrayList(mapScheduleToDatedValueList.evaluate(fpmlStepList)))
					.setUnit(priceUnits(fpmlRate, fpmlStepList, fpmlCurrency, arithmeticOperator).get())
					.setPerUnitOf(priceUnits(fpmlRate, fpmlStepList, fpmlCurrency, arithmeticOperator).get())
					.setArithmeticOperator(arithmeticOperator)
					.setPriceType(PriceTypeEnum.INTEREST_RATE)
					.build());
			} else {
				priceSchedule = null;
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> priceUnits(BigDecimal fpmlRate, List<? extends Step> fpmlStepList, Currency fpmlCurrency, ArithmeticOperationEnum arithmeticOperator) {
			return MapperS.of(UnitType.builder()
				.setCurrency(mapCurrency.evaluate(fpmlCurrency))
				.build());
		}
	}
}
