package drr.projection.iso20022.hkma.rewrite.margin.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import iso20022.auth108.hkma.tr.CollateralPortfolioCode6Choice__1;
import iso20022.auth108.hkma.tr.CollateralisationType3Code__1;
import iso20022.auth108.hkma.tr.GenericIdentification175__4;
import iso20022.auth108.hkma.tr.MarginCollateralReport5__1;
import iso20022.auth108.hkma.tr.MarginPortfolio4;
import iso20022.auth108.hkma.tr.MarginReportData9__1;
import iso20022.auth108.hkma.tr.NotApplicable1Code;
import iso20022.auth108.hkma.tr.PortfolioCode5Choice;
import iso20022.auth108.hkma.tr.PortfolioIdentification3;
import iso20022.auth108.hkma.tr.TechnicalAttributes6__1;
import iso20022.auth108.hkma.tr.UniqueTransactionIdentifier2Choice__1;
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
	public MarginReportData9__1 evaluate(HKMAMarginReport marginReport) {
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

	protected abstract MarginReportData9__1.MarginReportData9__1Builder doEvaluate(HKMAMarginReport marginReport);

	public static class Create_MarginReportDataDefault extends Create_MarginReportData {
		@Override
		protected MarginReportData9__1.MarginReportData9__1Builder doEvaluate(HKMAMarginReport marginReport) {
			MarginReportData9__1.MarginReportData9__1Builder details = MarginReportData9__1.builder();
			return assignOutput(details, marginReport);
		}
		
		protected MarginReportData9__1.MarginReportData9__1Builder assignOutput(MarginReportData9__1.MarginReportData9__1Builder details, HKMAMarginReport marginReport) {
			String ifThenElseResult0 = null;
			if (exists(MapperS.of(marginReport).<String>map("getUti", hKMAMarginReport -> hKMAMarginReport.getUti())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(marginReport).<String>map("getUti", hKMAMarginReport -> hKMAMarginReport.getUti()).get();
			}
			PortfolioIdentification3 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", hKMAMarginReport -> hKMAMarginReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = PortfolioIdentification3.builder()
					.setCd(MapperS.of(marginReport).<String>map("getInitialMarginCollateralPortfolioCode", hKMAMarginReport -> hKMAMarginReport.getInitialMarginCollateralPortfolioCode()).get())
					.setPrtflTxXmptn(MapperS.of(marginReport).<Boolean>map("getPortfolioContainingNonReportableComponentIndicator", hKMAMarginReport -> hKMAMarginReport.getPortfolioContainingNonReportableComponentIndicator()).get())
					.build();
			}
			NotApplicable1Code ifThenElseResult2 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", hKMAMarginReport -> hKMAMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = NotApplicable1Code.NOAP;
			}
			PortfolioIdentification3 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", hKMAMarginReport -> hKMAMarginReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = PortfolioIdentification3.builder()
					.setCd(MapperS.of(marginReport).<String>map("getVariationMarginCollateralPortfolioCode", hKMAMarginReport -> hKMAMarginReport.getVariationMarginCollateralPortfolioCode()).get())
					.setPrtflTxXmptn(MapperS.of(marginReport).<Boolean>map("getPortfolioContainingNonReportableComponentIndicator", hKMAMarginReport -> hKMAMarginReport.getPortfolioContainingNonReportableComponentIndicator()).get())
					.build();
			}
			NotApplicable1Code ifThenElseResult4 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", hKMAMarginReport -> hKMAMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = NotApplicable1Code.NOAP;
			}
			details = toBuilder(MarginReportData9__1.builder()
				.setRptgTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getReportingTimestamp", hKMAMarginReport -> hKMAMarginReport.getReportingTimestamp()).get())
				.setEvtDt(MapperS.of(marginReport).<Date>map("getEventDate", hKMAMarginReport -> hKMAMarginReport.getEventDate()).get())
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(marginReport).<String>map("getUti", hKMAMarginReport -> hKMAMarginReport.getUti()).get())
					.setPrtry(GenericIdentification175__4.builder()
						.setId(ifThenElseResult0)
						.setSchmeNm(null)
						.build())
					.build())
				.setCtrPtyId(create_CounterpartySpecificData.evaluate(marginReport))
				.setColl(MarginCollateralReport5__1.builder()
					.setCollstnCtgy(MapperS.of(marginReport).<CollateralisationType3Code>map("getCollateralisationCategory", hKMAMarginReport -> hKMAMarginReport.getCollateralisationCategory()).checkedMap("to-enum", e -> CollateralisationType3Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
					.setCollPrtflCd(CollateralPortfolioCode6Choice__1.builder()
						.setMrgnPrtflCd(MarginPortfolio4.builder()
							.setInitlMrgnPrtflCd(PortfolioCode5Choice.builder()
								.setPrtfl(ifThenElseResult1)
								.setNoPrtfl(ifThenElseResult2)
								.build())
							.setVartnMrgnPrtflCd(PortfolioCode5Choice.builder()
								.setPrtfl(ifThenElseResult3)
								.setNoPrtfl(ifThenElseResult4)
								.build())
							.build())
						.build())
					.setTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getCollateralTimestamp", hKMAMarginReport -> hKMAMarginReport.getCollateralTimestamp()).get())
					.build())
				.setPstdMrgnOrColl(create_PostedMarginReport.evaluate(marginReport))
				.setRcvdMrgnOrColl(create_ReceivedMarginReport.evaluate(marginReport))
				.setTechAttrbts(TechnicalAttributes6__1.builder()
					.setTechRcrdId(MapperS.of(marginReport).<String>map("getTechnicalRecordId", hKMAMarginReport -> hKMAMarginReport.getTechnicalRecordId()).get())
					.build())
				.build());
			
			return Optional.ofNullable(details)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
