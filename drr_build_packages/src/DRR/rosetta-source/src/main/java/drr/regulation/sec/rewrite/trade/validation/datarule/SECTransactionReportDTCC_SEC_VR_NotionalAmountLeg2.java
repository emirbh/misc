package drr.regulation.sec.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2 extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2";
	String DEFINITION = "if leg2 -> notionalCurrency exists then leg2 -> notionalAmount exists";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			ComparisonResult result = executeDataRule(sECTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SECTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SECTransactionReport sECTransactionReport) {
			try {
				if (exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg2", _sECTransactionReport -> _sECTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency())).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<SECLeg>map("getLeg2", _sECTransactionReport -> _sECTransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", sECLeg -> sECLeg.getNotionalAmount()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
