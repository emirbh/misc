package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.CollateralValuation;
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
@RosettaDataRule("CollateralValuationChoice4")
@ImplementedBy(CollateralValuationChoice4.Default.class)
public interface CollateralValuationChoice4 extends Validator<CollateralValuation> {
	
	String NAME = "CollateralValuationChoice4";
	String DEFINITION = "nominalAmount exists or numberOfUnits exists or quantity exists and cleanPrice exists and unitPrice is absent or quantity exists and unitPrice is absent and accruals is absent";
	
	class Default implements CollateralValuationChoice4 {
	
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
				return exists(MapperS.of(collateralValuation).<Money>map("getNominalAmount", _collateralValuation -> _collateralValuation.getNominalAmount())).orNullSafe(exists(MapperS.of(collateralValuation).<BigDecimal>map("getNumberOfUnits", _collateralValuation -> _collateralValuation.getNumberOfUnits()))).orNullSafe(exists(MapperS.of(collateralValuation).<BigDecimal>map("getQuantity", _collateralValuation -> _collateralValuation.getQuantity())).andNullSafe(exists(MapperS.of(collateralValuation).<BigDecimal>map("getCleanPrice", _collateralValuation -> _collateralValuation.getCleanPrice()))).andNullSafe(notExists(MapperS.of(collateralValuation).<NonNegativeMoney>map("getUnitPrice", _collateralValuation -> _collateralValuation.getUnitPrice())))).orNullSafe(exists(MapperS.of(collateralValuation).<BigDecimal>map("getQuantity", _collateralValuation -> _collateralValuation.getQuantity())).andNullSafe(notExists(MapperS.of(collateralValuation).<NonNegativeMoney>map("getUnitPrice", _collateralValuation -> _collateralValuation.getUnitPrice()))).andNullSafe(notExists(MapperS.of(collateralValuation).<BigDecimal>map("getAccruals", _collateralValuation -> _collateralValuation.getAccruals()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValuationChoice4 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation collateralValuation) {
			return Collections.emptyList();
		}
	}
}
