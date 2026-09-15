package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.quantity.functions.NotionalAmountScheduleCount_Validation;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0040_01b")
@ImplementedBy(CSATransactionReportCSA_VR_0040_01b.Default.class)
public interface CSATransactionReportCSA_VR_0040_01b extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0040_01b";
	String DEFINITION = "common.quantity.NotionalAmountScheduleCount_Validation( leg1 -> notionalAmountSchedule ) and common.quantity.NotionalAmountScheduleCount_Validation( leg2 -> notionalAmountSchedule )";
	
	class Default implements CSATransactionReportCSA_VR_0040_01b {
	
		@Inject protected NotionalAmountScheduleCount_Validation notionalAmountScheduleCount_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(notionalAmountScheduleCount_Validation.evaluate(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg1", _cSATransactionReport -> _cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cSALeg -> cSALeg.getNotionalAmountSchedule()).getMulti()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(notionalAmountScheduleCount_Validation.evaluate(MapperS.of(cSATransactionReport).<CSALeg>map("getLeg2", _cSATransactionReport -> _cSATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cSALeg -> cSALeg.getNotionalAmountSchedule()).getMulti()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0040_01b {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
