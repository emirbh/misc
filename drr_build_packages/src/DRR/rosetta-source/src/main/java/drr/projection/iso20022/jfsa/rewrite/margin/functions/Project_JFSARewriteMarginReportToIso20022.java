package drr.projection.iso20022.jfsa.rewrite.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.iso20022.jfsa.rewrite.margin.labels.Project_JFSARewriteMarginReportToIso20022LabelProvider;
import drr.regulation.jfsa.rewrite.margin.JFSAMarginReport;
import drr.standards.iso.MarginActionEnum;
import iso20022.auth108.jfsa.Document;
import iso20022.auth108.jfsa.MarginReportData9__1;
import iso20022.auth108.jfsa.TradeReport34Choice__1;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@RuneLabelProvider(labelProvider=Project_JFSARewriteMarginReportToIso20022LabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_JFSARewriteMarginReportToIso20022.Project_JFSARewriteMarginReportToIso20022Default.class)
public abstract class Project_JFSARewriteMarginReportToIso20022 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_MarginReportData create_MarginReportData;

	/**
	* @param marginReport 
	* @return iso20022Report 
	*/
	public Document evaluate(JFSAMarginReport marginReport) {
		Document.DocumentBuilder iso20022ReportBuilder = doEvaluate(marginReport);
		
		final Document iso20022Report;
		if (iso20022ReportBuilder == null) {
			iso20022Report = null;
		} else {
			iso20022Report = iso20022ReportBuilder.build();
			objectValidator.validate(Document.class, iso20022Report);
		}
		
		return iso20022Report;
	}

	protected abstract Document.DocumentBuilder doEvaluate(JFSAMarginReport marginReport);

	public static class Project_JFSARewriteMarginReportToIso20022Default extends Project_JFSARewriteMarginReportToIso20022 {
		@Override
		protected Document.DocumentBuilder doEvaluate(JFSAMarginReport marginReport) {
			Document.DocumentBuilder iso20022Report = Document.builder();
			return assignOutput(iso20022Report, marginReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder iso20022Report, JFSAMarginReport marginReport) {
			MarginReportData9__1 ifThenElseResult = null;
			if (areEqual(MapperS.of(marginReport).<MarginActionEnum>map("getActionType", jFSAMarginReport -> jFSAMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = create_MarginReportData.evaluate(marginReport);
			}
			final TradeReport34Choice__1 tradeReport34Choice__1 = TradeReport34Choice__1.builder()
				.setMrgnUpd(ifThenElseResult)
				.build();
			iso20022Report
				.getOrCreateDerivsTradMrgnDataRpt()
				.getOrCreateTradData()
				.setRpt((tradeReport34Choice__1 == null ? Collections.<TradeReport34Choice__1>emptyList() : Collections.singletonList(tradeReport34Choice__1)));
			
			return Optional.ofNullable(iso20022Report)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
