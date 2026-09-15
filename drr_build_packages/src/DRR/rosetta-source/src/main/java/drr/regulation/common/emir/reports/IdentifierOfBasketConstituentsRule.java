package drr.regulation.common.emir.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.basket.reports.BasketConstituentsRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IdentifierOfBasketConstituentsRule.IdentifierOfBasketConstituentsRuleDefault.class)
public abstract class IdentifierOfBasketConstituentsRule implements ReportFunction<TransactionReportInstruction, List<? extends BasketConstituentsReport>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BasketConstituentsRule basketConstituentsRule;

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

	public static class IdentifierOfBasketConstituentsRuleDefault extends IdentifierOfBasketConstituentsRule {
		@Override
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> doEvaluate(TransactionReportInstruction input) {
			List<BasketConstituentsReport.BasketConstituentsReportBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> assignOutput(List<BasketConstituentsReport.BasketConstituentsReportBuilder> output, TransactionReportInstruction input) {
			final MapperC<BasketConstituentsReport> thenArg0 = MapperS.of(input)
				.mapSingleToList(item -> MapperC.<BasketConstituentsReport>of(basketConstituentsRule.evaluate(item.get())));
			final MapperC<BasketConstituentsReport> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).get());
			output = toBuilder(thenArg1
				.mapItem(item -> MapperS.of(BasketConstituentsReport.builder()
					.setIdentifier(item.<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).get())
					.build())).getMulti());
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
