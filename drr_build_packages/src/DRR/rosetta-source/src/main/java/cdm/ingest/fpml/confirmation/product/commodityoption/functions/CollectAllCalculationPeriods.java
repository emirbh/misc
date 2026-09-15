package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.shared.AdjustableDates;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(CollectAllCalculationPeriods.CollectAllCalculationPeriodsDefault.class)
public abstract class CollectAllCalculationPeriods implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityOption 
	* @return fpmlCommodityCalculationPeriods 
	*/
	public List<? extends AdjustableDates> evaluate(CommodityOption fpmlCommodityOption) {
		List<AdjustableDates.AdjustableDatesBuilder> fpmlCommodityCalculationPeriodsBuilder = doEvaluate(fpmlCommodityOption);
		
		final List<? extends AdjustableDates> fpmlCommodityCalculationPeriods;
		if (fpmlCommodityCalculationPeriodsBuilder == null) {
			fpmlCommodityCalculationPeriods = null;
		} else {
			fpmlCommodityCalculationPeriods = fpmlCommodityCalculationPeriodsBuilder.stream().map(AdjustableDates::build).collect(Collectors.toList());
			objectValidator.validate(AdjustableDates.class, fpmlCommodityCalculationPeriods);
		}
		
		return fpmlCommodityCalculationPeriods;
	}

	protected abstract List<AdjustableDates.AdjustableDatesBuilder> doEvaluate(CommodityOption fpmlCommodityOption);

	public static class CollectAllCalculationPeriodsDefault extends CollectAllCalculationPeriods {
		@Override
		protected List<AdjustableDates.AdjustableDatesBuilder> doEvaluate(CommodityOption fpmlCommodityOption) {
			List<AdjustableDates.AdjustableDatesBuilder> fpmlCommodityCalculationPeriods = new ArrayList<>();
			return assignOutput(fpmlCommodityCalculationPeriods, fpmlCommodityOption);
		}
		
		protected List<AdjustableDates.AdjustableDatesBuilder> assignOutput(List<AdjustableDates.AdjustableDatesBuilder> fpmlCommodityCalculationPeriods, CommodityOption fpmlCommodityOption) {
			fpmlCommodityCalculationPeriods.addAll(toBuilder(MapperS.of(fpmlCommodityOption).<AdjustableDates>map("getCalculationPeriods", commodityOption -> commodityOption.getCalculationPeriods()).getMulti()));
			
			fpmlCommodityCalculationPeriods.addAll(toBuilder(MapperS.of(fpmlCommodityOption).<AdjustableDates>map("getCalculationPeriods", commodityOption -> commodityOption.getCalculationPeriods()).getMulti()));
			
			return Optional.ofNullable(fpmlCommodityCalculationPeriods)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
