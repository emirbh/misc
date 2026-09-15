package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MasterAgreement;
import fpml.consolidated.shared.MasterAgreementType;
import fpml.consolidated.shared.MasterAgreementVersion;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MasterAgreementValidator implements Validator<MasterAgreement> {

	private List<ComparisonResult> getComparisonResults(MasterAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterAgreementType", (MasterAgreementType) o.getMasterAgreementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementVersion", (MasterAgreementVersion) o.getMasterAgreementVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementDate", (ZonedDateTime) o.getMasterAgreementDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreement", ValidationResult.ValidationType.CARDINALITY, "MasterAgreement", path, "", res.getError());
				}
				return success("MasterAgreement", ValidationResult.ValidationType.CARDINALITY, "MasterAgreement", path, "");
			})
			.collect(toList());
	}

}
