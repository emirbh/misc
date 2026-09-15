package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualOption;
import fpml.consolidated.fx.accruals.validation.FxAccrualOptionTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualOptionValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualOptionChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualOptionChoice1;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualOptionChoice2;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualOption.class)
public class FxAccrualOptionMeta implements RosettaMetaData<FxAccrualOption> {

	@Override
	public List<Validator<? super FxAccrualOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualOption>create(FxAccrualOptionChoice0.class),
			factory.<FxAccrualOption>create(FxAccrualOptionChoice1.class),
			factory.<FxAccrualOption>create(FxAccrualOptionChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualOption> validator(ValidatorFactory factory) {
		return factory.<FxAccrualOption>create(FxAccrualOptionValidator.class);
	}

	@Override
	public Validator<? super FxAccrualOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualOption>create(FxAccrualOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualOption> validator() {
		return new FxAccrualOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualOption> typeFormatValidator() {
		return new FxAccrualOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualOption, Set<String>> onlyExistsValidator() {
		return new FxAccrualOptionOnlyExistsValidator();
	}
}
