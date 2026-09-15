package drr.regulation.mas.rewrite.margin.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PartyInformation;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.base.util.party.functions.PartyLei;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionAgentOfTheCounterparty1DTCCRule.ExecutionAgentOfTheCounterparty1DTCCRuleDefault.class)
public abstract class ExecutionAgentOfTheCounterparty1DTCCRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected PartyLei partyLei;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class ExecutionAgentOfTheCounterparty1DTCCRuleDefault extends ExecutionAgentOfTheCounterparty1DTCCRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportableEvent -> {
					final MapperC<PartyInformation> thenArg0 = reportableEvent.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation());
					final MapperC<String> thenArg1 = thenArg0
						.mapItem(item -> {
							final MapperS<PartyInformation> _thenArg0 = item
								.filterSingleNullSafe(_item -> areEqual(_item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportableEvent.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
							if (_thenArg0
								.mapSingleToItem(_item -> exists(MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(_item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.EXECUTION_AGENT))).asMapper()).getOrDefault(false)) {
								final MapperS<PartyInformation> _thenArg1 = item
									.filterSingleNullSafe(_item -> areEqual(_item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportableEvent.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
								final MapperS<Party> thenArg2 = _thenArg1
									.mapSingleToItem(_item -> MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(_item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.EXECUTION_AGENT)));
								return thenArg2
									.mapSingleToItem(_item -> MapperS.of(partyLei.evaluate(_item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti())));
							}
							final MapperS<PartyInformation> thenArg3 = item
								.filterSingleNullSafe(_item -> areEqual(_item.<ReferenceWithMetaParty>map("getPartyReference", partyInformation -> partyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), reportableEvent.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All).get());
							if (thenArg3
								.mapSingleToItem(_item -> exists(MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(_item.<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.EXECUTION_AGENT))).asMapper()).getOrDefault(false)) {
								return MapperS.of("NOAP");
							}
							return MapperS.<String>ofNull();
						});
					return thenArg1
						.first();
				}).get();
			
			return output;
		}
	}
}
