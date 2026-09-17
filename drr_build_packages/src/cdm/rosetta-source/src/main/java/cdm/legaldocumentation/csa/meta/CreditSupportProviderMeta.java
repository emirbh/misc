package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportProvider;
import cdm.legaldocumentation.csa.validation.CreditSupportProviderTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportProviderValidator;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportProviderOnlyExistsValidator;
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
@RosettaMeta(model=CreditSupportProvider.class)
public class CreditSupportProviderMeta implements RosettaMetaData<CreditSupportProvider> {

	@Override
	public List<Validator<? super CreditSupportProvider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportProvider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportProvider> validator(ValidatorFactory factory) {
		return factory.<CreditSupportProvider>create(CreditSupportProviderValidator.class);
	}

	@Override
	public Validator<? super CreditSupportProvider> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportProvider>create(CreditSupportProviderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportProvider> validator() {
		return new CreditSupportProviderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportProvider> typeFormatValidator() {
		return new CreditSupportProviderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportProvider, Set<String>> onlyExistsValidator() {
		return new CreditSupportProviderOnlyExistsValidator();
	}
}
