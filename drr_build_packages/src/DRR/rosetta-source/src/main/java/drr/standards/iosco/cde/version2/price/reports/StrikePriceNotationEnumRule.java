package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationFromPrice;
import drr.standards.iosco.cde.version2.price.functions.StrikePrice;
import javax.inject.Inject;


@ImplementedBy(StrikePriceNotationEnumRule.StrikePriceNotationEnumRuleDefault.class)
public abstract class StrikePriceNotationEnumRule implements ReportFunction<TransactionReportInstructionBase, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationFromPrice notationFromPrice;
	@Inject protected StrikePrice strikePrice;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstructionBase input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstructionBase input);

	public static class StrikePriceNotationEnumRuleDefault extends StrikePriceNotationEnumRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstructionBase input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstructionBase input) {
			output = MapperS.of(strikePrice.evaluate(input))
				.mapSingleToItem(item -> MapperS.of(notationFromPrice.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
