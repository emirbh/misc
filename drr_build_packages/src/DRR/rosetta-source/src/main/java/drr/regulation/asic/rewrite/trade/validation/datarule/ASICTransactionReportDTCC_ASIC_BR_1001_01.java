package drr.regulation.asic.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.standards.iosco.uti.functions.UniqueTransactionIdentifier_Validation;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;


/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1001_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1001_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1001_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1001_01";
	String DEFINITION = "uti.UniqueTransactionIdentifier_Validation( uniqueTransactionIdentifier, uniqueTransactionIdentifierProprietary, priorUTI, priorUTIProprietary, actionType )";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1001_01 {
	
		@Inject protected UniqueTransactionIdentifier_Validation uniqueTransactionIdentifier_Validation;
		
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
				return ComparisonResult.ofNullSafe(MapperS.of(uniqueTransactionIdentifier_Validation.evaluate(MapperS.of(aSICTransactionReport).<String>map("getUniqueTransactionIdentifier", _aSICTransactionReport -> _aSICTransactionReport.getUniqueTransactionIdentifier()).get(), MapperS.of(aSICTransactionReport).<String>map("getUniqueTransactionIdentifierProprietary", _aSICTransactionReport -> _aSICTransactionReport.getUniqueTransactionIdentifierProprietary()).get(), MapperS.of(aSICTransactionReport).<String>map("getPriorUTI", _aSICTransactionReport -> _aSICTransactionReport.getPriorUTI()).get(), MapperS.of(aSICTransactionReport).<String>map("getPriorUTIProprietary", _aSICTransactionReport -> _aSICTransactionReport.getPriorUTIProprietary()).get(), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()).get())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1001_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
