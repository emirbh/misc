package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportPriorUTICondition")
@ImplementedBy(CFTCPart45TransactionReportPriorUTICondition.Default.class)
public interface CFTCPart45TransactionReportPriorUTICondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportPriorUTICondition";
	String DEFINITION = "if actionType = ActionTypeEnum -> NEWT and [EventTypeEnum -> NOVA, EventTypeEnum -> CLRG, EventTypeEnum -> EXER, EventTypeEnum -> ALOC, EventTypeEnum -> CLAL] any = eventType and priorUSI is absent then priorUTI exists else priorUTI is absent";
	
	class Default implements CFTCPart45TransactionReportPriorUTICondition {
	
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
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<ActionTypeEnum>map("getActionType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.NOVA), MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.EXER), MapperS.of(EventTypeEnum.ALOC), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(cFTCPart45TransactionReport).<EventTypeEnum>map("getEventType", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getEventType()), CardinalityOperator.Any)).andNullSafe(notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getPriorUSI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPriorUSI()))).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<String>map("getPriorUTI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPriorUTI()));
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getPriorUTI", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPriorUTI()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportPriorUTICondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
