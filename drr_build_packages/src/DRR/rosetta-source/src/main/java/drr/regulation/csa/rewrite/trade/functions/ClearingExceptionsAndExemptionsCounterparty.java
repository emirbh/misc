package drr.regulation.csa.rewrite.trade.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IntendedToClear;
import drr.base.qualification.event.functions.IsCleared;
import drr.regulation.common.ClearingException;
import drr.regulation.common.ClearingExceptionReasonEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ClearingExceptionsAndExemptions;
import drr.regulation.common.metafields.FieldWithMetaRegimeNameEnum;
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
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

	/**
	* @param transactionReportInstruction 
	* @param party 
	* @return _clearingExceptionsAndExemptions 
	*/
	public List<ClearingExceptionsAndExemptionsEnum> evaluate(TransactionReportInstruction transactionReportInstruction, Party party) {
		List<ClearingExceptionsAndExemptionsEnum> _clearingExceptionsAndExemptions = doEvaluate(transactionReportInstruction, party);
		
		return _clearingExceptionsAndExemptions;
	}

	protected abstract List<ClearingExceptionsAndExemptionsEnum> doEvaluate(TransactionReportInstruction transactionReportInstruction, Party party);

	public static class ClearingExceptionsAndExemptionsCounterpartyDefault extends ClearingExceptionsAndExemptionsCounterparty {
		@Override
		protected List<ClearingExceptionsAndExemptionsEnum> doEvaluate(TransactionReportInstruction transactionReportInstruction, Party party) {
			List<ClearingExceptionsAndExemptionsEnum> _clearingExceptionsAndExemptions = new ArrayList<>();
			return assignOutput(_clearingExceptionsAndExemptions, transactionReportInstruction, party);
		}
		
		protected List<ClearingExceptionsAndExemptionsEnum> assignOutput(List<ClearingExceptionsAndExemptionsEnum> _clearingExceptionsAndExemptions, TransactionReportInstruction transactionReportInstruction, Party party) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(transactionReportInstruction)
				.mapSingleToItem(item -> item
					.filterSingleNullSafe(_item -> areEqual(MapperS.of(isCleared.evaluate(_item.<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(intendedToClear.evaluate(_item.<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(false), CardinalityOperator.All)).get()));
			_clearingExceptionsAndExemptions.addAll(thenArg
				.mapSingleToList(reportInstruction -> {
					final MapperC<ReportableJurisdictionInformation> thenArg0 = reportInstruction.<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).<ReportableJurisdictionInformation>mapC("getJurisdictionInformation", reportableInformation -> reportableInformation.getJurisdictionInformation());
					final MapperC<ClearingExceptionsAndExemptionsEnum> ifThenElseResult;
					if (areEqual(thenArg0.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.DODD_FRANK_ACT), CardinalityOperator.Any).orNullSafe(areEqual(thenArg0.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(SupervisoryBodyEnum.CFTC), CardinalityOperator.Any)).getOrDefault(false)) {
						final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
							.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any)).get());
						final MapperC<JurisdictionPartyInformation> thenArg2 = thenArg1.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation());
						final MapperC<JurisdictionPartyInformation> thenArg3 = thenArg2
							.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(party), CardinalityOperator.All).get());
						final MapperC<ClearingException> thenArg4 = thenArg3.<ClearingException>map("getClearingException", jurisdictionPartyInformation -> jurisdictionPartyInformation.getClearingException());
						final MapperC<ClearingException> thenArg5 = thenArg4
							.filterItemNullSafe(item -> areEqual(item.<Boolean>map("getClearingException", clearingException -> clearingException.getClearingException()), MapperS.of(true), CardinalityOperator.All).get());
						final MapperC<ClearingExceptionReasonEnum> thenArg6 = thenArg5.<ClearingExceptionReasonEnum>mapC("getClearingExceptionReason", clearingException -> clearingException.getClearingExceptionReason());
						ifThenElseResult = thenArg6
							.mapItem(item -> MapperS.of(clearingExceptionsAndExemptions.evaluate(item.get())));
					} else {
						final MapperC<ReportableJurisdictionInformation> thenArg7 = thenArg0
							.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaRegimeNameEnum>map("getRegimeName", reportableJurisdictionInformation -> reportableJurisdictionInformation.getRegimeName()).<RegimeNameEnum>map("Type coercion", fieldWithMetaRegimeNameEnum -> fieldWithMetaRegimeNameEnum == null ? null : fieldWithMetaRegimeNameEnum.getValue()), MapperS.of(RegimeNameEnum.CSA), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<SupervisoryBodyEnum>of(supervisoryBodyForCSA.evaluate()), item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), CardinalityOperator.Any)).get());
						final MapperC<JurisdictionPartyInformation> thenArg8 = thenArg7.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation());
						final MapperC<JurisdictionPartyInformation> thenArg9 = thenArg8
							.filterItemNullSafe(item -> areEqual(item.<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), MapperS.of(party), CardinalityOperator.All).get());
						final MapperC<ClearingException> thenArg10 = thenArg9.<ClearingException>map("getClearingException", jurisdictionPartyInformation -> jurisdictionPartyInformation.getClearingException());
						final MapperC<ClearingException> thenArg11 = thenArg10
							.filterItemNullSafe(item -> areEqual(item.<Boolean>map("getClearingException", clearingException -> clearingException.getClearingException()), MapperS.of(true), CardinalityOperator.All).get());
						final MapperC<ClearingExceptionReasonEnum> thenArg12 = thenArg11.<ClearingExceptionReasonEnum>mapC("getClearingExceptionReason", clearingException -> clearingException.getClearingExceptionReason());
						final MapperC<ClearingExceptionReasonEnum> thenArg13 = thenArg12
							.filterItemNullSafe(item -> areEqual(MapperC.<ClearingExceptionReasonEnum>of(MapperS.of(ClearingExceptionReasonEnum.INTER_AFFILIATE), MapperS.of(ClearingExceptionReasonEnum.EXCEPTION)), item, CardinalityOperator.Any).get());
						ifThenElseResult = thenArg13
							.mapItem(item -> MapperS.of(clearingExceptionsAndExemptions.evaluate(item.get())));
					}
					return ifThenElseResult;
				}).getMulti());
			
			return _clearingExceptionsAndExemptions;
		}
	}
}
