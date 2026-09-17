package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityTransmissionContingency;
import fpml.consolidated.com.ElectricityTransmissionContingencyType;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ElectricityTransmissionContingencyValidator implements Validator<ElectricityTransmissionContingency> {

	private List<ComparisonResult> getComparisonResults(ElectricityTransmissionContingency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contingency", (ElectricityTransmissionContingencyType) o.getContingency() != null ? 1 : 0, 0, 1), 
				checkCardinality("contingentParty", (List<? extends PartyReference>) o.getContingentParty() == null ? 0 : o.getContingentParty().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityTransmissionContingency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityTransmissionContingency", ValidationResult.ValidationType.CARDINALITY, "ElectricityTransmissionContingency", path, "", res.getError());
				}
				return success("ElectricityTransmissionContingency", ValidationResult.ValidationType.CARDINALITY, "ElectricityTransmissionContingency", path, "");
			})
			.collect(toList());
	}

}
