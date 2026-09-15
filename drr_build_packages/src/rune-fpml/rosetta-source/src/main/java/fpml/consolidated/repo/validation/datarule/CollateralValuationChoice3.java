package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.CollateralValuation;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CollateralValuationChoice3")
@ImplementedBy(CollateralValuationChoice3.Default.class)
public interface CollateralValuationChoice3 extends Validator<CollateralValuation> {
	
	String NAME = "CollateralValuationChoice3";
	String DEFINITION = "numberOfUnits is absent or unitPrice exists and quantity is absent and cleanPrice is absent and accruals is absent and dirtyPrice is absent and relativePrice is absent and yieldToMaturity is absent and inflationFactor is absent and allInPrice is absent and accrualsAmount is absent";
	
	class Default implements CollateralValuationChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation collateralValuation) {
			ComparisonResult result = executeDataRule(collateralValuation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralValuation collateralValuation) {
			try {
				return notExists(MapperS.of(collateralValuation).<BigDecimal>map("getNumberOfUnits", _collateralValuation -> _collateralValuation.getNumberOfUnits())).orNullSafe(exists(MapperS.of(collateralValuation).<NonNegativeMoney>map("getUnitPrice", _collateralValuation -> _collateralValuation.getUnitPrice())).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getQuantity", _collateralValuation -> _collateralValuation.getQuantity()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getCleanPrice", _collateralValuation -> _collateralValuation.getCleanPrice()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getAccruals", _collateralValuation -> _collateralValuation.getAccruals()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getDirtyPrice", _collateralValuation -> _collateralValuation.getDirtyPrice()))).andNullSafe(notExists(MapperS.of(collateralValuation).<RelativePrice>map("getRelativePrice", _collateralValuation -> _collateralValuation.getRelativePrice()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getYieldToMaturity", _collateralValuation -> _collateralValuation.getYieldToMaturity()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getInflationFactor", _collateralValuation -> _collateralValuation.getInflationFactor()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getAllInPrice", _collateralValuation -> _collateralValuation.getAllInPrice()))).andNullSafe(notExists(MapperS.of(collateralValuation).<Money>map("getAccrualsAmount", _collateralValuation -> _collateralValuation.getAccrualsAmount()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValuationChoice3 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation collateralValuation) {
			return Collections.emptyList();
		}
	}
}
