package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.Counterparty46;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import iso20022.auth108.iso.PartyIdentification248Choice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Counterparty46Validator implements Validator<Counterparty46> {

	private List<ComparisonResult> getComparisonResults(Counterparty46 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("idTp", (PartyIdentification248Choice) o.getIdTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("ntr", (CounterpartyTradeNature15Choice) o.getNtr() != null ? 1 : 0, 0, 1), 
				checkCardinality("rptgOblgtn", (Boolean) o.getRptgOblgtn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty46 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty46", ValidationResult.ValidationType.CARDINALITY, "Counterparty46", path, "", res.getError());
				}
				return success("Counterparty46", ValidationResult.ValidationType.CARDINALITY, "Counterparty46", path, "");
			})
			.collect(toList());
	}

}
