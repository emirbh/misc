package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import drr.standards.iosco.upi.AnnaDsbDerived;
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
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_CDSIndexAttachmentPoint")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_CDSIndexAttachmentPoint.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_CDSIndexAttachmentPoint extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_CDSIndexAttachmentPoint";
	String DEFINITION = "if nonReportable -> postUpiData -> Derived -> UnderlyingAssetType = Index_Tranche or nonReportable -> underlyingAssetType = \"Index_Tranche\" then (cdSIndexAttachmentPoint exists and cdSIndexAttachmentPoint < cdSIndexDetachmentPoint) else cdSIndexAttachmentPoint is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_CDSIndexAttachmentPoint {
	
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
				if (areEqual(MapperS.of(sECTransactionReportTrade).<NonReportable>map("getNonReportable", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbUnderlyingAssetTypeEnum>map("getUnderlyingAssetType", annaDsbDerived -> annaDsbDerived.getUnderlyingAssetType()), MapperS.of(AnnaDsbUnderlyingAssetTypeEnum.INDEX_TRANCHE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<NonReportable>map("getNonReportable", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNonReportable()).<String>map("getUnderlyingAssetType", nonReportable -> nonReportable.getUnderlyingAssetType()), MapperS.of("Index_Tranche"), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<BigDecimal>map("getCdSIndexAttachmentPoint", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCdSIndexAttachmentPoint())).andNullSafe(lessThan(MapperS.of(sECTransactionReportTrade).<BigDecimal>map("getCdSIndexAttachmentPoint", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCdSIndexAttachmentPoint()), MapperS.of(sECTransactionReportTrade).<BigDecimal>map("getCdSIndexDetachmentPoint", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCdSIndexDetachmentPoint()), CardinalityOperator.All));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<BigDecimal>map("getCdSIndexAttachmentPoint", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCdSIndexAttachmentPoint()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_CDSIndexAttachmentPoint {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
