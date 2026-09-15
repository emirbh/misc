package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
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
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1";
	String DEFINITION = "if ((leg1 -> notionalAmount exists and leg1 -> notionalAmount <> 99999999999999999999.99999) or (leg1 -> notionalAmountSchedule -> value exists)) and (nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange or dtccAdditionalFields -> primaryAssetClass = ForeignExchange) and [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and (nonReportable -> postUpiData -> Header -> InstrumentType = Option or nonReportable -> instrumentType = Option) then leg1 -> notionalCurrency exists and (leg1 -> notionalCurrency = callCurrency or leg1 -> notionalCurrency = putCurrency)";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1 {
	
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
				if (exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", sECLeg -> sECLeg.getNotionalAmount())).andNullSafe(notEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", sECLeg -> sECLeg.getNotionalAmount()), MapperS.of(new BigDecimal("99999999999999999999.99999")), CardinalityOperator.Any)).orNullSafe(exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", sECLeg -> sECLeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()))).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All))).andNullSafe(areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(sECTransactionReport).<ActionTypeEnum>map("getActionType", _sECTransactionReport -> _sECTransactionReport.getActionType()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", nonReportable -> nonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency())).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency()), MapperS.of(sECTransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _sECTransactionReport -> _sECTransactionReport.getCallCurrency()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency()), MapperS.of(sECTransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _sECTransactionReport -> _sECTransactionReport.getPutCurrency()), CardinalityOperator.All)));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
