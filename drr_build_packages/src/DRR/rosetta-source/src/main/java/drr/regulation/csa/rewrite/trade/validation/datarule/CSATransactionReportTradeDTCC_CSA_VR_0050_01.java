package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
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
@RosettaDataRule("CSATransactionReportTradeDTCC_CSA_VR_0050_01")
@ImplementedBy(CSATransactionReportTradeDTCC_CSA_VR_0050_01.Default.class)
public interface CSATransactionReportTradeDTCC_CSA_VR_0050_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeDTCC_CSA_VR_0050_01";
	String DEFINITION = "if ([AnnaDsbAssetClassEnum -> Equity, AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass or [AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass) then if priceSchedule -> effectiveDate count >= 1 then priceSchedule -> effectiveDate count = priceSchedule -> price count";
	
	class Default implements CSATransactionReportTradeDTCC_CSA_VR_0050_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cSATransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReportTrade -> _cSATransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (greaterThanEquals(MapperS.of(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
						return areEqual(MapperS.of(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).resultCount()), MapperS.of(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).resultCount()), CardinalityOperator.All);
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeDTCC_CSA_VR_0050_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
