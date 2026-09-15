package drr.regulation.mas.rewrite.margin.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import drr.standards.iso.MarginActionEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("MASMarginReportDTCC_MAS_BR_0074_01")
@ImplementedBy(MASMarginReportDTCC_MAS_BR_0074_01.Default.class)
public interface MASMarginReportDTCC_MAS_BR_0074_01 extends Validator<MASMarginReport> {
	
	String NAME = "MASMarginReportDTCC_MAS_BR_0074_01";
	String DEFINITION = "if [MarginActionEnum -> CORR, MarginActionEnum -> MARU] any = actionType and excessCollateralCollectedByTheCounterparty1 exists then currencyOfTheExcessCollateralCollected exists and [\"XAG\", \"XAU\", \"XBA\", \"XBB\", \"XBC\", \"XBD\", \"XDR\", \"XEU\", \"XFU\", \"XPD\", \"XPT\", \"XTS\", \"XXX\"] all <> currencyOfTheExcessCollateralCollected";
	
	class Default implements MASMarginReportDTCC_MAS_BR_0074_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			ComparisonResult result = executeDataRule(mASMarginReport);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MASMarginReport", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MASMarginReport", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MASMarginReport mASMarginReport) {
			try {
				if (areEqual(MapperC.<MarginActionEnum>of(MapperS.of(MarginActionEnum.CORR), MapperS.of(MarginActionEnum.MARU)), MapperS.of(mASMarginReport).<MarginActionEnum>map("getActionType", _mASMarginReport -> _mASMarginReport.getActionType()), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(mASMarginReport).<BigDecimal>map("getExcessCollateralCollectedByTheCounterparty1", _mASMarginReport -> _mASMarginReport.getExcessCollateralCollectedByTheCounterparty1()))).getOrDefault(false)) {
					return exists(MapperS.of(mASMarginReport).<String>map("getCurrencyOfTheExcessCollateralCollected", _mASMarginReport -> _mASMarginReport.getCurrencyOfTheExcessCollateralCollected())).andNullSafe(notEqual(MapperC.<String>of(MapperS.of("XAG"), MapperS.of("XAU"), MapperS.of("XBA"), MapperS.of("XBB"), MapperS.of("XBC"), MapperS.of("XBD"), MapperS.of("XDR"), MapperS.of("XEU"), MapperS.of("XFU"), MapperS.of("XPD"), MapperS.of("XPT"), MapperS.of("XTS"), MapperS.of("XXX")), MapperS.of(mASMarginReport).<String>map("getCurrencyOfTheExcessCollateralCollected", _mASMarginReport -> _mASMarginReport.getCurrencyOfTheExcessCollateralCollected()), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MASMarginReportDTCC_MAS_BR_0074_01 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MASMarginReport mASMarginReport) {
			return Collections.emptyList();
		}
	}
}
