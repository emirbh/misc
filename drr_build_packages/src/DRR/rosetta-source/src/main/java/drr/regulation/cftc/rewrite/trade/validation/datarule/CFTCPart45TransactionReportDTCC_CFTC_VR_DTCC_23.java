package drr.regulation.cftc.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
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
@RosettaDataRule("CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_23")
@ImplementedBy(CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_23.Default.class)
public interface CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_23 extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_23";
	String DEFINITION = "if dtccAdditionalFields -> primaryAssetClass = Commodity or nonReportable -> postUpiData -> Header -> AssetClass = Commodities then dtccAdditionalFields -> productID exists else dtccAdditionalFields -> productID is absent";
	
	class Default implements CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_23 {
	
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
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<CFTCNonReportablePart45>map("getNonReportable", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart45 -> cFTCNonReportablePart45.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>map("getProductID", dTCCAdditionalFields -> dTCCAdditionalFields.getProductID()));
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>map("getProductID", dTCCAdditionalFields -> dTCCAdditionalFields.getProductID()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportDTCC_CFTC_VR_DTCC_23 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
