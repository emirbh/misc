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
import drr.regulation.common.trade.NonReportable;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
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
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0076_03")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0076_03.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0076_03 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0076_03";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CommonAssetClass -> CURR and contractType = CommonContractType -> OPTN then (if nonReportable -> postUpiData -> Header -> InstrumentType = Option and nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange and nonReportable -> postUpiData -> Header -> UseCase <> Digital_Option then [callAmount, putAmount] any = leg1 -> notionalAmount or leg1 -> notionalAmount = 9999999999999999999999999 and (leg1 -> notionalAmount exists and leg1 -> notionalAmount >= 0))";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0076_03 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<CommonAssetClass>map("getAssetClass", _mASTransactionReport -> _mASTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(mASTransactionReport).<NonReportable>map("getNonReportable", _mASTransactionReport -> _mASTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbUseCaseEnum>map("getUseCase", annaDsbHeader -> annaDsbHeader.getUseCase()), MapperS.of(AnnaDsbUseCaseEnum.DIGITAL_OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
						return areEqual(MapperC.<BigDecimal>of(MapperS.of(mASTransactionReport).<BigDecimal>map("getCallAmount", _mASTransactionReport -> _mASTransactionReport.getCallAmount()), MapperS.of(mASTransactionReport).<BigDecimal>map("getPutAmount", _mASTransactionReport -> _mASTransactionReport.getPutAmount())), MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), CardinalityOperator.Any).orNullSafe(areEqual(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), (bigInteger == null ? MapperS.<BigDecimal>ofNull() : MapperS.of(new BigDecimal(bigInteger))), CardinalityOperator.All).andNullSafe(exists(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount())).andNullSafe(greaterThanEquals(MapperS.of(mASTransactionReport).<CommonLeg>map("getLeg1", _mASTransactionReport -> _mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All))));
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
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0076_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
