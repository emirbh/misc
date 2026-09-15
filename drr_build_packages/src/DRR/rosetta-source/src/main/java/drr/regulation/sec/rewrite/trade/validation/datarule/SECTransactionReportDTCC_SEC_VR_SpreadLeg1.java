package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iso.PaymentType4Code;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_SpreadLeg1")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_SpreadLeg1.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_SpreadLeg1 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_SpreadLeg1";
	String DEFINITION = "if dtccAdditionalFields -> primaryAssetClass = Credit or nonReportable -> postUpiData -> Header -> AssetClass = Credit then (if leg1 -> fixedRate is absent and otherPayment -> paymentType any <> UFRO and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> spread exists else leg1 -> spread is absent) else if dtccAdditionalFields -> primaryAssetClass = InterestRate or nonReportable -> postUpiData -> Header -> AssetClass = Rates then (if leg1 -> fixedRate is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option and leg2 -> spread is absent then leg1 -> spread exists else leg1 -> spread is absent) else if dtccAdditionalFields -> primaryAssetClass = Equity or nonReportable -> postUpiData -> Header -> AssetClass = Equity then (if price is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> spread exists else leg1 -> spread is absent)";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_SpreadLeg1 {
	
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
				if (areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.CREDIT), CardinalityOperator.All)).getOrDefault(false)) {
					if (notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", sECLeg -> sECLeg.getFixedRate())).andNullSafe(notEqual(MapperS.of(sECTransactionReport).<OtherPayment>mapC("getOtherPayment", _sECTransactionReport -> _sECTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UFRO), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<Boolean>map("getPostPricedSwapIndicator", _sECTransactionReport -> _sECTransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", nonReportable -> nonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						return exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()));
					}
					return notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()));
				}
				if (areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.RATES), CardinalityOperator.All)).getOrDefault(false)) {
					if (notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", sECLeg -> sECLeg.getFixedRate())).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<Boolean>map("getPostPricedSwapIndicator", _sECTransactionReport -> _sECTransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", nonReportable -> nonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).andNullSafe(notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg2", _sECTransactionReport -> _sECTransactionReport.getLeg2()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()))).getOrDefault(false)) {
						return exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()));
					}
					return notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()));
				}
				if (areEqual(MapperS.of(sECTransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReport -> _sECTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), CardinalityOperator.All)).getOrDefault(false)) {
					if (notExists(MapperS.of(sECTransactionReport).<PriceFormat>map("getPrice", _sECTransactionReport -> _sECTransactionReport.getPrice())).andNullSafe(areEqual(MapperS.of(sECTransactionReport).<Boolean>map("getPostPricedSwapIndicator", _sECTransactionReport -> _sECTransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", nonReportable -> nonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						return exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()));
					}
					return notExists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg1", _sECTransactionReport -> _sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_SpreadLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
