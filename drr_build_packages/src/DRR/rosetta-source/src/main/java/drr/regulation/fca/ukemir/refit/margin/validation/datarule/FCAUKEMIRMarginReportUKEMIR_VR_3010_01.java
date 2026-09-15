package drr.regulation.fca.ukemir.refit.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRMarginReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("FCAUKEMIRMarginReportUKEMIR_VR_3010_01")
@ImplementedBy(FCAUKEMIRMarginReportUKEMIR_VR_3010_01.Default.class)
public interface FCAUKEMIRMarginReportUKEMIR_VR_3010_01 extends Validator<FCAUKEMIRMarginReport> {
	
	String NAME = "FCAUKEMIRMarginReportUKEMIR_VR_3010_01";
	String DEFINITION = "if collateralPortfolioIndicator exists and collateralPortfolioIndicator = False then uti exists else uti is absent";
	
	class Default implements FCAUKEMIRMarginReportUKEMIR_VR_3010_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			ComparisonResult result = executeDataRule(fCAUKEMIRMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FCAUKEMIRMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			try {
				if (exists(MapperS.of(fCAUKEMIRMarginReport).<Boolean>map("getCollateralPortfolioIndicator", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCollateralPortfolioIndicator())).andNullSafe(areEqual(MapperS.of(fCAUKEMIRMarginReport).<Boolean>map("getCollateralPortfolioIndicator", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getCollateralPortfolioIndicator()), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
					return exists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getUti", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getUti()));
				}
				return notExists(MapperS.of(fCAUKEMIRMarginReport).<String>map("getUti", _fCAUKEMIRMarginReport -> _fCAUKEMIRMarginReport.getUti()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FCAUKEMIRMarginReportUKEMIR_VR_3010_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAUKEMIRMarginReport fCAUKEMIRMarginReport) {
			return Collections.emptyList();
		}
	}
}
