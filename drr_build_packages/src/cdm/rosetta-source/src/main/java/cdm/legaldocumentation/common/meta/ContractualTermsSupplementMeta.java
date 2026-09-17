package cdm.legaldocumentation.common.meta;

import cdm.legaldocumentation.common.ContractualTermsSupplement;
import cdm.legaldocumentation.common.validation.ContractualTermsSupplementTypeFormatValidator;
import cdm.legaldocumentation.common.validation.ContractualTermsSupplementValidator;
import cdm.legaldocumentation.common.validation.exists.ContractualTermsSupplementOnlyExistsValidator;
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
@RosettaMeta(model=ContractualTermsSupplement.class)
public class ContractualTermsSupplementMeta implements RosettaMetaData<ContractualTermsSupplement> {

	@Override
	public List<Validator<? super ContractualTermsSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualTermsSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualTermsSupplement> validator(ValidatorFactory factory) {
		return factory.<ContractualTermsSupplement>create(ContractualTermsSupplementValidator.class);
	}

	@Override
	public Validator<? super ContractualTermsSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ContractualTermsSupplement>create(ContractualTermsSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ContractualTermsSupplement> validator() {
		return new ContractualTermsSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ContractualTermsSupplement> typeFormatValidator() {
		return new ContractualTermsSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualTermsSupplement, Set<String>> onlyExistsValidator() {
		return new ContractualTermsSupplementOnlyExistsValidator();
	}
}
