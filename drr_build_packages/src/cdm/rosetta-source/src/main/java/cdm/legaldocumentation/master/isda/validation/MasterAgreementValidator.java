package cdm.legaldocumentation.master.isda.validation;

import cdm.legaldocumentation.common.AddressForNotices;
import cdm.legaldocumentation.csa.CreditSupportDocument;
import cdm.legaldocumentation.csa.CreditSupportProvider;
import cdm.legaldocumentation.master.isda.AutomaticEarlyTermination;
import cdm.legaldocumentation.master.isda.MasterAgreement;
import cdm.legaldocumentation.master.isda.SpecifiedEntities;
import cdm.legaldocumentation.master.isda.TerminationCurrency;
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

public class MasterAgreementValidator implements Validator<MasterAgreement> {

	private List<ComparisonResult> getComparisonResults(MasterAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("automaticEarlyTermination", (AutomaticEarlyTermination) o.getAutomaticEarlyTermination() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminationCurrency", (TerminationCurrency) o.getTerminationCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("addressForNotices", (AddressForNotices) o.getAddressForNotices() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonContractualObligations", (Boolean) o.getNonContractualObligations() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportDocument", (CreditSupportDocument) o.getCreditSupportDocument() != null ? 1 : 0, 1, 1), 
				checkCardinality("creditSupportProvider", (CreditSupportProvider) o.getCreditSupportProvider() != null ? 1 : 0, 1, 1), 
				checkCardinality("specifiedEntities", (List<? extends SpecifiedEntities>) o.getSpecifiedEntities() == null ? 0 : o.getSpecifiedEntities().size(), 4, 4)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreement", ValidationResult.ValidationType.CARDINALITY, "MasterAgreement", path, "", res.getError());
				}
				return success("MasterAgreement", ValidationResult.ValidationType.CARDINALITY, "MasterAgreement", path, "");
			})
			.collect(toList());
	}

}
