package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.Counterparty45__1;
import iso20022.auth030.hkma.tr.Counterparty46__1;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__1;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__3;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__4;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__3;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__4;
import iso20022.auth030.hkma.tr.TradeCounterpartyReport20__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyReport20__1Validator implements Validator<TradeCounterpartyReport20__1> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyReport20__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgCtrPty", (Counterparty45__1) o.getRptgCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("othrCtrPty", (Counterparty46__1) o.getOthrCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("brkr", (OrganisationIdentification15Choice__3) o.getBrkr() != null ? 1 : 0, 0, 1), 
				checkCardinality("submitgAgt", (OrganisationIdentification15Choice__4) o.getSubmitgAgt() != null ? 1 : 0, 1, 1), 
				checkCardinality("clrMmb", (PartyIdentification248Choice__3) o.getClrMmb() != null ? 1 : 0, 0, 1), 
				checkCardinality("bnfcry", (PartyIdentification248Choice__4) o.getBnfcry() != null ? 1 : 0, 0, 1), 
				checkCardinality("nttyRspnsblForRpt", (OrganisationIdentification15Choice__1) o.getNttyRspnsblForRpt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyReport20__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyReport20__1", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20__1", path, "", res.getError());
				}
				return success("TradeCounterpartyReport20__1", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20__1", path, "");
			})
			.collect(toList());
	}

}
