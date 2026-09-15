package fpml.consolidated.sec.lending.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.sec.lending.SecLendTermination;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class SecLendTerminationValidator implements Validator<SecLendTermination> {

	private List<ComparisonResult> getComparisonResults(SecLendTermination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementDate", (IdentifiedDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryMethod", (DeliveryMethod) o.getDeliveryMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SecLendTermination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SecLendTermination", ValidationResult.ValidationType.CARDINALITY, "SecLendTermination", path, "", res.getError());
				}
				return success("SecLendTermination", ValidationResult.ValidationType.CARDINALITY, "SecLendTermination", path, "");
			})
			.collect(toList());
	}

}
