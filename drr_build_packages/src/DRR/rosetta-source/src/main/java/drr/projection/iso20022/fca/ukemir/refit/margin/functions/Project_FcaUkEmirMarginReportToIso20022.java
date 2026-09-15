package drr.projection.iso20022.fca.ukemir.refit.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.transform.Projection;
import com.rosetta.model.lib.transform.SerializationFormat;
import drr.projection.iso20022.fca.ukemir.refit.margin.labels.Project_FcaUkEmirMarginReportToIso20022LabelProvider;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.standards.iso.MarginActionEnum;
import iso20022.auth108.fca.Document;
import iso20022.auth108.fca.MarginReportData7__1;
import iso20022.auth108.fca.MarginReportData7__2;
import iso20022.auth108.fca.TradeReport31Choice__1;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@RuneLabelProvider(labelProvider=Project_FcaUkEmirMarginReportToIso20022LabelProvider.class)
@Projection(format = SerializationFormat.XML)
@ImplementedBy(Project_FcaUkEmirMarginReportToIso20022.Project_FcaUkEmirMarginReportToIso20022Default.class)
public abstract class Project_FcaUkEmirMarginReportToIso20022 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_MarginCorrectionData create_MarginCorrectionData;
	@Inject protected Create_MarginUpdateData create_MarginUpdateData;

	/**
	* @param marginReport 
	* @return iso20022Report 
	*/
	public Document evaluate(FCAUKEMIRMarginReport marginReport) {
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

	protected abstract Document.DocumentBuilder doEvaluate(FCAUKEMIRMarginReport marginReport);

	public static class Project_FcaUkEmirMarginReportToIso20022Default extends Project_FcaUkEmirMarginReportToIso20022 {
		@Override
		protected Document.DocumentBuilder doEvaluate(FCAUKEMIRMarginReport marginReport) {
			Document.DocumentBuilder iso20022Report = Document.builder();
			return assignOutput(iso20022Report, marginReport);
		}
		
		protected Document.DocumentBuilder assignOutput(Document.DocumentBuilder iso20022Report, FCAUKEMIRMarginReport marginReport) {
			MarginReportData7__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(marginReport).<MarginActionEnum>map("getActionType", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = create_MarginUpdateData.evaluate(marginReport);
			}
			MarginReportData7__2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<MarginActionEnum>map("getActionType", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getActionType()), MapperS.of(MarginActionEnum.CORR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = create_MarginCorrectionData.evaluate(marginReport);
			}
			final TradeReport31Choice__1 tradeReport31Choice__1 = TradeReport31Choice__1.builder()
				.setMrgnUpd(ifThenElseResult0)
				.setCrrctn(ifThenElseResult1)
				.build();
			iso20022Report
				.getOrCreateDerivsTradMrgnDataRpt()
				.getOrCreateTradData()
				.setRpt((tradeReport31Choice__1 == null ? Collections.<TradeReport31Choice__1>emptyList() : Collections.singletonList(tradeReport31Choice__1)));
			
			return Optional.ofNullable(iso20022Report)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
