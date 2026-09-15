package drr.regulation.common.dtcc.valuation.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_TradeParty2ReportingDestinationRule.DTCC_TradeParty2ReportingDestinationRuleDefault.class)
public abstract class DTCC_TradeParty2ReportingDestinationRule implements ReportFunction<ValuationReportInstruction, List<SupervisoryBodyEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<SupervisoryBodyEnum> evaluate(ValuationReportInstruction input) {
		List<SupervisoryBodyEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<SupervisoryBodyEnum> doEvaluate(ValuationReportInstruction input);

	public static class DTCC_TradeParty2ReportingDestinationRuleDefault extends DTCC_TradeParty2ReportingDestinationRule {
		@Override
		protected List<SupervisoryBodyEnum> doEvaluate(ValuationReportInstruction input) {
			List<SupervisoryBodyEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<SupervisoryBodyEnum> assignOutput(List<SupervisoryBodyEnum> output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToList(valuation -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperS.of(input).<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
					final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> notEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum0 -> fieldWithMetaSupervisoryBodyEnum0 == null ? null : fieldWithMetaSupervisoryBodyEnum0.getValue()), CardinalityOperator.All).andNullSafe(notEqual(MapperC.<SupervisoryBodyEnum>of(MapperS.of(SupervisoryBodyEnum.CFTC), MapperS.of(SupervisoryBodyEnum.SEC)), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum1 -> fieldWithMetaSupervisoryBodyEnum1 == null ? null : fieldWithMetaSupervisoryBodyEnum1.getValue()), CardinalityOperator.All)).get());
					final MapperC<ReportableJurisdictionInformation> thenArg2 = thenArg1
						.filterItemNullSafe(item -> areEqual(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", _referenceWithMetaParty -> _referenceWithMetaParty.getValue()), valuation.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), CardinalityOperator.Any).get());
					final MapperC<ReportableJurisdictionInformation> thenArg3 = distinctIgnoringPrecision(thenArg2);
					return thenArg3
						.mapItem(item -> item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()));
				}).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum.getValue()).getMulti();
			
			return output;
		}
	}
}
