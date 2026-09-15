package drr.projection.iso20022.fca.ukemir.refit.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import iso20022.auth108.fca.CollateralPortfolioCode5Choice__1;
import iso20022.auth108.fca.CollateralisationType3Code__1;
import iso20022.auth108.fca.GenericIdentification175__2;
import iso20022.auth108.fca.MarginCollateralReport4__1;
import iso20022.auth108.fca.MarginReportData7__1;
import iso20022.auth108.fca.NotApplicable1Code;
import iso20022.auth108.fca.PortfolioCode3Choice;
import iso20022.auth108.fca.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_MarginUpdateData.Create_MarginUpdateDataDefault.class)
public abstract class Create_MarginUpdateData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CounterpartySpecificData create_CounterpartySpecificData;
	@Inject protected Create_PostedMarginReport create_PostedMarginReport;
	@Inject protected Create_ReceivedMarginReport create_ReceivedMarginReport;
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

	/**
	* @param marginReport 
	* @return details 
	*/
	public MarginReportData7__1 evaluate(FCAUKEMIRMarginReport marginReport) {
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

	protected abstract MarginReportData7__1.MarginReportData7__1Builder doEvaluate(FCAUKEMIRMarginReport marginReport);

	public static class Create_MarginUpdateDataDefault extends Create_MarginUpdateData {
		@Override
		protected MarginReportData7__1.MarginReportData7__1Builder doEvaluate(FCAUKEMIRMarginReport marginReport) {
			MarginReportData7__1.MarginReportData7__1Builder details = MarginReportData7__1.builder();
			return assignOutput(details, marginReport);
		}
		
		protected MarginReportData7__1.MarginReportData7__1Builder assignOutput(MarginReportData7__1.MarginReportData7__1Builder details, FCAUKEMIRMarginReport marginReport) {
			final Boolean _boolean = isMax52UpperCaseAlphanumericText.evaluate(MapperS.of(marginReport).<String>map("getUti", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getUti()).get());
			String ifThenElseResult0 = null;
			if ((_boolean == null ? false : _boolean)) {
				ifThenElseResult0 = MapperS.of(marginReport).<String>map("getUti", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getUti()).get();
			}
			GenericIdentification175__2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(MapperS.of(marginReport).<String>map("getUti", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getUti()).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = GenericIdentification175__2.builder()
					.setId(MapperS.of(marginReport).<String>map("getUti", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getUti()).get())
					.build();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(marginReport).<String>map("getCollateralPortfolioCode", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult3 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = NotApplicable1Code.NOAP;
			}
			details = toBuilder(MarginReportData7__1.builder()
				.setRptgTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getReportingTimestamp", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getReportingTimestamp()).get())
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(ifThenElseResult0)
					.setPrtry(ifThenElseResult1)
					.build())
				.setCtrPtyId(create_CounterpartySpecificData.evaluate(marginReport))
				.setColl(MarginCollateralReport4__1.builder()
					.setCollstnCtgy(MapperS.of(marginReport).<CollateralisationType3Code>map("getCollateralisationCategory", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCollateralisationCategory()).checkedMap("to-enum", e -> CollateralisationType3Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
					.setCollPrtflCd(CollateralPortfolioCode5Choice__1.builder()
						.setPrtfl(PortfolioCode3Choice.builder()
							.setCd(ifThenElseResult2)
							.setNoPrtfl(ifThenElseResult3)
							.build())
						.build())
					.setTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getCollateralTimestamp", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getCollateralTimestamp()).get())
					.build())
				.setPstdMrgnOrColl(create_PostedMarginReport.evaluate(marginReport))
				.setRcvdMrgnOrColl(create_ReceivedMarginReport.evaluate(marginReport))
				.setEvtDt(MapperS.of(marginReport).<Date>map("getEventDate", fCAUKEMIRMarginReport -> fCAUKEMIRMarginReport.getEventDate()).get())
				.build());
			
			return Optional.ofNullable(details)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
