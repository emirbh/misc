package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_ClearingMember;
import drr.regulation.hkma.rewrite.trade.functions.Filter_HKMAPriorityPartyIdentifiers;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingMemberRule.ClearingMemberRuleDefault.class)
public abstract class ClearingMemberRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.ClearingMemberRule clearingMemberRule;
	@Inject protected Extract_ClearingMember extract_ClearingMember;
	@Inject protected Filter_HKMAPriorityPartyIdentifiers filter_HKMAPriorityPartyIdentifiers;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

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

	public static class ClearingMemberRuleDefault extends ClearingMemberRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final MapperS<String> ifThenElseResult;
			if (exists(MapperS.of(clearingMemberRule.evaluate(thenArg0.get()))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(clearingMemberRule.evaluate(thenArg0.get()));
			} else {
				final MapperS<Party> thenArg1 = MapperS.of(extract_ClearingMember.evaluate(thenArg0.get()));
				final MapperS<PartyIdentifier> thenArg2 = MapperS.of(filter_HKMAPriorityPartyIdentifiers.evaluate(thenArg1.get()));
				ifThenElseResult = thenArg2.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue());
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
