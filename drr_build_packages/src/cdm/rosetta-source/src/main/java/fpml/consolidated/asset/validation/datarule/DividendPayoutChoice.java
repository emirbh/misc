package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.DividendPayout;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("DividendPayoutChoice")
@ImplementedBy(DividendPayoutChoice.Default.class)
public interface DividendPayoutChoice extends Validator<DividendPayout> {
	
	String NAME = "DividendPayoutChoice";
	String DEFINITION = "dividendPayoutConditions is absent or dividendPayoutRatio is absent and dividendPayoutRatioCash is absent and dividendPayoutRatioNonCash is absent";
	
	class Default implements DividendPayoutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayout dividendPayout) {
			ComparisonResult result = executeDataRule(dividendPayout);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayout", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayout", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DividendPayout dividendPayout) {
			try {
				return notExists(MapperS.of(dividendPayout).<String>map("getDividendPayoutConditions", _dividendPayout -> _dividendPayout.getDividendPayoutConditions())).orNullSafe(notExists(MapperS.of(dividendPayout).<BigDecimal>map("getDividendPayoutRatio", _dividendPayout -> _dividendPayout.getDividendPayoutRatio())).andNullSafe(notExists(MapperS.of(dividendPayout).<BigDecimal>map("getDividendPayoutRatioCash", _dividendPayout -> _dividendPayout.getDividendPayoutRatioCash()))).andNullSafe(notExists(MapperS.of(dividendPayout).<BigDecimal>map("getDividendPayoutRatioNonCash", _dividendPayout -> _dividendPayout.getDividendPayoutRatioNonCash()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendPayoutChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayout dividendPayout) {
			return Collections.emptyList();
		}
	}
}
