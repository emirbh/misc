package drr.projection.iso20022.jfsa.rewrite.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.margin.JFSAMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import iso20022.auth108.jfsa.CollateralPortfolioCode6Choice__1;
import iso20022.auth108.jfsa.GenericIdentification175__1;
import iso20022.auth108.jfsa.MarginCollateralReport5__1;
import iso20022.auth108.jfsa.MarginPortfolio4__1;
import iso20022.auth108.jfsa.MarginReportData9__1;
import iso20022.auth108.jfsa.NotApplicable1Code;
import iso20022.auth108.jfsa.PortfolioCode5Choice__1;
import iso20022.auth108.jfsa.PortfolioIdentification3__1;
import iso20022.auth108.jfsa.TechnicalAttributes6__1;
import iso20022.auth108.jfsa.UniqueTransactionIdentifier2Choice__1;
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
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

	/**
	* @param marginReport 
	* @return details 
	*/
	public MarginReportData9__1 evaluate(JFSAMarginReport marginReport) {
		MarginReportData9__1.MarginReportData9__1Builder detailsBuilder = doEvaluate(marginReport);
		
		final MarginReportData9__1 details;
		if (detailsBuilder == null) {
			details = null;
		} else {
			details = detailsBuilder.build();
			objectValidator.validate(MarginReportData9__1.class, details);
		}
		
		return details;
	}

	protected abstract MarginReportData9__1.MarginReportData9__1Builder doEvaluate(JFSAMarginReport marginReport);

	public static class Create_MarginReportDataDefault extends Create_MarginReportData {
		@Override
		protected MarginReportData9__1.MarginReportData9__1Builder doEvaluate(JFSAMarginReport marginReport) {
			MarginReportData9__1.MarginReportData9__1Builder details = MarginReportData9__1.builder();
			return assignOutput(details, marginReport);
		}
		
		protected MarginReportData9__1.MarginReportData9__1Builder assignOutput(MarginReportData9__1.MarginReportData9__1Builder details, JFSAMarginReport marginReport) {
			final Boolean _boolean = isMax52UpperCaseAlphanumericText.evaluate(MapperS.of(marginReport).<String>map("getUti", jFSAMarginReport -> jFSAMarginReport.getUti()).get());
			String ifThenElseResult0 = null;
			if ((_boolean == null ? false : _boolean)) {
				ifThenElseResult0 = MapperS.of(marginReport).<String>map("getUti", jFSAMarginReport -> jFSAMarginReport.getUti()).get();
			}
			GenericIdentification175__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(MapperS.of(marginReport).<String>map("getUti", jFSAMarginReport -> jFSAMarginReport.getUti()).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = GenericIdentification175__1.builder()
					.setId(MapperS.of(marginReport).<String>map("getUti", jFSAMarginReport -> jFSAMarginReport.getUti()).get())
					.build();
			}
			String ifThenElseResult2 = null;
			if (exists(MapperS.of(marginReport).<String>map("getInitialMarginCollateralPortfolioCode", jFSAMarginReport -> jFSAMarginReport.getInitialMarginCollateralPortfolioCode())).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(marginReport).<String>map("getInitialMarginCollateralPortfolioCode", jFSAMarginReport -> jFSAMarginReport.getInitialMarginCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult3 = null;
			if (notExists(MapperS.of(marginReport).<String>map("getInitialMarginCollateralPortfolioCode", jFSAMarginReport -> jFSAMarginReport.getInitialMarginCollateralPortfolioCode())).getOrDefault(false)) {
				ifThenElseResult3 = NotApplicable1Code.NOAP;
			}
			String ifThenElseResult4 = null;
			if (exists(MapperS.of(marginReport).<String>map("getVariationMarginCollateralPortfolioCode", jFSAMarginReport -> jFSAMarginReport.getVariationMarginCollateralPortfolioCode())).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(marginReport).<String>map("getVariationMarginCollateralPortfolioCode", jFSAMarginReport -> jFSAMarginReport.getVariationMarginCollateralPortfolioCode()).get();
			}
			NotApplicable1Code ifThenElseResult5 = null;
			if (notExists(MapperS.of(marginReport).<String>map("getVariationMarginCollateralPortfolioCode", jFSAMarginReport -> jFSAMarginReport.getVariationMarginCollateralPortfolioCode())).getOrDefault(false)) {
				ifThenElseResult5 = NotApplicable1Code.NOAP;
			}
			details = toBuilder(MarginReportData9__1.builder()
				.setRptgTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getReportingTimestamp", jFSAMarginReport -> jFSAMarginReport.getReportingTimestamp()).get())
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(ifThenElseResult0)
					.setPrtry(ifThenElseResult1)
					.build())
				.setCtrPtyId(create_CounterpartySpecificData.evaluate(marginReport))
				.setColl(MarginCollateralReport5__1.builder()
					.setCollstnCtgy(MapperS.of(marginReport).<CollateralisationType3Code>map("getCollateralisationCategory", jFSAMarginReport -> jFSAMarginReport.getCollateralisationCategory()).checkedMap("to-enum", e -> iso20022.auth108.jfsa.CollateralisationType3Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setCollPrtflCd(CollateralPortfolioCode6Choice__1.builder()
						.setMrgnPrtflCd(MarginPortfolio4__1.builder()
							.setInitlMrgnPrtflCd(PortfolioCode5Choice__1.builder()
								.setPrtfl(PortfolioIdentification3__1.builder()
									.setCd(ifThenElseResult2)
									.build())
								.setNoPrtfl(ifThenElseResult3)
								.build())
							.setVartnMrgnPrtflCd(PortfolioCode5Choice__1.builder()
								.setPrtfl(PortfolioIdentification3__1.builder()
									.setCd(ifThenElseResult4)
									.build())
								.setNoPrtfl(ifThenElseResult5)
								.build())
							.build())
						.build())
					.setTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getCollateralTimestamp", jFSAMarginReport -> jFSAMarginReport.getCollateralTimestamp()).get())
					.build())
				.setPstdMrgnOrColl(create_PostedMarginReport.evaluate(marginReport))
				.setRcvdMrgnOrColl(create_ReceivedMarginReport.evaluate(marginReport))
				.setTechAttrbts(TechnicalAttributes6__1.builder()
					.setTechRcrdId(MapperS.of(marginReport).<String>map("getTechnicalRecordId", jFSAMarginReport -> jFSAMarginReport.getTechnicalRecordId()).get())
					.build())
				.build());
			
			return Optional.ofNullable(details)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
