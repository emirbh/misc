package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.cftc.rewrite.trade.CFTCPart45Leg;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.common.trade.quantity.functions.NotionalScheduleEndDateCountDTCC_Validation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportDTCC_CFTC_VR_0035_02")
@ImplementedBy(CFTCPart45TransactionReportDTCC_CFTC_VR_0035_02.Default.class)
public interface CFTCPart45TransactionReportDTCC_CFTC_VR_0035_02 extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportDTCC_CFTC_VR_0035_02";
	String DEFINITION = "common.quantity.NotionalScheduleEndDateCountDTCC_Validation( leg2 -> notionalAmountSchedule -> value, leg2 -> notionalAmountSchedule -> endDate )";
	
	class Default implements CFTCPart45TransactionReportDTCC_CFTC_VR_0035_02 {
	
		@Inject protected NotionalScheduleEndDateCountDTCC_Validation notionalScheduleEndDateCountDTCC_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(notionalScheduleEndDateCountDTCC_Validation.evaluate(MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmountSchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).getMulti(), MapperS.of(cFTCPart45TransactionReport).<CFTCPart45Leg>map("getLeg2", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", cFTCPart45Leg -> cFTCPart45Leg.getNotionalAmountSchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).getMulti())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportDTCC_CFTC_VR_0035_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
