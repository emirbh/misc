package drr.regulation.jfsa.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.party.functions.Counterparty_Validation;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSAValuationReportDTCC_JFSA_VR_0008_01")
@ImplementedBy(JFSAValuationReportDTCC_JFSA_VR_0008_01.Default.class)
public interface JFSAValuationReportDTCC_JFSA_VR_0008_01 extends Validator<JFSAValuationReport> {
	
	String NAME = "JFSAValuationReportDTCC_JFSA_VR_0008_01";
	String DEFINITION = "if counterparty2IdentifierType = True then common.party.Counterparty_Validation(actionType, counterparty1, counterparty2)";
	
	class Default implements JFSAValuationReportDTCC_JFSA_VR_0008_01 {
	
		@Inject protected Counterparty_Validation counterparty_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAValuationReport jFSAValuationReport) {
			ComparisonResult result = executeDataRule(jFSAValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSAValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSAValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSAValuationReport jFSAValuationReport) {
			try {
				if (areEqual(MapperS.of(jFSAValuationReport).<Boolean>map("getCounterparty2IdentifierType", _jFSAValuationReport -> _jFSAValuationReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(counterparty_Validation.evaluate(MapperS.of(jFSAValuationReport).<ActionTypeEnum>map("getActionType", _jFSAValuationReport -> _jFSAValuationReport.getActionType()).get(), MapperS.of(jFSAValuationReport).<String>map("getCounterparty1", _jFSAValuationReport -> _jFSAValuationReport.getCounterparty1()).get(), MapperS.of(jFSAValuationReport).<String>map("getCounterparty2", _jFSAValuationReport -> _jFSAValuationReport.getCounterparty2()).get())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSAValuationReportDTCC_JFSA_VR_0008_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSAValuationReport jFSAValuationReport) {
			return Collections.emptyList();
		}
	}
}
