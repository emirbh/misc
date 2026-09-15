package drr.regulation.mas.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.party.functions.Counterparty_Validation;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("MASValuationReportDTCC_MAS_BR_0002_01")
@ImplementedBy(MASValuationReportDTCC_MAS_BR_0002_01.Default.class)
public interface MASValuationReportDTCC_MAS_BR_0002_01 extends Validator<MASValuationReport> {
	
	String NAME = "MASValuationReportDTCC_MAS_BR_0002_01";
	String DEFINITION = "trade.party.Counterparty_Validation(actionType, counterparty1, counterparty2)";
	
	class Default implements MASValuationReportDTCC_MAS_BR_0002_01 {
	
		@Inject protected Counterparty_Validation counterparty_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			ComparisonResult result = executeDataRule(mASValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASValuationReport mASValuationReport) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(counterparty_Validation.evaluate(MapperS.of(mASValuationReport).<ActionTypeEnum>map("getActionType", _mASValuationReport -> _mASValuationReport.getActionType()).get(), MapperS.of(mASValuationReport).<String>map("getCounterparty1", _mASValuationReport -> _mASValuationReport.getCounterparty1()).get(), MapperS.of(mASValuationReport).<String>map("getCounterparty2", _mASValuationReport -> _mASValuationReport.getCounterparty2()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASValuationReportDTCC_MAS_BR_0002_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASValuationReport mASValuationReport) {
			return Collections.emptyList();
		}
	}
}
