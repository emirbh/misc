package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.PutCallEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ListedDerivativeOptions")
@ImplementedBy(ListedDerivativeOptions.Default.class)
public interface ListedDerivativeOptions extends Validator<ListedDerivative> {
	
	String NAME = "ListedDerivativeOptions";
	String DEFINITION = "if optionType exists then strike exists else strike is absent";
	
	class Default implements ListedDerivativeOptions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListedDerivative listedDerivative) {
			ComparisonResult result = executeDataRule(listedDerivative);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ListedDerivative", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ListedDerivative", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ListedDerivative listedDerivative) {
			try {
				if (exists(MapperS.of(listedDerivative).<PutCallEnum>map("getOptionType", _listedDerivative -> _listedDerivative.getOptionType())).getOrDefault(false)) {
					return exists(MapperS.of(listedDerivative).<BigDecimal>map("getStrike", _listedDerivative -> _listedDerivative.getStrike()));
				}
				return notExists(MapperS.of(listedDerivative).<BigDecimal>map("getStrike", _listedDerivative -> _listedDerivative.getStrike()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ListedDerivativeOptions {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListedDerivative listedDerivative) {
			return Collections.emptyList();
		}
	}
}
