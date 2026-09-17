package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.math.DatedValue;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityOptionStrikePriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityStrikeSchedule;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityOptionToStrikePriceDatedValues.MapCommodityOptionToStrikePriceDatedValuesDefault.class)
public abstract class MapCommodityOptionToStrikePriceDatedValues implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculateCommodityCalculationPeriods calculateCommodityCalculationPeriods;
	@Inject protected CollectAllCalculationPeriods collectAllCalculationPeriods;
	@Inject protected CollectAllCalculationPeriodsSchedules collectAllCalculationPeriodsSchedules;
	@Inject protected ExtractCommodityCalculationPeriods extractCommodityCalculationPeriods;
	@Inject protected ExtractCommodityCalculationPeriodsFromHref extractCommodityCalculationPeriodsFromHref;
	@Inject protected ExtractCommodityCalculationPeriodsScheduleFromHref extractCommodityCalculationPeriodsScheduleFromHref;
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapCommodityOptionStrikePriceSchedule mapCommodityOptionStrikePriceSchedule;

	/**
	* @param fpmlCommodityOption 
	* @return strikePriceSchedule 
	*/
	public List<? extends DatedValue> evaluate(CommodityOption fpmlCommodityOption) {
		List<DatedValue.DatedValueBuilder> strikePriceScheduleBuilder = doEvaluate(fpmlCommodityOption);
		
		final List<? extends DatedValue> strikePriceSchedule;
		if (strikePriceScheduleBuilder == null) {
			strikePriceSchedule = null;
		} else {
			strikePriceSchedule = strikePriceScheduleBuilder.stream().map(DatedValue::build).collect(Collectors.toList());
			objectValidator.validate(DatedValue.class, strikePriceSchedule);
		}
		
		return strikePriceSchedule;
	}

	protected abstract List<DatedValue.DatedValueBuilder> doEvaluate(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<? extends CommodityStrikeSchedule> fpmlStrikePriceSchedule(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<? extends CommodityCalculationPeriodsSchedule> fpmlCalculationPeriodsSchedule(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<? extends AdjustableDates> fpmlCalculationPeriods(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<Date> effectiveDate(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<Date> terminationDate(CommodityOption fpmlCommodityOption);

	protected abstract MapperC<Date> fpmlCommodityStrikePriceDates(CommodityOption fpmlCommodityOption);

	public static class MapCommodityOptionToStrikePriceDatedValuesDefault extends MapCommodityOptionToStrikePriceDatedValues {
		@Override
		protected List<DatedValue.DatedValueBuilder> doEvaluate(CommodityOption fpmlCommodityOption) {
			List<DatedValue.DatedValueBuilder> strikePriceSchedule = new ArrayList<>();
			return assignOutput(strikePriceSchedule, fpmlCommodityOption);
		}
		
		protected List<DatedValue.DatedValueBuilder> assignOutput(List<DatedValue.DatedValueBuilder> strikePriceSchedule, CommodityOption fpmlCommodityOption) {
			strikePriceSchedule.addAll(toBuilder(mapCommodityOptionStrikePriceSchedule.evaluate(MapperS.of(fpmlCommodityOption).<CommodityStrikeSchedule>map("getStrikePricePerUnitSchedule", commodityOption -> commodityOption.getStrikePricePerUnitSchedule()).<NonNegativeMoney>mapC("getStrikePricePerUnitStep", commodityStrikeSchedule -> commodityStrikeSchedule.getStrikePricePerUnitStep()).getMulti(), fpmlCommodityStrikePriceDates(fpmlCommodityOption).getMulti())));
			
			return Optional.ofNullable(strikePriceSchedule)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CommodityStrikeSchedule> fpmlStrikePriceSchedule(CommodityOption fpmlCommodityOption) {
			return MapperS.of(fpmlCommodityOption).<CommodityStrikeSchedule>map("getStrikePricePerUnitSchedule", commodityOption -> commodityOption.getStrikePricePerUnitSchedule());
		}
		
		@Override
		protected MapperS<? extends CommodityCalculationPeriodsSchedule> fpmlCalculationPeriodsSchedule(CommodityOption fpmlCommodityOption) {
			return MapperS.of(extractCommodityCalculationPeriodsScheduleFromHref.evaluate(collectAllCalculationPeriodsSchedules.evaluate(fpmlCommodityOption), MapperS.of(fpmlCommodityOption).<CommodityStrikeSchedule>map("getStrikePricePerUnitSchedule", commodityOption -> commodityOption.getStrikePricePerUnitSchedule()).<CalculationPeriodsScheduleReference>map("getCalculationPeriodsScheduleReference", commodityStrikeSchedule -> commodityStrikeSchedule.getCalculationPeriodsScheduleReference()).<String>map("getHref", calculationPeriodsScheduleReference -> calculationPeriodsScheduleReference.getHref()).get()));
		}
		
		@Override
		protected MapperS<? extends AdjustableDates> fpmlCalculationPeriods(CommodityOption fpmlCommodityOption) {
			return MapperS.of(extractCommodityCalculationPeriodsFromHref.evaluate(collectAllCalculationPeriods.evaluate(fpmlCommodityOption), MapperS.of(fpmlCommodityOption).<CommodityStrikeSchedule>map("getStrikePricePerUnitSchedule", commodityOption -> commodityOption.getStrikePricePerUnitSchedule()).<CalculationPeriodsReference>map("getCalculationPeriodsReference", commodityStrikeSchedule -> commodityStrikeSchedule.getCalculationPeriodsReference()).<String>map("getHref", calculationPeriodsReference -> calculationPeriodsReference.getHref()).get()));
		}
		
		@Override
		protected MapperS<Date> effectiveDate(CommodityOption fpmlCommodityOption) {
			return MapperS.of(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCommodityOption).<AdjustableOrRelativeDate>map("getEffectiveDate", commodityOption -> commodityOption.getEffectiveDate()).get())).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate());
		}
		
		@Override
		protected MapperS<Date> terminationDate(CommodityOption fpmlCommodityOption) {
			return MapperS.of(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCommodityOption).<AdjustableOrRelativeDate>map("getTerminationDate", commodityOption -> commodityOption.getTerminationDate()).get())).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate());
		}
		
		@Override
		protected MapperC<Date> fpmlCommodityStrikePriceDates(CommodityOption fpmlCommodityOption) {
			if (exists(fpmlCalculationPeriods(fpmlCommodityOption)).getOrDefault(false)) {
				return MapperC.<Date>of(extractCommodityCalculationPeriods.evaluate(fpmlCalculationPeriods(fpmlCommodityOption).get()));
			}
			if (exists(fpmlCalculationPeriodsSchedule(fpmlCommodityOption)).getOrDefault(false)) {
				return MapperC.<Date>of(calculateCommodityCalculationPeriods.evaluate(fpmlCalculationPeriodsSchedule(fpmlCommodityOption).get(), effectiveDate(fpmlCommodityOption).get(), terminationDate(fpmlCommodityOption).get()));
			}
			return MapperC.<Date>ofNull();
		}
	}
}
