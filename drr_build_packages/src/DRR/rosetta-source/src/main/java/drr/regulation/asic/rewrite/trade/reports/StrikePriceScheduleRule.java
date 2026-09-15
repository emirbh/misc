package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PricePeriod;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.price.functions.GetReportableStrikePricePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(StrikePriceScheduleRule.StrikePriceScheduleRuleDefault.class)
public abstract class StrikePriceScheduleRule implements ReportFunction<TransactionReportInstruction, List<? extends PricePeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetReportableStrikePricePeriod getReportableStrikePricePeriod;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;

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

	public static class StrikePriceScheduleRuleDefault extends StrikePriceScheduleRule {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstruction input) {
			List<PricePeriod.PricePeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToList(item -> MapperC.<PricePeriod>of(getReportableStrikePricePeriod.evaluate(item.get(), DefaultingType.DEFAULT_PERCENTAGETO_DECIMAL))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
