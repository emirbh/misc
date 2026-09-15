package iso20022.auth030.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.dtcc.ClearingPartyAndTime22__1;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__3;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingPartyAndTime22__1Validator implements Validator<ClearingPartyAndTime22__1> {

	private List<ComparisonResult> getComparisonResults(ClearingPartyAndTime22__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ccp", (OrganisationIdentification15Choice__3) o.getCcp() != null ? 1 : 0, 1, 1), 
				checkCardinality("clrDtTm", (ZonedDateTime) o.getClrDtTm() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingPartyAndTime22__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingPartyAndTime22__1", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime22__1", path, "", res.getError());
				}
				return success("ClearingPartyAndTime22__1", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime22__1", path, "");
			})
			.collect(toList());
	}

}
