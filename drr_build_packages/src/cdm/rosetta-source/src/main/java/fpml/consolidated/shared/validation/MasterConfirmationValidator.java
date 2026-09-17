package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MasterConfirmation;
import fpml.consolidated.shared.MasterConfirmationAnnexType;
import fpml.consolidated.shared.MasterConfirmationType;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MasterConfirmationValidator implements Validator<MasterConfirmation> {

	private List<ComparisonResult> getComparisonResults(MasterConfirmation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterConfirmationType", (MasterConfirmationType) o.getMasterConfirmationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmationDate", (ZonedDateTime) o.getMasterConfirmationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmationAnnexDate", (ZonedDateTime) o.getMasterConfirmationAnnexDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterConfirmationAnnexType", (MasterConfirmationAnnexType) o.getMasterConfirmationAnnexType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterConfirmation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterConfirmation", ValidationResult.ValidationType.CARDINALITY, "MasterConfirmation", path, "", res.getError());
				}
				return success("MasterConfirmation", ValidationResult.ValidationType.CARDINALITY, "MasterConfirmation", path, "");
			})
			.collect(toList());
	}

}
