package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart43TransactionReportPackageTransactionSpreadCondition")
@ImplementedBy(CFTCPart43TransactionReportPackageTransactionSpreadCondition.Default.class)
public interface CFTCPart43TransactionReportPackageTransactionSpreadCondition extends Validator<CFTCPart43TransactionReport> {
	
	String NAME = "CFTCPart43TransactionReportPackageTransactionSpreadCondition";
	String DEFINITION = "if packageIndicator = True and packageTransactionPrice is absent then packageTransactionSpread exists else packageTransactionSpread is absent";
	
	class Default implements CFTCPart43TransactionReportPackageTransactionSpreadCondition {
	
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
				if (areEqual(MapperS.of(cFTCPart43TransactionReport).<Boolean>map("getPackageIndicator", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageIndicator()), MapperS.of(true), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(cFTCPart43TransactionReport).<PriceFormat>map("getPackageTransactionPrice", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageTransactionPrice()))).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart43TransactionReport).<PriceFormat>map("getPackageTransactionSpread", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageTransactionSpread()));
				}
				return notExists(MapperS.of(cFTCPart43TransactionReport).<PriceFormat>map("getPackageTransactionSpread", _cFTCPart43TransactionReport -> _cFTCPart43TransactionReport.getPackageTransactionSpread()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart43TransactionReportPackageTransactionSpreadCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart43TransactionReport cFTCPart43TransactionReport) {
			return Collections.emptyList();
		}
	}
}
