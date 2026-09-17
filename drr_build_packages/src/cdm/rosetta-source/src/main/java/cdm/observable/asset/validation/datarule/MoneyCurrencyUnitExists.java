package cdm.observable.asset.validation.datarule;

import cdm.base.math.UnitType;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("MoneyCurrencyUnitExists")
@ImplementedBy(MoneyCurrencyUnitExists.Default.class)
public interface MoneyCurrencyUnitExists extends Validator<Money> {
	
	String NAME = "MoneyCurrencyUnitExists";
	String DEFINITION = "unit -> currency exists";
	
	class Default implements MoneyCurrencyUnitExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Money money) {
			ComparisonResult result = executeDataRule(money);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Money", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Money", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Money money) {
			try {
				return exists(MapperS.of(money).<UnitType>map("getUnit", _money -> _money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MoneyCurrencyUnitExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Money money) {
			return Collections.emptyList();
		}
	}
}
