package drr.projection.dtcc.rds.harmonized.cftc.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.dtcc.rds.harmonized.cftc.rewrite.valuation.labels.Project_CFTCValuationReportToDtccRdsHarmonizedLabelProvider;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import iso20022.dtcc.rds.harmonized.Document;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Project_CFTCValuationReportToDtccRdsHarmonizedLabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_CFTCValuationReportToDtccRdsHarmonized.Project_CFTCValuationReportToDtccRdsHarmonizedDefault.class)
public abstract class Project_CFTCValuationReportToDtccRdsHarmonized implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_SubmissionCore create_SubmissionCore;
	@Inject protected Create_SubmissionHarmonizedData create_SubmissionHarmonizedData;
	@Inject protected Create_SubmissionHeader create_SubmissionHeader;

	/**
	* @param drrReport 
	* @return harmonizedReport 
	*/
	public Document evaluate(CFTCValuationReport drrReport) {
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

	protected abstract Document.DocumentBuilder doEvaluate(CFTCValuationReport drrReport);

	public static class Project_CFTCValuationReportToDtccRdsHarmonizedDefault extends Project_CFTCValuationReportToDtccRdsHarmonized {
		@Override
		protected Document.DocumentBuilder doEvaluate(CFTCValuationReport drrReport) {
			Document.DocumentBuilder harmonizedReport = Document.builder();
			return assignOutput(harmonizedReport, drrReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder harmonizedReport, CFTCValuationReport drrReport) {
			harmonizedReport
				.getOrCreateSubmission()
				.setHeader(create_SubmissionHeader.evaluate(drrReport));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setCore(create_SubmissionCore.evaluate(drrReport));
			
			harmonizedReport
				.getOrCreateSubmission()
				.setHarmonizedData(create_SubmissionHarmonizedData.evaluate(drrReport));
			
			return Optional.ofNullable(harmonizedReport)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
