package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.NonReportable;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1042_02")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1042_02.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1042_02 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1042_02";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and CommonAssetClass -> INTR = assetClass then (if nonReportable -> postUpiData -> Header -> InstrumentType = Swap and nonReportable -> postUpiData -> Attributes -> NotionalSchedule = upi.AnnaDsbNotionalScheduleEnum -> Constant and nonReportable -> postUpiData -> Header -> AssetClass = Rates then ((leg1 -> notionalAmountSchedule -> value exists and leg1 -> notionalAmountSchedule -> value any > 0) or leg1 -> notionalAmountSchedule -> value any = 9999999999999999999999999) else (if leg1 -> notionalAmountSchedule -> value count <> leg1 -> notionalAmountSchedule -> effectiveDate count then False))";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1042_02 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(CommonAssetClass.INTR), MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.SWAP), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbAttributesRecord>map("getAttributes", annaDsbUpiRecord -> annaDsbUpiRecord.getAttributes()).<AnnaDsbNotionalScheduleEnum>map("getNotionalSchedule", annaDsbAttributesRecord -> annaDsbAttributesRecord.getNotionalSchedule()), MapperS.of(AnnaDsbNotionalScheduleEnum.CONSTANT), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.RATES), CardinalityOperator.All)).getOrDefault(false)) {
						final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
						return exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue())).andNullSafe(greaterThan(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.Any)).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.Any));
					}
					if (notEqual(MapperS.of(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount()), MapperS.of(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule()).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).resultCount()), CardinalityOperator.Any).getOrDefault(false)) {
						return ComparisonResult.ofNullSafe(MapperS.of(false));
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
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1042_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
