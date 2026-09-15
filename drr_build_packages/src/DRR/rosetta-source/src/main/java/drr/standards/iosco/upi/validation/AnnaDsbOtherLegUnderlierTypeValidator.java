package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbOtherLegUnderlierTypeValidator implements Validator<AnnaDsbOtherLegUnderlierType> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbOtherLegUnderlierType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("OtherLegUnderlierID", (String) o.getOtherLegUnderlierID() != null ? 1 : 0, 1, 1), 
				checkCardinality("OtherLegUnderlierIDSource", (AnnaDsbOtherLegUnderlierIDSourceEnum) o.getOtherLegUnderlierIDSource() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbOtherLegUnderlierType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbOtherLegUnderlierType", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOtherLegUnderlierType", path, "", res.getError());
				}
				return success("AnnaDsbOtherLegUnderlierType", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOtherLegUnderlierType", path, "");
			})
			.collect(toList());
	}

}
