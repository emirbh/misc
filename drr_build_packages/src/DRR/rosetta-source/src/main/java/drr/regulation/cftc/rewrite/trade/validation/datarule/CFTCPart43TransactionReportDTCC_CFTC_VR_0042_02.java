package drr.regulation.cftc.rewrite.trade.validation.datarule;

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
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02")
@ImplementedBy(CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02.Default.class)
public interface CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02 extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02";
	String DEFINITION = "if (nonReportable -> postUpiData -> Header -> AssetClass = Commodities or dtccAdditionalFields -> primaryAssetClass = Commodity) and leg2 -> quantityFrequency exists and [FrequencyPeriodEnum -> ONDE, FrequencyPeriodEnum -> ADHO] all <> leg2 -> quantityFrequency then leg2 -> quantityFrequencyMultiplier exists else leg2 -> quantityFrequencyMultiplier is absent";
	
	class Default implements CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<CFTCNonReportablePart43>map("getNonReportable", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cFTCNonReportablePart43 -> cFTCNonReportablePart43.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart43TransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All)).andNullSafe(exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", commonLeg -> commonLeg.getQuantityFrequency()))).andNullSafe(notEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.ONDE), MapperS.of(FrequencyPeriodEnum.ADHO)), MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", commonLeg -> commonLeg.getQuantityFrequency()), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", commonLeg -> commonLeg.getQuantityFrequencyMultiplier()));
				}
				return notExists(MapperS.of(cFTCPart43TransactionReport).<CommonLeg>map("getLeg2", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", commonLeg -> commonLeg.getQuantityFrequencyMultiplier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
