package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.labels.Project_CftcPart43TradeReportToDtccRdsHarmonizedLabelProvider;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import iso20022.dtcc.rds.harmonized.Document;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Project_CftcPart43TradeReportToDtccRdsHarmonizedLabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_CftcPart43TradeReportToDtccRdsHarmonized.Project_CftcPart43TradeReportToDtccRdsHarmonizedDefault.class)
public abstract class Project_CftcPart43TradeReportToDtccRdsHarmonized implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_SubmissionCore create_SubmissionCore;
	@Inject protected Create_SubmissionCore_Part43 create_SubmissionCore_Part43;
	@Inject protected Create_SubmissionHarmonizedData create_SubmissionHarmonizedData;
	@Inject protected Create_SubmissionHarmonizedData_Part43 create_SubmissionHarmonizedData_Part43;
	@Inject protected Create_SubmissionHarmonizedRepeatableData create_SubmissionHarmonizedRepeatableData;
	@Inject protected Create_SubmissionHeader create_SubmissionHeader;
	@Inject protected Create_SubmissionSchedules create_SubmissionSchedules;

	/**
	* @param drrReport 
	* @return harmonizedReport 
	*/
	public Document evaluate(CFTCPart43TransactionReport drrReport) {
		Document.DocumentBuilder harmonizedReportBuilder = doEvaluate(drrReport);
		
		final Document harmonizedReport;
		if (harmonizedReportBuilder == null) {
			harmonizedReport = null;
		} else {
			harmonizedReport = harmonizedReportBuilder.build();
			objectValidator.validate(Document.class, harmonizedReport);
		}
		
		return harmonizedReport;
	}

	protected abstract Document.DocumentBuilder doEvaluate(CFTCPart43TransactionReport drrReport);

	public static class Project_CftcPart43TradeReportToDtccRdsHarmonizedDefault extends Project_CftcPart43TradeReportToDtccRdsHarmonized {
		@Override
		protected Document.DocumentBuilder doEvaluate(CFTCPart43TransactionReport drrReport) {
			Document.DocumentBuilder harmonizedReport = Document.builder();
			return assignOutput(harmonizedReport, drrReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder harmonizedReport, CFTCPart43TransactionReport drrReport) {
			harmonizedReport
				.getOrCreateSubmission()
				.setHeader(create_SubmissionHeader.evaluate(drrReport));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setCore(create_SubmissionCore_Part43.evaluate(drrReport, create_SubmissionCore.evaluate(drrReport)));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setHarmonizedData(create_SubmissionHarmonizedData_Part43.evaluate(drrReport, create_SubmissionHarmonizedData.evaluate(drrReport)));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setHarmonizedRepeatableData(create_SubmissionHarmonizedRepeatableData.evaluate(drrReport));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setSchedules(create_SubmissionSchedules.evaluate(drrReport));
			
			return Optional.ofNullable(harmonizedReport)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
