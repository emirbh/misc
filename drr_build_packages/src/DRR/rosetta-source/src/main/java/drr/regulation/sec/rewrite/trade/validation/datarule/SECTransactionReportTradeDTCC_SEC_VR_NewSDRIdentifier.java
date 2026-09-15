package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_NewSDRIdentifier")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_NewSDRIdentifier.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_NewSDRIdentifier extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_NewSDRIdentifier";
	String DEFINITION = "if actionType = ActionTypeEnum -> PRTO then newSDRIdentifier exists else newSDRIdentifier is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_NewSDRIdentifier {
	
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
				if (areEqual(MapperS.of(sECTransactionReportTrade).<ActionTypeEnum>map("getActionType", _sECTransactionReportTrade -> _sECTransactionReportTrade.getActionType()), MapperS.of(ActionTypeEnum.PRTO), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<String>map("getNewSDRIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNewSDRIdentifier()));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<String>map("getNewSDRIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getNewSDRIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_NewSDRIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
