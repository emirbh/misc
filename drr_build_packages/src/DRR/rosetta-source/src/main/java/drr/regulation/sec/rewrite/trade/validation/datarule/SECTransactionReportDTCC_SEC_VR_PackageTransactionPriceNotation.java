package drr.regulation.sec.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation")
@ImplementedBy(SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation.Default.class)
public interface SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation extends Validator<SECTransactionReport> {
	
	String NAME = "SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation";
	String DEFINITION = "if packageTransactionPrice exists then packageTransactionPriceNotation exists else packageTransactionPriceNotation is absent";
	
	class Default implements SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation {
	
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
				if (exists(MapperS.of(sECTransactionReport).<PriceFormat>map("getPackageTransactionPrice", _sECTransactionReport -> _sECTransactionReport.getPackageTransactionPrice())).getOrDefault(false)) {
					return exists(MapperS.of(sECTransactionReport).<PriceNotationEnum>map("getPackageTransactionPriceNotation", _sECTransactionReport -> _sECTransactionReport.getPackageTransactionPriceNotation()));
				}
				return notExists(MapperS.of(sECTransactionReport).<PriceNotationEnum>map("getPackageTransactionPriceNotation", _sECTransactionReport -> _sECTransactionReport.getPackageTransactionPriceNotation()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SECTransactionReport sECTransactionReport) {
			return Collections.emptyList();
		}
	}
}
