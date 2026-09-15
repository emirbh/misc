package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.Counterparty45;
import iso20022.auth108.iso.Counterparty46;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.PartyIdentification248Choice;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyReport20Validator implements Validator<TradeCounterpartyReport20> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyReport20 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgCtrPty", (Counterparty45) o.getRptgCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("othrCtrPty", (Counterparty46) o.getOthrCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("brkr", (OrganisationIdentification15Choice) o.getBrkr() != null ? 1 : 0, 0, 1), 
				checkCardinality("submitgAgt", (OrganisationIdentification15Choice) o.getSubmitgAgt() != null ? 1 : 0, 0, 1), 
				checkCardinality("clrMmb", (PartyIdentification248Choice) o.getClrMmb() != null ? 1 : 0, 0, 1), 
				checkCardinality("bnfcry", (List<? extends PartyIdentification248Choice>) o.getBnfcry() == null ? 0 : o.getBnfcry().size(), 0, 2), 
				checkCardinality("nttyRspnsblForRpt", (OrganisationIdentification15Choice) o.getNttyRspnsblForRpt() != null ? 1 : 0, 0, 1), 
				checkCardinality("exctnAgt", (List<? extends OrganisationIdentification15Choice>) o.getExctnAgt() == null ? 0 : o.getExctnAgt().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyReport20 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyReport20", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20", path, "", res.getError());
				}
				return success("TradeCounterpartyReport20", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20", path, "");
			})
			.collect(toList());
	}

}
