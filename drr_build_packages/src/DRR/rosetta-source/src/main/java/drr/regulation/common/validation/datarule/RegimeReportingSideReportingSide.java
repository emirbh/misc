package drr.regulation.common.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.ReportingSide;
import drr.regulation.common.RegimeReportingSide;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("RegimeReportingSideReportingSide")
@ImplementedBy(RegimeReportingSideReportingSide.Default.class)
public interface RegimeReportingSideReportingSide extends Validator<RegimeReportingSide> {
	
	String NAME = "RegimeReportingSideReportingSide";
	String DEFINITION = "reportingSide exists or delegatedReportingSide exists";
	
	class Default implements RegimeReportingSideReportingSide {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeReportingSide regimeReportingSide) {
			ComparisonResult result = executeDataRule(regimeReportingSide);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RegimeReportingSide", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RegimeReportingSide", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RegimeReportingSide regimeReportingSide) {
			try {
				return exists(MapperS.of(regimeReportingSide).<ReportingSide>map("getReportingSide", _regimeReportingSide -> _regimeReportingSide.getReportingSide())).orNullSafe(exists(MapperS.of(regimeReportingSide).<ReportingSide>map("getDelegatedReportingSide", _regimeReportingSide -> _regimeReportingSide.getDelegatedReportingSide())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RegimeReportingSideReportingSide {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegimeReportingSide regimeReportingSide) {
			return Collections.emptyList();
		}
	}
}
