package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyFloatingRateOption;
import fpml.consolidated.loan.validation.LegacyFloatingRateOptionTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyFloatingRateOptionValidator;
import fpml.consolidated.loan.validation.exists.LegacyFloatingRateOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyFloatingRateOption.class)
public class LegacyFloatingRateOptionMeta implements RosettaMetaData<LegacyFloatingRateOption> {

	@Override
	public List<Validator<? super LegacyFloatingRateOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyFloatingRateOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyFloatingRateOption> validator(ValidatorFactory factory) {
		return factory.<LegacyFloatingRateOption>create(LegacyFloatingRateOptionValidator.class);
	}

	@Override
	public Validator<? super LegacyFloatingRateOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyFloatingRateOption>create(LegacyFloatingRateOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyFloatingRateOption> validator() {
		return new LegacyFloatingRateOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyFloatingRateOption> typeFormatValidator() {
		return new LegacyFloatingRateOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyFloatingRateOption, Set<String>> onlyExistsValidator() {
		return new LegacyFloatingRateOptionOnlyExistsValidator();
	}
}
