package drr.regulation.asic.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractProductIdentifierBySource;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlierProductIdentifierOtherRule;
import javax.inject.Inject;


@ImplementedBy(UnderlyingIdOtherRule.UnderlyingIdOtherRuleDefault.class)
public abstract class UnderlyingIdOtherRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractProductIdentifierBySource extractProductIdentifierBySource;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected UnderlierProductIdentifierOtherRule underlierProductIdentifierOtherRule;

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

	public static class UnderlyingIdOtherRuleDefault extends UnderlyingIdOtherRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperC<AssetIdentifier> thenArg1 = thenArg0
				.mapSingleToList(item -> MapperC.<AssetIdentifier>of(underlierProductIdentifierOtherRule.evaluate(item.get())));
			final MapperS<AssetIdentifier> thenArg2 = MapperS.of(extractProductIdentifierBySource.evaluate(thenArg1.getMulti()));
			final FieldWithMetaString fieldWithMetaString = thenArg2.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
