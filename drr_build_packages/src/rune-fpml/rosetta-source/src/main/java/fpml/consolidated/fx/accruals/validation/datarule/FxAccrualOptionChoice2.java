package fpml.consolidated.fx.accruals.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualOption;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxOptionStrikePrice;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FxAccrualOptionChoice2")
@ImplementedBy(FxAccrualOptionChoice2.Default.class)
public interface FxAccrualOptionChoice2 extends Validator<FxAccrualOption> {
	
	String NAME = "FxAccrualOptionChoice2";
	String DEFINITION = "if strike exists then averageStrike is absent else if averageStrike exists then strike is absent and counterCurrencyAmount is absent else False";
	
	class Default implements FxAccrualOptionChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualOption fxAccrualOption) {
			ComparisonResult result = executeDataRule(fxAccrualOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FxAccrualOption fxAccrualOption) {
			try {
				if (exists(MapperS.of(fxAccrualOption).<FxOptionStrikePrice>map("getStrike", _fxAccrualOption -> _fxAccrualOption.getStrike())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualOption).<FxAverageStrike>map("getAverageStrike", _fxAccrualOption -> _fxAccrualOption.getAverageStrike()));
				}
				if (exists(MapperS.of(fxAccrualOption).<FxAverageStrike>map("getAverageStrike", _fxAccrualOption -> _fxAccrualOption.getAverageStrike())).getOrDefault(false)) {
					return notExists(MapperS.of(fxAccrualOption).<FxOptionStrikePrice>map("getStrike", _fxAccrualOption -> _fxAccrualOption.getStrike())).andNullSafe(notExists(MapperS.of(fxAccrualOption).<NonNegativeAmountSchedule>map("getCounterCurrencyAmount", _fxAccrualOption -> _fxAccrualOption.getCounterCurrencyAmount())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualOptionChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualOption fxAccrualOption) {
			return Collections.emptyList();
		}
	}
}
