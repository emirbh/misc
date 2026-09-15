package drr.regulation.asic.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import drr.regulation.asic.rewrite.margin.labels.ASICMarginLabelProvider;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.margin.collateral.reports.ActionTypeRule;
import drr.regulation.common.margin.collateral.reports.CollateralPortfolioIndicatorRule;
import drr.regulation.common.margin.collateral.reports.CollateralTimestampRule;
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
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.margin.party.reports.Counterparty1Rule;
import drr.regulation.common.margin.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.margin.party.reports.Counterparty2Rule;
import drr.regulation.common.margin.party.reports.ReportSubmittingEntityIDRule;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.asic.rewrite.margin", body="ASIC", corpusList={"Margin"})
@RuneLabelProvider(labelProvider=ASICMarginLabelProvider.class)
@ImplementedBy(ASICMarginReportFunction.ASICMarginReportFunctionDefault.class)
public abstract class ASICMarginReportFunction implements ReportFunction<CollateralReportInstruction, ASICMarginReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected CollateralTimestampRule collateralTimestampRule;
	@Inject protected CollateralisationCategoryRule collateralisationCategoryRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CurrencyOfExcessCollateralCollectedRule currencyOfExcessCollateralCollectedRule;
	@Inject protected CurrencyOfTheExcessCollateralPostedRule currencyOfTheExcessCollateralPostedRule;
	@Inject protected ExecutionAgentOfCounterparty1Rule executionAgentOfCounterparty1Rule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected InitialMarginCollectedByCounterparty1CurrencyRule initialMarginCollectedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginCollectedByCounterparty1PostHaircutRule initialMarginCollectedByCounterparty1PostHaircutRule;
	@Inject protected InitialMarginCollectedByCounterparty1PreHaircutRule initialMarginCollectedByCounterparty1PreHaircutRule;
	@Inject protected InitialMarginPostedByCounterparty1CurrencyRule initialMarginPostedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PostHaircutRule initialMarginPostedByTheCounterparty1PostHaircutRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PreHaircutRule initialMarginPostedByTheCounterparty1PreHaircutRule;
	@Inject protected PortfolioContainingNonReportedComponentIndicatorRule portfolioContainingNonReportedComponentIndicatorRule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingEntityRule reportingEntityRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SmallScaleBuySideEntityIndicatorRule smallScaleBuySideEntityIndicatorRule;
	@Inject protected TechnicalRecordIdRule technicalRecordIdRule;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;
	@Inject protected VariationMarginCollectedByCounterparty1CurrencyRule variationMarginCollectedByCounterparty1CurrencyRule;
	@Inject protected VariationMarginCollectedByTheCounterparty1PreHaircutRule variationMarginCollectedByTheCounterparty1PreHaircutRule;
	@Inject protected VariationMarginPostedByCounterparty1CurrencyRule variationMarginPostedByCounterparty1CurrencyRule;
	@Inject protected VariationMarginPostedByTheCounterparty1PreHaircutRule variationMarginPostedByTheCounterparty1PreHaircutRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ASICMarginReport evaluate(CollateralReportInstruction input) {
		ASICMarginReport.ASICMarginReportBuilder outputBuilder = doEvaluate(input);
		
		final ASICMarginReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(ASICMarginReport.class, output);
		}
		
		return output;
	}

	protected abstract ASICMarginReport.ASICMarginReportBuilder doEvaluate(CollateralReportInstruction input);

	public static class ASICMarginReportFunctionDefault extends ASICMarginReportFunction {
		@Override
		protected ASICMarginReport.ASICMarginReportBuilder doEvaluate(CollateralReportInstruction input) {
			ASICMarginReport.ASICMarginReportBuilder output = ASICMarginReport.builder();
			return assignOutput(output, input);
		}
		
		protected ASICMarginReport.ASICMarginReportBuilder assignOutput(ASICMarginReport.ASICMarginReportBuilder output, CollateralReportInstruction input) {
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2IdentifierType(counterparty2IdentifierTypeRule.evaluate(input));
			
			output
				.setCounterparty2OverriddenAsString(counterparty2Rule.evaluate(input));
			
			output
				.setCollateralPortfolioIndicator(collateralPortfolioIndicatorRule.evaluate(input));
			
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
				.setVariationMarginCollectedByCounterparty1Currency(variationMarginCollectedByCounterparty1CurrencyRule.evaluate(input));
			
			output
				.setCurrencyOfTheExcessCollateralPosted(currencyOfTheExcessCollateralPostedRule.evaluate(input));
			
			output
				.setCurrencyOfTheExcessCollateralCollected(currencyOfExcessCollateralCollectedRule.evaluate(input));
			
			output
				.setCollateralTimestamp(collateralTimestampRule.evaluate(input));
			
			output
				.setVariationMarginCollateralPortfolioCode(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setActionType(actionTypeRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(uniqueTransactionIdentifierProprietaryRule.evaluate(input));
			
			output
				.setReportingEntity(reportingEntityRule.evaluate(input));
			
			output
				.setSmallScaleBuySideEntityIndicator(smallScaleBuySideEntityIndicatorRule.evaluate(input));
			
			output
				.setPortfolioContainingNonReportedComponentIndicator(portfolioContainingNonReportedComponentIndicatorRule.evaluate(input));
			
			output
				.setTechnicalRecordId(technicalRecordIdRule.evaluate(input));
			
			output
				.setExecutionAgentOfCounterparty1(executionAgentOfCounterparty1Rule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
