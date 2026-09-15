package drr.regulation.asic.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import drr.regulation.asic.rewrite.valuation.labels.ASICValuationLabelProvider;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.valuation.datetime.reports.NextFloatingReferenceResetDateLeg1Rule;
import drr.regulation.common.valuation.datetime.reports.NextFloatingReferenceResetDateLeg2Rule;
import drr.regulation.common.valuation.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.valuation.datetime.reports.ValuationTimestampRule;
import drr.regulation.common.valuation.event.reports.ActionTypeRule;
import drr.regulation.common.valuation.event.reports.LevelRule;
import drr.regulation.common.valuation.party.reports.Counterparty1Rule;
import drr.regulation.common.valuation.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.valuation.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.valuation.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.common.valuation.quantity.reports.DeltaRule;
import drr.regulation.common.valuation.valuation.reports.ValuationAmountRule;
import drr.regulation.common.valuation.valuation.reports.ValuationCurrencyRule;
import drr.regulation.common.valuation.valuation.reports.ValuationMethodRule;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.asic.rewrite.valuation", body="ASIC", corpusList={"Valuation"})
@RuneLabelProvider(labelProvider=ASICValuationLabelProvider.class)
@ImplementedBy(ASICValuationReportFunction.ASICValuationReportFunctionDefault.class)
public abstract class ASICValuationReportFunction implements ReportFunction<ValuationReportInstruction, ASICValuationReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected ExecutionAgentOfTheCounterparty1Rule executionAgentOfTheCounterparty1Rule;
	@Inject protected ExecutionAgentOfTheCounterparty2DTCCRule executionAgentOfTheCounterparty2DTCCRule;
	@Inject protected LevelRule levelRule;
	@Inject protected NextFloatingReferenceResetDateLeg1Rule nextFloatingReferenceResetDateLeg1Rule;
	@Inject protected NextFloatingReferenceResetDateLeg2Rule nextFloatingReferenceResetDateLeg2Rule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SmallScaleBuySideEntityIndicatorRule smallScaleBuySideEntityIndicatorRule;
	@Inject protected TechnicalRecordIdRule technicalRecordIdRule;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected ValuationAmountRule valuationAmountRule;
	@Inject protected ValuationCurrencyRule valuationCurrencyRule;
	@Inject protected ValuationMethodRule valuationMethodRule;
	@Inject protected ValuationTimestampRule valuationTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ASICValuationReport evaluate(ValuationReportInstruction input) {
		ASICValuationReport.ASICValuationReportBuilder outputBuilder = doEvaluate(input);
		
		final ASICValuationReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(ASICValuationReport.class, output);
		}
		
		return output;
	}

	protected abstract ASICValuationReport.ASICValuationReportBuilder doEvaluate(ValuationReportInstruction input);

	public static class ASICValuationReportFunctionDefault extends ASICValuationReportFunction {
		@Override
		protected ASICValuationReport.ASICValuationReportBuilder doEvaluate(ValuationReportInstruction input) {
			ASICValuationReport.ASICValuationReportBuilder output = ASICValuationReport.builder();
			return assignOutput(output, input);
		}
		
		protected ASICValuationReport.ASICValuationReportBuilder assignOutput(ASICValuationReport.ASICValuationReportBuilder output, ValuationReportInstruction input) {
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2IdentifierTypeOverriddenAsBoolean(counterparty2IdentifierTypeRule.evaluate(input));
			
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
				.setTechnicalRecordIdOverriddenAsString(technicalRecordIdRule.evaluate(input));
			
			output
				.setReportSubmittingEntityIDOverriddenAsString(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setEntityResponsibleForReportingOverriddenAsString(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setNextFloatingReferenceResetDateLeg1(nextFloatingReferenceResetDateLeg1Rule.evaluate(input));
			
			output
				.setNextFloatingReferenceResetDateLeg2(nextFloatingReferenceResetDateLeg2Rule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(uniqueTransactionIdentifierProprietaryRule.evaluate(input));
			
			output
				.setExecutionAgentOfTheCounterparty2(executionAgentOfTheCounterparty2DTCCRule.evaluate(input));
			
			output
				.setExecutionAgentOfTheCounterparty1(executionAgentOfTheCounterparty1Rule.evaluate(input));
			
			output
				.setSmallScaleBuySideEntityIndicator(smallScaleBuySideEntityIndicatorRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
