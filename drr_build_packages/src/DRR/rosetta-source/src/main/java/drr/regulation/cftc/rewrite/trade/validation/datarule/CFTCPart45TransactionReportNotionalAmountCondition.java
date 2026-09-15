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
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportNotionalAmountCondition")
@ImplementedBy(CFTCPart45TransactionReportNotionalAmountCondition.Default.class)
public interface CFTCPart45TransactionReportNotionalAmountCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportNotionalAmountCondition";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange or dtccAdditionalFields -> primaryAssetClass = ForeignExchange) and (nonReportable -> instrumentType = Option or nonReportable -> postUpiData -> Header -> InstrumentType = Option) then ((if leg1 -> notionalAmount exists and (callAmount exists and putAmount exists) then leg1 -> notionalAmount = callAmount or leg1 -> notionalAmount = putAmount) and (if leg2 -> notionalAmount exists and (callAmount exists and putAmount exists) then leg2 -> notionalAmount = callAmount or leg2 -> notionalAmount = putAmount else True))";
	
	class Default implements CFTCPart45TransactionReportNotionalAmountCondition {
	
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
					if (exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmount())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getCallAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallAmount())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getPutAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutAmount())))).getOrDefault(false)) {
						ifThenElseResult0 = areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmount()), MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getCallAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallAmount()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmount()), MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getPutAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutAmount()), CardinalityOperator.All));
					} else {
						ifThenElseResult0 = ComparisonResult.ofEmpty();
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmount())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getCallAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallAmount())).andNullSafe(exists(MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getPutAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutAmount())))).getOrDefault(false)) {
						ifThenElseResult1 = areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmount()), MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getCallAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCallAmount()), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmount()), MapperS.of(cFTCPart45TransactionReport).<BigDecimal>map("getPutAmount", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPutAmount()), CardinalityOperator.All));
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
	class NoOp implements CFTCPart45TransactionReportNotionalAmountCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
