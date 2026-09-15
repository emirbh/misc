package drr.regulation.cftc.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportNotionalCurrencyCondition")
@ImplementedBy(CFTCPart43TransactionReportNotionalCurrencyCondition.Default.class)
public interface CFTCPart43TransactionReportNotionalCurrencyCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportNotionalCurrencyCondition";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange or dtccAdditionalFields -> primaryAssetClass = ForeignExchange) and (nonReportable -> instrumentType = Option or nonReportable -> postUpiData -> Header -> InstrumentType = Option) then ((if leg1 -> notionalCurrency exists and (callCurrency exists and putCurrency exists) then leg1 -> notionalCurrency = callCurrency or leg1 -> notionalCurrency = putCurrency) and (if leg2 -> notionalCurrency exists and (callCurrency exists and putCurrency exists) then leg2 -> notionalCurrency = callCurrency or leg2 -> notionalCurrency = putCurrency else True))";
	
	class Default implements CFTCPart43TransactionReportNotionalCurrencyCondition {
	
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
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency())).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getCallCurrency())).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPutCurrency())))).getOrDefault(false)) {
						ifThenElseResult0 = areEqual(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()), MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getCallCurrency()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()), MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPutCurrency()), CardinalityOperator.All));
					} else {
						ifThenElseResult0 = ComparisonResult.ofEmpty();
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency())).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getCallCurrency())).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPutCurrency())))).getOrDefault(false)) {
						ifThenElseResult1 = areEqual(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()), MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getCallCurrency()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()), MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPutCurrency()), CardinalityOperator.All));
					} else {
						ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportNotionalCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
