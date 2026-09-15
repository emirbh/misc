package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableDates;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractCommodityCalculationPeriodsFromHref.ExtractCommodityCalculationPeriodsFromHrefDefault.class)
public abstract class ExtractCommodityCalculationPeriodsFromHref implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityCalculationPeriodList 
	* @param href 
	* @return fpmlCommodityCalculationPeriods 
	*/
	public AdjustableDates evaluate(List<? extends AdjustableDates> fpmlCommodityCalculationPeriodList, String href) {
		AdjustableDates.AdjustableDatesBuilder fpmlCommodityCalculationPeriodsBuilder = doEvaluate(fpmlCommodityCalculationPeriodList, href);
		
		final AdjustableDates fpmlCommodityCalculationPeriods;
		if (fpmlCommodityCalculationPeriodsBuilder == null) {
			fpmlCommodityCalculationPeriods = null;
		} else {
			fpmlCommodityCalculationPeriods = fpmlCommodityCalculationPeriodsBuilder.build();
			objectValidator.validate(AdjustableDates.class, fpmlCommodityCalculationPeriods);
		}
		
		return fpmlCommodityCalculationPeriods;
	}

	protected abstract AdjustableDates.AdjustableDatesBuilder doEvaluate(List<? extends AdjustableDates> fpmlCommodityCalculationPeriodList, String href);

	public static class ExtractCommodityCalculationPeriodsFromHrefDefault extends ExtractCommodityCalculationPeriodsFromHref {
		@Override
		protected AdjustableDates.AdjustableDatesBuilder doEvaluate(List<? extends AdjustableDates> fpmlCommodityCalculationPeriodList, String href) {
			if (fpmlCommodityCalculationPeriodList == null) {
				fpmlCommodityCalculationPeriodList = Collections.emptyList();
			}
			AdjustableDates.AdjustableDatesBuilder fpmlCommodityCalculationPeriods = AdjustableDates.builder();
			return assignOutput(fpmlCommodityCalculationPeriods, fpmlCommodityCalculationPeriodList, href);
		}
		
		protected AdjustableDates.AdjustableDatesBuilder assignOutput(AdjustableDates.AdjustableDatesBuilder fpmlCommodityCalculationPeriods, List<? extends AdjustableDates> fpmlCommodityCalculationPeriodList, String href) {
			final MapperC<AdjustableDates> thenArg = MapperC.<AdjustableDates>of(fpmlCommodityCalculationPeriodList)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getId", adjustableDates -> adjustableDates.getId()), MapperS.of(href), CardinalityOperator.All).get());
			fpmlCommodityCalculationPeriods = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(fpmlCommodityCalculationPeriods)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
