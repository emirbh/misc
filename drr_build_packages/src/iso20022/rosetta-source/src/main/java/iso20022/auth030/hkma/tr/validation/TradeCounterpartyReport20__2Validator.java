package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.Counterparty45__2;
import iso20022.auth030.hkma.tr.Counterparty46__2;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__1;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__4;
import iso20022.auth030.hkma.tr.TradeCounterpartyReport20__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyReport20__2Validator implements Validator<TradeCounterpartyReport20__2> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyReport20__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgCtrPty", (Counterparty45__2) o.getRptgCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("othrCtrPty", (Counterparty46__2) o.getOthrCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("submitgAgt", (OrganisationIdentification15Choice__4) o.getSubmitgAgt() != null ? 1 : 0, 1, 1), 
				checkCardinality("nttyRspnsblForRpt", (OrganisationIdentification15Choice__1) o.getNttyRspnsblForRpt() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyReport20__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyReport20__2", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20__2", path, "", res.getError());
				}
				return success("TradeCounterpartyReport20__2", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20__2", path, "");
			})
			.collect(toList());
	}

}
