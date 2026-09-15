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
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportCentralCounterpartyCondition")
@ImplementedBy(CFTCPart45TransactionReportCentralCounterpartyCondition.Default.class)
public interface CFTCPart45TransactionReportCentralCounterpartyCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportCentralCounterpartyCondition";
	String DEFINITION = "if cleared = Y then centralCounterparty exists and centralCounterparty = counterparty1 else if cleared = N then centralCounterparty is absent";
	
	class Default implements CFTCPart45TransactionReportCentralCounterpartyCondition {
	
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
					return exists(MapperS.of(cFTCPart45TransactionReport).<String>map("getCentralCounterparty", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCentralCounterparty())).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<String>map("getCentralCounterparty", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCentralCounterparty()), MapperS.of(cFTCPart45TransactionReport).<String>map("getCounterparty1", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCounterparty1()), CardinalityOperator.All));
				}
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getCentralCounterparty", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCentralCounterparty()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportCentralCounterpartyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
