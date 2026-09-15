package drr.regulation.cftc.rewrite.valuation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.cftc.rewrite.valuation.CFTCValuationReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CFTCValuationReportCFTC_VR_0103_01")
@ImplementedBy(CFTCValuationReportCFTC_VR_0103_01.Default.class)
public interface CFTCValuationReportCFTC_VR_0103_01 extends Validator<CFTCValuationReport> {
	
	String NAME = "CFTCValuationReportCFTC_VR_0103_01";
	String DEFINITION = "if uniqueSwapIdentifier is absent then uniqueTransactionIdentifier exists else uniqueTransactionIdentifier is absent";
	
	class Default implements CFTCValuationReportCFTC_VR_0103_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCValuationReport cFTCValuationReport) {
			ComparisonResult result = executeDataRule(cFTCValuationReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCValuationReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CFTCValuationReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CFTCValuationReport cFTCValuationReport) {
			try {
				if (notExists(MapperS.of(cFTCValuationReport).<String>map("getUniqueSwapIdentifier", _cFTCValuationReport -> _cFTCValuationReport.getUniqueSwapIdentifier())).getOrDefault(false)) {
					return exists(MapperS.of(cFTCValuationReport).<String>map("getUniqueTransactionIdentifier", _cFTCValuationReport -> _cFTCValuationReport.getUniqueTransactionIdentifier()));
				}
				return notExists(MapperS.of(cFTCValuationReport).<String>map("getUniqueTransactionIdentifier", _cFTCValuationReport -> _cFTCValuationReport.getUniqueTransactionIdentifier()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CFTCValuationReportCFTC_VR_0103_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CFTCValuationReport cFTCValuationReport) {
			return Collections.emptyList();
		}
	}
}
