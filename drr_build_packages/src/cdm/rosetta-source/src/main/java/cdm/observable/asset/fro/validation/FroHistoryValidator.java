package cdm.observable.asset.fro.validation;

import cdm.observable.asset.fro.ContractualDefinition;
import cdm.observable.asset.fro.FroHistory;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FroHistoryValidator implements Validator<FroHistory> {

	private List<ComparisonResult> getComparisonResults(FroHistory o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", (Date) o.getStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstDefinedIn", (ContractualDefinition) o.getFirstDefinedIn() != null ? 1 : 0, 0, 1), 
				checkCardinality("updateDate", (Date) o.getUpdateDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastUpdatedIn", (ContractualDefinition) o.getLastUpdatedIn() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FroHistory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FroHistory", ValidationResult.ValidationType.CARDINALITY, "FroHistory", path, "", res.getError());
				}
				return success("FroHistory", ValidationResult.ValidationType.CARDINALITY, "FroHistory", path, "");
			})
			.collect(toList());
	}

}
