package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0025_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0025_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0025_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0025_01";
	String DEFINITION = "if masterAgreementType exists and (masterAgreementType <> BIAG and masterAgreementType <> OTHR) then masterAgreementVersion exists else masterAgreementVersion is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0025_01 {
	
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
				if (exists(MapperS.of(cSATransactionReportTrade).<MasterAgreementEnum>map("getMasterAgreementType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getMasterAgreementType())).andNullSafe(notEqual(MapperS.of(cSATransactionReportTrade).<MasterAgreementEnum>map("getMasterAgreementType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getMasterAgreementType()), MapperS.of(MasterAgreementEnum.BIAG), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(cSATransactionReportTrade).<MasterAgreementEnum>map("getMasterAgreementType", _cSATransactionReportTrade -> _cSATransactionReportTrade.getMasterAgreementType()), MapperS.of(MasterAgreementEnum.OTHR), CardinalityOperator.Any))).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<Integer>map("getMasterAgreementVersion", _cSATransactionReportTrade -> _cSATransactionReportTrade.getMasterAgreementVersion()));
				}
				return notExists(MapperS.of(cSATransactionReportTrade).<Integer>map("getMasterAgreementVersion", _cSATransactionReportTrade -> _cSATransactionReportTrade.getMasterAgreementVersion()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0025_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
