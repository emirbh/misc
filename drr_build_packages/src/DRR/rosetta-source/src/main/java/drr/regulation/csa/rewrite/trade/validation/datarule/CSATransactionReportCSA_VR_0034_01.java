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
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSANonReportable;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
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
@RosettaDataRule("CSATransactionReportCSA_VR_0034_01")
@ImplementedBy(CSATransactionReportCSA_VR_0034_01.Default.class)
public interface CSATransactionReportCSA_VR_0034_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0034_01";
	String DEFINITION = "if nonReportable -> postUpiData -> Header -> AssetClass = Commodities or dtccAdditionalFields -> primaryAssetClass = Commodity then ((if leg1 -> quantityFrequency exists and [FrequencyPeriodEnum -> ONDE, FrequencyPeriodEnum -> ADHO] all <> leg1 -> quantityFrequency then leg1 -> quantityFrequencyMultiplier exists else leg1 -> quantityFrequencyMultiplier is absent) and (if leg2 -> quantityFrequency exists and [FrequencyPeriodEnum -> ONDE, FrequencyPeriodEnum -> ADHO] all <> leg2 -> quantityFrequency then leg2 -> quantityFrequencyMultiplier exists else leg2 -> quantityFrequencyMultiplier is absent)) else leg1 -> quantityFrequencyMultiplier is absent and leg2 -> quantityFrequencyMultiplier is absent";
	
	class Default implements CSATransactionReportCSA_VR_0034_01 {
	
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
				if (areEqual(MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<FrequencyPeriodEnum>map("getQuantityFrequency", cSALeg -> cSALeg.getQuantityFrequency())).andNullSafe(notEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.ONDE), MapperS.of(FrequencyPeriodEnum.ADHO)), MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<FrequencyPeriodEnum>map("getQuantityFrequency", cSALeg -> cSALeg.getQuantityFrequency()), CardinalityOperator.All)).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier()));
					} else {
						ifThenElseResult0 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier()));
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", cSALeg -> cSALeg.getQuantityFrequency())).andNullSafe(notEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.ONDE), MapperS.of(FrequencyPeriodEnum.ADHO)), MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", cSALeg -> cSALeg.getQuantityFrequency()), CardinalityOperator.All)).getOrDefault(false)) {
						ifThenElseResult1 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier()));
					} else {
						ifThenElseResult1 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier()));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier())).andNullSafe(notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0034_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
