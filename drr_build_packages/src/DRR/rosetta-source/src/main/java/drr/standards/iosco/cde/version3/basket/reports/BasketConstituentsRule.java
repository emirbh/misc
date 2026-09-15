package drr.standards.iosco.cde.version3.basket.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.basket.BasketConstituentsReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(BasketConstituentsRule.BasketConstituentsRuleDefault.class)
public abstract class BasketConstituentsRule implements ReportFunction<TransactionReportInstructionBase, List<? extends BasketConstituentsReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.basket.reports.BasketConstituentsRule basketConstituentsRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends BasketConstituentsReport> evaluate(TransactionReportInstructionBase input) {
		List<BasketConstituentsReport.BasketConstituentsReportBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends BasketConstituentsReport> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(BasketConstituentsReport::build).collect(Collectors.toList());
			objectValidator.validate(BasketConstituentsReport.class, output);
		}
		
		return output;
	}

	protected abstract List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(TransactionReportInstructionBase input);

	public static class BasketConstituentsRuleDefault extends BasketConstituentsRule {
		@Override
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(TransactionReportInstructionBase input) {
			List<BasketConstituentsReport.BasketConstituentsReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> assignOutput(List<BasketConstituentsReport.BasketConstituentsReportBuilder> output, TransactionReportInstructionBase input) {
			output = toBuilder(basketConstituentsRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
