package drr.regulation.cftc.rewrite.trade.validation.datarule;

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
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
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
@RosettaDataRule("CFTCPart45TransactionReportSpreadCurrencyCondition")
@ImplementedBy(CFTCPart45TransactionReportSpreadCurrencyCondition.Default.class)
public interface CFTCPart45TransactionReportSpreadCurrencyCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportSpreadCurrencyCondition";
	String DEFINITION = "(if ([AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass or [upi.AnnaDsbAssetClassEnum -> Credit, upi.AnnaDsbAssetClassEnum -> Rates, upi.AnnaDsbAssetClassEnum -> Equity, upi.AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass) and leg1 -> spreadNotation = Monetary then leg1 -> spreadCurrency exists else leg1 -> spreadCurrency is absent) and (if ([AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass or [upi.AnnaDsbAssetClassEnum -> Credit, upi.AnnaDsbAssetClassEnum -> Rates, upi.AnnaDsbAssetClassEnum -> Equity, upi.AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass) and leg2 -> spreadNotation = Monetary then leg2 -> spreadCurrency exists else leg2 -> spreadCurrency is absent)";
	
	class Default implements CFTCPart45TransactionReportSpreadCurrencyCondition {
	
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
				final ComparisonResult ifThenElseResult0;
				if (areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", cFTCPart45Leg -> cFTCPart45Leg.getSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All)).getOrDefault(false)) {
					ifThenElseResult0 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", cFTCPart45Leg -> cFTCPart45Leg.getSpreadCurrency()));
				} else {
					ifThenElseResult0 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", cFTCPart45Leg -> cFTCPart45Leg.getSpreadCurrency()));
				}
				final ComparisonResult ifThenElseResult1;
				if (areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", cFTCPart45Leg -> cFTCPart45Leg.getSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All)).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", cFTCPart45Leg -> cFTCPart45Leg.getSpreadCurrency()));
				} else {
					ifThenElseResult1 = notExists(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", cFTCPart45Leg -> cFTCPart45Leg.getSpreadCurrency()));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportSpreadCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
