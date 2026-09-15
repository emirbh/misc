package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.quantity.reports.NotionalQuantityScheduleRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(NotionalQuantityScheduleLeg2Rule.NotionalQuantityScheduleLeg2RuleDefault.class)
public abstract class NotionalQuantityScheduleLeg2Rule implements ReportFunction<TransactionReportInstruction, List<? extends NotionalPeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected NotionalQuantityScheduleRule notionalQuantityScheduleRule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends NotionalPeriod> evaluate(TransactionReportInstruction input) {
		List<NotionalPeriod.NotionalPeriodBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends NotionalPeriod> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(NotionalPeriod::build).collect(Collectors.toList());
			objectValidator.validate(NotionalPeriod.class, output);
		}
		
		return output;
	}

	protected abstract List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(TransactionReportInstruction input);

	public static class NotionalQuantityScheduleLeg2RuleDefault extends NotionalQuantityScheduleLeg2Rule {
		@Override
		protected List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(TransactionReportInstruction input) {
			List<NotionalPeriod.NotionalPeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<NotionalPeriod.NotionalPeriodBuilder> assignOutput(List<NotionalPeriod.NotionalPeriodBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			output = toBuilder(MapperC.<NotionalPeriod>of(notionalQuantityScheduleRule.evaluate(payoutLeg2Rule.evaluate(thenArg.get()))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
