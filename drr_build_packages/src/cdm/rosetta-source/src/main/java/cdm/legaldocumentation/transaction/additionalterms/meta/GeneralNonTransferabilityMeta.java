package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.GeneralNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.validation.GeneralNonTransferabilityTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.GeneralNonTransferabilityValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.GeneralNonTransferabilitySettlementPostponementExistence;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.GeneralNonTransferabilitySubstituteTermsChoice;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.GeneralNonTransferabilityOnlyExistsValidator;
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
@RosettaMeta(model=GeneralNonTransferability.class)
public class GeneralNonTransferabilityMeta implements RosettaMetaData<GeneralNonTransferability> {

	@Override
	public List<Validator<? super GeneralNonTransferability>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GeneralNonTransferability>create(GeneralNonTransferabilitySettlementPostponementExistence.class),
			factory.<GeneralNonTransferability>create(GeneralNonTransferabilitySubstituteTermsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GeneralNonTransferability, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GeneralNonTransferability> validator(ValidatorFactory factory) {
		return factory.<GeneralNonTransferability>create(GeneralNonTransferabilityValidator.class);
	}

	@Override
	public Validator<? super GeneralNonTransferability> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GeneralNonTransferability>create(GeneralNonTransferabilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GeneralNonTransferability> validator() {
		return new GeneralNonTransferabilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GeneralNonTransferability> typeFormatValidator() {
		return new GeneralNonTransferabilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralNonTransferability, Set<String>> onlyExistsValidator() {
		return new GeneralNonTransferabilityOnlyExistsValidator();
	}
}
