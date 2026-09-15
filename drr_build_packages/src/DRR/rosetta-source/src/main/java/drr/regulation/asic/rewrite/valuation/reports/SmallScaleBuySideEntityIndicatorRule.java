package drr.regulation.asic.rewrite.valuation.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ASICPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SmallScaleBuySideEntityIndicatorRule.SmallScaleBuySideEntityIndicatorRuleDefault.class)
public abstract class SmallScaleBuySideEntityIndicatorRule implements ReportFunction<ValuationReportInstruction, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class SmallScaleBuySideEntityIndicatorRuleDefault extends SmallScaleBuySideEntityIndicatorRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(reportInstruction -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(input).<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
					final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.ASIC), CardinalityOperator.All).get());
					final MapperListOfLists<JurisdictionPartyInformation> thenArg2 = thenArg1
						.mapItemToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
					final MapperListOfLists<JurisdictionPartyInformation> thenArg3 = thenArg2
						.filterListNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", _referenceWithMetaParty -> _referenceWithMetaParty.getValue()), reportInstruction.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), CardinalityOperator.Any).get());
					final MapperC<JurisdictionPartyInformation> thenArg4 = thenArg3
						.flattenList();
					final MapperC<ASICPartyInformation> thenArg5 = thenArg4
						.mapItem(item -> item.<ASICPartyInformation>map("getAsicPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getAsicPartyInformation()));
					final MapperS<ASICPartyInformation> thenArg6 = MapperS.of(thenArg5.get());
					return thenArg6
						.mapSingleToItem(item -> {
							if (exists(item.<Boolean>map("getSmallScaleBuySideIndicator", aSICPartyInformation -> aSICPartyInformation.getSmallScaleBuySideIndicator())).andNullSafe(areEqual(item.<Boolean>map("getSmallScaleBuySideIndicator", aSICPartyInformation -> aSICPartyInformation.getSmallScaleBuySideIndicator()), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
								return MapperS.of("SSBS");
							}
							return MapperS.<String>ofNull();
						});
				}).get();
			
			return output;
		}
	}
}
