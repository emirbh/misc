package drr.ingest.fpml.recordkeeping.message.functions;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.transform.Ingest;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.ingest.fpml.recordkeeping.message.labels.Ingest_FpmlRecordKeepingToReportableEventLabelProvider;
import drr.ingest.fpml.recordkeeping.reportableinfo.functions.MapTradeHeaderToReportableInformation;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.doc.Document;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.recordkeeping.processes.NonpublicExecutionReport;
import fpml.consolidated.shared.Party;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Ingest_FpmlRecordKeepingToReportableEventLabelProvider.class)
@Ingest(format = SerializationFormat.XML)
@ImplementedBy(Ingest_FpmlRecordKeepingToReportableEvent.Ingest_FpmlRecordKeepingToReportableEventDefault.class)
public abstract class Ingest_FpmlRecordKeepingToReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetTradeHeaderForNonpublicExecutionReport getTradeHeaderForNonpublicExecutionReport;
	@Inject protected MapNonpublicExecutionReportToWorkflowStep mapNonpublicExecutionReportToWorkflowStep;
	@Inject protected MapTradeHeaderToReportableInformation mapTradeHeaderToReportableInformation;

	/**
	* @param fpmlDocument 
	* @return reportableEvent 
	*/
	public ReportableEvent evaluate(Document fpmlDocument) {
		ReportableEvent.ReportableEventBuilder reportableEventBuilder = doEvaluate(fpmlDocument);
		
		final ReportableEvent reportableEvent;
		if (reportableEventBuilder == null) {
			reportableEvent = null;
		} else {
			reportableEvent = reportableEventBuilder.build();
			objectValidator.validate(ReportableEvent.class, reportableEvent);
		}
		
		return reportableEvent;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(Document fpmlDocument);

	public static class Ingest_FpmlRecordKeepingToReportableEventDefault extends Ingest_FpmlRecordKeepingToReportableEvent {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(Document fpmlDocument) {
			ReportableEvent.ReportableEventBuilder reportableEvent = ReportableEvent.builder();
			return assignOutput(reportableEvent, fpmlDocument);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder reportableEvent, Document fpmlDocument) {
			final WorkflowStep ifThenElseResult0;
			if (fpmlDocument == null) {
				ifThenElseResult0 = null;
			} else if (fpmlDocument instanceof NonpublicExecutionReport) {
				final NonpublicExecutionReport nonpublicExecutionReport0 = (NonpublicExecutionReport) fpmlDocument;
				ifThenElseResult0 = mapNonpublicExecutionReportToWorkflowStep.evaluate(nonpublicExecutionReport0);
			} else {
				ifThenElseResult0 = null;
			}
			reportableEvent
				.setOriginatingWorkflowStep(ifThenElseResult0);
			
			final ReportableInformation ifThenElseResult1;
			if (fpmlDocument == null) {
				ifThenElseResult1 = null;
			} else if (fpmlDocument instanceof NonpublicExecutionReport) {
				final NonpublicExecutionReport nonpublicExecutionReport1 = (NonpublicExecutionReport) fpmlDocument;
				ifThenElseResult1 = mapTradeHeaderToReportableInformation.evaluate(getTradeHeaderForNonpublicExecutionReport.evaluate(nonpublicExecutionReport1), MapperS.of(nonpublicExecutionReport1).<Withdrawal>map("getWithdrawal", nonpublicExecutionReport -> nonpublicExecutionReport.getWithdrawal()).get(), MapperS.of(nonpublicExecutionReport1).<Party>mapC("getParty", nonpublicExecutionReport -> nonpublicExecutionReport.getParty()).getMulti(), MapperS.of(nonpublicExecutionReport1).<BasicQuotation>mapC("getQuote", nonpublicExecutionReport -> nonpublicExecutionReport.getQuote()).getMulti(), MapperS.of(nonpublicExecutionReport1).<RequestMessageHeader>map("getHeader", nonpublicExecutionReport -> nonpublicExecutionReport.getHeader()).get());
			} else {
				ifThenElseResult1 = null;
			}
			reportableEvent
				.setReportableInformation(ifThenElseResult1);
			
			return Optional.ofNullable(reportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
