package drr.regulation.common.margin.collateral.reports;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.standards.iosco.cde.version2.collateral.functions.InitialMarginPostedByReportingCounterpartyPostHaircut;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(InitialMarginPostedByTheCounterparty1PostHaircutRule.InitialMarginPostedByTheCounterparty1PostHaircutRuleDefault.class)
public abstract class InitialMarginPostedByTheCounterparty1PostHaircutRule implements ReportFunction<CollateralReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected InitialMarginPostedByReportingCounterpartyPostHaircut initialMarginPostedByReportingCounterpartyPostHaircut;

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

	public static class InitialMarginPostedByTheCounterparty1PostHaircutRuleDefault extends InitialMarginPostedByTheCounterparty1PostHaircutRule {
		@Override
		protected BigDecimal doEvaluate(CollateralReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
					return MapperS.of(initialMarginPostedByReportingCounterpartyPostHaircut.evaluate(item.get(), (referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
