package drr.projection.iso20022.jfsa.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.iso20022.jfsa.rewrite.valuation.labels.Project_JFSARewriteValuationReportToIso20022LabelProvider;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import iso20022.auth030.jfsa.Document;
import iso20022.auth030.jfsa.TradeReport33Choice__1;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Project_JFSARewriteValuationReportToIso20022LabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_JFSARewriteValuationReportToIso20022.Project_JFSARewriteValuationReportToIso20022Default.class)
public abstract class Project_JFSARewriteValuationReportToIso20022 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeReport33Choice__1 create_TradeReport33Choice__1;
	@Inject protected Create_TradeReportHeader create_TradeReportHeader;

	/**
	* @param drrReport 
	* @return iso20022Report 
	*/
	public Document evaluate(JFSAValuationReport drrReport) {
		Document.DocumentBuilder iso20022ReportBuilder = doEvaluate(drrReport);
		
		final Document iso20022Report;
		if (iso20022ReportBuilder == null) {
			iso20022Report = null;
		} else {
			iso20022Report = iso20022ReportBuilder.build();
			objectValidator.validate(Document.class, iso20022Report);
		}
		
		return iso20022Report;
	}

	protected abstract Document.DocumentBuilder doEvaluate(JFSAValuationReport drrReport);

	public static class Project_JFSARewriteValuationReportToIso20022Default extends Project_JFSARewriteValuationReportToIso20022 {
		@Override
		protected Document.DocumentBuilder doEvaluate(JFSAValuationReport drrReport) {
			Document.DocumentBuilder iso20022Report = Document.builder();
			return assignOutput(iso20022Report, drrReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder iso20022Report, JFSAValuationReport drrReport) {
			iso20022Report
				.getOrCreateDerivsTradRpt()
				.setRptHdr(create_TradeReportHeader.evaluate(drrReport));
			
			final TradeReport33Choice__1 tradeReport33Choice__1 = create_TradeReport33Choice__1.evaluate(drrReport);
			iso20022Report
				.getOrCreateDerivsTradRpt()
				.getOrCreateTradData()
				.setRpt((tradeReport33Choice__1 == null ? Collections.<TradeReport33Choice__1>emptyList() : Collections.singletonList(tradeReport33Choice__1)));
			
			return Optional.ofNullable(iso20022Report)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
