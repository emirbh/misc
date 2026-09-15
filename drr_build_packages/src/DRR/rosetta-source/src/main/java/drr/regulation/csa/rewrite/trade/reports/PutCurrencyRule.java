package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(PutCurrencyRule.PutCurrencyRuleDefault.class)
public abstract class PutCurrencyRule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsFXOption isFXOption;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected drr.standards.iosco.cde.version3.quantity.reports.PutCurrencyRule putCurrencyRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransactionReportInstruction input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input);

	public static class PutCurrencyRuleDefault extends PutCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final Boolean _boolean = isFXOption.evaluate(productForEvent.evaluate(thenArg.get()));
			final MapperS<ISOCurrencyCodeEnum> ifThenElseResult;
			if ((_boolean == null ? false : _boolean)) {
				ifThenElseResult = MapperS.of(putCurrencyRule.evaluate(thenArg.get()));
			} else {
				ifThenElseResult = MapperS.<ISOCurrencyCodeEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
