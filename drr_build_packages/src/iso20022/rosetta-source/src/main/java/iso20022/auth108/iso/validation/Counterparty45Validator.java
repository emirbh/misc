package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.Counterparty45;
import iso20022.auth108.iso.CounterpartyTradeNature15Choice;
import iso20022.auth108.iso.Direction4Choice;
import iso20022.auth108.iso.PartyIdentification248Choice;
import iso20022.auth108.iso.ReportingExemption1;
import iso20022.auth108.iso.TradingCapacity7Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Counterparty45Validator implements Validator<Counterparty45> {

	private List<ComparisonResult> getComparisonResults(Counterparty45 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (PartyIdentification248Choice) o.getId() != null ? 1 : 0, 1, 1), 
				checkCardinality("ntr", (CounterpartyTradeNature15Choice) o.getNtr() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradgCpcty", (TradingCapacity7Code) o.getTradgCpcty() != null ? 1 : 0, 0, 1), 
				checkCardinality("drctnOrSd", (Direction4Choice) o.getDrctnOrSd() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradrLctn", (String) o.getTradrLctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("bookgLctn", (String) o.getBookgLctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("rptgXmptn", (ReportingExemption1) o.getRptgXmptn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Counterparty45 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Counterparty45", ValidationResult.ValidationType.CARDINALITY, "Counterparty45", path, "", res.getError());
				}
				return success("Counterparty45", ValidationResult.ValidationType.CARDINALITY, "Counterparty45", path, "");
			})
			.collect(toList());
	}

}
