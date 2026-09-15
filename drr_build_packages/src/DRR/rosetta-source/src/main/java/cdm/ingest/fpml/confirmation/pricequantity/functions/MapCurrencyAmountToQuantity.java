package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.ingest.fpml.confirmation.common.functions.MapCurrency;
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

@ImplementedBy(MapCurrencyAmountToQuantity.MapCurrencyAmountToQuantityDefault.class)
public abstract class MapCurrencyAmountToQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrency mapCurrency;
	@Inject protected MapScheduleToDatedValueList mapScheduleToDatedValueList;

	/**
	* @param fpmlNotionalAmount 
	* @param fpmlStepList 
	* @param fpmlCurrency 
	* @param fpmlFinancialUnit 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, FinancialUnitEnum fpmlFinancialUnit) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlNotionalAmount, fpmlStepList, fpmlCurrency, fpmlFinancialUnit);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, FinancialUnitEnum fpmlFinancialUnit);

	protected abstract MapperS<? extends UnitType> mappedUnit(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, FinancialUnitEnum fpmlFinancialUnit);

	public static class MapCurrencyAmountToQuantityDefault extends MapCurrencyAmountToQuantity {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, FinancialUnitEnum fpmlFinancialUnit) {
			if (fpmlStepList == null) {
				fpmlStepList = Collections.emptyList();
			}
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlNotionalAmount, fpmlStepList, fpmlCurrency, fpmlFinancialUnit);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, FinancialUnitEnum fpmlFinancialUnit) {
			if (exists(MapperS.of(fpmlNotionalAmount)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
					.setValue(fpmlNotionalAmount)
					.setDatedValue(new ArrayList(mapScheduleToDatedValueList.evaluate(fpmlStepList)))
					.setUnit(mappedUnit(fpmlNotionalAmount, fpmlStepList, fpmlCurrency, fpmlFinancialUnit).get())
					.build());
			} else {
				nonNegativeQuantitySchedule = null;
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends UnitType> mappedUnit(BigDecimal fpmlNotionalAmount, List<? extends Step> fpmlStepList, Currency fpmlCurrency, FinancialUnitEnum fpmlFinancialUnit) {
			if (exists(MapperS.of(fpmlCurrency)).getOrDefault(false)) {
				return MapperS.of(UnitType.builder()
					.setCurrency(mapCurrency.evaluate(fpmlCurrency))
					.build());
			}
			if (exists(MapperS.of(fpmlFinancialUnit)).getOrDefault(false)) {
				return MapperS.of(UnitType.builder()
					.setFinancialUnit(fpmlFinancialUnit)
					.build());
			}
			return MapperS.<UnitType>ofNull();
		}
	}
}
