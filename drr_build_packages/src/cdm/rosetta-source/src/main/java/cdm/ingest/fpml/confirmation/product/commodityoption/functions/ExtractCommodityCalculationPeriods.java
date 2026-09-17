package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(ExtractCommodityCalculationPeriods.ExtractCommodityCalculationPeriodsDefault.class)
public abstract class ExtractCommodityCalculationPeriods implements RosettaFunction {

	/**
	* @param fpmlCommodityCalculationPeriods 
	* @return commodityCalculationPeriods 
	*/
	public List<Date> evaluate(AdjustableDates fpmlCommodityCalculationPeriods) {
		List<Date> commodityCalculationPeriods = doEvaluate(fpmlCommodityCalculationPeriods);
		
		return commodityCalculationPeriods;
	}

	protected abstract List<Date> doEvaluate(AdjustableDates fpmlCommodityCalculationPeriods);

	public static class ExtractCommodityCalculationPeriodsDefault extends ExtractCommodityCalculationPeriods {
		@Override
		protected List<Date> doEvaluate(AdjustableDates fpmlCommodityCalculationPeriods) {
			List<Date> commodityCalculationPeriods = new ArrayList<>();
			return assignOutput(commodityCalculationPeriods, fpmlCommodityCalculationPeriods);
		}
		
		protected List<Date> assignOutput(List<Date> commodityCalculationPeriods, AdjustableDates fpmlCommodityCalculationPeriods) {
			commodityCalculationPeriods = MapperS.of(fpmlCommodityCalculationPeriods).<IdentifiedDate>mapC("getUnadjustedDate", adjustableDates -> adjustableDates.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).getMulti();
			
			return commodityCalculationPeriods;
		}
	}
}
