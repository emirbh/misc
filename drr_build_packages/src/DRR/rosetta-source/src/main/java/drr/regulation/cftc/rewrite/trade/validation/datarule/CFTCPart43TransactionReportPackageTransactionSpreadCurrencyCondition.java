package drr.regulation.cftc.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition")
@ImplementedBy(CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition.Default.class)
public interface CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition";
	String DEFINITION = "if packageTransactionSpreadNotation = Monetary then packageTransactionSpreadCurrency exists else packageTransactionSpreadCurrency is absent";
	
	class Default implements CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart43TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart43TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageTransactionSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageTransactionSpreadCurrency()));
				}
				return notExists(MapperS.of(cFTCPart43TransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageTransactionSpreadCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
