package drr.regulation.csa.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportDTCC_CSA_VR_0137_01")
@ImplementedBy(CSATransactionReportDTCC_CSA_VR_0137_01.Default.class)
public interface CSATransactionReportDTCC_CSA_VR_0137_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportDTCC_CSA_VR_0137_01";
	String DEFINITION = "if otherPayment -> currency exists and otherPayment -> currency count > 1 then otherPayment -> amount count = otherPayment -> currency count";
	
	class Default implements CSATransactionReportDTCC_CSA_VR_0137_01 {
	
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
				if (exists(MapperS.of(cSATransactionReport).<OtherPayment>mapC("getOtherPayment", _cSATransactionReport -> _cSATransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency())).andNullSafe(greaterThan(MapperS.of(MapperS.of(cSATransactionReport).<OtherPayment>mapC("getOtherPayment", _cSATransactionReport -> _cSATransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).resultCount()), MapperS.of(1), CardinalityOperator.All)).getOrDefault(false)) {
					return areEqual(MapperS.of(MapperS.of(cSATransactionReport).<OtherPayment>mapC("getOtherPayment", _cSATransactionReport -> _cSATransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).resultCount()), MapperS.of(MapperS.of(cSATransactionReport).<OtherPayment>mapC("getOtherPayment", _cSATransactionReport -> _cSATransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency()).resultCount()), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportDTCC_CSA_VR_0137_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
