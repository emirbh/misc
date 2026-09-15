package drr.regulation.cftc.rewrite.trade.validation.datarule;

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
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
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
@RosettaDataRule("CFTCPart45TransactionReportSpreadCondition")
@ImplementedBy(CFTCPart45TransactionReportSpreadCondition.Default.class)
public interface CFTCPart45TransactionReportSpreadCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportSpreadCondition";
	String DEFINITION = "if dtccAdditionalFields -> primaryAssetClass = Credit or nonReportable -> postUpiData -> Header -> AssetClass = Credit then (if leg1 -> fixedRate is absent and otherPayment -> paymentType any <> UFRO and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> spread exists else leg1 -> spread is absent) and (if leg2 -> fixedRate is absent and otherPayment -> paymentType any <> UFRO and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg2 -> spread exists else leg2 -> spread is absent) else if dtccAdditionalFields -> primaryAssetClass = InterestRate or nonReportable -> postUpiData -> Header -> AssetClass = Rates then (if leg1 -> fixedRate is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> spread exists else leg1 -> spread is absent) and (if leg2 -> fixedRate is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg2 -> spread exists else leg2 -> spread is absent) else if (dtccAdditionalFields -> primaryAssetClass = Equity or nonReportable -> postUpiData -> Header -> AssetClass = Equity) and (price is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option) then leg1 -> spread exists or leg2 -> spread exists else if dtccAdditionalFields -> primaryAssetClass = Commodity or nonReportable -> postUpiData -> Header -> AssetClass = Commodities then (if (price is absent or leg1 -> fixedRate is absent) and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> spread exists else leg1 -> spread is absent) and (if (price is absent or leg2 -> fixedRate is absent) and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg2 -> spread exists else leg2 -> spread is absent) else leg1 -> spread is absent and leg2 -> spread is absent";
	
	class Default implements CFTCPart45TransactionReportSpreadCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.CREDIT), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", cFTCPart45Leg -> cFTCPart45Leg.getFixedRate())).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<OtherPayment>mapC("getOtherPayment", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UFRO), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					} else {
						ifThenElseResult0 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					}
					final ComparisonResult ifThenElseResult1;
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", cFTCPart45Leg -> cFTCPart45Leg.getFixedRate())).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<OtherPayment>mapC("getOtherPayment", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UFRO), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult1 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					} else {
						ifThenElseResult1 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.RATES), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult2;
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", cFTCPart45Leg -> cFTCPart45Leg.getFixedRate())).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult2 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					} else {
						ifThenElseResult2 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					}
					final ComparisonResult ifThenElseResult3;
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", cFTCPart45Leg -> cFTCPart45Leg.getFixedRate())).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult3 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					} else {
						ifThenElseResult3 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					}
					return ifThenElseResult2.andNullSafe(ifThenElseResult3);
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<PriceFormat>map("getPrice", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPrice())).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any))).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread())).orNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread())));
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult4;
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<PriceFormat>map("getPrice", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPrice())).orNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", cFTCPart45Leg -> cFTCPart45Leg.getFixedRate()))).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult4 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					} else {
						ifThenElseResult4 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					}
					final ComparisonResult ifThenElseResult5;
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<PriceFormat>map("getPrice", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPrice())).orNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", cFTCPart45Leg -> cFTCPart45Leg.getFixedRate()))).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult5 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					} else {
						ifThenElseResult5 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread()));
					}
					return ifThenElseResult4.andNullSafe(ifThenElseResult5);
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread())).andNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceFormat>map("getSpread", cFTCPart45Leg -> cFTCPart45Leg.getSpread())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportSpreadCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
