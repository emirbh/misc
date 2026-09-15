package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier";
	String DEFINITION = "(if actionType = NEWT then uniqueSwapIdentifier is absent else True) and (if uniqueTransactionIdentifier is absent then uniqueSwapIdentifier exists else True)";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				final ComparisonResult ifThenElseResult0;
				if (areEqual(MapperS.of(sECTransactionReport).<ActionTypeEnum>map("getActionType", _sECTransactionReport -> _sECTransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult0 = notExists(MapperS.of(sECTransactionReport).<String>map("getUniqueSwapIdentifier", _sECTransactionReport -> _sECTransactionReport.getUniqueSwapIdentifier()));
				} else {
					ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				final ComparisonResult ifThenElseResult1;
				if (notExists(MapperS.of(sECTransactionReport).<String>map("getUniqueTransactionIdentifier", _sECTransactionReport -> _sECTransactionReport.getUniqueTransactionIdentifier())).getOrDefault(false)) {
					ifThenElseResult1 = exists(MapperS.of(sECTransactionReport).<String>map("getUniqueSwapIdentifier", _sECTransactionReport -> _sECTransactionReport.getUniqueSwapIdentifier()));
				} else {
					ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				return ifThenElseResult0.andNullSafe(ifThenElseResult1);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
