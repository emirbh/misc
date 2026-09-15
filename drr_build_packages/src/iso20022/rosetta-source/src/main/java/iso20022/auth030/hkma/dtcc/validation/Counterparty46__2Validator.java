package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.Counterparty46__2;
import iso20022.auth030.hkma.dtcc.PartyIdentification248Choice__5;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Counterparty46__2Validator implements Validator<Counterparty46__2> {

	private List<ComparisonResult> getComparisonResults(Counterparty46__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("idTp", (PartyIdentification248Choice__5) o.getIdTp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty46__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty46__2", ValidationResult.ValidationType.CARDINALITY, "Counterparty46__2", path, "", res.getError());
				}
				return success("Counterparty46__2", ValidationResult.ValidationType.CARDINALITY, "Counterparty46__2", path, "");
			})
			.collect(toList());
	}

}
