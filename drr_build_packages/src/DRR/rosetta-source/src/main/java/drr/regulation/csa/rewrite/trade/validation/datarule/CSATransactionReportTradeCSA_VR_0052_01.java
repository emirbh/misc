package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
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
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0052_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0052_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0052_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0052_01";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Equity or dtccAdditionalFields -> primaryAssetClass = Equity) then (if ((leg1 -> spread is absent and leg2 -> spread is absent) or price is absent) and ((nonReportable -> postUpiData -> Header -> InstrumentType exists and nonReportable -> postUpiData -> Header -> InstrumentType <> Option) or nonReportable -> instrumentType <> Option) then priceSchedule -> price exists else priceSchedule -> price is absent) else if (nonReportable -> postUpiData -> Header -> AssetClass = Commodities or dtccAdditionalFields -> primaryAssetClass = Commodity) and ((leg1 -> spread is absent and leg2 -> spread is absent) or (leg1 -> fixedRate is absent and leg2 -> fixedRate is absent) or price is absent) then priceSchedule -> price exists else priceSchedule -> price is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0052_01 {
	
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
				if (areEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReportTrade -> _cSATransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All)).getOrDefault(false)) {
					if (notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()))).orNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<PriceFormat>map("getPrice", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPrice()))).andNullSafe(exists(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType())).andNullSafe(notEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any)).orNullSafe(notEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", cSANonReportable -> cSANonReportable.getInstrumentType()), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.Any))).getOrDefault(false)) {
						return exists(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()));
					}
					return notExists(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()));
				}
				if (areEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReportTrade -> _cSATransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()))).orNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg1", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg1()).<BigDecimal>map("getFixedRate", cSALeg -> cSALeg.getFixedRate())).andNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<CSALeg>map("getLeg2", _cSATransactionReportTrade -> _cSATransactionReportTrade.getLeg2()).<BigDecimal>map("getFixedRate", cSALeg -> cSALeg.getFixedRate())))).orNullSafe(notExists(MapperS.of(cSATransactionReportTrade).<PriceFormat>map("getPrice", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPrice())))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<PricePeriod>mapC("getPriceSchedule", _cSATransactionReportTrade -> _cSATransactionReportTrade.getPriceSchedule()).<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0052_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
