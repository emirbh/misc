package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.labels.Project_CftcPart45TradeReportToDtccRdsHarmonizedLabelProvider;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import iso20022.dtcc.rds.harmonized.Document;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Project_CftcPart45TradeReportToDtccRdsHarmonizedLabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_CftcPart45TradeReportToDtccRdsHarmonized.Project_CftcPart45TradeReportToDtccRdsHarmonizedDefault.class)
public abstract class Project_CftcPart45TradeReportToDtccRdsHarmonized implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_SubmissionCore create_SubmissionCore;
	@Inject protected Create_SubmissionCore_Part45 create_SubmissionCore_Part45;
	@Inject protected Create_SubmissionHarmonizedData create_SubmissionHarmonizedData;
	@Inject protected Create_SubmissionHarmonizedData_Part45 create_SubmissionHarmonizedData_Part45;
	@Inject protected Create_SubmissionHarmonizedRepeatableData create_SubmissionHarmonizedRepeatableData;
	@Inject protected Create_SubmissionHarmonizedRepeatableData_Part45 create_SubmissionHarmonizedRepeatableData_Part45;
	@Inject protected Create_SubmissionHeader create_SubmissionHeader;
	@Inject protected Create_SubmissionSchedules create_SubmissionSchedules;

	/**
	* @param drrReport 
	* @return harmonizedReport 
	*/
	public Document evaluate(CFTCPart45TransactionReport drrReport) {
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

	protected abstract Document.DocumentBuilder doEvaluate(CFTCPart45TransactionReport drrReport);

	public static class Project_CftcPart45TradeReportToDtccRdsHarmonizedDefault extends Project_CftcPart45TradeReportToDtccRdsHarmonized {
		@Override
		protected Document.DocumentBuilder doEvaluate(CFTCPart45TransactionReport drrReport) {
			Document.DocumentBuilder harmonizedReport = Document.builder();
			return assignOutput(harmonizedReport, drrReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder harmonizedReport, CFTCPart45TransactionReport drrReport) {
			harmonizedReport
				.getOrCreateSubmission()
				.setHeader(create_SubmissionHeader.evaluate(drrReport));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setCore(create_SubmissionCore_Part45.evaluate(drrReport, create_SubmissionCore.evaluate(drrReport)));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setHarmonizedData(create_SubmissionHarmonizedData_Part45.evaluate(drrReport, create_SubmissionHarmonizedData.evaluate(drrReport)));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setHarmonizedRepeatableData(create_SubmissionHarmonizedRepeatableData_Part45.evaluate(drrReport, create_SubmissionHarmonizedRepeatableData.evaluate(drrReport)));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setSchedules(create_SubmissionSchedules.evaluate(drrReport));
			
			return Optional.ofNullable(harmonizedReport)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
