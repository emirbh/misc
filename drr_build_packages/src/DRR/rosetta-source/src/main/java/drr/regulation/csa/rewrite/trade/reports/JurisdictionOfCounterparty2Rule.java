package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CSAPartyInformation;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(JurisdictionOfCounterparty2Rule.JurisdictionOfCounterparty2RuleDefault.class)
public abstract class JurisdictionOfCounterparty2Rule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class JurisdictionOfCounterparty2RuleDefault extends JurisdictionOfCounterparty2Rule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(transaction -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = thenArg.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
					final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
						.filterItemNullSafe(item -> areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any).get());
					final MapperC<ReportableJurisdictionInformation> thenArg2 = thenArg1
						.filterItemNullSafe(item -> areEqual(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", _referenceWithMetaParty -> _referenceWithMetaParty.getValue()), transaction.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), CardinalityOperator.Any).get());
					final MapperC<ReportableJurisdictionInformation> thenArg3 = thenArg2
						.filterItemNullSafe(item -> areEqual(item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<CSAPartyInformation>map("getCsaPartyInformation", jurisdictionPartyInformation -> jurisdictionPartyInformation.getCsaPartyInformation()).<Boolean>map("getLocalCounterparty", cSAPartyInformation -> cSAPartyInformation.getLocalCounterparty()), MapperS.of(true), CardinalityOperator.Any).get());
					final MapperC<String> thenArg4 = thenArg3
						.mapItem(item -> item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()).map("to-string", SupervisoryBodyEnum::toDisplayString));
					final MapperC<String> ifThenElseResult;
					if (exists(thenArg4).getOrDefault(false)) {
						ifThenElseResult = thenArg4;
					} else {
						ifThenElseResult = MapperC.of(Collections.singletonList("NON-CA"));
					}
					return ifThenElseResult;
				}).getMulti();
			
			return output;
		}
	}
}
