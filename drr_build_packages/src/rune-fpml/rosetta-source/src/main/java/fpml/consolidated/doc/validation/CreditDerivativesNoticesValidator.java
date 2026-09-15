package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.CreditDerivativesNotices;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CreditDerivativesNoticesValidator implements Validator<CreditDerivativesNotices> {

	private List<ComparisonResult> getComparisonResults(CreditDerivativesNotices o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditEvent", (Boolean) o.getCreditEvent() != null ? 1 : 0, 0, 1), 
				checkCardinality("publiclyAvailableInformation", (Boolean) o.getPubliclyAvailableInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalSettlement", (Boolean) o.getPhysicalSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditDerivativesNotices o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditDerivativesNotices", ValidationResult.ValidationType.CARDINALITY, "CreditDerivativesNotices", path, "", res.getError());
				}
				return success("CreditDerivativesNotices", ValidationResult.ValidationType.CARDINALITY, "CreditDerivativesNotices", path, "");
			})
			.collect(toList());
	}

}
