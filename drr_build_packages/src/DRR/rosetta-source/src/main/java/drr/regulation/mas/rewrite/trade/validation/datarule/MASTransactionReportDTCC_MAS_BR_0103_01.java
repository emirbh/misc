package drr.regulation.mas.rewrite.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.CommonContractType;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASTransactionReportDTCC_MAS_BR_0103_01")
@ImplementedBy(MASTransactionReportDTCC_MAS_BR_0103_01.Default.class)
public interface MASTransactionReportDTCC_MAS_BR_0103_01 extends Validator<MASTransactionReport> {
	
	String NAME = "MASTransactionReportDTCC_MAS_BR_0103_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType and [CommonContractType -> SWPT, CommonContractType -> SWAP, CommonContractType -> OPTN] any = contractType then if strikePrice exists then strikePriceNotation exists and if contractType = CommonContractType -> SWAP then strikePriceNotation = Decimal else True";
	
	class Default implements MASTransactionReportDTCC_MAS_BR_0103_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			ComparisonResult result = executeDataRule(mASTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASTransactionReport mASTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(mASTransactionReport).<ActionTypeEnum>map("getActionType", _mASTransactionReport -> _mASTransactionReport.getActionType()), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.SWPT), MapperS.of(CommonContractType.SWAP), MapperS.of(CommonContractType.OPTN)), MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), CardinalityOperator.Any)).getOrDefault(false)) {
					if (exists(MapperS.of(mASTransactionReport).<PriceFormat>map("getStrikePrice", _mASTransactionReport -> _mASTransactionReport.getStrikePrice())).getOrDefault(false)) {
						final ComparisonResult ifThenElseResult;
						if (areEqual(MapperS.of(mASTransactionReport).<CommonContractType>map("getContractType", _mASTransactionReport -> _mASTransactionReport.getContractType()), MapperS.of(CommonContractType.SWAP), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = areEqual(MapperS.of(mASTransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _mASTransactionReport -> _mASTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All);
						} else {
							ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
						}
						return exists(MapperS.of(mASTransactionReport).<PriceNotationEnum>map("getStrikePriceNotation", _mASTransactionReport -> _mASTransactionReport.getStrikePriceNotation())).andNullSafe(ifThenElseResult);
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
	class NoOp implements MASTransactionReportDTCC_MAS_BR_0103_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASTransactionReport mASTransactionReport) {
			return Collections.emptyList();
		}
	}
}
