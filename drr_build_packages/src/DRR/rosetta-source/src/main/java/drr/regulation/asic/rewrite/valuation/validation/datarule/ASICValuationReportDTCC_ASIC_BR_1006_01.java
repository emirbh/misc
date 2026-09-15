package drr.regulation.asic.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import drr.regulation.common.trade.party.functions.Counterparty_Validation;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICValuationReportDTCC_ASIC_BR_1006_01")
@ImplementedBy(ASICValuationReportDTCC_ASIC_BR_1006_01.Default.class)
public interface ASICValuationReportDTCC_ASIC_BR_1006_01 extends Validator<ASICValuationReport> {
	
	String NAME = "ASICValuationReportDTCC_ASIC_BR_1006_01";
	String DEFINITION = "trade.party.Counterparty_Validation(actionType, counterparty1, counterparty2)";
	
	class Default implements ASICValuationReportDTCC_ASIC_BR_1006_01 {
	
		@Inject protected Counterparty_Validation counterparty_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICValuationReport aSICValuationReport) {
			ComparisonResult result = executeDataRule(aSICValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICValuationReport aSICValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty_Validation.evaluate(MapperS.of(aSICValuationReport).<ActionTypeEnum>map("getActionType", _aSICValuationReport -> _aSICValuationReport.getActionType()).get(), MapperS.of(aSICValuationReport).<String>map("getCounterparty1", _aSICValuationReport -> _aSICValuationReport.getCounterparty1()).get(), MapperS.of(aSICValuationReport).<String>map("getCounterparty2", _aSICValuationReport -> _aSICValuationReport.getCounterparty2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICValuationReportDTCC_ASIC_BR_1006_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICValuationReport aSICValuationReport) {
			return Collections.emptyList();
		}
	}
}
