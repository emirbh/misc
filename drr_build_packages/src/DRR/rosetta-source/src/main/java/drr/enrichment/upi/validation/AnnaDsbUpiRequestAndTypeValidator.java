package drr.enrichment.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.enrichment.upi.AnnaDsbUpiRequestTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbUpiRequestAndTypeValidator implements Validator<AnnaDsbUpiRequestAndType> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbUpiRequestAndType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("request", (AnnaDsbUpiRequest) o.getRequest() != null ? 1 : 0, 1, 1), 
				checkCardinality("requestType", (AnnaDsbUpiRequestTypeEnum) o.getRequestType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbUpiRequestAndType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbUpiRequestAndType", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUpiRequestAndType", path, "", res.getError());
				}
				return success("AnnaDsbUpiRequestAndType", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbUpiRequestAndType", path, "");
			})
			.collect(toList());
	}

}
