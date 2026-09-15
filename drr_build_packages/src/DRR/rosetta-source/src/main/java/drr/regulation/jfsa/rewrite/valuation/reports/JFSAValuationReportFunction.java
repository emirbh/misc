package drr.regulation.jfsa.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.valuation.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.valuation.datetime.reports.ValuationTimestampRule;
import drr.regulation.common.valuation.event.reports.ActionTypeRule;
import drr.regulation.common.valuation.party.reports.Counterparty1Rule;
import drr.regulation.common.valuation.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.valuation.party.reports.Counterparty2Rule;
import drr.regulation.common.valuation.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.valuation.party.reports.ReportSubmittingEntityIDRule;
import drr.regulation.common.valuation.quantity.reports.DeltaRule;
import drr.regulation.common.valuation.valuation.reports.ValuationAmountRule;
import drr.regulation.common.valuation.valuation.reports.ValuationCurrencyRule;
import drr.regulation.common.valuation.valuation.reports.ValuationMethodRule;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import drr.regulation.jfsa.rewrite.valuation.labels.JFSAValuationLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.jfsa.rewrite.valuation", body="JFSA", corpusList={"Valuation"})
@RuneLabelProvider(labelProvider=JFSAValuationLabelProvider.class)
@ImplementedBy(JFSAValuationReportFunction.JFSAValuationReportFunctionDefault.class)
public abstract class JFSAValuationReportFunction implements ReportFunction<ValuationReportInstruction, JFSAValuationReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected NewSDRIdentifierRule newSDRIdentifierRule;
	@Inject protected ReportSubmittingEntityIDRule reportSubmittingEntityIDRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
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
	public JFSAValuationReport evaluate(ValuationReportInstruction input) {
		JFSAValuationReport.JFSAValuationReportBuilder outputBuilder = doEvaluate(input);
		
		final JFSAValuationReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(JFSAValuationReport.class, output);
		}
		
		return output;
	}

	protected abstract JFSAValuationReport.JFSAValuationReportBuilder doEvaluate(ValuationReportInstruction input);

	public static class JFSAValuationReportFunctionDefault extends JFSAValuationReportFunction {
		@Override
		protected JFSAValuationReport.JFSAValuationReportBuilder doEvaluate(ValuationReportInstruction input) {
			JFSAValuationReport.JFSAValuationReportBuilder output = JFSAValuationReport.builder();
			return assignOutput(output, input);
		}
		
		protected JFSAValuationReport.JFSAValuationReportBuilder assignOutput(JFSAValuationReport.JFSAValuationReportBuilder output, ValuationReportInstruction input) {
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
				.setTechnicalRecordIdOverriddenAsString(technicalRecordIdRule.evaluate(input));
			
			output
				.setReportSubmittingEntityIDOverriddenAsString(reportSubmittingEntityIDRule.evaluate(input));
			
			output
				.setEntityResponsibleForReportingOverriddenAsString(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(uniqueTransactionIdentifierProprietaryRule.evaluate(input));
			
			output
				.setNewSDRIdentifier(newSDRIdentifierRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
