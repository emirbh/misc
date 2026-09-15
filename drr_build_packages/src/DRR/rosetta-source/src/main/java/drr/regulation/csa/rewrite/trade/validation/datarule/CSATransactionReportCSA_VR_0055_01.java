package drr.regulation.csa.rewrite.trade.validation.datarule;

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
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
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
@RosettaDataRule("CSATransactionReportCSA_VR_0055_01")
@ImplementedBy(CSATransactionReportCSA_VR_0055_01.Default.class)
public interface CSATransactionReportCSA_VR_0055_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0055_01";
	String DEFINITION = "(if ([AnnaDsbAssetClassEnum -> Credit, AnnaDsbAssetClassEnum -> Rates, AnnaDsbAssetClassEnum -> Equity, AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass or [AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass) and leg1 -> spread exists then leg1 -> spreadNotation exists else leg1 -> spreadNotation is absent) and (if ([AnnaDsbAssetClassEnum -> Credit, AnnaDsbAssetClassEnum -> Rates, AnnaDsbAssetClassEnum -> Equity, AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass or [AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass) and leg2 -> spread exists then leg2 -> spreadNotation exists else leg2 -> spreadNotation is absent)";
	
	class Default implements CSATransactionReportCSA_VR_0055_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				final ComparisonResult ifThenElseResult0;
				if (areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()))).getOrDefault(false)) {
					ifThenElseResult0 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", cSALeg -> cSALeg.getSpreadNotation()));
				} else {
					ifThenElseResult0 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", cSALeg -> cSALeg.getSpreadNotation()));
				}
				final ComparisonResult ifThenElseResult1;
				if (areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any)).andNullSafe(exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()))).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", cSALeg -> cSALeg.getSpreadNotation()));
				} else {
					ifThenElseResult1 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", cSALeg -> cSALeg.getSpreadNotation()));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0055_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
