package drr.regulation.mas.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.party.functions.Counterparty_Validation;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.MarginActionEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("MASMarginReportDTCC_MAS_BR_0001_01")
@ImplementedBy(MASMarginReportDTCC_MAS_BR_0001_01.Default.class)
public interface MASMarginReportDTCC_MAS_BR_0001_01 extends Validator<MASMarginReport> {
	
	String NAME = "MASMarginReportDTCC_MAS_BR_0001_01";
	String DEFINITION = "trade.party.Counterparty_Validation( actionType to-enum ActionTypeEnum, counterparty1, counterparty2 )";
	
	class Default implements MASMarginReportDTCC_MAS_BR_0001_01 {
	
		@Inject protected Counterparty_Validation counterparty_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			ComparisonResult result = executeDataRule(mASMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASMarginReport mASMarginReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty_Validation.evaluate(MapperS.of(mASMarginReport).<MarginActionEnum>map("getActionType", _mASMarginReport -> _mASMarginReport.getActionType()).checkedMap("to-enum", e -> ActionTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(mASMarginReport).<String>map("getCounterparty1", _mASMarginReport -> _mASMarginReport.getCounterparty1()).get(), MapperS.of(mASMarginReport).<String>map("getCounterparty2", _mASMarginReport -> _mASMarginReport.getCounterparty2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASMarginReportDTCC_MAS_BR_0001_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			return Collections.emptyList();
		}
	}
}
