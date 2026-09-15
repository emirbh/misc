package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
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
@RosettaDataRule("SECTransactionReportTradeDTCC_SEC_VR_OriginalSwapSDRIdentifier")
@ImplementedBy(SECTransactionReportTradeDTCC_SEC_VR_OriginalSwapSDRIdentifier.Default.class)
public interface SECTransactionReportTradeDTCC_SEC_VR_OriginalSwapSDRIdentifier extends Validator<SECTransactionReportTrade> {
	
	String NAME = "SECTransactionReportTradeDTCC_SEC_VR_OriginalSwapSDRIdentifier";
	String DEFINITION = "if (cleared = Y and actionType = NEWT and [EventTypeEnum -> CLRG, EventTypeEnum -> CLAL] any = eventType) or dtccAdditionalFields -> originalSwapSDRIDType exists then originalSwapSDRIdentifier exists else originalSwapSDRIdentifier is absent";
	
	class Default implements SECTransactionReportTradeDTCC_SEC_VR_OriginalSwapSDRIdentifier {
	
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
				if (areEqual(MapperS.of(sECTransactionReportTrade).<ClearedEnum>map("getCleared", _sECTransactionReportTrade -> _sECTransactionReportTrade.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(sECTransactionReportTrade).<ActionTypeEnum>map("getActionType", _sECTransactionReportTrade -> _sECTransactionReportTrade.getActionType()), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<EventTypeEnum>of(MapperS.of(EventTypeEnum.CLRG), MapperS.of(EventTypeEnum.CLAL)), MapperS.of(sECTransactionReportTrade).<EventTypeEnum>map("getEventType", _sECTransactionReportTrade -> _sECTransactionReportTrade.getEventType()), CardinalityOperator.Any)).orNullSafe(exists(MapperS.of(sECTransactionReportTrade).<DTCCAdditionalFields>map("getDtccAdditionalFields", _sECTransactionReportTrade -> _sECTransactionReportTrade.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getOriginalSwapSDRIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOriginalSwapSDRIDType()))).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReportTrade).<String>map("getOriginalSwapSDRIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOriginalSwapSDRIdentifier()));
				}
				return notExists(MapperS.of(sECTransactionReportTrade).<String>map("getOriginalSwapSDRIdentifier", _sECTransactionReportTrade -> _sECTransactionReportTrade.getOriginalSwapSDRIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportTradeDTCC_SEC_VR_OriginalSwapSDRIdentifier {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReportTrade sECTransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
