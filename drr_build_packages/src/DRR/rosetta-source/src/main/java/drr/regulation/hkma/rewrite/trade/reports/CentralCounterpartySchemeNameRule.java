package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_CentralCounterparty;
import drr.regulation.hkma.rewrite.trade.functions.Extract_HKMASchemeName;
import drr.regulation.hkma.rewrite.trade.functions.Filter_HKMAPriorityPartyIdentifiers;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CentralCounterpartySchemeNameRule.CentralCounterpartySchemeNameRuleDefault.class)
public abstract class CentralCounterpartySchemeNameRule implements ReportFunction<TransactionReportInstruction, HKTRPartyScheme> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CentralCounterpartyIdentifierFormatRule centralCounterpartyIdentifierFormatRule;
	@Inject protected Extract_CentralCounterparty extract_CentralCounterparty;
	@Inject protected Extract_HKMASchemeName extract_HKMASchemeName;
	@Inject protected Filter_HKMAPriorityPartyIdentifiers filter_HKMAPriorityPartyIdentifiers;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public HKTRPartyScheme evaluate(TransactionReportInstruction input) {
		HKTRPartyScheme output = doEvaluate(input);
		
		return output;
	}

	protected abstract HKTRPartyScheme doEvaluate(TransactionReportInstruction input);

	public static class CentralCounterpartySchemeNameRuleDefault extends CentralCounterpartySchemeNameRule {
		@Override
		protected HKTRPartyScheme doEvaluate(TransactionReportInstruction input) {
			HKTRPartyScheme output = null;
			return assignOutput(output, input);
		}
		
		protected HKTRPartyScheme assignOutput(HKTRPartyScheme output, TransactionReportInstruction input) {
			final MapperS<Party> thenArg0;
			if (areEqual(MapperS.of(centralCounterpartyIdentifierFormatRule.evaluate(input)), MapperS.of(PartyIdentifierFormat2Enum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				thenArg0 = MapperS.of(extract_CentralCounterparty.evaluate(input));
			} else {
				thenArg0 = MapperS.<Party>ofNull();
			}
			final MapperS<PartyIdentifier> thenArg1 = MapperS.of(filter_HKMAPriorityPartyIdentifiers.evaluate(thenArg0.get()));
			output = MapperS.of(extract_HKMASchemeName.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
