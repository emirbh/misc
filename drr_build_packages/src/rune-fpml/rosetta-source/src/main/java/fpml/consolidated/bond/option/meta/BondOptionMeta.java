package fpml.consolidated.bond.option.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.bond.option.validation.BondOptionTypeFormatValidator;
import fpml.consolidated.bond.option.validation.BondOptionValidator;
import fpml.consolidated.bond.option.validation.datarule.BondOptionChoice;
import fpml.consolidated.bond.option.validation.exists.BondOptionOnlyExistsValidator;
import fpml.consolidated.option.shared.OptionBaseExtended;
import fpml.consolidated.option.shared.validation.datarule.OptionBaseExtendedChoice0;
import fpml.consolidated.option.shared.validation.datarule.OptionBaseExtendedChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BondOption.class)
public class BondOptionMeta implements RosettaMetaData<BondOption> {

	@Override
	public List<Validator<? super BondOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionBaseExtended>create(OptionBaseExtendedChoice0.class),
			factory.<OptionBaseExtended>create(OptionBaseExtendedChoice1.class),
			factory.<BondOption>create(BondOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BondOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BondOption> validator(ValidatorFactory factory) {
		return factory.<BondOption>create(BondOptionValidator.class);
	}

	@Override
	public Validator<? super BondOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BondOption>create(BondOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BondOption> validator() {
		return new BondOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BondOption> typeFormatValidator() {
		return new BondOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondOption, Set<String>> onlyExistsValidator() {
		return new BondOptionOnlyExistsValidator();
	}
}
