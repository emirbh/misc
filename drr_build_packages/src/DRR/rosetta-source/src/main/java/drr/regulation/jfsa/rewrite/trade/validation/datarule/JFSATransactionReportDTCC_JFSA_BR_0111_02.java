package drr.regulation.jfsa.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0111_02")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0111_02.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0111_02 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0111_02";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonAssetClass -> CRDT, CommonAssetClass -> EQUI] any = assetClass then (if underlyingIdentificationType = I then underlyingIdentification exists else if underlyingIdentificationType = X and nameOfTheUnderlyingIndex is absent then underlyingIdentification exists)";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0111_02 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI)), MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (areEqual(MapperS.of(jFSATransactionReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", _jFSATransactionReport -> _jFSATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<String>map("getUnderlyingIdentification", _jFSATransactionReport -> _jFSATransactionReport.getUnderlyingIdentification()));
					}
					if (areEqual(MapperS.of(jFSATransactionReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", _jFSATransactionReport -> _jFSATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(jFSATransactionReport).<String>map("getNameOfTheUnderlyingIndex", _jFSATransactionReport -> _jFSATransactionReport.getNameOfTheUnderlyingIndex()))).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<String>map("getUnderlyingIdentification", _jFSATransactionReport -> _jFSATransactionReport.getUnderlyingIdentification()));
					}
					return ComparisonResult.ofEmpty();
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0111_02 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
