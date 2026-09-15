package drr.regulation.fca.ukemir.refit.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.CollateralEnrichmentDataRule;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.margin.collateral.reports.ActionTypeRule;
import drr.regulation.common.margin.collateral.reports.CollateralPortfolioCodeRule;
import drr.regulation.common.margin.collateral.reports.CollateralPortfolioIndicatorRule;
import drr.regulation.common.margin.collateral.reports.CollateralTimestampRule;
import drr.regulation.common.margin.collateral.reports.CollateralisationCategoryRule;
import drr.regulation.common.margin.collateral.reports.CurrencyOfExcessCollateralCollectedRule;
import drr.regulation.common.margin.collateral.reports.CurrencyOfTheExcessCollateralPostedRule;
import drr.regulation.common.margin.collateral.reports.ExcessCollateralCollectedByTheCounterparty1Rule;
import drr.regulation.common.margin.collateral.reports.ExcessCollateralPostedByTheCounterparty1Rule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollateralPortfolioCodeRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollectedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollectedByCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginCollectedByCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginPostedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginPostedByTheCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.InitialMarginPostedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.UTIRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollateralPortfolioCodeRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByTheCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginCollectedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByCounterparty1CurrencyRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByTheCounterparty1PostHaircutRule;
import drr.regulation.common.margin.collateral.reports.VariationMarginPostedByTheCounterparty1PreHaircutRule;
import drr.regulation.common.margin.datetime.reports.EventDateRule;
import drr.regulation.common.margin.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.margin.party.reports.Counterparty1Rule;
import drr.regulation.common.margin.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.margin.party.reports.Counterparty2Rule;
import drr.regulation.common.margin.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import drr.regulation.fca.ukemir.refit.margin.labels.FCAUKEMIRMarginLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.fca.ukemir.refit.margin", body="FCA", corpusList={"UKEMIR", "Margin"})
@RuneLabelProvider(labelProvider=FCAUKEMIRMarginLabelProvider.class)
@ImplementedBy(FCAUKEMIRMarginReportFunction.FCAUKEMIRMarginReportFunctionDefault.class)
public abstract class FCAUKEMIRMarginReportFunction implements ReportFunction<CollateralReportInstruction, FCAUKEMIRMarginReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected CollateralEnrichmentDataRule collateralEnrichmentDataRule;
	@Inject protected CollateralPortfolioCodeRule collateralPortfolioCodeRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected CollateralTimestampRule collateralTimestampRule;
	@Inject protected CollateralisationCategoryRule collateralisationCategoryRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CurrencyOfExcessCollateralCollectedRule currencyOfExcessCollateralCollectedRule;
	@Inject protected CurrencyOfTheExcessCollateralPostedRule currencyOfTheExcessCollateralPostedRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected EventDateRule eventDateRule;
	@Inject protected ExcessCollateralCollectedByTheCounterparty1Rule excessCollateralCollectedByTheCounterparty1Rule;
	@Inject protected ExcessCollateralPostedByTheCounterparty1Rule excessCollateralPostedByTheCounterparty1Rule;
	@Inject protected ExecutionAgentOfCounterparty1Rule executionAgentOfCounterparty1Rule;
	@Inject protected ExecutionAgentOfCounterparty2Rule executionAgentOfCounterparty2Rule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected InitialMarginCollectedByCounterparty1CurrencyRule initialMarginCollectedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginCollectedByCounterparty1PostHaircutRule initialMarginCollectedByCounterparty1PostHaircutRule;
	@Inject protected InitialMarginCollectedByCounterparty1PreHaircutRule initialMarginCollectedByCounterparty1PreHaircutRule;
	@Inject protected InitialMarginPostedByCounterparty1CurrencyRule initialMarginPostedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PostHaircutRule initialMarginPostedByTheCounterparty1PostHaircutRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PreHaircutRule initialMarginPostedByTheCounterparty1PreHaircutRule;
	@Inject protected MICCollateralRule mICCollateralRule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected UTIRule uTIRule;
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
	public FCAUKEMIRMarginReport evaluate(CollateralReportInstruction input) {
		FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder outputBuilder = doEvaluate(input);
		
		final FCAUKEMIRMarginReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(FCAUKEMIRMarginReport.class, output);
		}
		
		return output;
	}

	protected abstract FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder doEvaluate(CollateralReportInstruction input);

	public static class FCAUKEMIRMarginReportFunctionDefault extends FCAUKEMIRMarginReportFunction {
		@Override
		protected FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder doEvaluate(CollateralReportInstruction input) {
			FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder output = FCAUKEMIRMarginReport.builder();
			return assignOutput(output, input);
		}
		
		protected FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder assignOutput(FCAUKEMIRMarginReport.FCAUKEMIRMarginReportBuilder output, CollateralReportInstruction input) {
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2IdentifierType(counterparty2IdentifierTypeRule.evaluate(input));
			
			output
				.setCounterparty2(counterparty2Rule.evaluate(input));
			
			output
				.setCollateralPortfolioCode(collateralPortfolioCodeRule.evaluate(input));
			
			output
				.setCollateralPortfolioIndicator(collateralPortfolioIndicatorRule.evaluate(input));
			
			output
				.setUti(uTIRule.evaluate(input));
			
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
				.setExcessCollateralPostedByTheCounterparty1(excessCollateralPostedByTheCounterparty1Rule.evaluate(input));
			
			output
				.setCurrencyOfTheExcessCollateralPosted(currencyOfTheExcessCollateralPostedRule.evaluate(input));
			
			output
				.setExcessCollateralCollectedByTheCounterparty1(excessCollateralCollectedByTheCounterparty1Rule.evaluate(input));
			
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
				.setEventDateOverriddenAsDate(eventDateRule.evaluate(input));
			
			output
				.setEntityResponsibleForReporting(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setEnrichment(collateralEnrichmentDataRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setMic(mICCollateralRule.evaluate(input));
			
			output
				.setExecutionAgentOfCounterparty1(executionAgentOfCounterparty1Rule.evaluate(input));
			
			output
				.setExecutionAgentOfCounterparty2(executionAgentOfCounterparty2Rule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
