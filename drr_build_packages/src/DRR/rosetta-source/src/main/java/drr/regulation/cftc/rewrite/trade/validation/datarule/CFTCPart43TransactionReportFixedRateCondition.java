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
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.common.trade.CommonLeg;
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
@RosettaDataRule("CFTCPart43TransactionReportFixedRateCondition")
@ImplementedBy(CFTCPart43TransactionReportFixedRateCondition.Default.class)
public interface CFTCPart43TransactionReportFixedRateCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportFixedRateCondition";
	String DEFINITION = "if dtccAdditionalFields -> primaryAssetClass = Credit or nonReportable -> postUpiData -> Header -> AssetClass = Credit then (if leg1 -> spread is absent and otherPayment -> paymentType any <> UFRO and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> fixedRate exists else leg1 -> fixedRate is absent) and (if leg2 -> spread is absent and otherPayment -> paymentType any <> UFRO and postPricedSwapIndicator = False and (nonReportable -> instrumentType = Option or nonReportable -> postUpiData -> Header -> InstrumentType = Option) then leg2 -> fixedRate exists else leg2 -> fixedRate is absent) else if dtccAdditionalFields -> primaryAssetClass = InterestRate or nonReportable -> postUpiData -> Header -> AssetClass = Rates then (if leg1 -> spread is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg1 -> fixedRate exists else leg1 -> fixedRate is absent) and (if leg2 -> spread is absent and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option then leg2 -> fixedRate exists else leg2 -> fixedRate is absent) else if (dtccAdditionalFields -> primaryAssetClass = Commodity or nonReportable -> postUpiData -> Header -> AssetClass = Commodities) and ((price is absent or (leg1 -> spread is absent and leg2 -> spread is absent)) and postPricedSwapIndicator = False and nonReportable -> instrumentType <> Option) then leg1 -> fixedRate exists or leg2 -> fixedRate exists else leg1 -> fixedRate is absent and leg2 -> fixedRate is absent";
	
	class Default implements CFTCPart43TransactionReportFixedRateCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.CREDIT), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread())).andNullSafe(notEqual(MapperS.of(cFTCPart43TransactionReport).<OtherPayment>mapC("getOtherPayment", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UFRO), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					} else {
						ifThenElseResult0 = notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					}
					final ComparisonResult ifThenElseResult1;
					if (notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread())).andNullSafe(notEqual(MapperS.of(cFTCPart43TransactionReport).<OtherPayment>mapC("getOtherPayment", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType()), MapperS.of(PaymentType4Code.UFRO), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All))).getOrDefault(false)) {
						ifThenElseResult1 = exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					} else {
						ifThenElseResult1 = notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.RATES), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult2;
					if (notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread())).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult2 = exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					} else {
						ifThenElseResult2 = notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					}
					final ComparisonResult ifThenElseResult3;
					if (notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread())).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult3 = exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					} else {
						ifThenElseResult3 = notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()));
					}
					return ifThenElseResult2.andNullSafe(ifThenElseResult3);
				}
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(cFTCPart43TransactionReport).<PriceFormat>map("getPrice", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPrice())).orNullSafe(notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread())).andNullSafe(notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread())))).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getPostPricedSwapIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPostPricedSwapIndicator()), MapperS.of(false), CardinalityOperator.All)).andNullSafe(notEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any))).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).orNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())));
				}
				return notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).andNullSafe(notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportFixedRateCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
