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
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
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
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0122_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0122_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0122_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0122_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonAssetClass -> INTR, CommonAssetClass -> CRDT, CommonAssetClass -> EQUI, CommonAssetClass -> COMM] any = assetClass and [CommonContractType -> FRAS, CommonContractType -> OPTN, CommonContractType -> SWAP, CommonContractType -> SWPT, CommonContractType -> OTHR] any = contractType and leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod exists and [FrequencyPeriodEnum -> YEAR, FrequencyPeriodEnum -> MNTH, FrequencyPeriodEnum -> WEEK, FrequencyPeriodEnum -> DAIL, FrequencyPeriodEnum -> QURT, FrequencyPeriodEnum -> EXPI] any = leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod then (leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier exists and leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier > 0 and leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier < 1000 and if leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod = FrequencyPeriodEnum -> EXPI then leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier = 1 else True) else if leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod is absent or leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod = FrequencyPeriodEnum -> ADHO then leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier is absent";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0122_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()))).andNullSafe(areEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.YEAR), MapperS.of(FrequencyPeriodEnum.MNTH), MapperS.of(FrequencyPeriodEnum.WEEK), MapperS.of(FrequencyPeriodEnum.DAIL), MapperS.of(FrequencyPeriodEnum.QURT), MapperS.of(FrequencyPeriodEnum.EXPI)), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()), CardinalityOperator.Any)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (areEqual(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult = areEqual(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()), MapperS.of(1), CardinalityOperator.All);
					} else {
						ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier())).andNullSafe(greaterThan(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()), MapperS.of(0), CardinalityOperator.All)).andNullSafe(lessThan(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()), MapperS.of(1000), CardinalityOperator.All)).andNullSafe(ifThenElseResult);
				}
				if (notExists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod())).orNullSafe(areEqual(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg2", _mASTransactionReport -> _mASTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0122_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
