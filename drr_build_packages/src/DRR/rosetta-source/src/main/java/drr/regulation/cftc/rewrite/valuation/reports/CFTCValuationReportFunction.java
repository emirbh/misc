package drr.regulation.cftc.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import drr.regulation.cftc.rewrite.valuation.labels.CFTCValuationLabelProvider;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.dtcc.valuation.reports.DTCC_Comment1Rule;
import drr.regulation.common.dtcc.valuation.reports.DTCC_MessageIDRule;
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
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.cftc.rewrite.valuation", body="CFTC", corpusList={"Valuation"})
@RuneLabelProvider(labelProvider=CFTCValuationLabelProvider.class)
@ImplementedBy(CFTCValuationReportFunction.CFTCValuationReportFunctionDefault.class)
public abstract class CFTCValuationReportFunction implements ReportFunction<ValuationReportInstruction, CFTCValuationReport> {
	
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
	@Inject protected UniqueSwapIdentifierRule uniqueSwapIdentifierRule;
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
	public CFTCValuationReport evaluate(ValuationReportInstruction input) {
		CFTCValuationReport.CFTCValuationReportBuilder outputBuilder = doEvaluate(input);
		
		final CFTCValuationReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CFTCValuationReport.class, output);
		}
		
		return output;
	}

	protected abstract CFTCValuationReport.CFTCValuationReportBuilder doEvaluate(ValuationReportInstruction input);

	public static class CFTCValuationReportFunctionDefault extends CFTCValuationReportFunction {
		@Override
		protected CFTCValuationReport.CFTCValuationReportBuilder doEvaluate(ValuationReportInstruction input) {
			CFTCValuationReport.CFTCValuationReportBuilder output = CFTCValuationReport.builder();
			return assignOutput(output, input);
		}
		
		protected CFTCValuationReport.CFTCValuationReportBuilder assignOutput(CFTCValuationReport.CFTCValuationReportBuilder output, ValuationReportInstruction input) {
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
				.setVariationMarginCollateralPortfolioCodeOverriddenAsString(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCodeOverriddenAsString(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
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
				.setSubmittedForPartyOverriddenAsString(dTCC_SubmittedForPartyRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(dTCC_TradeParty1ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setTradeParty2ReportingDestinationOverriddenAsSupervisoryBodyEnum(dTCC_TradeParty2ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setPrimaryAssetClass(dTCC_PrimaryAssetClassRule.evaluate(input));
			
			output
				.getOrCreateDtccValuationFields()
				.setComment1OverriddenAsString(null);
			
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
				.setUniqueProductIdentifier(uniqueProductIdentifierRule.evaluate(input));
			
			output
				.setUniqueSwapIdentifier(uniqueSwapIdentifierRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
