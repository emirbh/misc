package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.PartyTerminationCurrencySelection;
import cdm.legaldocumentation.master.isda.validation.PartyTerminationCurrencySelectionTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.PartyTerminationCurrencySelectionValidator;
import cdm.legaldocumentation.master.isda.validation.exists.PartyTerminationCurrencySelectionOnlyExistsValidator;
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
@RosettaMeta(model=PartyTerminationCurrencySelection.class)
public class PartyTerminationCurrencySelectionMeta implements RosettaMetaData<PartyTerminationCurrencySelection> {

	@Override
	public List<Validator<? super PartyTerminationCurrencySelection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTerminationCurrencySelection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTerminationCurrencySelection> validator(ValidatorFactory factory) {
		return factory.<PartyTerminationCurrencySelection>create(PartyTerminationCurrencySelectionValidator.class);
	}

	@Override
	public Validator<? super PartyTerminationCurrencySelection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyTerminationCurrencySelection>create(PartyTerminationCurrencySelectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyTerminationCurrencySelection> validator() {
		return new PartyTerminationCurrencySelectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyTerminationCurrencySelection> typeFormatValidator() {
		return new PartyTerminationCurrencySelectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTerminationCurrencySelection, Set<String>> onlyExistsValidator() {
		return new PartyTerminationCurrencySelectionOnlyExistsValidator();
	}
}
