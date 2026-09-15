package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractCommodityCalculationPeriodsScheduleFromHref.ExtractCommodityCalculationPeriodsScheduleFromHrefDefault.class)
public abstract class ExtractCommodityCalculationPeriodsScheduleFromHref implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityCalculationPeriodsScheduleList 
	* @param href 
	* @return fpmlCommodityCalculationPeriodsSchedule 
	*/
	public CommodityCalculationPeriodsSchedule evaluate(List<? extends CommodityCalculationPeriodsSchedule> fpmlCommodityCalculationPeriodsScheduleList, String href) {
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder fpmlCommodityCalculationPeriodsScheduleBuilder = doEvaluate(fpmlCommodityCalculationPeriodsScheduleList, href);
		
		final CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule;
		if (fpmlCommodityCalculationPeriodsScheduleBuilder == null) {
			fpmlCommodityCalculationPeriodsSchedule = null;
		} else {
			fpmlCommodityCalculationPeriodsSchedule = fpmlCommodityCalculationPeriodsScheduleBuilder.build();
			objectValidator.validate(CommodityCalculationPeriodsSchedule.class, fpmlCommodityCalculationPeriodsSchedule);
		}
		
		return fpmlCommodityCalculationPeriodsSchedule;
	}

	protected abstract CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder doEvaluate(List<? extends CommodityCalculationPeriodsSchedule> fpmlCommodityCalculationPeriodsScheduleList, String href);

	public static class ExtractCommodityCalculationPeriodsScheduleFromHrefDefault extends ExtractCommodityCalculationPeriodsScheduleFromHref {
		@Override
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder doEvaluate(List<? extends CommodityCalculationPeriodsSchedule> fpmlCommodityCalculationPeriodsScheduleList, String href) {
			if (fpmlCommodityCalculationPeriodsScheduleList == null) {
				fpmlCommodityCalculationPeriodsScheduleList = Collections.emptyList();
			}
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder fpmlCommodityCalculationPeriodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			return assignOutput(fpmlCommodityCalculationPeriodsSchedule, fpmlCommodityCalculationPeriodsScheduleList, href);
		}
		
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder assignOutput(CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder fpmlCommodityCalculationPeriodsSchedule, List<? extends CommodityCalculationPeriodsSchedule> fpmlCommodityCalculationPeriodsScheduleList, String href) {
			final MapperC<CommodityCalculationPeriodsSchedule> thenArg = MapperC.<CommodityCalculationPeriodsSchedule>of(fpmlCommodityCalculationPeriodsScheduleList)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getId", commodityCalculationPeriodsSchedule -> commodityCalculationPeriodsSchedule.getId()), MapperS.of(href), CardinalityOperator.All).get());
			fpmlCommodityCalculationPeriodsSchedule = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(fpmlCommodityCalculationPeriodsSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
