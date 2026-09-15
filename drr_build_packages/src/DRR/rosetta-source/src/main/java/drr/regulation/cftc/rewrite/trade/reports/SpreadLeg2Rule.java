package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version2.price.reports.SpreadValueRule;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SpreadLeg2Rule.SpreadLeg2RuleDefault.class)
public abstract class SpreadLeg2Rule implements ReportFunction<TransactionReportInstruction, PriceFormat> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;
	@Inject protected SpreadNotationLeg2Rule spreadNotationLeg2Rule;
	@Inject protected SpreadValueRule spreadValueRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceFormat evaluate(TransactionReportInstruction input) {
		PriceFormat.PriceFormatBuilder outputBuilder = doEvaluate(input);
		
		final PriceFormat output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceFormat.class, output);
		}
		
		return output;
	}

	protected abstract PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input);

	public static class SpreadLeg2RuleDefault extends SpreadLeg2Rule {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input) {
			PriceFormat.PriceFormatBuilder output = PriceFormat.builder();
			return assignOutput(output, input);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToItem(item -> MapperS.of(priceFormatFromNotation.evaluate(spreadValueRule.evaluate(payoutLeg2Rule.evaluate(item.get())), spreadNotationLeg2Rule.evaluate(item.get())))).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
