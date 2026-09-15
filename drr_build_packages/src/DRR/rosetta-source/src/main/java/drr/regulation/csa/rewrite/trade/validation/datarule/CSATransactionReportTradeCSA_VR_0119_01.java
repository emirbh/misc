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
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0119_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0119_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0119_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0119_01";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Credit or dtccAdditionalFields -> primaryAssetClass = Credit) and (nonReportable -> postUpiData -> Derived -> UnderlyingAssetType = Index_Tranche or nonReportable -> underlyingAssetType = \"Index_Tranche\") then (cdSIndexDetachmentPoint exists and cdSIndexDetachmentPoint > cdSIndexAttachmentPoint) else cdSIndexDetachmentPoint is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0119_01 {
	
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
				if (areEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.CREDIT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReportTrade -> _cSATransactionReportTrade.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbUnderlyingAssetTypeEnum>map("getUnderlyingAssetType", annaDsbDerived -> annaDsbDerived.getUnderlyingAssetType()), MapperS.of(AnnaDsbUnderlyingAssetTypeEnum.INDEX_TRANCHE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<CSANonReportable>map("getNonReportable", _cSATransactionReportTrade -> _cSATransactionReportTrade.getNonReportable()).<String>map("getUnderlyingAssetType", cSANonReportable -> cSANonReportable.getUnderlyingAssetType()), MapperS.of("Index_Tranche"), CardinalityOperator.All))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<BigDecimal>map("getCdSIndexDetachmentPoint", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCdSIndexDetachmentPoint())).andNullSafe(greaterThan(MapperS.of(cSATransactionReportTrade).<BigDecimal>map("getCdSIndexDetachmentPoint", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCdSIndexDetachmentPoint()), MapperS.of(cSATransactionReportTrade).<BigDecimal>map("getCdSIndexAttachmentPoint", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCdSIndexAttachmentPoint()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<BigDecimal>map("getCdSIndexDetachmentPoint", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCdSIndexDetachmentPoint()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0119_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
