package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PricePeriod;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.price.functions.GetReportablePricePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(PriceScheduleRule.PriceScheduleRuleDefault.class)
public abstract class PriceScheduleRule implements ReportFunction<TransactionReportInstruction, List<? extends PricePeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetReportablePricePeriod getReportablePricePeriod;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends PricePeriod> evaluate(TransactionReportInstruction input) {
		List<PricePeriod.PricePeriodBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends PricePeriod> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(PricePeriod::build).collect(Collectors.toList());
			objectValidator.validate(PricePeriod.class, output);
		}
		
		return output;
	}

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstruction input);

	public static class PriceScheduleRuleDefault extends PriceScheduleRule {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstruction input) {
			List<PricePeriod.PricePeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToList(item -> MapperC.<PricePeriod>of(getReportablePricePeriod.evaluate(item.get(), DefaultingType.DEFAULT_PERCENTAGETO_DECIMAL))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
