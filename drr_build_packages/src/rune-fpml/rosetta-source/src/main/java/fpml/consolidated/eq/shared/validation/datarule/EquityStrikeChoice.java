package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("EquityStrikeChoice")
@ImplementedBy(EquityStrikeChoice.Default.class)
public interface EquityStrikeChoice extends Validator<EquityStrike> {
	
	String NAME = "EquityStrikeChoice";
	String DEFINITION = "strikePrice is absent or strikePercentage is absent and strikeDeterminationDate is absent";
	
	class Default implements EquityStrikeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityStrike equityStrike) {
			ComparisonResult result = executeDataRule(equityStrike);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityStrike", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityStrike", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityStrike equityStrike) {
			try {
				return notExists(MapperS.of(equityStrike).<BigDecimal>map("getStrikePrice", _equityStrike -> _equityStrike.getStrikePrice())).orNullSafe(notExists(MapperS.of(equityStrike).<BigDecimal>map("getStrikePercentage", _equityStrike -> _equityStrike.getStrikePercentage())).andNullSafe(notExists(MapperS.of(equityStrike).<AdjustableOrRelativeDate>map("getStrikeDeterminationDate", _equityStrike -> _equityStrike.getStrikeDeterminationDate()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityStrikeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityStrike equityStrike) {
			return Collections.emptyList();
		}
	}
}
