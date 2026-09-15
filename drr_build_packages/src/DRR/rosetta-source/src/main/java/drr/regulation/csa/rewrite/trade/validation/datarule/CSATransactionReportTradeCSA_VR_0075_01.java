package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.csa.rewrite.trade.CSATransactionReportTrade;
import drr.standards.iso.ClearedEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportTradeCSA_VR_0075_01")
@ImplementedBy(CSATransactionReportTradeCSA_VR_0075_01.Default.class)
public interface CSATransactionReportTradeCSA_VR_0075_01 extends Validator<CSATransactionReportTrade> {
	
	String NAME = "CSATransactionReportTradeCSA_VR_0075_01";
	String DEFINITION = "if cleared = Y then clearingMember exists else if cleared = N or cleared = I then clearingMember is absent";
	
	class Default implements CSATransactionReportTradeCSA_VR_0075_01 {
	
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
				if (areEqual(MapperS.of(cSATransactionReportTrade).<ClearedEnum>map("getCleared", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCleared()), MapperS.of(ClearedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReportTrade).<String>map("getClearingMember", _cSATransactionReportTrade -> _cSATransactionReportTrade.getClearingMember()));
				}
				if (areEqual(MapperS.of(cSATransactionReportTrade).<ClearedEnum>map("getCleared", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cSATransactionReportTrade).<ClearedEnum>map("getCleared", _cSATransactionReportTrade -> _cSATransactionReportTrade.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
					return notExists(MapperS.of(cSATransactionReportTrade).<String>map("getClearingMember", _cSATransactionReportTrade -> _cSATransactionReportTrade.getClearingMember()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportTradeCSA_VR_0075_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReportTrade cSATransactionReportTrade) {
			return Collections.emptyList();
		}
	}
}
