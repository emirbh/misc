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
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
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
@RosettaDataRule("CSATransactionReportCSA_VR_0120_01")
@ImplementedBy(CSATransactionReportCSA_VR_0120_01.Default.class)
public interface CSATransactionReportCSA_VR_0120_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0120_01";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Credit or dtccAdditionalFields -> primaryAssetClass = Credit) and ([AnnaDsbUnderlyingAssetTypeEnum -> Index, AnnaDsbUnderlyingAssetTypeEnum -> Index_Tranche] any = nonReportable -> postUpiData -> Derived -> UnderlyingAssetType or [\"Index\", \"Index_Tranche\"] any = nonReportable -> underlyingAssetType) then indexFactor exists else indexFactor is absent";
	
	class Default implements CSATransactionReportCSA_VR_0120_01 {
	
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
				if (areEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.CREDIT), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<AnnaDsbUnderlyingAssetTypeEnum>of(MapperS.of(AnnaDsbUnderlyingAssetTypeEnum.INDEX), MapperS.of(AnnaDsbUnderlyingAssetTypeEnum.INDEX_TRANCHE)), MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbDerived>map("getDerived", annaDsbUpiRecord -> annaDsbUpiRecord.getDerived()).<AnnaDsbUnderlyingAssetTypeEnum>map("getUnderlyingAssetType", annaDsbDerived -> annaDsbDerived.getUnderlyingAssetType()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<String>of(MapperS.of("Index"), MapperS.of("Index_Tranche")), MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<String>map("getUnderlyingAssetType", cSANonReportable -> cSANonReportable.getUnderlyingAssetType()), CardinalityOperator.Any))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<BigDecimal>map("getIndexFactor", _cSATransactionReport -> _cSATransactionReport.getIndexFactor()));
				}
				return notExists(MapperS.of(cSATransactionReport).<BigDecimal>map("getIndexFactor", _cSATransactionReport -> _cSATransactionReport.getIndexFactor()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0120_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
