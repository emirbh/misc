package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.Counterparty45__1;
import iso20022.auth030.esma.CounterpartyTradeNature15Choice__1;
import iso20022.auth030.esma.Direction4Choice__1;
import iso20022.auth030.esma.PartyIdentification248Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Counterparty45__1Validator implements Validator<Counterparty45__1> {

	private List<ComparisonResult> getComparisonResults(Counterparty45__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (PartyIdentification248Choice__1) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("ntr", (CounterpartyTradeNature15Choice__1) o.getNtr() != null ? 1 : 0, 1, 1), 
				checkCardinality("drctnOrSd", (Direction4Choice__1) o.getDrctnOrSd() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty45__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty45__1", ValidationResult.ValidationType.CARDINALITY, "Counterparty45__1", path, "", res.getError());
				}
				return success("Counterparty45__1", ValidationResult.ValidationType.CARDINALITY, "Counterparty45__1", path, "");
			})
			.collect(toList());
	}

}
