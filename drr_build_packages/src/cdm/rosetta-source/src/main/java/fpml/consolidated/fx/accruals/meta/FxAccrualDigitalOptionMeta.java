package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualDigitalOption;
import fpml.consolidated.fx.accruals.validation.FxAccrualDigitalOptionTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualDigitalOptionValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualDigitalOptionChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualDigitalOptionChoice1;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualDigitalOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualDigitalOption.class)
public class FxAccrualDigitalOptionMeta implements RosettaMetaData<FxAccrualDigitalOption> {

	@Override
	public List<Validator<? super FxAccrualDigitalOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualDigitalOption>create(FxAccrualDigitalOptionChoice0.class),
			factory.<FxAccrualDigitalOption>create(FxAccrualDigitalOptionChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualDigitalOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualDigitalOption> validator(ValidatorFactory factory) {
		return factory.<FxAccrualDigitalOption>create(FxAccrualDigitalOptionValidator.class);
	}

	@Override
	public Validator<? super FxAccrualDigitalOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualDigitalOption>create(FxAccrualDigitalOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualDigitalOption> validator() {
		return new FxAccrualDigitalOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualDigitalOption> typeFormatValidator() {
		return new FxAccrualDigitalOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualDigitalOption, Set<String>> onlyExistsValidator() {
		return new FxAccrualDigitalOptionOnlyExistsValidator();
	}
}
