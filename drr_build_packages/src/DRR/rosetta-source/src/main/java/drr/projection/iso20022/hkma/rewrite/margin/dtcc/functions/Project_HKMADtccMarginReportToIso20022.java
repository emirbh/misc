package drr.projection.iso20022.hkma.rewrite.margin.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.iso20022.hkma.rewrite.margin.dtcc.labels.Project_HKMADtccMarginReportToIso20022LabelProvider;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
import drr.standards.iso.MarginActionEnum;
import iso20022.auth108.hkma.dtcc.Document;
import iso20022.auth108.hkma.dtcc.MarginReportData9__1;
import iso20022.auth108.hkma.dtcc.TradeReport34Choice__1;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@RuneLabelProvider(labelProvider=Project_HKMADtccMarginReportToIso20022LabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_HKMADtccMarginReportToIso20022.Project_HKMADtccMarginReportToIso20022Default.class)
public abstract class Project_HKMADtccMarginReportToIso20022 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_MarginReportData create_MarginReportData;

	/**
	* @param marginReport 
	* @return iso20022Report 
	*/
	public Document evaluate(HKMAMarginReport marginReport) {
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

	protected abstract Document.DocumentBuilder doEvaluate(HKMAMarginReport marginReport);

	public static class Project_HKMADtccMarginReportToIso20022Default extends Project_HKMADtccMarginReportToIso20022 {
		@Override
		protected Document.DocumentBuilder doEvaluate(HKMAMarginReport marginReport) {
			Document.DocumentBuilder iso20022Report = Document.builder();
			return assignOutput(iso20022Report, marginReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder iso20022Report, HKMAMarginReport marginReport) {
			MarginReportData9__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(marginReport).<MarginActionEnum>map("getActionType", hKMAMarginReport -> hKMAMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = create_MarginReportData.evaluate(marginReport);
			}
			MarginReportData9__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<MarginActionEnum>map("getActionType", hKMAMarginReport -> hKMAMarginReport.getActionType()), MapperS.of(MarginActionEnum.CORR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = create_MarginReportData.evaluate(marginReport);
			}
			final TradeReport34Choice__1 tradeReport34Choice__1 = TradeReport34Choice__1.builder()
				.setMrgnUpd(ifThenElseResult0)
				.setCrrctn(ifThenElseResult1)
				.build();
			iso20022Report
				.getOrCreateDerivsTradMrgnDataRpt()
				.getOrCreateTradData()
				.addRpt((tradeReport34Choice__1 == null ? Collections.<TradeReport34Choice__1>emptyList() : Collections.singletonList(tradeReport34Choice__1)));
			
			return Optional.ofNullable(iso20022Report)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
