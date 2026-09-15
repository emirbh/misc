package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlying;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbOtherUnderlyingValidator implements Validator<AnnaDsbOtherUnderlying> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbOtherUnderlying o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("OtherUnderlierIDSource", (AnnaDsbOtherUnderlierIDSourceEnum) o.getOtherUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierID", (String) o.getOtherUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("Basket", (AnnaDsbEmpty) o.getBasket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbOtherUnderlying o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbOtherUnderlying", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOtherUnderlying", path, "", res.getError());
				}
				return success("AnnaDsbOtherUnderlying", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOtherUnderlying", path, "");
			})
			.collect(toList());
	}

}
