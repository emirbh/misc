package drr.regulation.mas.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
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
import drr.regulation.common.margin.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.margin.party.reports.Counterparty2Rule;
import drr.regulation.common.margin.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import drr.regulation.mas.rewrite.margin.labels.MASMarginLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.mas.rewrite.margin", body="MAS", corpusList={"Margin"})
@RuneLabelProvider(labelProvider=MASMarginLabelProvider.class)
@ImplementedBy(MASMarginReportFunction.MASMarginReportFunctionDefault.class)
public abstract class MASMarginReportFunction implements ReportFunction<CollateralReportInstruction, MASMarginReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected CollateralPortfolioCodeRule collateralPortfolioCodeRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected CollateralTimestampRule collateralTimestampRule;
	@Inject protected CollateralisationCategoryRule collateralisationCategoryRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CurrencyOfExcessCollateralCollectedRule currencyOfExcessCollateralCollectedRule;
	@Inject protected CurrencyOfTheExcessCollateralPostedRule currencyOfTheExcessCollateralPostedRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected ExcessCollateralCollectedByTheCounterparty1Rule excessCollateralCollectedByTheCounterparty1Rule;
	@Inject protected ExcessCollateralPostedByTheCounterparty1Rule excessCollateralPostedByTheCounterparty1Rule;
	@Inject protected ExecutionAgentOfTheCounterparty1DTCCRule executionAgentOfTheCounterparty1DTCCRule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected InitialMarginCollectedByCounterparty1CurrencyRule initialMarginCollectedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginCollectedByCounterparty1PostHaircutRule initialMarginCollectedByCounterparty1PostHaircutRule;
	@Inject protected InitialMarginCollectedByCounterparty1PreHaircutRule initialMarginCollectedByCounterparty1PreHaircutRule;
	@Inject protected InitialMarginPostedByCounterparty1CurrencyRule initialMarginPostedByCounterparty1CurrencyRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PostHaircutRule initialMarginPostedByTheCounterparty1PostHaircutRule;
	@Inject protected InitialMarginPostedByTheCounterparty1PreHaircutRule initialMarginPostedByTheCounterparty1PreHaircutRule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingSpecifiedPersonRule reportingSpecifiedPersonRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected TechnicalRecordIdRule technicalRecordIdRule;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;
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
	public MASMarginReport evaluate(CollateralReportInstruction input) {
		MASMarginReport.MASMarginReportBuilder outputBuilder = doEvaluate(input);
		
		final MASMarginReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(MASMarginReport.class, output);
		}
		
		return output;
	}

	protected abstract MASMarginReport.MASMarginReportBuilder doEvaluate(CollateralReportInstruction input);

	public static class MASMarginReportFunctionDefault extends MASMarginReportFunction {
		@Override
		protected MASMarginReport.MASMarginReportBuilder doEvaluate(CollateralReportInstruction input) {
			MASMarginReport.MASMarginReportBuilder output = MASMarginReport.builder();
			return assignOutput(output, input);
		}
		
		protected MASMarginReport.MASMarginReportBuilder assignOutput(MASMarginReport.MASMarginReportBuilder output, CollateralReportInstruction input) {
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2IdentifierTypeOverriddenAsBoolean(counterparty2IdentifierTypeRule.evaluate(input));
			
			output
				.setCounterparty2(counterparty2Rule.evaluate(input));
			
			output
				.setCollateralPortfolioCode(collateralPortfolioCodeRule.evaluate(input));
			
			output
				.setCollateralPortfolioIndicator(collateralPortfolioIndicatorRule.evaluate(input));
			
			output
				.setUti(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setCollateralisationCategoryOverriddenAsCollateralisationType3Code(collateralisationCategoryRule.evaluate(input));
			
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
				.setVariationMarginCollateralPortfolioCodeOverriddenAsString(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setActionTypeOverriddenAsMarginActionEnum(actionTypeRule.evaluate(input));
			
			output
				.setEventTimestampOverriddenAsZonedDateTime(eventTimestampRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(uniqueTransactionIdentifierProprietaryRule.evaluate(input));
			
			output
				.setTechnicalRecordId(technicalRecordIdRule.evaluate(input));
			
			output
				.setExecutionAgentOfTheCounterparty1(executionAgentOfTheCounterparty1DTCCRule.evaluate(input));
			
			output
				.setReportingSpecifiedPerson(reportingSpecifiedPersonRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
