package cdm.event.common.validation;

import cdm.event.common.ContractDetails;
import cdm.legaldocumentation.common.metafields.FieldWithMetaGoverningLawEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractDetailsValidator implements Validator<ContractDetails> {

	private List<ComparisonResult> getComparisonResults(ContractDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("governingLaw", (FieldWithMetaGoverningLawEnum) o.getGoverningLaw() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractDetails", ValidationResult.ValidationType.CARDINALITY, "ContractDetails", path, "", res.getError());
				}
				return success("ContractDetails", ValidationResult.ValidationType.CARDINALITY, "ContractDetails", path, "");
			})
			.collect(toList());
	}

}
