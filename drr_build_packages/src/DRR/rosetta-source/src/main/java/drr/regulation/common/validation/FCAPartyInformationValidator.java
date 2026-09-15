package drr.regulation.common.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.FCAPartyInformation;
import drr.regulation.common.NatureOfPartyEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FCAPartyInformationValidator implements Validator<FCAPartyInformation> {

	private List<ComparisonResult> getComparisonResults(FCAPartyInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("natureOfParty", (NatureOfPartyEnum) o.getNatureOfParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("corporateSector", (CorporateSector) o.getCorporateSector() != null ? 1 : 0, 0, 1), 
				checkCardinality("exceedsClearingThreshold", (Boolean) o.getExceedsClearingThreshold() != null ? 1 : 0, 0, 1), 
				checkCardinality("directlyLinkedActivity", (Boolean) o.getDirectlyLinkedActivity() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FCAPartyInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FCAPartyInformation", ValidationResult.ValidationType.CARDINALITY, "FCAPartyInformation", path, "", res.getError());
				}
				return success("FCAPartyInformation", ValidationResult.ValidationType.CARDINALITY, "FCAPartyInformation", path, "");
			})
			.collect(toList());
	}

}
