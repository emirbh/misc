package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.shared.DisseminationId;
import fpml.consolidated.reg.fpmlreporting.shared.PublicDissemination;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PublicDisseminationValidator implements Validator<PublicDissemination> {

	private List<ComparisonResult> getComparisonResults(PublicDissemination o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("disseminationId", (DisseminationId) o.getDisseminationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("publicationTime", (ZonedDateTime) o.getPublicationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("projectedTime", (ZonedDateTime) o.getProjectedTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("withdrawn", (ZonedDateTime) o.getWithdrawn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PublicDissemination o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PublicDissemination", ValidationResult.ValidationType.CARDINALITY, "PublicDissemination", path, "", res.getError());
				}
				return success("PublicDissemination", ValidationResult.ValidationType.CARDINALITY, "PublicDissemination", path, "");
			})
			.collect(toList());
	}

}
