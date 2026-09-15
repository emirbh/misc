package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure";
	String DEFINITION = "if price exists then priceUnitOfMeasure exists else priceUnitOfMeasure is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure {
	
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
				if (exists(MapperS.of(sECTransactionReport).<PriceFormat>map("getPrice", _sECTransactionReport -> _sECTransactionReport.getPrice())).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<String>map("getPriceUnitOfMeasure", _sECTransactionReport -> _sECTransactionReport.getPriceUnitOfMeasure()));
				}
				return notExists(MapperS.of(sECTransactionReport).<String>map("getPriceUnitOfMeasure", _sECTransactionReport -> _sECTransactionReport.getPriceUnitOfMeasure()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
