package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(CollectAllCalculationPeriodsSchedules.CollectAllCalculationPeriodsSchedulesDefault.class)
public abstract class CollectAllCalculationPeriodsSchedules implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityOption 
	* @return fpmlCommodityCalculationPeriodsScheduleList 
	*/
	public List<? extends CommodityCalculationPeriodsSchedule> evaluate(CommodityOption fpmlCommodityOption) {
		List<CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder> fpmlCommodityCalculationPeriodsScheduleListBuilder = doEvaluate(fpmlCommodityOption);
		
		final List<? extends CommodityCalculationPeriodsSchedule> fpmlCommodityCalculationPeriodsScheduleList;
		if (fpmlCommodityCalculationPeriodsScheduleListBuilder == null) {
			fpmlCommodityCalculationPeriodsScheduleList = null;
		} else {
			fpmlCommodityCalculationPeriodsScheduleList = fpmlCommodityCalculationPeriodsScheduleListBuilder.stream().map(CommodityCalculationPeriodsSchedule::build).collect(Collectors.toList());
			objectValidator.validate(CommodityCalculationPeriodsSchedule.class, fpmlCommodityCalculationPeriodsScheduleList);
		}
		
		return fpmlCommodityCalculationPeriodsScheduleList;
	}

	protected abstract List<CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder> doEvaluate(CommodityOption fpmlCommodityOption);

	public static class CollectAllCalculationPeriodsSchedulesDefault extends CollectAllCalculationPeriodsSchedules {
		@Override
		protected List<CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder> doEvaluate(CommodityOption fpmlCommodityOption) {
			List<CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder> fpmlCommodityCalculationPeriodsScheduleList = new ArrayList<>();
			return assignOutput(fpmlCommodityCalculationPeriodsScheduleList, fpmlCommodityOption);
		}
		
		protected List<CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder> assignOutput(List<CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder> fpmlCommodityCalculationPeriodsScheduleList, CommodityOption fpmlCommodityOption) {
			fpmlCommodityCalculationPeriodsScheduleList.addAll(toBuilder(MapperS.of(fpmlCommodityOption).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", commodityOption -> commodityOption.getCalculationPeriodsSchedule()).getMulti()));
			
			fpmlCommodityCalculationPeriodsScheduleList.addAll(toBuilder(MapperS.of(fpmlCommodityOption).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", commodityOption -> commodityOption.getCalculationPeriodsSchedule()).getMulti()));
			
			fpmlCommodityCalculationPeriodsScheduleList.addAll(toBuilder(MapperS.of(fpmlCommodityOption).<CommodityCalculationPeriodsSchedule>map("getFloatingStrikePricePerUnitSchedule", commodityOption -> commodityOption.getFloatingStrikePricePerUnitSchedule()).getMulti()));
			
			return Optional.ofNullable(fpmlCommodityCalculationPeriodsScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
