package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.SpecificNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.validation.SpecificNonTransferabilityTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.SpecificNonTransferabilityValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.SpecificNonTransferabilitySettlementPostponementExistence;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.SpecificNonTransferabilitySubstituteTermsChoice;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.SpecificNonTransferabilityOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=SpecificNonTransferability.class)
public class SpecificNonTransferabilityMeta implements RosettaMetaData<SpecificNonTransferability> {

	@Override
	public List<Validator<? super SpecificNonTransferability>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SpecificNonTransferability>create(SpecificNonTransferabilitySettlementPostponementExistence.class),
			factory.<SpecificNonTransferability>create(SpecificNonTransferabilitySubstituteTermsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SpecificNonTransferability, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecificNonTransferability> validator(ValidatorFactory factory) {
		return factory.<SpecificNonTransferability>create(SpecificNonTransferabilityValidator.class);
	}

	@Override
	public Validator<? super SpecificNonTransferability> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpecificNonTransferability>create(SpecificNonTransferabilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpecificNonTransferability> validator() {
		return new SpecificNonTransferabilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpecificNonTransferability> typeFormatValidator() {
		return new SpecificNonTransferabilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecificNonTransferability, Set<String>> onlyExistsValidator() {
		return new SpecificNonTransferabilityOnlyExistsValidator();
	}
}
