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
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportClearingSwapUSICondition")
@ImplementedBy(CFTCPart45TransactionReportClearingSwapUSICondition.Default.class)
public interface CFTCPart45TransactionReportClearingSwapUSICondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportClearingSwapUSICondition";
	String DEFINITION = "if (cleared = Y or (cleared = I and actionType = ActionTypeEnum -> TERM)) and eventType = EventTypeEnum -> CLRG then (if clearingSwapUSIs is absent then clearingSwapUTIs exists else if clearingSwapUSIs exists then clearingSwapUTIs is absent) else clearingSwapUSIs is absent";
	
	class Default implements CFTCPart45TransactionReportClearingSwapUSICondition {
	
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
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All))).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<String>mapC("getClearingSwapUSIs", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingSwapUSIs())).getOrDefault(false)) {
						return exists(MapperS.of(cFTCPart45TransactionReport).<String>mapC("getClearingSwapUTIs", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingSwapUTIs()));
					}
					if (exists(MapperS.of(cFTCPart45TransactionReport).<String>mapC("getClearingSwapUSIs", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingSwapUSIs())).getOrDefault(false)) {
						return notExists(MapperS.of(cFTCPart45TransactionReport).<String>mapC("getClearingSwapUTIs", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingSwapUTIs()));
					}
					return ComparisonResult.ofEmpty();
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<String>mapC("getClearingSwapUSIs", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getClearingSwapUSIs()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportClearingSwapUSICondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
