package drr.regulation.common.validation;

import cdm.event.common.Valuation;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationTradeInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationDetailsValidator implements Validator<ValuationDetails> {

	private List<ComparisonResult> getComparisonResults(ValuationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuation", (Valuation) o.getValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeInformation", (ValuationTradeInformation) o.getTradeInformation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationDetails", ValidationResult.ValidationType.CARDINALITY, "ValuationDetails", path, "", res.getError());
				}
				return success("ValuationDetails", ValidationResult.ValidationType.CARDINALITY, "ValuationDetails", path, "");
			})
			.collect(toList());
	}

}
