package cdm.product.collateral.validation;

import cdm.product.collateral.ListingExchange;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ListingExchangeValidator implements Validator<ListingExchange> {

	private List<ComparisonResult> getComparisonResults(ListingExchange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exchange", (List<? extends FieldWithMetaString>) o.getExchange() == null ? 0 : o.getExchange().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListingExchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ListingExchange", ValidationResult.ValidationType.CARDINALITY, "ListingExchange", path, "", res.getError());
				}
				return success("ListingExchange", ValidationResult.ValidationType.CARDINALITY, "ListingExchange", path, "");
			})
			.collect(toList());
	}

}
