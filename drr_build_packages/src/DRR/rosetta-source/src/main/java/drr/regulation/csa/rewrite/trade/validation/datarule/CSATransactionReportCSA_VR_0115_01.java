package drr.regulation.csa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0115_01")
@ImplementedBy(CSATransactionReportCSA_VR_0115_01.Default.class)
public interface CSATransactionReportCSA_VR_0115_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0115_01";
	String DEFINITION = "if packageTransactionSpread exists then packageTransactionSpreadNotation exists else packageTransactionSpreadNotation is absent";
	
	class Default implements CSATransactionReportCSA_VR_0115_01 {
	
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
				if (exists(MapperS.of(cSATransactionReport).<PriceFormat>map("getPackageTransactionSpread", _cSATransactionReport -> _cSATransactionReport.getPackageTransactionSpread())).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _cSATransactionReport -> _cSATransactionReport.getPackageTransactionSpreadNotation()));
				}
				return notExists(MapperS.of(cSATransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _cSATransactionReport -> _cSATransactionReport.getPackageTransactionSpreadNotation()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0115_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
