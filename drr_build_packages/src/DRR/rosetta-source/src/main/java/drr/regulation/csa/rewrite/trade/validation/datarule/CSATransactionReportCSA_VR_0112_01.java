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
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("CSATransactionReportCSA_VR_0112_01")
@ImplementedBy(CSATransactionReportCSA_VR_0112_01.Default.class)
public interface CSATransactionReportCSA_VR_0112_01 extends Validator<CSATransactionReport> {
	
	String NAME = "CSATransactionReportCSA_VR_0112_01";
	String DEFINITION = "if packageTransactionPriceNotation = Monetary then packageTransactionPriceCurrency exists else packageTransactionPriceCurrency is absent";
	
	class Default implements CSATransactionReportCSA_VR_0112_01 {
	
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
				if (areEqual(MapperS.of(cSATransactionReport).<PriceNotationEnum>map("getPackageTransactionPriceNotation", _cSATransactionReport -> _cSATransactionReport.getPackageTransactionPriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(cSATransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", _cSATransactionReport -> _cSATransactionReport.getPackageTransactionPriceCurrency()));
				}
				return notExists(MapperS.of(cSATransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", _cSATransactionReport -> _cSATransactionReport.getPackageTransactionPriceCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CSATransactionReportCSA_VR_0112_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CSATransactionReport cSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
