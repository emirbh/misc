package drr.projection.iso20022.mas.rewrite.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import drr.standards.iso.CollateralisationType3Code;
import iso20022.auth108.mas.CollateralPortfolioCode6Choice__1;
import iso20022.auth108.mas.GenericIdentification175__1;
import iso20022.auth108.mas.MarginCollateralReport5__1;
import iso20022.auth108.mas.MarginPortfolio4__1;
import iso20022.auth108.mas.MarginReportData9__1;
import iso20022.auth108.mas.NotApplicable1Code;
import iso20022.auth108.mas.PortfolioCode5Choice__1;
import iso20022.auth108.mas.PortfolioIdentification3__1;
import iso20022.auth108.mas.TechnicalAttributes6__1;
import iso20022.auth108.mas.UniqueTransactionIdentifier2Choice__1;
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
	public MarginReportData9__1 evaluate(MASMarginReport marginReport) {
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

	protected abstract MarginReportData9__1.MarginReportData9__1Builder doEvaluate(MASMarginReport marginReport);

	public static class Create_MarginReportDataDefault extends Create_MarginReportData {
		@Override
		protected MarginReportData9__1.MarginReportData9__1Builder doEvaluate(MASMarginReport marginReport) {
			MarginReportData9__1.MarginReportData9__1Builder details = MarginReportData9__1.builder();
			return assignOutput(details, marginReport);
		}
		
		protected MarginReportData9__1.MarginReportData9__1Builder assignOutput(MarginReportData9__1.MarginReportData9__1Builder details, MASMarginReport marginReport) {
			String ifThenElseResult0 = null;
			if (exists(MapperS.of(marginReport).<String>map("getUniqueTransactionIdentifierProprietary", mASMarginReport -> mASMarginReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(marginReport).<String>map("getUniqueTransactionIdentifierProprietary", mASMarginReport -> mASMarginReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			PortfolioIdentification3__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", mASMarginReport -> mASMarginReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = PortfolioIdentification3__1.builder()
					.setCd(MapperS.of(marginReport).<String>map("getInitialMarginCollateralPortfolioCode", mASMarginReport -> mASMarginReport.getInitialMarginCollateralPortfolioCode()).get())
					.build();
			}
			NotApplicable1Code ifThenElseResult2 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", mASMarginReport -> mASMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = NotApplicable1Code.NOAP;
			}
			PortfolioIdentification3__1 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", mASMarginReport -> mASMarginReport.getCollateralPortfolioIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = PortfolioIdentification3__1.builder()
					.setCd(MapperS.of(marginReport).<String>map("getVariationMarginCollateralPortfolioCode", mASMarginReport -> mASMarginReport.getVariationMarginCollateralPortfolioCode()).get())
					.build();
			}
			NotApplicable1Code ifThenElseResult4 = null;
			if (areEqual(MapperS.of(marginReport).<Boolean>map("getCollateralPortfolioIndicator", mASMarginReport -> mASMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = NotApplicable1Code.NOAP;
			}
			details = toBuilder(MarginReportData9__1.builder()
				.setRptgTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getReportingTimestamp", mASMarginReport -> mASMarginReport.getReportingTimestamp()).get())
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(marginReport).<String>map("getUti", mASMarginReport -> mASMarginReport.getUti()).get())
					.setPrtry(GenericIdentification175__1.builder()
						.setId(ifThenElseResult0)
						.build())
					.build())
				.setCtrPtyId(create_CounterpartySpecificData.evaluate(marginReport))
				.setColl(MarginCollateralReport5__1.builder()
					.setCollstnCtgy(MapperS.of(marginReport).<CollateralisationType3Code>map("getCollateralisationCategory", mASMarginReport -> mASMarginReport.getCollateralisationCategory()).checkedMap("to-enum", e -> iso20022.auth108.mas.CollateralisationType3Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setCollPrtflCd(CollateralPortfolioCode6Choice__1.builder()
						.setMrgnPrtflCd(MarginPortfolio4__1.builder()
							.setInitlMrgnPrtflCd(PortfolioCode5Choice__1.builder()
								.setPrtfl(ifThenElseResult1)
								.setNoPrtfl(ifThenElseResult2)
								.build())
							.setVartnMrgnPrtflCd(PortfolioCode5Choice__1.builder()
								.setPrtfl(ifThenElseResult3)
								.setNoPrtfl(ifThenElseResult4)
								.build())
							.build())
						.build())
					.setTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getEventTimestamp", mASMarginReport -> mASMarginReport.getEventTimestamp()).get())
					.build())
				.setPstdMrgnOrColl(create_PostedMarginReport.evaluate(marginReport))
				.setRcvdMrgnOrColl(create_ReceivedMarginReport.evaluate(marginReport))
				.setTechAttrbts(TechnicalAttributes6__1.builder()
					.setTechRcrdId(MapperS.of(marginReport).<String>map("getTechnicalRecordId", mASMarginReport -> mASMarginReport.getTechnicalRecordId()).get())
					.setRptRctTmStmp(MapperS.of(marginReport).<ZonedDateTime>map("getReportingTimestamp", mASMarginReport -> mASMarginReport.getReportingTimestamp()).get())
					.build())
				.build());
			
			return Optional.ofNullable(details)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
