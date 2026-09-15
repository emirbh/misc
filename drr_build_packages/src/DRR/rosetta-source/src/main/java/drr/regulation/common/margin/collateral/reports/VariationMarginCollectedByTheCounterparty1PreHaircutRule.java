package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.functions.VariationMarginCollectedByReportingCounterpartyPreHaircut;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(VariationMarginCollectedByTheCounterparty1PreHaircutRule.VariationMarginCollectedByTheCounterparty1PreHaircutRuleDefault.class)
public abstract class VariationMarginCollectedByTheCounterparty1PreHaircutRule implements ReportFunction<CollateralReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected VariationMarginCollectedByReportingCounterpartyPreHaircut variationMarginCollectedByReportingCounterpartyPreHaircut;

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

	public static class VariationMarginCollectedByTheCounterparty1PreHaircutRuleDefault extends VariationMarginCollectedByTheCounterparty1PreHaircutRule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstruction input) {
			final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(input).<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			output = variationMarginCollectedByReportingCounterpartyPreHaircut.evaluate(input, (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()));
			
			return output;
		}
	}
}
