package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.underlier.reports.CryptoAssetUnderlyingIndicatorRule;
import javax.inject.Inject;


@ImplementedBy(DerivativeBasedOnCryptoAssetsRule.DerivativeBasedOnCryptoAssetsRuleDefault.class)
public abstract class DerivativeBasedOnCryptoAssetsRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CryptoAssetUnderlyingIndicatorRule cryptoAssetUnderlyingIndicatorRule;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class DerivativeBasedOnCryptoAssetsRuleDefault extends DerivativeBasedOnCryptoAssetsRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(cryptoAssetUnderlyingIndicatorRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
