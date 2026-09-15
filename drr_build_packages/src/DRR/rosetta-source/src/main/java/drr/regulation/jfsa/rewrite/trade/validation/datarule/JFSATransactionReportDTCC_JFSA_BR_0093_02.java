package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.quantity.functions.QuantityUnitOfMeasureLeg_Validation;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0093_02")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0093_02.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0093_02 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0093_02";
	String DEFINITION = "if CommonAssetClass -> EQUI = assetClass then common.quantity.QuantityUnitOfMeasureLeg_Validation( actionType, leg2 -> totalNotionalQuantity, leg2 -> quantityUnitOfMeasure )";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0093_02 {
	
		@Inject protected QuantityUnitOfMeasureLeg_Validation quantityUnitOfMeasureLeg_Validation;
		
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			ComparisonResult result = executeDataRule(jFSATransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "JFSATransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(JFSATransactionReport jFSATransactionReport) {
			try {
				if (areEqual(MapperS.of(CommonAssetClass.EQUI), MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), CardinalityOperator.All).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(quantityUnitOfMeasureLeg_Validation.evaluate(MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()).get(), MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg2", _jFSATransactionReport -> _jFSATransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get(), MapperS.of(jFSATransactionReport).<CommonLeg>map("getLeg2", _jFSATransactionReport -> _jFSATransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0093_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
