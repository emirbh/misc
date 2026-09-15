package drr.regulation.mas.rewrite.trade.validation;

import cdm.base.staticdata.party.Address;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.mas.rewrite.trade.Trader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TraderValidator implements Validator<Trader> {

	private List<ComparisonResult> getComparisonResults(Trader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("placeOfEmployment", (Address) o.getPlaceOfEmployment() != null ? 1 : 0, 1, 1), 
				checkCardinality("isAuthorisedToTradeInSingapore", (Boolean) o.getIsAuthorisedToTradeInSingapore() != null ? 1 : 0, 1, 1), 
				checkCardinality("currentLocation", (Address) o.getCurrentLocation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Trader", ValidationResult.ValidationType.CARDINALITY, "Trader", path, "", res.getError());
				}
				return success("Trader", ValidationResult.ValidationType.CARDINALITY, "Trader", path, "");
			})
			.collect(toList());
	}

}
