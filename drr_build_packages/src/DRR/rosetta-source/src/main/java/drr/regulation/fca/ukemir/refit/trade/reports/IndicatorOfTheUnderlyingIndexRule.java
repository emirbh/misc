package drr.regulation.fca.ukemir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.IndexEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IndicatorOfTheUnderlyingIndexRule.IndicatorOfTheUnderlyingIndexRuleDefault.class)
public abstract class IndicatorOfTheUnderlyingIndexRule implements ReportFunction<TransactionReportInstruction, List<IndexEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.emir.reports.IndicatorOfTheUnderlyingIndexRule indicatorOfTheUnderlyingIndexRule;
	@Inject protected IsAllowableAction isAllowableAction;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<IndexEnum> evaluate(TransactionReportInstruction input) {
		List<IndexEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<IndexEnum> doEvaluate(TransactionReportInstruction input);

	public static class IndicatorOfTheUnderlyingIndexRuleDefault extends IndicatorOfTheUnderlyingIndexRule {
		@Override
		protected List<IndexEnum> doEvaluate(TransactionReportInstruction input) {
			List<IndexEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<IndexEnum> assignOutput(List<IndexEnum> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperC<IndexEnum> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<IndexEnum>of(indicatorOfTheUnderlyingIndexRule.evaluate(item.get())));
			output = thenArg1
				.mapItem(item -> {
					if (areEqual(MapperC.<IndexEnum>of(MapperS.of(IndexEnum.CORA), MapperS.of(IndexEnum.HKIO), MapperS.of(IndexEnum.TORF), MapperS.of(IndexEnum.SIBO), MapperS.of(IndexEnum.SSOR), MapperS.of(IndexEnum.SORA)), item, CardinalityOperator.Any).getOrDefault(false)) {
						return MapperS.<IndexEnum>ofNull();
					}
					return item;
				}).getMulti();
			
			return output;
		}
	}
}
