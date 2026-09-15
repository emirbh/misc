package drr.regulation.cftc.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCPart45TransactionReportPackageIdentifierCondition")
@ImplementedBy(CFTCPart45TransactionReportPackageIdentifierCondition.Default.class)
public interface CFTCPart45TransactionReportPackageIdentifierCondition extends Validator<CFTCPart45TransactionReport> {
	
	String NAME = "CFTCPart45TransactionReportPackageIdentifierCondition";
	String DEFINITION = "if packageIndicator = True then packageIdentifier exists else packageIdentifier is absent";
	
	class Default implements CFTCPart45TransactionReportPackageIdentifierCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			ComparisonResult result = executeDataRule(cFTCPart45TransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCPart45TransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			try {
				if (areEqual(MapperS.of(cFTCPart45TransactionReport).<Boolean>map("getPackageIndicator", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPackageIndicator()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(cFTCPart45TransactionReport).<String>map("getPackageIdentifier", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPackageIdentifier()));
				}
				return notExists(MapperS.of(cFTCPart45TransactionReport).<String>map("getPackageIdentifier", _cFTCPart45TransactionReport -> _cFTCPart45TransactionReport.getPackageIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCPart45TransactionReportPackageIdentifierCondition {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCPart45TransactionReport cFTCPart45TransactionReport) {
			return Collections.emptyList();
		}
	}
}
