package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.price.reports.StrikePriceNotationEnumRule;
import javax.inject.Inject;


@ImplementedBy(StrikePriceNotationRule.StrikePriceNotationRuleDefault.class)
public abstract class StrikePriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected StrikePriceNotationEnumRule strikePriceNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstruction input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstruction input);

	public static class StrikePriceNotationRuleDefault extends StrikePriceNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(strikePriceNotationEnumRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
