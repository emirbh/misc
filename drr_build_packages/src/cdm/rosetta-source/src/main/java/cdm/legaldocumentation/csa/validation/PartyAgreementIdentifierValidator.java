package cdm.legaldocumentation.csa.validation;

import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legaldocumentation.csa.PartyAgreementIdentifier;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PartyAgreementIdentifierValidator implements Validator<PartyAgreementIdentifier> {

	private List<ComparisonResult> getComparisonResults(PartyAgreementIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", (ReferenceWithMetaParty) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("documentIdentifier", (List<? extends FieldWithMetaIdentifier>) o.getDocumentIdentifier() == null ? 0 : o.getDocumentIdentifier().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyAgreementIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyAgreementIdentifier", ValidationResult.ValidationType.CARDINALITY, "PartyAgreementIdentifier", path, "", res.getError());
				}
				return success("PartyAgreementIdentifier", ValidationResult.ValidationType.CARDINALITY, "PartyAgreementIdentifier", path, "");
			})
			.collect(toList());
	}

}
