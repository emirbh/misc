package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.FrequencyPeriodEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0071_01")
@ImplementedBy(CSATransactionReportCSA_VR_0071_01.Default.class)
public interface CSATransactionReportCSA_VR_0071_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0071_01";
	String DEFINITION = "(if leg1 -> periodicPayment -> floatingRateResetFrequencyPeriod exists and leg1 -> periodicPayment -> floatingRateResetFrequencyPeriod <> ADHO then leg1 -> periodicPayment -> floatingRateResetFrequencyMultiplier exists else leg1 -> periodicPayment -> floatingRateResetFrequencyMultiplier is absent) and (if leg2 -> periodicPayment -> floatingRateResetFrequencyPeriod exists and leg2 -> periodicPayment -> floatingRateResetFrequencyPeriod <> ADHO then leg2 -> periodicPayment -> floatingRateResetFrequencyMultiplier exists else leg2 -> periodicPayment -> floatingRateResetFrequencyMultiplier is absent)";
	
	class Default implements CSATransactionReportCSA_VR_0071_01 {
	
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
				final ComparisonResult ifThenElseResult0;
				if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod())).andNullSafe(notEqual(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.Any)).getOrDefault(false)) {
					ifThenElseResult0 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()));
				} else {
					ifThenElseResult0 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()));
				}
				final ComparisonResult ifThenElseResult1;
				if (exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod())).andNullSafe(notEqual(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()), MapperS.of(FrequencyPeriodEnum.ADHO), CardinalityOperator.Any)).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()));
				} else {
					ifThenElseResult1 = notExists(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0071_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
