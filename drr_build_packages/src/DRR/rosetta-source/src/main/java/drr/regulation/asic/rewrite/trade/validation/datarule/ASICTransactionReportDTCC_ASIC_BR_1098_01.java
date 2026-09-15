package drr.regulation.asic.rewrite.trade.validation.datarule;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
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
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICTransactionReportDTCC_ASIC_BR_1098_01")
@ImplementedBy(ASICTransactionReportDTCC_ASIC_BR_1098_01.Default.class)
public interface ASICTransactionReportDTCC_ASIC_BR_1098_01 extends Validator<ASICTransactionReport> {
	
	String NAME = "ASICTransactionReportDTCC_ASIC_BR_1098_01";
	String DEFINITION = "if [ActionTypeEnum -> NEWT, ActionTypeEnum -> MODI, ActionTypeEnum -> CORR, ActionTypeEnum -> REVI] any = actionType then if packageTransactionSpreadNotation = Monetary then packageTransactionSpreadCurrency exists and [ISOCurrencyCodeEnum -> XAG, ISOCurrencyCodeEnum -> XAU, ISOCurrencyCodeEnum -> XBA, ISOCurrencyCodeEnum -> XBB, ISOCurrencyCodeEnum -> XBC, ISOCurrencyCodeEnum -> XBD, ISOCurrencyCodeEnum -> XDR, ISOCurrencyCodeEnum -> XPD, ISOCurrencyCodeEnum -> XPT, ISOCurrencyCodeEnum -> XTS, ISOCurrencyCodeEnum -> XXX] any <> packageTransactionSpreadCurrency else if packageTransactionSpreadNotation = Decimal or packageTransactionSpreadNotation = Basis then packageTransactionSpreadCurrency is absent";
	
	class Default implements ASICTransactionReportDTCC_ASIC_BR_1098_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			ComparisonResult result = executeDataRule(aSICTransactionReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICTransactionReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICTransactionReport aSICTransactionReport) {
			try {
				if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(aSICTransactionReport).<ActionTypeEnum>map("getActionType", _aSICTransactionReport -> _aSICTransactionReport.getActionType()), CardinalityOperator.Any).getOrDefault(false)) {
					if (areEqual(MapperS.of(aSICTransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _aSICTransactionReport -> _aSICTransactionReport.getPackageTransactionSpreadNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
						return exists(MapperS.of(aSICTransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _aSICTransactionReport -> _aSICTransactionReport.getPackageTransactionSpreadCurrency())).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XTS), MapperS.of(ISOCurrencyCodeEnum.XXX)), MapperS.of(aSICTransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _aSICTransactionReport -> _aSICTransactionReport.getPackageTransactionSpreadCurrency()), CardinalityOperator.Any));
					}
					if (areEqual(MapperS.of(aSICTransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _aSICTransactionReport -> _aSICTransactionReport.getPackageTransactionSpreadNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICTransactionReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", _aSICTransactionReport -> _aSICTransactionReport.getPackageTransactionSpreadNotation()), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All)).getOrDefault(false)) {
						return notExists(MapperS.of(aSICTransactionReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", _aSICTransactionReport -> _aSICTransactionReport.getPackageTransactionSpreadCurrency()));
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
	class NoOp implements ASICTransactionReportDTCC_ASIC_BR_1098_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICTransactionReport aSICTransactionReport) {
			return Collections.emptyList();
		}
	}
}
