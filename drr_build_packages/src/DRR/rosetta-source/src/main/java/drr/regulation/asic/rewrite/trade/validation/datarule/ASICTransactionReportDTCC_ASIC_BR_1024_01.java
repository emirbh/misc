package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.trade.execution.functions.ClearingMember_Validation;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1024_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1024_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1024_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1024_01";
	String DEFINITION = "common.execution.ClearingMember_Validation( actionType, cleared, centralCounterparty, clearingMember )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1024_01 {
	
		@Inject protected ClearingMember_Validation clearingMember_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(clearingMember_Validation.evaluate(MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get(), MapperS.of(aSICTransactionReport).<ClearedEnum>map("getCleared", _aSICTransactionReport -> _aSICTransactionReport.getCleared()).get(), MapperS.of(aSICTransactionReport).<String>map("getCentralCounterparty", _aSICTransactionReport -> _aSICTransactionReport.getCentralCounterparty()).get(), MapperS.of(aSICTransactionReport).<String>map("getClearingMember", _aSICTransactionReport -> _aSICTransactionReport.getClearingMember()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1024_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
