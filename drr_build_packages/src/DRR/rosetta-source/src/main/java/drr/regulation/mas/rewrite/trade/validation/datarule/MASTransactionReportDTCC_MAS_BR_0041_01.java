package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.execution.functions.ClearingMember_Validation;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0041_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0041_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0041_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0041_01";
	String DEFINITION = "common.execution.ClearingMember_Validation( actionType, cleared, centralCounterparty, clearingMember )";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0041_01 {
	
		@Inject protected ClearingMember_Validation clearingMember_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(clearingMember_Validation.evaluate(MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()).get(), MapperS.of(mASTransactionReport).<ClearedEnum>map("getCleared", _mASTransactionReport -> _mASTransactionReport.getCleared()).get(), MapperS.of(mASTransactionReport).<String>map("getCentralCounterparty", _mASTransactionReport -> _mASTransactionReport.getCentralCounterparty()).get(), MapperS.of(mASTransactionReport).<String>map("getClearingMember", _mASTransactionReport -> _mASTransactionReport.getClearingMember()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0041_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
