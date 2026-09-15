package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SingleOrUpperAndLowerBarrierRule.SingleOrUpperAndLowerBarrierRuleDefault.class)
public abstract class SingleOrUpperAndLowerBarrierRule implements ReportFunction<TransactionReportInstruction, SingleOrUpperAndLowerBarrier> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected drr.regulation.common.trade.price.reports.SingleOrUpperAndLowerBarrierRule singleOrUpperAndLowerBarrierRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SingleOrUpperAndLowerBarrier evaluate(TransactionReportInstruction input) {
		SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder outputBuilder = doEvaluate(input);
		
		final SingleOrUpperAndLowerBarrier output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(SingleOrUpperAndLowerBarrier.class, output);
		}
		
		return output;
	}

	protected abstract SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder doEvaluate(TransactionReportInstruction input);

	public static class SingleOrUpperAndLowerBarrierRuleDefault extends SingleOrUpperAndLowerBarrierRule {
		@Override
		protected SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder doEvaluate(TransactionReportInstruction input) {
			SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder output = SingleOrUpperAndLowerBarrier.builder();
			return assignOutput(output, input);
		}
		
		protected SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder assignOutput(SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToItem(item -> MapperS.of(singleOrUpperAndLowerBarrierRule.evaluate(item.get()))).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
