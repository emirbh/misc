package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(CalculateCommodityCalculationPeriods.CalculateCommodityCalculationPeriodsDefault.class)
public abstract class CalculateCommodityCalculationPeriods implements RosettaFunction {

	/**
	* @param fpmlCommodityCalculationPeriodsSchedule 
	* @param effectiveDate 
	* @param terminationDate 
	* @return commodityCalculationPeriods 
	*/
	public List<Date> evaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule, Date effectiveDate, Date terminationDate) {
		List<Date> commodityCalculationPeriods = doEvaluate(fpmlCommodityCalculationPeriodsSchedule, effectiveDate, terminationDate);
		
		return commodityCalculationPeriods;
	}

	protected abstract List<Date> doEvaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule, Date effectiveDate, Date terminationDate);

	public static class CalculateCommodityCalculationPeriodsDefault extends CalculateCommodityCalculationPeriods {
		@Override
		protected List<Date> doEvaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule, Date effectiveDate, Date terminationDate) {
			List<Date> commodityCalculationPeriods = new ArrayList<>();
			return assignOutput(commodityCalculationPeriods, fpmlCommodityCalculationPeriodsSchedule, effectiveDate, terminationDate);
		}
		
		protected List<Date> assignOutput(List<Date> commodityCalculationPeriods, CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule, Date effectiveDate, Date terminationDate) {
			return commodityCalculationPeriods;
		}
	}
}
