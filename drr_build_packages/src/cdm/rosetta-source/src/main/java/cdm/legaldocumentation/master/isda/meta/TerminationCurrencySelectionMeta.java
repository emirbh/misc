package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.TerminationCurrencySelection;
import cdm.legaldocumentation.master.isda.validation.TerminationCurrencySelectionTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.TerminationCurrencySelectionValidator;
import cdm.legaldocumentation.master.isda.validation.exists.TerminationCurrencySelectionOnlyExistsValidator;
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
@RosettaMeta(model=TerminationCurrencySelection.class)
public class TerminationCurrencySelectionMeta implements RosettaMetaData<TerminationCurrencySelection> {

	@Override
	public List<Validator<? super TerminationCurrencySelection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrencySelection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrencySelection> validator(ValidatorFactory factory) {
		return factory.<TerminationCurrencySelection>create(TerminationCurrencySelectionValidator.class);
	}

	@Override
	public Validator<? super TerminationCurrencySelection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TerminationCurrencySelection>create(TerminationCurrencySelectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrencySelection> validator() {
		return new TerminationCurrencySelectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrencySelection> typeFormatValidator() {
		return new TerminationCurrencySelectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrencySelection, Set<String>> onlyExistsValidator() {
		return new TerminationCurrencySelectionOnlyExistsValidator();
	}
}
