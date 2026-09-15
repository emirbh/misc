package drr.regulation.cftc.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportSpreadNotationCondition")
@ImplementedBy(CFTCPart43TransactionReportSpreadNotationCondition.Default.class)
public interface CFTCPart43TransactionReportSpreadNotationCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportSpreadNotationCondition";
	String DEFINITION = "(if ([AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass or [upi.AnnaDsbAssetClassEnum -> Credit, upi.AnnaDsbAssetClassEnum -> Rates, upi.AnnaDsbAssetClassEnum -> Equity, upi.AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass) and leg1 -> spread exists then leg1 -> spreadNotation exists else leg1 -> spreadNotation is absent) and (if ([AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass or [upi.AnnaDsbAssetClassEnum -> Credit, upi.AnnaDsbAssetClassEnum -> Rates, upi.AnnaDsbAssetClassEnum -> Equity, upi.AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass) and leg2 -> spread exists then leg2 -> spreadNotation exists else leg2 -> spreadNotation is absent)";
	
	class Default implements CFTCPart43TransactionReportSpreadNotationCondition {
	
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
				final ComparisonResult ifThenElseResult0;
				if (areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()))).getOrDefault(false)) {
					ifThenElseResult0 = exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()));
				} else {
					ifThenElseResult0 = notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg1", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()));
				}
				final ComparisonResult ifThenElseResult1;
				if (areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()))).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()));
				} else {
					ifThenElseResult1 = notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation()));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportSpreadNotationCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
