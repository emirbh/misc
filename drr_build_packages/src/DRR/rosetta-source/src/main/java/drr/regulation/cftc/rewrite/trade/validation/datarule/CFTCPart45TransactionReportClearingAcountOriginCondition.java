package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportClearingAcountOriginCondition")
@ImplementedBy(CFTCPart45TransactionReportClearingAcountOriginCondition.Default.class)
public interface CFTCPart45TransactionReportClearingAcountOriginCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportClearingAcountOriginCondition";
	String DEFINITION = "if cleared = Y then clearingAccountOrigin exists else if cleared = I or cleared = N then clearingAccountOrigin is absent";
	
	class Default implements CFTCPart45TransactionReportClearingAcountOriginCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<ClearingAccountOriginEnum>map("getClearingAccountOrigin", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingAccountOrigin()));
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(cFTCPart45TransactionReport).<ClearingAccountOriginEnum>map("getClearingAccountOrigin", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingAccountOrigin()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportClearingAcountOriginCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
