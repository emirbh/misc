package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.ReferenceInformation;
import fpml.consolidated.shared.LegalEntity;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReferenceInformationValidator implements Validator<ReferenceInformation> {

	private List<ComparisonResult> getComparisonResults(ReferenceInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceEntity", (LegalEntity) o.getReferenceEntity() != null ? 1 : 0, 1, 1), 
				checkCardinality("noReferenceObligation", (Boolean) o.getNoReferenceObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("unknownReferenceObligation", (Boolean) o.getUnknownReferenceObligation() != null ? 1 : 0, 0, 1), 
				checkCardinality("allGuarantees", (Boolean) o.getAllGuarantees() != null ? 1 : 0, 0, 1), 
				checkCardinality("referencePrice", (BigDecimal) o.getReferencePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("referencePolicy", (Boolean) o.getReferencePolicy() != null ? 1 : 0, 0, 1), 
				checkCardinality("securedList", (Boolean) o.getSecuredList() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceInformation", ValidationResult.ValidationType.CARDINALITY, "ReferenceInformation", path, "", res.getError());
				}
				return success("ReferenceInformation", ValidationResult.ValidationType.CARDINALITY, "ReferenceInformation", path, "");
			})
			.collect(toList());
	}

}
