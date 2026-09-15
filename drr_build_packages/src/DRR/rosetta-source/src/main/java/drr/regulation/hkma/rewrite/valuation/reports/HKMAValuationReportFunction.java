package drr.regulation.hkma.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.valuation.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.valuation.datetime.reports.ValuationTimestampRule;
import drr.regulation.common.valuation.event.reports.ActionTypeRule;
import drr.regulation.common.valuation.event.reports.LevelRule;
import drr.regulation.common.valuation.party.reports.Counterparty1Rule;
import drr.regulation.common.valuation.party.reports.Counterparty2IdentifierTypeRule;
import drr.regulation.common.valuation.party.reports.Counterparty2Rule;
import drr.regulation.common.valuation.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.valuation.quantity.reports.DeltaRule;
import drr.regulation.common.valuation.valuation.reports.ValuationAmountRule;
import drr.regulation.common.valuation.valuation.reports.ValuationCurrencyRule;
import drr.regulation.common.valuation.valuation.reports.ValuationMethodRule;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import drr.regulation.hkma.rewrite.valuation.labels.HKMAValuationLabelProvider;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.hkma.rewrite.valuation", body="HKMA", corpusList={"Valuation"})
@RuneLabelProvider(labelProvider=HKMAValuationLabelProvider.class)
@ImplementedBy(HKMAValuationReportFunction.HKMAValuationReportFunctionDefault.class)
public abstract class HKMAValuationReportFunction implements ReportFunction<ValuationReportInstruction, HKMAValuationReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierFormatRule counterparty2IdentifierFormatRule;
	@Inject protected Counterparty2IdentifierTypeRule counterparty2IdentifierTypeRule;
	@Inject protected Counterparty2NameRule counterparty2NameRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected Counterparty2SchemeNameRule counterparty2SchemeNameRule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected LevelRule levelRule;
	@Inject protected NumberRecordsRule numberRecordsRule;
	@Inject protected RemarksRule remarksRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SubmitterIdentifierRule submitterIdentifierRule;
	@Inject protected TechnicalRecordIdRule technicalRecordIdRule;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;
	@Inject protected UniqueTransactionIdentifierProprietarySchemeNameRule uniqueTransactionIdentifierProprietarySchemeNameRule;
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
	public HKMAValuationReport evaluate(ValuationReportInstruction input) {
		HKMAValuationReport.HKMAValuationReportBuilder outputBuilder = doEvaluate(input);
		
		final HKMAValuationReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(HKMAValuationReport.class, output);
		}
		
		return output;
	}

	protected abstract HKMAValuationReport.HKMAValuationReportBuilder doEvaluate(ValuationReportInstruction input);

	public static class HKMAValuationReportFunctionDefault extends HKMAValuationReportFunction {
		@Override
		protected HKMAValuationReport.HKMAValuationReportBuilder doEvaluate(ValuationReportInstruction input) {
			HKMAValuationReport.HKMAValuationReportBuilder output = HKMAValuationReport.builder();
			return assignOutput(output, input);
		}
		
		protected HKMAValuationReport.HKMAValuationReportBuilder assignOutput(HKMAValuationReport.HKMAValuationReportBuilder output, ValuationReportInstruction input) {
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
				.setEntityResponsibleForReporting(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(uniqueTransactionIdentifierProprietaryRule.evaluate(input));
			
			output
				.setCounterparty2Name(counterparty2NameRule.evaluate(input));
			
			output
				.setSubmitterIdentifier(submitterIdentifierRule.evaluate(input));
			
			output
				.setNumberRecords(null);
			
			output
				.setRemarks(null);
			
			output
				.setCounterparty2IdentifierFormat(counterparty2IdentifierFormatRule.evaluate(input));
			
			output
				.setCounterparty2SchemeName(counterparty2SchemeNameRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietarySchemeName(uniqueTransactionIdentifierProprietarySchemeNameRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
