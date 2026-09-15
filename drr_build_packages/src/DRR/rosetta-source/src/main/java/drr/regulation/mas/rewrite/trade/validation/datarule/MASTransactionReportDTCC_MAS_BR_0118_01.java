package drr.regulation.mas.rewrite.trade.validation.datarule;

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
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0118_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0118_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0118_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0118_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and leg2 -> periodicPayment -> floatingRateResetFrequencyPeriod exists and [FrequencyPeriodEnum -> YEAR, FrequencyPeriodEnum -> MNTH, FrequencyPeriodEnum -> WEEK, FrequencyPeriodEnum -> DAIL, FrequencyPeriodEnum -> QURT, FrequencyPeriodEnum -> EXPI] any = leg2 -> periodicPayment -> floatingRateResetFrequencyPeriod then leg2 -> periodicPayment -> floatingRateResetFrequencyMultiplier exists and leg2 -> periodicPayment -> floatingRateResetFrequencyMultiplier > 0 else if leg2 -> periodicPayment -> floatingRateResetFrequencyPeriod = FrequencyPeriodEnum -> ADHO then leg2 -> periodicPayment -> floatingRateResetFrequencyMultiplier is absent";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0118_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()))).andNullSafe(areEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.YEAR), MapperS.of(FrequencyPeriodEnum.MNTH), MapperS.of(FrequencyPeriodEnum.WEEK), MapperS.of(FrequencyPeriodEnum.DAIL), MapperS.of(FrequencyPeriodEnum.QURT), MapperS.of(FrequencyPeriodEnum.EXPI)), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier())).andNullSafe(greaterThan(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()), MapperS.of(0), CardinalityOperator.All));
				}
				if (areEqual(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0118_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
