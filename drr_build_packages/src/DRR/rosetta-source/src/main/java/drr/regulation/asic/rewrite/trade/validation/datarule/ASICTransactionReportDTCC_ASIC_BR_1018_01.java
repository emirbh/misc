package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.trade.datetime.functions.ExpirationDate_Validation;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1018_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1018_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1018_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1018_01";
	String DEFINITION = "common.datetime.ExpirationDate_Validation( actionType, effectiveDate, executionTimestamp, expirationDate )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1018_01 {
	
		@Inject protected ExpirationDate_Validation expirationDate_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			ComparisonResult result = executeDataRule(aSICTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICTransactionReport aSICTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(expirationDate_Validation.evaluate(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get(), MapperS.of(aSICTransactionReport).<Date>map("getEffectiveDate", _aSICTransactionReport -> _aSICTransactionReport.getEffectiveDate()).get(), MapperS.of(aSICTransactionReport).<ZonedDateTime>map("getExecutionTimestamp", _aSICTransactionReport -> _aSICTransactionReport.getExecutionTimestamp()).get(), MapperS.of(aSICTransactionReport).<Date>map("getExpirationDate", _aSICTransactionReport -> _aSICTransactionReport.getExpirationDate()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1018_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
