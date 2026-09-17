package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustedDateToAdjustableOrRelativeDate;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.RequiredIdentifierDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraCalculationPeriodDates.MapFraCalculationPeriodDatesDefault.class)
public abstract class MapFraCalculationPeriodDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustedDateToAdjustableOrRelativeDate mapAdjustedDateToAdjustableOrRelativeDate;

	/**
	* @param fpmlFra 
	* @return calculationPeriodDates 
	*/
	public CalculationPeriodDates evaluate(Fra fpmlFra) {
		CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDatesBuilder = doEvaluate(fpmlFra);
		
		final CalculationPeriodDates calculationPeriodDates;
		if (calculationPeriodDatesBuilder == null) {
			calculationPeriodDates = null;
		} else {
			calculationPeriodDates = calculationPeriodDatesBuilder.build();
			objectValidator.validate(CalculationPeriodDates.class, calculationPeriodDates);
		}
		
		return calculationPeriodDates;
	}

	protected abstract CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(Fra fpmlFra);

	public static class MapFraCalculationPeriodDatesDefault extends MapFraCalculationPeriodDates {
		@Override
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(Fra fpmlFra) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates = CalculationPeriodDates.builder();
			return assignOutput(calculationPeriodDates, fpmlFra);
		}
		
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder assignOutput(CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates, Fra fpmlFra) {
			calculationPeriodDates = toBuilder(CalculationPeriodDates.builder()
				.setEffectiveDate(mapAdjustedDateToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFra).<RequiredIdentifierDate>map("getAdjustedEffectiveDate", fra -> fra.getAdjustedEffectiveDate()).<ZonedDateTime>map("getValue", requiredIdentifierDate -> requiredIdentifierDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(fpmlFra).<RequiredIdentifierDate>map("getAdjustedEffectiveDate", fra -> fra.getAdjustedEffectiveDate()).<String>map("getId", requiredIdentifierDate -> requiredIdentifierDate.getId()).get()))
				.setTerminationDate(mapAdjustedDateToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFra).<ZonedDateTime>map("getAdjustedTerminationDate", fra -> fra.getAdjustedTerminationDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), null))
				.build());
			
			return Optional.ofNullable(calculationPeriodDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
