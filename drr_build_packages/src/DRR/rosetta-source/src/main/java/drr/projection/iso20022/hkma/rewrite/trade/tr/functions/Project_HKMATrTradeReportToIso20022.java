package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.iso20022.hkma.rewrite.trade.tr.labels.Project_HKMATrTradeReportToIso20022LabelProvider;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.Document;
import iso20022.auth030.hkma.tr.TradeReport33Choice__1;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@RuneLabelProvider(labelProvider=Project_HKMATrTradeReportToIso20022LabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_HKMATrTradeReportToIso20022.Project_HKMATrTradeReportToIso20022Default.class)
public abstract class Project_HKMATrTradeReportToIso20022 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeReport33Choice__1 create_TradeReport33Choice__1;
	@Inject protected Create_TradeReportHeader create_TradeReportHeader;

	/**
	* @param drrReport 
	* @return iso20022Report 
	*/
	public Document evaluate(HKMATransactionReport drrReport) {
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

	protected abstract Document.DocumentBuilder doEvaluate(HKMATransactionReport drrReport);

	public static class Project_HKMATrTradeReportToIso20022Default extends Project_HKMATrTradeReportToIso20022 {
		@Override
		protected Document.DocumentBuilder doEvaluate(HKMATransactionReport drrReport) {
			Document.DocumentBuilder iso20022Report = Document.builder();
			return assignOutput(iso20022Report, drrReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder iso20022Report, HKMATransactionReport drrReport) {
			iso20022Report
				.getOrCreateDerivsTradRpt()
				.setRptHdr(create_TradeReportHeader.evaluate());
			
			final TradeReport33Choice__1 tradeReport33Choice__1 = create_TradeReport33Choice__1.evaluate(drrReport);
			iso20022Report
				.getOrCreateDerivsTradRpt()
				.getOrCreateTradData()
				.addRpt((tradeReport33Choice__1 == null ? Collections.<TradeReport33Choice__1>emptyList() : Collections.singletonList(tradeReport33Choice__1)));
			
			return Optional.ofNullable(iso20022Report)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
