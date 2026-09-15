package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_ReportingCounterparty;
import drr.regulation.hkma.rewrite.trade.functions.Filter_HKMAPriorityPartyIdentifiers;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2Rule.Counterparty2RuleDefault.class)
public abstract class Counterparty2Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.party.reports.Counterparty2Rule counterparty2Rule;
	@Inject protected Extract_ReportingCounterparty extract_ReportingCounterparty;
	@Inject protected Filter_HKMAPriorityPartyIdentifiers filter_HKMAPriorityPartyIdentifiers;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class Counterparty2RuleDefault extends Counterparty2Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(counterparty2Rule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(counterparty2Rule.evaluate(item.get()));
					}
					final MapperS<Party> thenArg0 = MapperS.of(extract_ReportingCounterparty.evaluate(item.get()));
					final MapperS<PartyIdentifier> thenArg1 = MapperS.of(filter_HKMAPriorityPartyIdentifiers.evaluate(thenArg0.get()));
					return thenArg1.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue());
				}).get();
			
			return output;
		}
	}
}
