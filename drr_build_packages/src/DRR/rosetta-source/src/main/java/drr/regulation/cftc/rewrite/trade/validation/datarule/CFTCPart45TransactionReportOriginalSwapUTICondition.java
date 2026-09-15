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
@RosettaDataRule("CFTCPart45TransactionReportOriginalSwapUTICondition")
@ImplementedBy(CFTCPart45TransactionReportOriginalSwapUTICondition.Default.class)
public interface CFTCPart45TransactionReportOriginalSwapUTICondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportOriginalSwapUTICondition";
	String DEFINITION = "if cleared = Y and actionType = ActionTypeEnum -> NEWT and eventType = EventTypeEnum -> CLRG then (if originalSwapUTI is absent then originalSwapUSI exists else if originalSwapUTI exists then originalSwapUSI is absent) else originalSwapUTI is absent";
	
	class Default implements CFTCPart45TransactionReportOriginalSwapUTICondition {
	
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
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ClearedEnum>map("getCleared", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
					if (notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getOriginalSwapUTI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOriginalSwapUTI())).getOrDefault(false)) {
						return exists(MapperS.of(cFTCPart45TransactionReport).<String>map("getOriginalSwapUSI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOriginalSwapUSI()));
					}
					if (exists(MapperS.of(cFTCPart45TransactionReport).<String>map("getOriginalSwapUTI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOriginalSwapUTI())).getOrDefault(false)) {
						return notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getOriginalSwapUSI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOriginalSwapUSI()));
					}
					return ComparisonResult.ofEmpty();
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getOriginalSwapUTI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getOriginalSwapUTI()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportOriginalSwapUTICondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
