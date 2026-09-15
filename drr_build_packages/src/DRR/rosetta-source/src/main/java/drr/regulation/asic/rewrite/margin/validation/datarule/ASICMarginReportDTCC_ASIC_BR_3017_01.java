package drr.regulation.asic.rewrite.margin.validation.datarule;

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
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("ASICMarginReportDTCC_ASIC_BR_3017_01")
@ImplementedBy(ASICMarginReportDTCC_ASIC_BR_3017_01.Default.class)
public interface ASICMarginReportDTCC_ASIC_BR_3017_01 extends Validator<ASICMarginReport> {
	
	String NAME = "ASICMarginReportDTCC_ASIC_BR_3017_01";
	String DEFINITION = "if actionType = MarginActionEnum -> MARU or actionType = MarginActionEnum -> CORR then if initialMarginCollectedByCounterparty1PreHaircut exists then initialMarginCollectedByCounterparty1Currency exists and [ISOCurrencyCodeEnum -> XAG, ISOCurrencyCodeEnum -> XAU, ISOCurrencyCodeEnum -> XBA, ISOCurrencyCodeEnum -> XBB, ISOCurrencyCodeEnum -> XBC, ISOCurrencyCodeEnum -> XBD, ISOCurrencyCodeEnum -> XDR, ISOCurrencyCodeEnum -> XPD, ISOCurrencyCodeEnum -> XPT, ISOCurrencyCodeEnum -> XXX, ISOCurrencyCodeEnum -> XTS] any <> initialMarginCollectedByCounterparty1Currency";
	
	class Default implements ASICMarginReportDTCC_ASIC_BR_3017_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			ComparisonResult result = executeDataRule(aSICMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ASICMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ASICMarginReport aSICMarginReport) {
			try {
				if (areEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.MARU), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(aSICMarginReport).<MarginActionEnum>map("getActionType", _aSICMarginReport -> _aSICMarginReport.getActionType()), MapperS.of(MarginActionEnum.CORR), CardinalityOperator.All)).getOrDefault(false)) {
					if (exists(MapperS.of(aSICMarginReport).<BigDecimal>map("getInitialMarginCollectedByCounterparty1PreHaircut", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollectedByCounterparty1PreHaircut())).getOrDefault(false)) {
						return exists(MapperS.of(aSICMarginReport).<ISOCurrencyCodeEnum>map("getInitialMarginCollectedByCounterparty1Currency", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollectedByCounterparty1Currency())).andNullSafe(notEqual(MapperC.<ISOCurrencyCodeEnum>of(MapperS.of(ISOCurrencyCodeEnum.XAG), MapperS.of(ISOCurrencyCodeEnum.XAU), MapperS.of(ISOCurrencyCodeEnum.XBA), MapperS.of(ISOCurrencyCodeEnum.XBB), MapperS.of(ISOCurrencyCodeEnum.XBC), MapperS.of(ISOCurrencyCodeEnum.XBD), MapperS.of(ISOCurrencyCodeEnum.XDR), MapperS.of(ISOCurrencyCodeEnum.XPD), MapperS.of(ISOCurrencyCodeEnum.XPT), MapperS.of(ISOCurrencyCodeEnum.XXX), MapperS.of(ISOCurrencyCodeEnum.XTS)), MapperS.of(aSICMarginReport).<ISOCurrencyCodeEnum>map("getInitialMarginCollectedByCounterparty1Currency", _aSICMarginReport -> _aSICMarginReport.getInitialMarginCollectedByCounterparty1Currency()), CardinalityOperator.Any));
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
	class NoOp implements ASICMarginReportDTCC_ASIC_BR_3017_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ASICMarginReport aSICMarginReport) {
			return Collections.emptyList();
		}
	}
}
