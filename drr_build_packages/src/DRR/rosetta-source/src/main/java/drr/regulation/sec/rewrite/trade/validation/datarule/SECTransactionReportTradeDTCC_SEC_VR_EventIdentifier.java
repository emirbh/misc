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
import drr.standards.iso.EventTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_EventIdentifier")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_EventIdentifier.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_EventIdentifier extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_EventIdentifier";
	String DEFINITION = "if [EventTypeEnum -> COMP, EventTypeEnum -> CREV] any = eventType then eventIdentifier exists else eventIdentifier is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_EventIdentifier {
	
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
				if (areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.COMP), MapperS.of(EventTypeEnum.CREV)), MapperS.of(sECTransactionReportTrade).<EventTypeEnum>map("getEventType", _sECTransactionReportTrade -> _sECTransactionReportTrade.getEventType()), CardinalityOperator.Any).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<String>map("getEventIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getEventIdentifier()));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<String>map("getEventIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getEventIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_EventIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
