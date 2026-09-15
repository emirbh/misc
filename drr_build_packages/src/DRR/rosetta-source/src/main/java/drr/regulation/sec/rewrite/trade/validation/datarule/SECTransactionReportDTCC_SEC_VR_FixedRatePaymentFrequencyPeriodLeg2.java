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
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2";
	String DEFINITION = "if leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod = EXPI then leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier = 1";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2 {
	
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
				if (areEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg2", _sECTransactionReport -> _sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
					return areEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg2", _sECTransactionReport -> _sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()), MapperS.of(1), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
