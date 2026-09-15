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
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
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
@RosettaDataRule("CFTCPart45TransactionReportNotionalCurrencyCondition")
@ImplementedBy(CFTCPart45TransactionReportNotionalCurrencyCondition.Default.class)
public interface CFTCPart45TransactionReportNotionalCurrencyCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportNotionalCurrencyCondition";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange or dtccAdditionalFields -> primaryAssetClass = ForeignExchange) and (nonReportable -> instrumentType = Option or nonReportable -> postUpiData -> Header -> InstrumentType = Option) then ((if leg1 -> notionalCurrency exists and (callCurrency exists and putCurrency exists) then leg1 -> notionalCurrency = callCurrency or leg1 -> notionalCurrency = putCurrency) and (if leg2 -> notionalCurrency exists and (callCurrency exists and putCurrency exists) then leg2 -> notionalCurrency = callCurrency or leg2 -> notionalCurrency = putCurrency else True))";
	
	class Default implements CFTCPart45TransactionReportNotionalCurrencyCondition {
	
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
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All))).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cFTCPart45Leg -> cFTCPart45Leg.getNotionalCurrency())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallCurrency())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutCurrency())))).getOrDefault(false)) {
						ifThenElseResult0 = areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cFTCPart45Leg -> cFTCPart45Leg.getNotionalCurrency()), MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallCurrency()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cFTCPart45Leg -> cFTCPart45Leg.getNotionalCurrency()), MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutCurrency()), CardinalityOperator.All));
					} else {
						ifThenElseResult0 = ComparisonResult.ofEmpty();
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cFTCPart45Leg -> cFTCPart45Leg.getNotionalCurrency())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallCurrency())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutCurrency())))).getOrDefault(false)) {
						ifThenElseResult1 = areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cFTCPart45Leg -> cFTCPart45Leg.getNotionalCurrency()), MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getCallCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallCurrency()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cFTCPart45Leg -> cFTCPart45Leg.getNotionalCurrency()), MapperS.of(cFTCPart45TransactionReport).<ISOCurrencyCodeEnum>map("getPutCurrency", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutCurrency()), CardinalityOperator.All));
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
	class NoOp implements CFTCPart45TransactionReportNotionalCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
