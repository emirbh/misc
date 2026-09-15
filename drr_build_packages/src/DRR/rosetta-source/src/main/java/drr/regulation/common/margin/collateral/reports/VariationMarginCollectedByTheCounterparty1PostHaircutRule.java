package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.functions.VariationMarginCollectedByReportingCounterpartyPostHaircut;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(VariationMarginCollectedByTheCounterparty1PostHaircutRule.VariationMarginCollectedByTheCounterparty1PostHaircutRuleDefault.class)
public abstract class VariationMarginCollectedByTheCounterparty1PostHaircutRule implements ReportFunction<CollateralReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected VariationMarginCollectedByReportingCounterpartyPostHaircut variationMarginCollectedByReportingCounterpartyPostHaircut;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(CollateralReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(CollateralReportInstruction input);

	public static class VariationMarginCollectedByTheCounterparty1PostHaircutRuleDefault extends VariationMarginCollectedByTheCounterparty1PostHaircutRule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstruction input) {
			final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(input).<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			output = variationMarginCollectedByReportingCounterpartyPostHaircut.evaluate(input, (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()));
			
			return output;
		}
	}
}
