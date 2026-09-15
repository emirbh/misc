package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
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
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_ClearingSwapUSIs")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_ClearingSwapUSIs.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_ClearingSwapUSIs extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_ClearingSwapUSIs";
	String DEFINITION = "if (cleared = Y or (cleared = I and actionType = TERM)) and [EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType and clearingSwapUTIs is absent then clearingSwapUSIs exists";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_ClearingSwapUSIs {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			ComparisonResult result = executeDataRule(sECTransactionReportTrade);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReportTrade", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReportTrade sECTransactionReportTrade) {
			try {
				if (areEqual(MapperS.of(sECTransactionReportTrade).<ClearedEnum>map("getCleared", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<ClearedEnum>map("getCleared", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<ActionTypeEnum>map("getActionType", _sECTransactionReportTrade -> _sECTransactionReportTrade.getActionType()), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All))).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(sECTransactionReportTrade).<EventTypeEnum>map("getEventType", _sECTransactionReportTrade -> _sECTransactionReportTrade.getEventType()), CardinalityOperator.Any)).andNullSafe(notExists(MapperS.of(sECTransactionReportTrade).<String>mapC("getClearingSwapUTIs", _sECTransactionReportTrade -> _sECTransactionReportTrade.getClearingSwapUTIs()))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<String>mapC("getClearingSwapUSIs", _sECTransactionReportTrade -> _sECTransactionReportTrade.getClearingSwapUSIs()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_ClearingSwapUSIs {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
