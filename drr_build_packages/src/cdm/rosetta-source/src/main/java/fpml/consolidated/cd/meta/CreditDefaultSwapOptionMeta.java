package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.validation.CreditDefaultSwapOptionTypeFormatValidator;
import fpml.consolidated.cd.validation.CreditDefaultSwapOptionValidator;
import fpml.consolidated.cd.validation.exists.CreditDefaultSwapOptionOnlyExistsValidator;
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
@RosettaMeta(model=CreditDefaultSwapOption.class)
public class CreditDefaultSwapOptionMeta implements RosettaMetaData<CreditDefaultSwapOption> {

	@Override
	public List<Validator<? super CreditDefaultSwapOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionBaseExtended>create(OptionBaseExtendedChoice0.class),
			factory.<OptionBaseExtended>create(OptionBaseExtendedChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CreditDefaultSwapOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditDefaultSwapOption> validator(ValidatorFactory factory) {
		return factory.<CreditDefaultSwapOption>create(CreditDefaultSwapOptionValidator.class);
	}

	@Override
	public Validator<? super CreditDefaultSwapOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditDefaultSwapOption>create(CreditDefaultSwapOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditDefaultSwapOption> validator() {
		return new CreditDefaultSwapOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditDefaultSwapOption> typeFormatValidator() {
		return new CreditDefaultSwapOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDefaultSwapOption, Set<String>> onlyExistsValidator() {
		return new CreditDefaultSwapOptionOnlyExistsValidator();
	}
}
