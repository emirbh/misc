package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.AssetPool;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AssetPoolValidator implements Validator<AssetPool> {

	private List<ComparisonResult> getComparisonResults(AssetPool o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("version", (Integer) o.getVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (IdentifiedDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFactor", (BigDecimal) o.getInitialFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("currentFactor", (BigDecimal) o.getCurrentFactor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetPool o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetPool", ValidationResult.ValidationType.CARDINALITY, "AssetPool", path, "", res.getError());
				}
				return success("AssetPool", ValidationResult.ValidationType.CARDINALITY, "AssetPool", path, "");
			})
			.collect(toList());
	}

}
