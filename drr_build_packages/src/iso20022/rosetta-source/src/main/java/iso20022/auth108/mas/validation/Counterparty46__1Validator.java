package iso20022.auth108.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.mas.Counterparty46__1;
import iso20022.auth108.mas.PartyIdentification248Choice__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Counterparty46__1Validator implements Validator<Counterparty46__1> {

	private List<ComparisonResult> getComparisonResults(Counterparty46__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("idTp", (PartyIdentification248Choice__2) o.getIdTp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty46__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty46__1", ValidationResult.ValidationType.CARDINALITY, "Counterparty46__1", path, "", res.getError());
				}
				return success("Counterparty46__1", ValidationResult.ValidationType.CARDINALITY, "Counterparty46__1", path, "");
			})
			.collect(toList());
	}

}
