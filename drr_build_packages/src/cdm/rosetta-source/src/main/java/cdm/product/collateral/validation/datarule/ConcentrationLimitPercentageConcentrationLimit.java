package cdm.product.collateral.validation.datarule;

import cdm.base.math.NumberRange;
import cdm.product.collateral.ConcentrationLimit;
import cdm.product.collateral.ConcentrationLimitCriteria;
import cdm.product.collateral.ConcentrationLimitTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ConcentrationLimitPercentageConcentrationLimit")
@ImplementedBy(ConcentrationLimitPercentageConcentrationLimit.Default.class)
public interface ConcentrationLimitPercentageConcentrationLimit extends Validator<ConcentrationLimit> {
	
	String NAME = "ConcentrationLimitPercentageConcentrationLimit";
	String DEFINITION = "if concentrationLimitCriteria -> concentrationLimitType = ConcentrationLimitTypeEnum -> MarketCapitalisation then percentageLimit exists";
	
	class Default implements ConcentrationLimitPercentageConcentrationLimit {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConcentrationLimit concentrationLimit) {
			ComparisonResult result = executeDataRule(concentrationLimit);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConcentrationLimit", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConcentrationLimit", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConcentrationLimit concentrationLimit) {
			try {
				if (areEqual(MapperS.of(concentrationLimit).<ConcentrationLimitCriteria>map("getConcentrationLimitCriteria", _concentrationLimit -> _concentrationLimit.getConcentrationLimitCriteria()).<ConcentrationLimitTypeEnum>map("getConcentrationLimitType", concentrationLimitCriteria -> concentrationLimitCriteria.getConcentrationLimitType()), MapperS.of(ConcentrationLimitTypeEnum.MARKET_CAPITALISATION), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(concentrationLimit).<NumberRange>map("getPercentageLimit", _concentrationLimit -> _concentrationLimit.getPercentageLimit()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConcentrationLimitPercentageConcentrationLimit {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConcentrationLimit concentrationLimit) {
			return Collections.emptyList();
		}
	}
}
