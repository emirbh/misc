package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.TerminationCurrencyAmendment;
import cdm.legaldocumentation.csa.validation.TerminationCurrencyAmendmentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.TerminationCurrencyAmendmentValidator;
import cdm.legaldocumentation.csa.validation.datarule.TerminationCurrencyAmendmentApplicability;
import cdm.legaldocumentation.csa.validation.exists.TerminationCurrencyAmendmentOnlyExistsValidator;
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
@RosettaMeta(model=TerminationCurrencyAmendment.class)
public class TerminationCurrencyAmendmentMeta implements RosettaMetaData<TerminationCurrencyAmendment> {

	@Override
	public List<Validator<? super TerminationCurrencyAmendment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TerminationCurrencyAmendment>create(TerminationCurrencyAmendmentApplicability.class)
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrencyAmendment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrencyAmendment> validator(ValidatorFactory factory) {
		return factory.<TerminationCurrencyAmendment>create(TerminationCurrencyAmendmentValidator.class);
	}

	@Override
	public Validator<? super TerminationCurrencyAmendment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TerminationCurrencyAmendment>create(TerminationCurrencyAmendmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrencyAmendment> validator() {
		return new TerminationCurrencyAmendmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrencyAmendment> typeFormatValidator() {
		return new TerminationCurrencyAmendmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrencyAmendment, Set<String>> onlyExistsValidator() {
		return new TerminationCurrencyAmendmentOnlyExistsValidator();
	}
}
