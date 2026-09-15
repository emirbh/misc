package drr.regulation.common.trade.execution.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IntendedToClear;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ClearingExceptionReasonEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ClearingExceptionsAndExemptions;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingExceptionsAndExemptionsCounterparty.ClearingExceptionsAndExemptionsCounterpartyDefault.class)
public abstract class ClearingExceptionsAndExemptionsCounterparty implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ClearingExceptionsAndExemptions clearingExceptionsAndExemptions;
	@Inject protected IntendedToClear intendedToClear;
	@Inject protected IsCleared isCleared;

	/**
	* @param transactionReportInstruction 
	* @param party 
	* @param supervisor 
	* @return exceptions 
	*/
	public List<ClearingExceptionsAndExemptionsEnum> evaluate(TransactionReportInstruction transactionReportInstruction, Party party, SupervisoryBodyEnum supervisor) {
		List<ClearingExceptionsAndExemptionsEnum> exceptions = doEvaluate(transactionReportInstruction, party, supervisor);
		
		return exceptions;
	}

	protected abstract List<ClearingExceptionsAndExemptionsEnum> doEvaluate(TransactionReportInstruction transactionReportInstruction, Party party, SupervisoryBodyEnum supervisor);

	public static class ClearingExceptionsAndExemptionsCounterpartyDefault extends ClearingExceptionsAndExemptionsCounterparty {
		@Override
		protected List<ClearingExceptionsAndExemptionsEnum> doEvaluate(TransactionReportInstruction transactionReportInstruction, Party party, SupervisoryBodyEnum supervisor) {
			List<ClearingExceptionsAndExemptionsEnum> exceptions = new ArrayList<>();
			return assignOutput(exceptions, transactionReportInstruction, party, supervisor);
		}
		
		protected List<ClearingExceptionsAndExemptionsEnum> assignOutput(List<ClearingExceptionsAndExemptionsEnum> exceptions, TransactionReportInstruction transactionReportInstruction, Party party, SupervisoryBodyEnum supervisor) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(transactionReportInstruction);
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(intendedToClear.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All)).get());
			exceptions.addAll(thenArg1
				.mapSingleToList(reportInstruction -> {
					final MapperC<ReportableJurisdictionInformation> _thenArg0 = reportInstruction.<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation())
						.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(supervisor), CardinalityOperator.All).get());
					final MapperS<ReportableJurisdictionInformation> _thenArg1 = MapperS.of(_thenArg0.get());
					final MapperC<JurisdictionPartyInformation> thenArg2 = _thenArg1
						.mapSingleToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()));
					final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
						.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(party), CardinalityOperator.All).get());
					final MapperC<JurisdictionPartyInformation> thenArg4 = thenArg3
						.filterItemNullSafe(item -> areEqual(item.<ClearingException>map("getClearingException", jurisdictionPartyInformation -> jurisdictionPartyInformation.getClearingException()).<Boolean>map("getClearingException", clearingException -> clearingException.getClearingException()), MapperS.of(true), CardinalityOperator.All).get());
					final MapperListOfLists<ClearingExceptionReasonEnum> thenArg5 = thenArg4
						.mapItemToList(item -> item.<ClearingException>map("getClearingException", jurisdictionPartyInformation -> jurisdictionPartyInformation.getClearingException()).<ClearingExceptionReasonEnum>mapC("getClearingExceptionReason", clearingException -> clearingException.getClearingExceptionReason()));
					final MapperC<ClearingExceptionReasonEnum> thenArg6 = thenArg5
						.flattenList();
					return thenArg6
						.mapItem(item -> MapperS.of(clearingExceptionsAndExemptions.evaluate(item.get())));
				}).getMulti());
			
			return exceptions;
		}
	}
}
