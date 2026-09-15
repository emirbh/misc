package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.business.events.UnitQuantityRef;
import fpml.consolidated.shared.NotionalReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UnitQuantityRefValidator implements Validator<UnitQuantityRef> {

	private List<ComparisonResult> getComparisonResults(UnitQuantityRef o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityUnit", (QuantityUnit) o.getQuantityUnit() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantityReference", (NotionalReference) o.getQuantityReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnitQuantityRef o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnitQuantityRef", ValidationResult.ValidationType.CARDINALITY, "UnitQuantityRef", path, "", res.getError());
				}
				return success("UnitQuantityRef", ValidationResult.ValidationType.CARDINALITY, "UnitQuantityRef", path, "");
			})
			.collect(toList());
	}

}
