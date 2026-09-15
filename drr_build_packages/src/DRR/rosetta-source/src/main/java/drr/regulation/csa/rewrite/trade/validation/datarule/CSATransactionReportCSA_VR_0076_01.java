package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.EventTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0076_01")
@ImplementedBy(CSATransactionReportCSA_VR_0076_01.Default.class)
public interface CSATransactionReportCSA_VR_0076_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0076_01";
	String DEFINITION = "if (cleared = Y or (cleared = I and actionType = TERM)) and eventType = CLRG then clearingReceiptTimestamp exists else clearingReceiptTimestamp is absent";
	
	class Default implements CSATransactionReportCSA_VR_0076_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			ComparisonResult result = executeDataRule(cSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReport cSATransactionReport) {
			try {
				if (areEqual(MapperS.of(cSATransactionReport).<ClearedEnum>map("getCleared", _cSATransactionReport -> _cSATransactionReport.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReport).<ClearedEnum>map("getCleared", _cSATransactionReport -> _cSATransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(cSATransactionReport).<ActionTypeEnum>map("getActionType", _cSATransactionReport -> _cSATransactionReport.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All))).andNullSafe(areEqual(MapperS.of(cSATransactionReport).<EventTypeEnum>map("getEventType", _cSATransactionReport -> _cSATransactionReport.getEventType()), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<ZonedDateTime>map("getClearingReceiptTimestamp", _cSATransactionReport -> _cSATransactionReport.getClearingReceiptTimestamp()));
				}
				return notExists(MapperS.of(cSATransactionReport).<ZonedDateTime>map("getClearingReceiptTimestamp", _cSATransactionReport -> _cSATransactionReport.getClearingReceiptTimestamp()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0076_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
