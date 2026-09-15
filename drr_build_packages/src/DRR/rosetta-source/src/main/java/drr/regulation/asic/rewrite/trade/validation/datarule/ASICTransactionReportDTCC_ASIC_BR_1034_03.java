package drr.regulation.asic.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
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
import drr.regulation.common.trade.NonReportable;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1034_03")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1034_03.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1034_03 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1034_03";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CURR and contractType = OPTN and leg1 -> notionalAmount exists then (leg1 -> notionalCurrency exists and [ISOCurrencyCodeEnum -> XAG, ISOCurrencyCodeEnum -> XAU, ISOCurrencyCodeEnum -> XBA, ISOCurrencyCodeEnum -> XBB, ISOCurrencyCodeEnum -> XBC, ISOCurrencyCodeEnum -> XBD, ISOCurrencyCodeEnum -> XDR, ISOCurrencyCodeEnum -> XPD, ISOCurrencyCodeEnum -> XPT, ISOCurrencyCodeEnum -> XTS] all <> leg1 -> notionalCurrency and (if nonReportable -> postUpiData -> Header -> InstrumentType = Option and nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange and nonReportable -> postUpiData -> Header -> UseCase <> Digital_Option then [callCurrency, putCurrency] any = leg1 -> notionalCurrency else True))";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1034_03 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonAssetClass>map("getAssetClass", _aSICTransactionReport -> _aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<CommonContractType>map("getContractType", _aSICTransactionReport -> _aSICTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult;
					if (areEqual(MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(aSICTransactionReport).<NonReportable>map("getNonReportable", _aSICTransactionReport -> _aSICTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbUseCaseEnum>map("getUseCase", annaDsbHeader -> annaDsbHeader.getUseCase()), MapperS.of(AnnaDsbUseCaseEnum.DIGITAL_OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult = areEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(aSICTransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _aSICTransactionReport -> _aSICTransactionReport.getCallCurrency()), MapperS.of(aSICTransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _aSICTransactionReport -> _aSICTransactionReport.getPutCurrency())), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()), CardinalityOperator.Any);
					} else {
						ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return exists(MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency())).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS)), MapperS.of(aSICTransactionReport).<CommonLeg>map("getLeg1", _aSICTransactionReport -> _aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()), CardinalityOperator.All)).andNullSafe(ifThenElseResult);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1034_03 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
