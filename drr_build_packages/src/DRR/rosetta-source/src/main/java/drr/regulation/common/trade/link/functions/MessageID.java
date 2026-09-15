package drr.regulation.common.trade.link.functions;

import cdm.event.workflow.MessageInformation;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import javax.inject.Inject;


@ImplementedBy(MessageID.MessageIDDefault.class)
public abstract class MessageID implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected TechnicalRecordId technicalRecordId;

	/**
	* @param transactionReportInstruction 
	* @param regimeName 
	* @return messageID 
	*/
	public String evaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName) {
		String messageID = doEvaluate(transactionReportInstruction, regimeName);
		
		return messageID;
	}

	protected abstract String doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName);

	public static class MessageIDDefault extends MessageID {
		@Override
		protected String doEvaluate(TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName) {
			String messageID = null;
			return assignOutput(messageID, transactionReportInstruction, regimeName);
		}
		
		protected String assignOutput(String messageID, TransactionReportInstruction transactionReportInstruction, RegimeNameEnum regimeName) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(transactionReportInstruction);
			messageID = thenArg
				.mapSingleToItem(ReportableEvent -> {
					if (MapperS.of(technicalRecordId.evaluate(thenArg.<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).get(), regimeName)).<Boolean>map("getIsUnique", _technicalRecordId -> _technicalRecordId.getIsUnique()).getOrDefault(false)) {
						return MapperS.of(technicalRecordId.evaluate(thenArg.<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).get(), regimeName)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue());
					}
					final MapperS<FieldWithMetaString> _thenArg = MapperS.of(MapperS.of(technicalRecordId.evaluate(thenArg.<ReportableInformation>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).get(), regimeName)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).getOrDefault(thenArg.<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).<MessageInformation>map("getMessageInformation", workflowStep -> workflowStep.getMessageInformation()).<FieldWithMetaString>map("getMessageId", messageInformation -> messageInformation.getMessageId()).get()));
					return _thenArg
						.mapSingleToItem(item -> MapperMaths.<String, String, String>add(item.<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString == null ? null : _fieldWithMetaString.getValue()), MapperS.of(reportingTimestampRule.evaluate(ReportableEvent.get())).map("to-string", Object::toString)));
				}).get();
			
			return messageID;
		}
	}
}
