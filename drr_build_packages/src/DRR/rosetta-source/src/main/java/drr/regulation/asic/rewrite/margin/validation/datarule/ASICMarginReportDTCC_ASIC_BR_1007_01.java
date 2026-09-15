package drr.regulation.asic.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import drr.regulation.common.trade.party.functions.Counterparty_Validation;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.MarginActionEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICMarginReportDTCC_ASIC_BR_1007_01")
@ImplementedBy(ASICMarginReportDTCC_ASIC_BR_1007_01.Default.class)
public interface ASICMarginReportDTCC_ASIC_BR_1007_01 extends Validator<ASICMarginReport> {
	
	String NAME = "ASICMarginReportDTCC_ASIC_BR_1007_01";
	String DEFINITION = "trade.party.Counterparty_Validation( actionType to-enum ActionTypeEnum, counterparty1, counterparty2 )";
	
	class Default implements ASICMarginReportDTCC_ASIC_BR_1007_01 {
	
		@Inject protected Counterparty_Validation counterparty_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			ComparisonResult result = executeDataRule(aSICMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICMarginReport aSICMarginReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty_Validation.evaluate(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()).checkedMap("to-enum", e -> ActionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(aSICMarginReport).<String>map("getCounterparty1", _aSICMarginReport -> _aSICMarginReport.getCounterparty1()).get(), MapperS.of(aSICMarginReport).<String>map("getCounterparty2", _aSICMarginReport -> _aSICMarginReport.getCounterparty2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICMarginReportDTCC_ASIC_BR_1007_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			return Collections.emptyList();
		}
	}
}
