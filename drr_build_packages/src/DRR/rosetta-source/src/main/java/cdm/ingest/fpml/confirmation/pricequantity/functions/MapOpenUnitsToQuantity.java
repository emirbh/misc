package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapOpenUnitsToQuantity.MapOpenUnitsToQuantityDefault.class)
public abstract class MapOpenUnitsToQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlOpenUnits 
	* @param fpmlFinancialUnit 
	* @param fpmlCurrency 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(BigDecimal fpmlOpenUnits, FinancialUnitEnum fpmlFinancialUnit, Currency fpmlCurrency) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlOpenUnits, fpmlFinancialUnit, fpmlCurrency);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlOpenUnits, FinancialUnitEnum fpmlFinancialUnit, Currency fpmlCurrency);

	public static class MapOpenUnitsToQuantityDefault extends MapOpenUnitsToQuantity {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(BigDecimal fpmlOpenUnits, FinancialUnitEnum fpmlFinancialUnit, Currency fpmlCurrency) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlOpenUnits, fpmlFinancialUnit, fpmlCurrency);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, BigDecimal fpmlOpenUnits, FinancialUnitEnum fpmlFinancialUnit, Currency fpmlCurrency) {
			if (exists(MapperS.of(fpmlOpenUnits)).getOrDefault(false)) {
				nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
					.setValue(fpmlOpenUnits)
					.setUnit(UnitType.builder()
						.setFinancialUnit(fpmlFinancialUnit)
						.build())
					.build());
			} else {
				nonNegativeQuantitySchedule = null;
			}
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
