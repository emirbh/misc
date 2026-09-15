package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1";
	String DEFINITION = "if leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriod = EXPI then leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier = 1";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (areEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()), MapperS.of(1), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
