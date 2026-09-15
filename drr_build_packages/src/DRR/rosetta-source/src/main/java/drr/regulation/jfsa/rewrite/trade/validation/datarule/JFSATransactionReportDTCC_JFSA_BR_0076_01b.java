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
@RosettaDataRule("JFSATransactionReportDTCC_JFSA_BR_0076_01b")
@ImplementedBy(JFSATransactionReportDTCC_JFSA_BR_0076_01b.Default.class)
public interface JFSATransactionReportDTCC_JFSA_BR_0076_01b extends Validator<JFSATransactionReport> {
	
	String NAME = "JFSATransactionReportDTCC_JFSA_BR_0076_01b";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and CommonAssetClass -> CURR = assetClass and [CommonContractType -> SWAP, CommonContractType -> SWPT, CommonContractType -> OPTN, CommonContractType -> CFDS] any = contractType then (if strikePriceNotation = Monetary then strikePriceCurrency exists and strikePriceCurrency = exchangeRateBasis)";
	
	class Default implements JFSATransactionReportDTCC_JFSA_BR_0076_01b {
	
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
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(jFSATransactionReport).<ActionTypeEnum>map("getActionType", _jFSATransactionReport -> _jFSATransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(CommonAssetClass.CURR), MapperS.of(jFSATransactionReport).<CommonAssetClass>map("getAssetClass", _jFSATransactionReport -> _jFSATransactionReport.getAssetClass()), CardinalityOperator.All)).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.CFDS)), MapperS.of(jFSATransactionReport).<CommonContractType>map("getContractType", _jFSATransactionReport -> _jFSATransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (areEqual(MapperS.of(jFSATransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _jFSATransactionReport -> _jFSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
						return exists(MapperS.of(jFSATransactionReport).<String>map("getStrikePriceCurrency", _jFSATransactionReport -> _jFSATransactionReport.getStrikePriceCurrency())).andNullSafe(areEqual(MapperS.of(jFSATransactionReport).<String>map("getStrikePriceCurrency", _jFSATransactionReport -> _jFSATransactionReport.getStrikePriceCurrency()), MapperS.of(jFSATransactionReport).<String>map("getExchangeRateBasis", _jFSATransactionReport -> _jFSATransactionReport.getExchangeRateBasis()), CardinalityOperator.All));
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
	class NoOp implements JFSATransactionReportDTCC_JFSA_BR_0076_01b {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, JFSATransactionReport jFSATransactionReport) {
			return Collections.emptyList();
		}
	}
}
