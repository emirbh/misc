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
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0076_01")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0076_01.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0076_01 extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0076_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonAssetClass -> INTR, CommonAssetClass -> CRDT, CommonAssetClass -> EQUI, CommonAssetClass -> COMM] any = assetClass and [CommonContractType -> SWAP, CommonContractType -> SWPT, CommonContractType -> OPTN, CommonContractType -> CFDS] any = contractType then (if strikePriceNotation = Monetary then strikePriceCurrency exists) else if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and assetClass = CommonAssetClass -> CURR and [CommonContractType -> SWPT, CommonContractType -> OPTN] any = contractType then strikePriceCurrency exists";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0076_01 {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonAssetClass>of(MapperS.of(CommonAssetClass.INTR), MapperS.of(CommonAssetClass.CRDT), MapperS.of(CommonAssetClass.EQUI), MapperS.of(CommonAssetClass.COMM)), MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), CardinalityOperator.Any)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.CFDS)), MapperS.of(jFSATransactionReport).<CommonContractType>map("getContractType", _jFSATransactionReport -> _jFSATransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (areEqual(MapperS.of(jFSATransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _jFSATransactionReport -> _jFSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<String>map("getStrikePriceCurrency", _jFSATransactionReport -> _jFSATransactionReport.getStrikePriceCurrency()));
					}
					return ComparisonResult.ofEmpty();
				}
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OPTN)), MapperS.of(jFSATransactionReport).<CommonContractType>map("getContractType", _jFSATransactionReport -> _jFSATransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					return exists(MapperS.of(jFSATransactionReport).<String>map("getStrikePriceCurrency", _jFSATransactionReport -> _jFSATransactionReport.getStrikePriceCurrency()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0076_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
