package cdm.event.common.validation;

import cdm.event.common.TermsChangeInstruction;
import cdm.product.common.NotionalAdjustmentEnum;
import cdm.product.template.NonTransferableProduct;
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

public class TermsChangeInstructionValidator implements Validator<TermsChangeInstruction> {

	private List<ComparisonResult> getComparisonResults(TermsChangeInstruction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("product", (NonTransferableProduct) o.getProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustment", (NotionalAdjustmentEnum) o.getAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermsChangeInstruction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermsChangeInstruction", ValidationResult.ValidationType.CARDINALITY, "TermsChangeInstruction", path, "", res.getError());
				}
				return success("TermsChangeInstruction", ValidationResult.ValidationType.CARDINALITY, "TermsChangeInstruction", path, "");
			})
			.collect(toList());
	}

}
