package drr.regulation.fca.ukemir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.IndexEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingRateIndicatorLeg2Rule.FloatingRateIndicatorLeg2RuleDefault.class)
public abstract class FloatingRateIndicatorLeg2Rule implements ReportFunction<TransactionReportInstruction, IndexEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.emir.reports.FloatingRateIndicatorLeg2Rule floatingRateIndicatorLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public IndexEnum evaluate(TransactionReportInstruction input) {
		IndexEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract IndexEnum doEvaluate(TransactionReportInstruction input);

	public static class FloatingRateIndicatorLeg2RuleDefault extends FloatingRateIndicatorLeg2Rule {
		@Override
		protected IndexEnum doEvaluate(TransactionReportInstruction input) {
			IndexEnum output = null;
			return assignOutput(output, input);
		}
		
		protected IndexEnum assignOutput(IndexEnum output, TransactionReportInstruction input) {
			final MapperS<IndexEnum> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(floatingRateIndicatorLeg2Rule.evaluate(item.get())));
			output = thenArg
				.filterSingleNullSafe(item -> notEqual(MapperC.<IndexEnum>of(MapperS.of(IndexEnum.CORA), MapperS.of(IndexEnum.HKIO), MapperS.of(IndexEnum.TORF), MapperS.of(IndexEnum.SIBO), MapperS.of(IndexEnum.SSOR), MapperS.of(IndexEnum.SORA)), item, CardinalityOperator.All).get()).get();
			
			return output;
		}
	}
}
