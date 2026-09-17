package fpml.consolidated.repo.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.repo.CollateralValuation;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralValuationValidator implements Validator<CollateralValuation> {

	private List<ComparisonResult> getComparisonResults(CollateralValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nominalAmount", (Money) o.getNominalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleanPrice", (BigDecimal) o.getCleanPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruals", (BigDecimal) o.getAccruals() != null ? 1 : 0, 0, 1), 
				checkCardinality("dirtyPrice", (BigDecimal) o.getDirtyPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativePrice", (RelativePrice) o.getRelativePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("yieldToMaturity", (BigDecimal) o.getYieldToMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("inflationFactor", (BigDecimal) o.getInflationFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("allInPrice", (BigDecimal) o.getAllInPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualsAmount", (Money) o.getAccrualsAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfUnits", (BigDecimal) o.getNumberOfUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("unitPrice", (NonNegativeMoney) o.getUnitPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetReference", (AssetReference) o.getAssetReference() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralValuation", ValidationResult.ValidationType.CARDINALITY, "CollateralValuation", path, "", res.getError());
				}
				return success("CollateralValuation", ValidationResult.ValidationType.CARDINALITY, "CollateralValuation", path, "");
			})
			.collect(toList());
	}

}
