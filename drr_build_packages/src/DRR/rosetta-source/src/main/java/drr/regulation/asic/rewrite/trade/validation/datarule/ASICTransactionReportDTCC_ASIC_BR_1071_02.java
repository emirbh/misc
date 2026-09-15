package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1071_02")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1071_02.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1071_02 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1071_02";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonAssetClass -> CRDT, CommonAssetClass -> EQUI, CommonAssetClass -> COMM, CommonAssetClass -> INTR] any = assetClass and [CommonContractType -> FRAS, CommonContractType -> OPTN, CommonContractType -> SWAP, CommonContractType -> SWPT, CommonContractType -> OTHR] any = contractType then if [FrequencyPeriodEnum -> YEAR, FrequencyPeriodEnum -> MNTH, FrequencyPeriodEnum -> WEEK, FrequencyPeriodEnum -> DAIL, FrequencyPeriodEnum -> EXPI] any = leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriod then leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier exists and (leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier < 1000 and leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier > 0) else if leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriod = FrequencyPeriodEnum -> EXPI then leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier = 1 else if leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriod is absent or leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriod = FrequencyPeriodEnum -> ADHO then leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier is absent";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1071_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			ComparisonResult result = executeDataRule(aSICTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICTransactionReport aSICTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM), MapperS.of(CommonAssetClass.INTR)), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.FRAS), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OTHR)), MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (areEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.YEAR), MapperS.of(FrequencyPeriodEnum.MNTH), MapperS.of(FrequencyPeriodEnum.WEEK), MapperS.of(FrequencyPeriodEnum.DAIL), MapperS.of(FrequencyPeriodEnum.EXPI)), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), CardinalityOperator.Any).getOrDefault(false)) {
						return exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier())).andNullSafe(lessThan(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()), MapperS.of(1000), CardinalityOperator.All).andNullSafe(greaterThan(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()), MapperS.of(0), CardinalityOperator.All)));
					}
					if (areEqual(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()), MapperS.of(1), CardinalityOperator.All);
					}
					if (notExists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod())).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.All)).getOrDefault(false)) {
						return notExists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg2", _aSICTransactionReport -> _aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()));
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
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1071_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
