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
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
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
@RosettaDataRule("CSATransactionReportCSA_VR_0143_01")
@ImplementedBy(CSATransactionReportCSA_VR_0143_01.Default.class)
public interface CSATransactionReportCSA_VR_0143_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0143_01";
	String DEFINITION = "if [AnnaDsbAssetClassEnum -> Credit, AnnaDsbAssetClassEnum -> Rates, AnnaDsbAssetClassEnum -> Equity, AnnaDsbAssetClassEnum -> Commodities] any = nonReportable -> postUpiData -> Header -> AssetClass or [AssetClassEnum -> Credit, AssetClassEnum -> InterestRate, AssetClassEnum -> Equity, AssetClassEnum -> Commodity] any = dtccAdditionalFields -> primaryAssetClass then ((if leg1 -> periodicPayment -> fixedRatePaymentFrequencyPeriod exists and leg1 -> periodicPayment -> fixedRatePaymentFrequencyPeriod <> ADHO then leg1 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier exists else if leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriod <> ADHO and leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriod exists then leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier exists else (leg1 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier is absent and leg1 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier is absent)) and (if leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod exists and leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriod <> ADHO then leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier exists else if leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriod <> ADHO and leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier exists then leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier exists else (leg2 -> periodicPayment -> fixedRatePaymentFrequencyPeriodMultiplier is absent and leg2 -> periodicPayment -> floatingRatePaymentFrequencyPeriodMultiplier is absent)))";
	
	class Default implements CSATransactionReportCSA_VR_0143_01 {
	
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
				if (areEqual(MapperC.<AnnaDsbAssetClassEnum>of(MapperS.of(AnnaDsbAssetClassEnum.CREDIT), MapperS.of(AnnaDsbAssetClassEnum.RATES), MapperS.of(AnnaDsbAssetClassEnum.EQUITY), MapperS.of(AnnaDsbAssetClassEnum.COMMODITIES)), MapperS.of(cSATransactionReport).<CSANonReportable>map("getNonReportable", _cSATransactionReport -> _cSATransactionReport.getNonReportable()).<AnnaDsbUpiRecord>map("getPostUpiData", cSANonReportable -> cSANonReportable.getPostUpiData()).<AnnaDsbHeader>map("getHeader", annaDsbUpiRecord -> annaDsbUpiRecord.getHeader()).<AnnaDsbAssetClassEnum>map("getAssetClass", annaDsbHeader -> annaDsbHeader.getAssetClass()), CardinalityOperator.Any).orNullSafe(areEqual(MapperC.<AssetClassEnum>of(MapperS.of(AssetClassEnum.CREDIT), MapperS.of(AssetClassEnum.INTEREST_RATE), MapperS.of(AssetClassEnum.EQUITY), MapperS.of(AssetClassEnum.COMMODITY)), MapperS.of(cSATransactionReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", _cSATransactionReport -> _cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), CardinalityOperator.Any)).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult0;
					if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod())).andNullSafe(notEqual(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()));
					} else if (notEqual(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()))).getOrDefault(false)) {
						ifThenElseResult0 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()));
					} else {
						ifThenElseResult0 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier())).andNullSafe(notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier())));
					}
					final ComparisonResult ifThenElseResult1;
					if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod())).andNullSafe(notEqual(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.Any)).getOrDefault(false)) {
						ifThenElseResult1 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()));
					} else if (notEqual(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()))).getOrDefault(false)) {
						ifThenElseResult1 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()));
					} else {
						ifThenElseResult1 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier())).andNullSafe(notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier())));
					}
					return ifThenElseResult0.andNullSafe(ifThenElseResult1);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0143_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
