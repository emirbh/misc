package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeDTCC_CSA_VR_0076_01")
@ImplementedBy(CSATransactionReportTradeDTCC_CSA_VR_0076_01.Default.class)
public interface CSATransactionReportTradeDTCC_CSA_VR_0076_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeDTCC_CSA_VR_0076_01";
	String DEFINITION = "if (actionType = NEWT and [EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType) or (actionType = TERM and [EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType) then clearingReceiptTimestamp exists";
	
	class Default implements CSATransactionReportTradeDTCC_CSA_VR_0076_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			ComparisonResult result = executeDataRule(cSATransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CSATransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CSATransactionReportTrade cSATransactionReportTrade) {
			try {
				if (areEqual(MapperS.of(cSATransactionReportTrade).<ActionTypeEnum>map("getActionType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(cSATransactionReportTrade).<EventTypeEnum>map("getEventType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getEventType()), CardinalityOperator.Any)).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<ActionTypeEnum>map("getActionType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(cSATransactionReportTrade).<EventTypeEnum>map("getEventType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getEventType()), CardinalityOperator.Any))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<ZonedDateTime>map("getClearingReceiptTimestamp", _cSATransactionReportTrade -> _cSATransactionReportTrade.getClearingReceiptTimestamp()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeDTCC_CSA_VR_0076_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
