package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.OtherAgreement;
import fpml.consolidated.shared.OtherAgreementType;
import fpml.consolidated.shared.OtherAgreementVersion;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OtherAgreementValidator implements Validator<OtherAgreement> {

	private List<ComparisonResult> getComparisonResults(OtherAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (OtherAgreementType) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("version", (OtherAgreementVersion) o.getVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherAgreement", ValidationResult.ValidationType.CARDINALITY, "OtherAgreement", path, "", res.getError());
				}
				return success("OtherAgreement", ValidationResult.ValidationType.CARDINALITY, "OtherAgreement", path, "");
			})
			.collect(toList());
	}

}
