package drr.regulation.hkma.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("HKMATransactionReportDOC0032")
@ImplementedBy(HKMATransactionReportDOC0032.Default.class)
public interface HKMATransactionReportDOC0032 extends Validator<HKMATransactionReport> {
	
	String NAME = "HKMATransactionReportDOC0032";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then if [FrequencyPeriodEnum -> YEAR, FrequencyPeriodEnum -> MNTH, FrequencyPeriodEnum -> WEEK, FrequencyPeriodEnum -> DAIL, FrequencyPeriodEnum -> EXPI] any = leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriod then leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier exists";
	
	class Default implements HKMATransactionReportDOC0032 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			ComparisonResult result = executeDataRule(hKMATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "HKMATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(HKMATransactionReport hKMATransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(hKMATransactionReport).<ActionTypeEnum>map("getActionType", _hKMATransactionReport -> _hKMATransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.YEAR), MapperS.of(FrequencyPeriodEnum.MNTH), MapperS.of(FrequencyPeriodEnum.WEEK), MapperS.of(FrequencyPeriodEnum.DAIL), MapperS.of(FrequencyPeriodEnum.EXPI)), MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), CardinalityOperator.Any).getOrDefault(false)) {
						return exists(MapperS.of(hKMATransactionReport).<CommonLeg>map("getLeg1", _hKMATransactionReport -> _hKMATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements HKMATransactionReportDOC0032 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, HKMATransactionReport hKMATransactionReport) {
			return Collections.emptyList();
		}
	}
}
