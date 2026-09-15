package drr.regulation.cftc.rewrite.margin.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PartyInformation;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.functions.RegimePartySupervisoryBody;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(AffiliatedCounterpartyForMarginAndCapitalIndicatorRule.AffiliatedCounterpartyForMarginAndCapitalIndicatorRuleDefault.class)
public abstract class AffiliatedCounterpartyForMarginAndCapitalIndicatorRule implements ReportFunction<CollateralReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected RegimePartySupervisoryBody regimePartySupervisoryBody;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(CollateralReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(CollateralReportInstruction input);

	public static class AffiliatedCounterpartyForMarginAndCapitalIndicatorRuleDefault extends AffiliatedCounterpartyForMarginAndCapitalIndicatorRule {
		@Override
		protected Boolean doEvaluate(CollateralReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, CollateralReportInstruction input) {
			final MapperS<ReportableInformation> thenArg0 = MapperS.of(input).<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation());
			final MapperC<PartyInformation> thenArg1 = thenArg0
				.mapSingleToList(r -> {
					final MapperC<PartyInformation> thenArg = r.<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation());
					return thenArg
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(MapperC.of(regimePartySupervisoryBody.evaluate(r.<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation()).getMulti(), SupervisoryBodyEnum.CFTC)).get()), CardinalityOperator.All).get());
				});
			final MapperS<PartyInformation> thenArg2 = MapperS.of(thenArg1.get());
			output = thenArg2
				.mapSingleToItem(item -> contains(item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).<PartyRoleEnum>map("getRole", relatedParty -> relatedParty.getRole()), MapperS.of(PartyRoleEnum.MARGIN_AFFILIATE)).asMapper()).get();
			
			return output;
		}
	}
}
