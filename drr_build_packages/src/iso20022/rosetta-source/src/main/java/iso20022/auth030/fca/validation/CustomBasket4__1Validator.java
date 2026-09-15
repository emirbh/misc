package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.BasketConstituents3__1;
import iso20022.auth030.fca.CustomBasket4__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CustomBasket4__1Validator implements Validator<CustomBasket4__1> {

	private List<ComparisonResult> getComparisonResults(CustomBasket4__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strr", (String) o.getStrr() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("cnsttnts", (List<? extends BasketConstituents3__1>) o.getCnsttnts() == null ? 0 : o.getCnsttnts().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CustomBasket4__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CustomBasket4__1", ValidationResult.ValidationType.CARDINALITY, "CustomBasket4__1", path, "", res.getError());
				}
				return success("CustomBasket4__1", ValidationResult.ValidationType.CARDINALITY, "CustomBasket4__1", path, "");
			})
			.collect(toList());
	}

}
