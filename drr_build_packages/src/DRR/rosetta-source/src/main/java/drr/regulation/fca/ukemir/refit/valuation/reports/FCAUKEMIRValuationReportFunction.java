package drr.regulation.fca.ukemir.refit.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.ValuationEnrichmentDataRule;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.valuation.datetime.reports.EventDateRule;
import drr.regulation.common.valuation.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.valuation.datetime.reports.ValuationTimestampRule;
import drr.regulation.common.valuation.event.reports.ActionTypeRule;
import drr.regulation.common.valuation.event.reports.LevelRule;
import drr.regulation.common.valuation.party.reports.Counterparty1Rule;
import drr.regulation.common.valuation.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.valuation.party.reports.Counterparty2Rule;
import drr.regulation.common.valuation.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.common.valuation.quantity.reports.DeltaRule;
import drr.regulation.common.valuation.valuation.reports.ValuationAmountRule;
import drr.regulation.common.valuation.valuation.reports.ValuationCurrencyRule;
import drr.regulation.common.valuation.valuation.reports.ValuationMethodRule;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import drr.regulation.fca.ukemir.refit.valuation.labels.FCAUKEMIRValuationLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.fca.ukemir.refit.valuation", body="FCA", corpusList={"UKEMIR", "Valuation"})
@RuneLabelProvider(labelProvider=FCAUKEMIRValuationLabelProvider.class)
@ImplementedBy(FCAUKEMIRValuationReportFunction.FCAUKEMIRValuationReportFunctionDefault.class)
public abstract class FCAUKEMIRValuationReportFunction implements ReportFunction<ValuationReportInstruction, FCAValuationReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected EventDateRule eventDateRule;
	@Inject protected LevelRule levelRule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected UtiProprietaryRule utiProprietaryRule;
	@Inject protected ValuationAmountRule valuationAmountRule;
	@Inject protected ValuationCurrencyRule valuationCurrencyRule;
	@Inject protected ValuationEnrichmentDataRule valuationEnrichmentDataRule;
	@Inject protected ValuationMethodRule valuationMethodRule;
	@Inject protected ValuationTimestampRule valuationTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FCAValuationReport evaluate(ValuationReportInstruction input) {
		FCAValuationReport.FCAValuationReportBuilder outputBuilder = doEvaluate(input);
		
		final FCAValuationReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(FCAValuationReport.class, output);
		}
		
		return output;
	}

	protected abstract FCAValuationReport.FCAValuationReportBuilder doEvaluate(ValuationReportInstruction input);

	public static class FCAUKEMIRValuationReportFunctionDefault extends FCAUKEMIRValuationReportFunction {
		@Override
		protected FCAValuationReport.FCAValuationReportBuilder doEvaluate(ValuationReportInstruction input) {
			FCAValuationReport.FCAValuationReportBuilder output = FCAValuationReport.builder();
			return assignOutput(output, input);
		}
		
		protected FCAValuationReport.FCAValuationReportBuilder assignOutput(FCAValuationReport.FCAValuationReportBuilder output, ValuationReportInstruction input) {
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
				.setLevelOverriddenAsReportLevelEnum(levelRule.evaluate(input));
			
			output
				.setReportSubmittingEntityIDOverriddenAsString(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setEntityResponsibleForReporting(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(utiProprietaryRule.evaluate(input));
			
			output
				.setEventDateOverriddenAsDate(eventDateRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setEnrichment(valuationEnrichmentDataRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
