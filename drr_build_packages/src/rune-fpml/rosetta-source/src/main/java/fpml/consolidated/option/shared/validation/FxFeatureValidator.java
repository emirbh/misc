package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.Composite;
import fpml.consolidated.option.shared.FxFeature;
import fpml.consolidated.option.shared.Quanto;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxFeatureValidator implements Validator<FxFeature> {

	private List<ComparisonResult> getComparisonResults(FxFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceCurrency", (IdentifiedCurrency) o.getReferenceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("composite", (Composite) o.getComposite() != null ? 1 : 0, 0, 1), 
				checkCardinality("quanto", (Quanto) o.getQuanto() != null ? 1 : 0, 0, 1), 
				checkCardinality("crossCurrency", (Composite) o.getCrossCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFeature", ValidationResult.ValidationType.CARDINALITY, "FxFeature", path, "", res.getError());
				}
				return success("FxFeature", ValidationResult.ValidationType.CARDINALITY, "FxFeature", path, "");
			})
			.collect(toList());
	}

}
