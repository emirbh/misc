package drr.projection.iso20022.esma.emir.refit.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import iso20022.auth108.esma.CollateralPortfolioCode5Choice__1;
import iso20022.auth108.esma.CollateralisationType3Code__1;
import iso20022.auth108.esma.MarginCollateralReport4__1;
import iso20022.auth108.esma.MarginReportData7__1;
import iso20022.auth108.esma.NotApplicable1Code;
import iso20022.auth108.esma.PortfolioCode3Choice;
import iso20022.auth108.esma.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_MarginReportData.Create_MarginReportDataDefault.class)
public abstract class Create_MarginReportData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CounterpartySpecificData create_CounterpartySpecificData;
	@Inject protected Create_PostedMarginReport create_PostedMarginReport;
	@Inject protected Create_ReceivedMarginReport create_ReceivedMarginReport;

	/**
	* @param marginReport 
	* @return details 
	*/
	public MarginReportData7__1 evaluate(ESMAEMIRMarginReport marginReport) {
		MarginReportData7__1.MarginReportData7__1Builder detailsBuilder = doEvaluate(marginReport);
		
		final MarginReportData7__1 details;
		if (detailsBuilder == null) {
			details = null;
		} else {
			details = detailsBuilder.build();
			objectValidator.validate(MarginReportData7__1.class, details);
		}
		
		return details;
	}

	protected abstract MarginReportData7__1.MarginReportData7__1Builder doEvaluate(ESMAEMIRMarginReport marginReport);

	public static class Create_MarginReportDataDefault extends Create_MarginReportData {
		@Override
		protected MarginReportData7__1.MarginReportData7__1Builder doEvaluate(ESMAEMIRMarginReport marginReport) {
			MarginReportData7__1.MarginReportData7__1Builder details = MarginReportData7__1.builder();
			return assignOutput(details, marginReport);
		}
		
		protected MarginReportData7__1.MarginReportData7__1Builder assignOutput(MarginReportData7__1.MarginReportData7__1Builder details, ESMAEMIRMarginReport marginReport) {
			String ifThenElseResult0 = null;
			if (exists(MapperS.of(marginReport).<String>map("getCollateralPortfolioCode", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCollateralPortfolioCode())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(marginReport).<String>map("getCollateralPortfolioCode", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult1 = null;
			if (notExists(MapperS.of(marginReport).<String>map("getCollateralPortfolioCode", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCollateralPortfolioCode())).getOrDefault(false)) {
				ifThenElseResult1 = NotApplicable1Code.NOAP;
			}
			details = toBuilder(MarginReportData7__1.builder()
				.setRptgTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getReportingTimestamp", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getReportingTimestamp()).get())
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(marginReport).<String>map("getUti", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getUti()).get())
					.build())
				.setCtrPtyId(create_CounterpartySpecificData.evaluate(marginReport))
				.setColl(MarginCollateralReport4__1.builder()
					.setCollstnCtgy(MapperS.of(marginReport).<CollateralisationType3Code>map("getCollateralisationCategory", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCollateralisationCategory()).checkedMap("to-enum", e -> CollateralisationType3Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
					.setCollPrtflCd(CollateralPortfolioCode5Choice__1.builder()
						.setPrtfl(PortfolioCode3Choice.builder()
							.setCd(ifThenElseResult0)
							.setNoPrtfl(ifThenElseResult1)
							.build())
						.build())
					.setTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getCollateralTimestamp", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getCollateralTimestamp()).get())
					.build())
				.setPstdMrgnOrColl(create_PostedMarginReport.evaluate(marginReport))
				.setRcvdMrgnOrColl(create_ReceivedMarginReport.evaluate(marginReport))
				.setEvtDt(MapperS.of(marginReport).<Date>map("getEventDate", eSMAEMIRMarginReport -> eSMAEMIRMarginReport.getEventDate()).get())
				.build());
			
			return Optional.ofNullable(details)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
