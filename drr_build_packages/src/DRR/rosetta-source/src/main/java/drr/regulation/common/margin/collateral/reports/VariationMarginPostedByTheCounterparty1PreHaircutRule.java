package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.functions.VariationMarginPostedByReportingCounterpartyPreHaircut;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(VariationMarginPostedByTheCounterparty1PreHaircutRule.VariationMarginPostedByTheCounterparty1PreHaircutRuleDefault.class)
public abstract class VariationMarginPostedByTheCounterparty1PreHaircutRule implements ReportFunction<CollateralReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected VariationMarginPostedByReportingCounterpartyPreHaircut variationMarginPostedByReportingCounterpartyPreHaircut;

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

	public static class VariationMarginPostedByTheCounterparty1PreHaircutRuleDefault extends VariationMarginPostedByTheCounterparty1PreHaircutRule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(variationMarginPostedByReportingCounterpartyPreHaircut.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
