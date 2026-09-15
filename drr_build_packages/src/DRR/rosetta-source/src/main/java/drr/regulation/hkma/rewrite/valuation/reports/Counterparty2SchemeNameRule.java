package drr.regulation.hkma.rewrite.valuation.reports;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_HKMASchemeName;
import drr.regulation.hkma.rewrite.trade.functions.Filter_HKMAPriorityPartyIdentifiers;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2SchemeNameRule.Counterparty2SchemeNameRuleDefault.class)
public abstract class Counterparty2SchemeNameRule implements ReportFunction<ValuationReportInstruction, HKTRPartyScheme> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty2IdentifierFormatRule counterparty2IdentifierFormatRule;
	@Inject protected Extract_HKMASchemeName extract_HKMASchemeName;
	@Inject protected Filter_HKMAPriorityPartyIdentifiers filter_HKMAPriorityPartyIdentifiers;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public HKTRPartyScheme evaluate(ValuationReportInstruction input) {
		HKTRPartyScheme output = doEvaluate(input);
		
		return output;
	}

	protected abstract HKTRPartyScheme doEvaluate(ValuationReportInstruction input);

	public static class Counterparty2SchemeNameRuleDefault extends Counterparty2SchemeNameRule {
		@Override
		protected HKTRPartyScheme doEvaluate(ValuationReportInstruction input) {
			HKTRPartyScheme output = null;
			return assignOutput(output, input);
		}
		
		protected HKTRPartyScheme assignOutput(HKTRPartyScheme output, ValuationReportInstruction input) {
			final MapperS<ReferenceWithMetaParty> thenArg0;
			if (areEqual(MapperS.of(counterparty2IdentifierFormatRule.evaluate(input)), MapperS.of(PartyIdentifierFormat2Enum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				thenArg0 = MapperS.of(input).<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty());
			} else {
				thenArg0 = MapperS.<ReferenceWithMetaParty>ofNull();
			}
			final ReferenceWithMetaParty referenceWithMetaParty = thenArg0.get();
			final MapperS<PartyIdentifier> thenArg1 = MapperS.of(filter_HKMAPriorityPartyIdentifiers.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
			output = MapperS.of(extract_HKMASchemeName.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
