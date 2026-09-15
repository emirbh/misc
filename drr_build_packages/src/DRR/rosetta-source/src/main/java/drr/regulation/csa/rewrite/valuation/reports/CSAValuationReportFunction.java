package drr.regulation.csa.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.dtcc.valuation.reports.DTCC_Comment1Rule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_MessageTypeRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_PrimaryAssetClassRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_SubmittedForPartyRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_SubmittingPartyIDTypeRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty1ExecutionAgentIDRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty1ExecutionAgentIDTypeRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty1IDTypeRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty1ReportingDestinationRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty1TransactionIDRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty2ExecutionAgentIDRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty2ExecutionAgentIDTypeRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_TradeParty2ReportingDestinationRule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_VersionRule;
import drr.regulation.common.valuation.collateral.reports.InitialMarginCollateralPortfolioCodeRule;
import drr.regulation.common.valuation.collateral.reports.VariationMarginCollateralPortfolioCodeRule;
import drr.regulation.common.valuation.datetime.reports.NextFloatingReferenceResetDateLeg1Rule;
import drr.regulation.common.valuation.datetime.reports.NextFloatingReferenceResetDateLeg2Rule;
import drr.regulation.common.valuation.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.valuation.datetime.reports.ValuationTimestampRule;
import drr.regulation.common.valuation.event.reports.ActionTypeRule;
import drr.regulation.common.valuation.event.reports.LevelRule;
import drr.regulation.common.valuation.execution.reports.LastFloatingReferenceResetDateLeg1Rule;
import drr.regulation.common.valuation.execution.reports.LastFloatingReferenceResetDateLeg2Rule;
import drr.regulation.common.valuation.execution.reports.LastFloatingReferenceValueLeg1Rule;
import drr.regulation.common.valuation.execution.reports.LastFloatingReferenceValueLeg2Rule;
import drr.regulation.common.valuation.party.reports.Counterparty1Rule;
import drr.regulation.common.valuation.party.reports.Counterparty2IdentifierSourceRule;
import drr.regulation.common.valuation.party.reports.Counterparty2Rule;
import drr.regulation.common.valuation.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.common.valuation.quantity.reports.DeltaRule;
import drr.regulation.common.valuation.valuation.reports.ValuationAmountRule;
import drr.regulation.common.valuation.valuation.reports.ValuationCurrencyRule;
import drr.regulation.common.valuation.valuation.reports.ValuationMethodRule;
import drr.regulation.csa.rewrite.dtcc.valuation.reports.DTCC_MessageIDRule;
import drr.regulation.csa.rewrite.dtcc.valuation.reports.DTCC_USIIDPrefixRule;
import drr.regulation.csa.rewrite.dtcc.valuation.reports.DTCC_USIIDRule;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
import drr.regulation.csa.rewrite.valuation.labels.CSAValuationLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.csa.rewrite.valuation", body="CSA", corpusList={"Valuation"})
@RuneLabelProvider(labelProvider=CSAValuationLabelProvider.class)
@ImplementedBy(CSAValuationReportFunction.CSAValuationReportFunctionDefault.class)
public abstract class CSAValuationReportFunction implements ReportFunction<ValuationReportInstruction, CSAValuationReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierSourceRule counterparty2IdentifierSourceRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected DTCC_Comment1Rule dTCC_Comment1Rule;
	@Inject protected DTCC_MessageIDRule dTCC_MessageIDRule;
	@Inject protected DTCC_MessageTypeRule dTCC_MessageTypeRule;
	@Inject protected DTCC_PrimaryAssetClassRule dTCC_PrimaryAssetClassRule;
	@Inject protected DTCC_SubmittedForPartyRule dTCC_SubmittedForPartyRule;
	@Inject protected DTCC_SubmittingPartyIDTypeRule dTCC_SubmittingPartyIDTypeRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDRule dTCC_TradeParty1ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDTypeRule dTCC_TradeParty1ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty1IDTypeRule dTCC_TradeParty1IDTypeRule;
	@Inject protected DTCC_TradeParty1ReportingDestinationRule dTCC_TradeParty1ReportingDestinationRule;
	@Inject protected DTCC_TradeParty1TransactionIDRule dTCC_TradeParty1TransactionIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDRule dTCC_TradeParty2ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDTypeRule dTCC_TradeParty2ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty2ReportingDestinationRule dTCC_TradeParty2ReportingDestinationRule;
	@Inject protected DTCC_USIIDPrefixRule dTCC_USIIDPrefixRule;
	@Inject protected DTCC_USIIDRule dTCC_USIIDRule;
	@Inject protected DTCC_VersionRule dTCC_VersionRule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected LastFloatingReferenceResetDateLeg1Rule lastFloatingReferenceResetDateLeg1Rule;
	@Inject protected LastFloatingReferenceResetDateLeg2Rule lastFloatingReferenceResetDateLeg2Rule;
	@Inject protected LastFloatingReferenceValueLeg1Rule lastFloatingReferenceValueLeg1Rule;
	@Inject protected LastFloatingReferenceValueLeg2Rule lastFloatingReferenceValueLeg2Rule;
	@Inject protected LevelRule levelRule;
	@Inject protected NextFloatingReferenceResetDateLeg1Rule nextFloatingReferenceResetDateLeg1Rule;
	@Inject protected NextFloatingReferenceResetDateLeg2Rule nextFloatingReferenceResetDateLeg2Rule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected ValuationAmountRule valuationAmountRule;
	@Inject protected ValuationCurrencyRule valuationCurrencyRule;
	@Inject protected ValuationMethodRule valuationMethodRule;
	@Inject protected ValuationTimestampRule valuationTimestampRule;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CSAValuationReport evaluate(ValuationReportInstruction input) {
		CSAValuationReport.CSAValuationReportBuilder outputBuilder = doEvaluate(input);
		
		final CSAValuationReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CSAValuationReport.class, output);
		}
		
		return output;
	}

	protected abstract CSAValuationReport.CSAValuationReportBuilder doEvaluate(ValuationReportInstruction input);

	public static class CSAValuationReportFunctionDefault extends CSAValuationReportFunction {
		@Override
		protected CSAValuationReport.CSAValuationReportBuilder doEvaluate(ValuationReportInstruction input) {
			CSAValuationReport.CSAValuationReportBuilder output = CSAValuationReport.builder();
			return assignOutput(output, input);
		}
		
		protected CSAValuationReport.CSAValuationReportBuilder assignOutput(CSAValuationReport.CSAValuationReportBuilder output, ValuationReportInstruction input) {
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2(counterparty2Rule.evaluate(input));
			
			output
				.setValuationAmount(valuationAmountRule.evaluate(input));
			
			output
				.setValuationCurrency(valuationCurrencyRule.evaluate(input));
			
			output
				.setValuationTimestamp(valuationTimestampRule.evaluate(input));
			
			output
				.setValuationMethod(valuationMethodRule.evaluate(input));
			
			output
				.setDelta(deltaRule.evaluate(input));
			
			output
				.setActionType(actionTypeRule.evaluate(input));
			
			output
				.setLevel(levelRule.evaluate(input));
			
			output
				.setReportSubmittingEntityIDOverriddenAsString(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setCounterparty2IdentifierSourceOverriddenAsString(counterparty2IdentifierSourceRule.evaluate(input));
			
			output
				.setNextFloatingReferenceResetDateLeg1(nextFloatingReferenceResetDateLeg1Rule.evaluate(input));
			
			output
				.setNextFloatingReferenceResetDateLeg2(nextFloatingReferenceResetDateLeg2Rule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setVariationMarginCollateralPortfolioCode(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setLastFloatingReferenceValueLeg1(lastFloatingReferenceValueLeg1Rule.evaluate(input));
			
			output
				.setLastFloatingReferenceValueLeg2(lastFloatingReferenceValueLeg2Rule.evaluate(input));
			
			output
				.setLastFloatingReferenceResetDateLeg1(lastFloatingReferenceResetDateLeg1Rule.evaluate(input));
			
			output
				.setLastFloatingReferenceResetDateLeg2(lastFloatingReferenceResetDateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty1IDTypeOverriddenAsPartyIdentifierTypeEnum(dTCC_TradeParty1IDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setSubmittingPartyIDTypeOverriddenAsPartyIdentifierTypeEnum(dTCC_SubmittingPartyIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setUsiIDPrefix(null);
			
			output
				.getOrCreateDtccValuationFields()
				.setSubmittedForPartyOverriddenAsString(dTCC_SubmittedForPartyRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(dTCC_TradeParty1ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty2ReportingDestination(dTCC_TradeParty2ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setPrimaryAssetClass(dTCC_PrimaryAssetClassRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setComment1(null);
			
			output
				.getOrCreateDtccValuationFields()
				.setMessageIDOverriddenAsString(dTCC_MessageIDRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setMessageTypeOverriddenAsString(dTCC_MessageTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty2ExecutionAgentID(dTCC_TradeParty2ExecutionAgentIDRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty2ExecutionAgentIDType(dTCC_TradeParty2ExecutionAgentIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty1ExecutionAgentID(dTCC_TradeParty1ExecutionAgentIDRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty1ExecutionAgentIDType(dTCC_TradeParty1ExecutionAgentIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty1TransactionID(dTCC_TradeParty1TransactionIDRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setVersion(dTCC_VersionRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setUsiID(dTCC_USIIDRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uniqueProductIdentifierRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
