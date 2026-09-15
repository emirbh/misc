package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(BasketConstituentsRule.BasketConstituentsRuleDefault.class)
public abstract class BasketConstituentsRule implements ReportFunction<TransactionReportInstruction, List<? extends BasketConstituentsReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.basket.reports.BasketConstituentsRule basketConstituentsRule;
	@Inject protected CustomBasketIndicatorRule customBasketIndicatorRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends BasketConstituentsReport> evaluate(TransactionReportInstruction input) {
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

	protected abstract List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(TransactionReportInstruction input);

	public static class BasketConstituentsRuleDefault extends BasketConstituentsRule {
		@Override
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(TransactionReportInstruction input) {
			List<BasketConstituentsReport.BasketConstituentsReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> assignOutput(List<BasketConstituentsReport.BasketConstituentsReportBuilder> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForCSA.evaluate(item.get()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(customBasketIndicatorRule.evaluate(item.get())))).get());
			output = toBuilder(thenArg
				.mapSingleToList(item -> MapperC.<BasketConstituentsReport>of(basketConstituentsRule.evaluate(item.get()))).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
