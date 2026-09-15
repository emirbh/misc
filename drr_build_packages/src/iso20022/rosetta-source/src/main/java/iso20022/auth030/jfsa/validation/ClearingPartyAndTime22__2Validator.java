package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.ClearingAccountType4Code;
import iso20022.auth030.jfsa.ClearingPartyAndTime22__2;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier2Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ClearingPartyAndTime22__2Validator implements Validator<ClearingPartyAndTime22__2> {

	private List<ComparisonResult> getComparisonResults(ClearingPartyAndTime22__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ccp", (OrganisationIdentification15Choice__1) o.getCcp() != null ? 1 : 0, 0, 1), 
				checkCardinality("orgnlIdr", (UniqueTransactionIdentifier2Choice__1) o.getOrgnlIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("orgnlTradRpstryIdr", (OrganisationIdentification15Choice__1) o.getOrgnlTradRpstryIdr() != null ? 1 : 0, 0, 1), 
				checkCardinality("clrAcctOrgn", (ClearingAccountType4Code) o.getClrAcctOrgn() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingPartyAndTime22__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingPartyAndTime22__2", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime22__2", path, "", res.getError());
				}
				return success("ClearingPartyAndTime22__2", ValidationResult.ValidationType.CARDINALITY, "ClearingPartyAndTime22__2", path, "");
			})
			.collect(toList());
	}

}
