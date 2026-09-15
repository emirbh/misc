package drr.standards.iosco.cde.version3.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(StrikePriceFormatRule.StrikePriceFormatRuleDefault.class)
public abstract class StrikePriceFormatRule implements ReportFunction<TransactionReportInstructionBase, PriceFormat> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;
	@Inject protected StrikePriceNotationEnumRule strikePriceNotationEnumRule;
	@Inject protected StrikePriceValueRule strikePriceValueRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceFormat evaluate(TransactionReportInstructionBase input) {
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

	protected abstract PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstructionBase input);

	public static class StrikePriceFormatRuleDefault extends StrikePriceFormatRule {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstructionBase input) {
			PriceFormat.PriceFormatBuilder output = PriceFormat.builder();
			return assignOutput(output, input);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder output, TransactionReportInstructionBase input) {
			output = toBuilder(priceFormatFromNotation.evaluate(strikePriceValueRule.evaluate(input), strikePriceNotationEnumRule.evaluate(input)));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
