package cdm.product.asset.validation.datarule;

import cdm.product.asset.DividendPayoutRatio;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("DividendPayoutRatioDividendPayoutRatioNonCash")
@ImplementedBy(DividendPayoutRatioDividendPayoutRatioNonCash.Default.class)
public interface DividendPayoutRatioDividendPayoutRatioNonCash extends Validator<DividendPayoutRatio> {
	
	String NAME = "DividendPayoutRatioDividendPayoutRatioNonCash";
	String DEFINITION = "if nonCashRatio exists then nonCashRatio >= 0 and totalRatio <= 1";
	
	class Default implements DividendPayoutRatioDividendPayoutRatioNonCash {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayoutRatio dividendPayoutRatio) {
			ComparisonResult result = executeDataRule(dividendPayoutRatio);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayoutRatio", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayoutRatio", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendPayoutRatio dividendPayoutRatio) {
			try {
				if (exists(MapperS.of(dividendPayoutRatio).<BigDecimal>map("getNonCashRatio", _dividendPayoutRatio -> _dividendPayoutRatio.getNonCashRatio())).getOrDefault(false)) {
					return greaterThanEquals(MapperS.of(dividendPayoutRatio).<BigDecimal>map("getNonCashRatio", _dividendPayoutRatio -> _dividendPayoutRatio.getNonCashRatio()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(dividendPayoutRatio).<BigDecimal>map("getTotalRatio", _dividendPayoutRatio -> _dividendPayoutRatio.getTotalRatio()), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendPayoutRatioDividendPayoutRatioNonCash {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayoutRatio dividendPayoutRatio) {
			return Collections.emptyList();
		}
	}
}
