package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.quantity.functions.NotionalScheduleEffectiveDateDTCC_Validation;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportDTCC_CSA_VR_0041_01")
@ImplementedBy(CSATransactionReportDTCC_CSA_VR_0041_01.Default.class)
public interface CSATransactionReportDTCC_CSA_VR_0041_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportDTCC_CSA_VR_0041_01";
	String DEFINITION = "common.quantity.NotionalScheduleEffectiveDateDTCC_Validation( leg1 -> notionalAmountSchedule -> value, leg1 -> notionalAmountSchedule -> effectiveDate )";
	
	class Default implements CSATransactionReportDTCC_CSA_VR_0041_01 {
	
		@Inject protected NotionalScheduleEffectiveDateDTCC_Validation notionalScheduleEffectiveDateDTCC_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(notionalScheduleEffectiveDateDTCC_Validation.evaluate(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cSALeg -> cSALeg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).getMulti(), MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cSALeg -> cSALeg.getNotionalAmountSchedule()).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).getMulti())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportDTCC_CSA_VR_0041_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
