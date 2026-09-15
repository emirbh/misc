package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.IsCSALeg2Aligned;
import drr.regulation.csa.rewrite.trade.functions.IsUnderlierTOTV;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetPriceSourceLeg1Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetPriceSourceLeg2Rule.UnderlyingAssetPriceSourceLeg2RuleDefault.class)
public abstract class UnderlyingAssetPriceSourceLeg2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCSALeg2Aligned isCSALeg2Aligned;
	@Inject protected IsUnderlierTOTV isUnderlierTOTV;
	@Inject protected UnderlyingAssetPriceSourceLeg1Rule underlyingAssetPriceSourceLeg1Rule;
	@Inject protected drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetPriceSourceLeg2Rule underlyingAssetPriceSourceLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class UnderlyingAssetPriceSourceLeg2RuleDefault extends UnderlyingAssetPriceSourceLeg2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final Boolean _boolean = isUnderlierTOTV.evaluate(thenArg.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get());
			final MapperS<String> ifThenElseResult;
			if ((_boolean == null ? false : _boolean)) {
				if (areEqual(MapperS.of(isCSALeg2Aligned.evaluate(thenArg.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = MapperS.of(underlyingAssetPriceSourceLeg2Rule.evaluate(thenArg.get()));
				} else {
					ifThenElseResult = MapperS.of(underlyingAssetPriceSourceLeg1Rule.evaluate(thenArg.get()));
				}
			} else {
				ifThenElseResult = MapperS.<String>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
