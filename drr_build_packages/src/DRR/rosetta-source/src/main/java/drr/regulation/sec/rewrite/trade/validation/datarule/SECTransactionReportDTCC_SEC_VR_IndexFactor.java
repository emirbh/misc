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
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
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
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_IndexFactor")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_IndexFactor.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_IndexFactor extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_IndexFactor";
	String DEFINITION = "if (nonReportable -> postUpiData -> Derived -> UnderlyingAssetType = Index_Tranche or nonReportable -> underlyingAssetType = \"Index_Tranche\") or (nonReportable -> postUpiData -> Derived -> UnderlyingAssetType = Index or nonReportable -> underlyingAssetType = \"Index\") then indexFactor exists else indexFactor is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_IndexFactor {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbUnderlyingAssetTypeEnum>map("getUnderlyingAssetType", annaDsbDerived -> annaDsbDerived.getUnderlyingAssetType()), MapperS.of(AnnaDsbUnderlyingAssetTypeEnum.INDEX_TRANCHE), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<String>map("getUnderlyingAssetType", nonReportable -> nonReportable.getUnderlyingAssetType()), MapperS.of("Index_Tranche"), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", nonReportable -> nonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbUnderlyingAssetTypeEnum>map("getUnderlyingAssetType", annaDsbDerived -> annaDsbDerived.getUnderlyingAssetType()), MapperS.of(AnnaDsbUnderlyingAssetTypeEnum.INDEX), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReport).<NonReportable>map("getNonReportable", _sECTransactionReport -> _sECTransactionReport.getNonReportable()).<String>map("getUnderlyingAssetType", nonReportable -> nonReportable.getUnderlyingAssetType()), MapperS.of("Index"), CardinalityOperator.All))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<BigDecimal>map("getIndexFactor", _sECTransactionReport -> _sECTransactionReport.getIndexFactor()));
				}
				return notExists(MapperS.of(sECTransactionReport).<BigDecimal>map("getIndexFactor", _sECTransactionReport -> _sECTransactionReport.getIndexFactor()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_IndexFactor {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
