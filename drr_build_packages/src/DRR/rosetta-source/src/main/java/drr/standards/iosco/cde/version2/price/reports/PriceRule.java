package drr.standards.iosco.cde.version2.price.reports;

import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.price.functions.Price;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(PriceRule.PriceRuleDefault.class)
public abstract class PriceRule implements ReportFunction<TransactionReportInstructionBase, PriceSchedule> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Price price;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceSchedule evaluate(TransactionReportInstructionBase input) {
		PriceSchedule.PriceScheduleBuilder outputBuilder = doEvaluate(input);
		
		final PriceSchedule output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceSchedule.class, output);
		}
		
		return output;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(TransactionReportInstructionBase input);

	public static class PriceRuleDefault extends PriceRule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(TransactionReportInstructionBase input) {
			PriceSchedule.PriceScheduleBuilder output = PriceSchedule.builder();
			return assignOutput(output, input);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder output, TransactionReportInstructionBase input) {
			output = toBuilder(price.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
