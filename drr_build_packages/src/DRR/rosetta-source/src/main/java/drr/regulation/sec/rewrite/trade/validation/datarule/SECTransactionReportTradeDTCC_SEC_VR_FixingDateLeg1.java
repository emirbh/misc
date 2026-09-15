package drr.regulation.sec.rewrite.trade.validation.datarule;

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
import drr.regulation.common.trade.NonReportable;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_FixingDateLeg1")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_FixingDateLeg1.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_FixingDateLeg1 extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_FixingDateLeg1";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Foreign_Exchange or dtccAdditionalFields -> primaryAssetClass = ForeignExchange) then (if ([upi.AnnaDsbInstrumentTypeEnum -> Forward, upi.AnnaDsbInstrumentTypeEnum -> Option] any = nonReportable -> postUpiData -> Header -> InstrumentType or [upi.AnnaDsbInstrumentTypeEnum -> Forward, upi.AnnaDsbInstrumentTypeEnum -> Option] any = nonReportable -> instrumentType) and (nonReportable -> postUpiData -> Attributes -> DeliveryType = CASH or dtccAdditionalFields -> settlementType = \"Cash\") then leg1 -> fixingDate exists else leg1 -> fixingDate is absent)";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_FixingDateLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			ComparisonResult result = executeDataRule(sECTransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReportTrade sECTransactionReportTrade) {
			try {
				if (areEqual(MapperS.of(sECTransactionReportTrade).<NonReportable>map("getNonReportable", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReportTrade -> _sECTransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(MapperC.<AnnaDsbInstrumentTypeEnum>of(MapperS.of(AnnaDsbInstrumentTypeEnum.FORWARD), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION)), MapperS.of(sECTransactionReportTrade).<NonReportable>map("getNonReportable", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", annaDsbHeader -> annaDsbHeader.getInstrumentType()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AnnaDsbInstrumentTypeEnum>of(MapperS.of(AnnaDsbInstrumentTypeEnum.FORWARD), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION)), MapperS.of(sECTransactionReportTrade).<NonReportable>map("getNonReportable", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNonReportable()).<AnnaDsbInstrumentTypeEnum>map("getInstrumentType", nonReportable -> nonReportable.getInstrumentType()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<NonReportable>map("getNonReportable", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbAttributesRecord>map("getAttributes", annaDsbUpiRecord -> annaDsbUpiRecord.getAttributes()).<AnnaDsbDeliveryTypeEnum>map("getDeliveryType", annaDsbAttributesRecord -> annaDsbAttributesRecord.getDeliveryType()), MapperS.of(AnnaDsbDeliveryTypeEnum.CASH), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReportTrade -> _sECTransactionReportTrade.getDtccAdditionalFields()).<String>map("getSettlementType", dTCCAdditionalFields -> dTCCAdditionalFields.getSettlementType()), MapperS.of("Cash"), CardinalityOperator.All))).getOrDefault(false)) {
						return exists(MapperS.of(sECTransactionReportTrade).<SECLeg>map("getLeg1", _sECTransactionReportTrade -> _sECTransactionReportTrade.getLeg1()).<ZonedDateTime>map("getFixingDate", sECLeg -> sECLeg.getFixingDate()));
					}
					return notExists(MapperS.of(sECTransactionReportTrade).<SECLeg>map("getLeg1", _sECTransactionReportTrade -> _sECTransactionReportTrade.getLeg1()).<ZonedDateTime>map("getFixingDate", sECLeg -> sECLeg.getFixingDate()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_FixingDateLeg1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
