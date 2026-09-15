package drr.regulation.csa.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.margin.collateral.reports.ActionTypeRule;
import drr.regulation.common.margin.collateral.reports.CollateralisationCategoryRule;
import drr.regulation.common.margin.collateral.reports.CurrencyOfExcessCollateralCollectedRule;
import drr.regulation.common.margin.collateral.reports.CurrencyOfTheExcessCollateralPostedRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollateralPortfolioCodeRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollectedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollectedByCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollectedByCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginPostedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginPostedByTheCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginPostedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollateralPortfolioCodeRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByTheCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByTheCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.datetime.reports.EventTimestampRule;
import drr.regulation.common.margin.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.margin.party.reports.Counterparty1Rule;
import drr.regulation.common.margin.party.reports.Counterparty2Rule;
import drr.regulation.common.margin.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.csa.rewrite.margin.CSAMarginReport;
import drr.regulation.csa.rewrite.margin.labels.CSAMarginLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.csa.rewrite.margin", body="CSA", corpusList={"Margin"})
@RuneLabelProvider(labelProvider=CSAMarginLabelProvider.class)
@ImplementedBy(CSAMarginReportFunction.CSAMarginReportFunctionDefault.class)
public abstract class CSAMarginReportFunction implements ReportFunction<CollateralReportInstruction, CSAMarginReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected CollateralisationCategoryRule collateralisationCategoryRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierSourceRule counterparty2IdentifierSourceRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CurrencyOfExcessCollateralCollectedRule currencyOfExcessCollateralCollectedRule;
	@Inject protected CurrencyOfTheExcessCollateralPostedRule currencyOfTheExcessCollateralPostedRule;
	@Inject protected DTCC_MessageIDRule dTCC_MessageIDRule;
	@Inject protected DTCC_MessageTypeRule dTCC_MessageTypeRule;
	@Inject protected DTCC_SubmittingPartyIDTypeRule dTCC_SubmittingPartyIDTypeRule;
	@Inject protected DTCC_TradeParty1IDTypeRule dTCC_TradeParty1IDTypeRule;
	@Inject protected DTCC_TradeParty1ReportingDestinationRule dTCC_TradeParty1ReportingDestinationRule;
	@Inject protected DTCC_USIIDRule dTCC_USIIDRule;
	@Inject protected DTCC_VersionRule dTCC_VersionRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected InitialMarginCollectedByCounterparty1CurrencyRule initialMarginCollectedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginCollectedByCounterparty1PostHaircutRule initialMarginCollectedByCounterparty1PostHaircutRule;
	@Inject protected InitialMarginCollectedByCounterparty1PreHaircutRule initialMarginCollectedByCounterparty1PreHaircutRule;
	@Inject protected InitialMarginPostedByCounterparty1CurrencyRule initialMarginPostedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PostHaircutRule initialMarginPostedByTheCounterparty1PostHaircutRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PreHaircutRule initialMarginPostedByTheCounterparty1PreHaircutRule;
	@Inject protected PortfolioContainingNonReportableComponentIndicatorRule portfolioContainingNonReportableComponentIndicatorRule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;
	@Inject protected VariationMarginCollectedByCounterparty1CurrencyRule variationMarginCollectedByCounterparty1CurrencyRule;
	@Inject protected VariationMarginCollectedByTheCounterparty1PostHaircutRule variationMarginCollectedByTheCounterparty1PostHaircutRule;
	@Inject protected VariationMarginCollectedByTheCounterparty1PreHaircutRule variationMarginCollectedByTheCounterparty1PreHaircutRule;
	@Inject protected VariationMarginPostedByCounterparty1CurrencyRule variationMarginPostedByCounterparty1CurrencyRule;
	@Inject protected VariationMarginPostedByTheCounterparty1PostHaircutRule variationMarginPostedByTheCounterparty1PostHaircutRule;
	@Inject protected VariationMarginPostedByTheCounterparty1PreHaircutRule variationMarginPostedByTheCounterparty1PreHaircutRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CSAMarginReport evaluate(CollateralReportInstruction input) {
		CSAMarginReport.CSAMarginReportBuilder outputBuilder = doEvaluate(input);
		
		final CSAMarginReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CSAMarginReport.class, output);
		}
		
		return output;
	}

	protected abstract CSAMarginReport.CSAMarginReportBuilder doEvaluate(CollateralReportInstruction input);

	public static class CSAMarginReportFunctionDefault extends CSAMarginReportFunction {
		@Override
		protected CSAMarginReport.CSAMarginReportBuilder doEvaluate(CollateralReportInstruction input) {
			CSAMarginReport.CSAMarginReportBuilder output = CSAMarginReport.builder();
			return assignOutput(output, input);
		}
		
		protected CSAMarginReport.CSAMarginReportBuilder assignOutput(CSAMarginReport.CSAMarginReportBuilder output, CollateralReportInstruction input) {
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2OverriddenAsString(counterparty2Rule.evaluate(input));
			
			output
				.setUti(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setCollateralisationCategory(collateralisationCategoryRule.evaluate(input));
			
			output
				.setInitialMarginPostedByTheCounterparty1PreHaircut(initialMarginPostedByTheCounterparty1PreHaircutRule.evaluate(input));
			
			output
				.setInitialMarginPostedByTheCounterparty1PostHaircut(initialMarginPostedByTheCounterparty1PostHaircutRule.evaluate(input));
			
			output
				.setInitialMarginPostedByCounterparty1Currency(initialMarginPostedByCounterparty1CurrencyRule.evaluate(input));
			
			output
				.setVariationMarginPostedByTheCounterparty1PreHaircut(variationMarginPostedByTheCounterparty1PreHaircutRule.evaluate(input));
			
			output
				.setVariationMarginPostedByTheCounterparty1PostHaircut(variationMarginPostedByTheCounterparty1PostHaircutRule.evaluate(input));
			
			output
				.setVariationMarginPostedByCounterparty1Currency(variationMarginPostedByCounterparty1CurrencyRule.evaluate(input));
			
			output
				.setInitialMarginCollectedByCounterparty1PreHaircut(initialMarginCollectedByCounterparty1PreHaircutRule.evaluate(input));
			
			output
				.setInitialMarginCollectedByCounterparty1PostHaircut(initialMarginCollectedByCounterparty1PostHaircutRule.evaluate(input));
			
			output
				.setInitialMarginCollectedByCounterparty1Currency(initialMarginCollectedByCounterparty1CurrencyRule.evaluate(input));
			
			output
				.setVariationMarginCollectedByTheCounterparty1PreHaircut(variationMarginCollectedByTheCounterparty1PreHaircutRule.evaluate(input));
			
			output
				.setVariationMarginCollectedByTheCounterparty1PostHaircut(variationMarginCollectedByTheCounterparty1PostHaircutRule.evaluate(input));
			
			output
				.setVariationMarginCollectedByCounterparty1Currency(variationMarginCollectedByCounterparty1CurrencyRule.evaluate(input));
			
			output
				.setCurrencyOfTheExcessCollateralPosted(currencyOfTheExcessCollateralPostedRule.evaluate(input));
			
			output
				.setCurrencyOfTheExcessCollateralCollected(currencyOfExcessCollateralCollectedRule.evaluate(input));
			
			output
				.setVariationMarginCollateralPortfolioCode(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setActionTypeOverriddenAsMarginActionEnum(actionTypeRule.evaluate(input));
			
			output
				.setEventTimestampOverriddenAsZonedDateTime(eventTimestampRule.evaluate(input));
			
			output
				.setCounterparty2IdentifierSource(counterparty2IdentifierSourceRule.evaluate(input));
			
			output
				.setPortfolioContainingNonReportableComponentIndicator(MapperC.of(portfolioContainingNonReportableComponentIndicatorRule.evaluate(input)).get());
			
			output
				.setTradeParty1IDType(dTCC_TradeParty1IDTypeRule.evaluate(input));
			
			output
				.setSubmittingPartyIDType(dTCC_SubmittingPartyIDTypeRule.evaluate(input));
			
			output
				.setUsiID(dTCC_USIIDRule.evaluate(input));
			
			output
				.setTradeParty1ReportingDestination(dTCC_TradeParty1ReportingDestinationRule.evaluate(input));
			
			output
				.setMessageID(dTCC_MessageIDRule.evaluate(input));
			
			output
				.setMessageType(dTCC_MessageTypeRule.evaluate(input));
			
			output
				.setVersion(dTCC_VersionRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
