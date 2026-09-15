package drr.standards.iosco.cde.version3.underlier.reports;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(UnderlierIDOtherRule.UnderlierIDOtherRuleDefault.class)
public abstract class UnderlierIDOtherRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected UnderlierProductIdentifierOtherRule underlierProductIdentifierOtherRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class UnderlierIDOtherRuleDefault extends UnderlierIDOtherRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final FieldWithMetaString fieldWithMetaString = MapperC.<AssetIdentifier>of(underlierProductIdentifierOtherRule.evaluate(input)).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())
				.first().get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
