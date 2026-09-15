package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.Counterparty45__3;
import iso20022.auth030.asic.Counterparty46__3;
import iso20022.auth030.asic.OrganisationIdentification15Choice__1;
import iso20022.auth030.asic.OrganisationIdentification15Choice__3;
import iso20022.auth030.asic.TradeCounterpartyReport20__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyReport20__3Validator implements Validator<TradeCounterpartyReport20__3> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyReport20__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptgCtrPty", (Counterparty45__3) o.getRptgCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("othrCtrPty", (Counterparty46__3) o.getOthrCtrPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("submitgAgt", (OrganisationIdentification15Choice__1) o.getSubmitgAgt() != null ? 1 : 0, 1, 1), 
				checkCardinality("nttyRspnsblForRpt", (OrganisationIdentification15Choice__1) o.getNttyRspnsblForRpt() != null ? 1 : 0, 1, 1), 
				checkCardinality("exctnAgt", (List<? extends OrganisationIdentification15Choice__3>) o.getExctnAgt() == null ? 0 : o.getExctnAgt().size(), 0, 2)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyReport20__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyReport20__3", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20__3", path, "", res.getError());
				}
				return success("TradeCounterpartyReport20__3", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyReport20__3", path, "");
			})
			.collect(toList());
	}

}
