package drr.standards.iosco.cde.version1.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PricePeriod;
import drr.standards.iosco.cde.version1.price.functions.ReportablePricePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(PriceScheduleRule.PriceScheduleRuleDefault.class)
public abstract class PriceScheduleRule implements ReportFunction<TransactionReportInstructionBase, List<? extends PricePeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportablePricePeriod reportablePricePeriod;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends PricePeriod> evaluate(TransactionReportInstructionBase input) {
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

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstructionBase input);

	public static class PriceScheduleRuleDefault extends PriceScheduleRule {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(TransactionReportInstructionBase input) {
			List<PricePeriod.PricePeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> output, TransactionReportInstructionBase input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToList(item -> MapperC.<PricePeriod>of(reportablePricePeriod.evaluate(item.get(), null))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
