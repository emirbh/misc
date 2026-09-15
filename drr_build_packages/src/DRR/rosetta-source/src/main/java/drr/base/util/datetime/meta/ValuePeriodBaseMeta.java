package drr.base.util.datetime.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.util.datetime.ValuePeriodBase;
import drr.base.util.datetime.validation.ValuePeriodBaseTypeFormatValidator;
import drr.base.util.datetime.validation.ValuePeriodBaseValidator;
import drr.base.util.datetime.validation.exists.ValuePeriodBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ValuePeriodBase.class)
public class ValuePeriodBaseMeta implements RosettaMetaData<ValuePeriodBase> {

	@Override
	public List<Validator<? super ValuePeriodBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuePeriodBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuePeriodBase> validator(ValidatorFactory factory) {
		return factory.<ValuePeriodBase>create(ValuePeriodBaseValidator.class);
	}

	@Override
	public Validator<? super ValuePeriodBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuePeriodBase>create(ValuePeriodBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuePeriodBase> validator() {
		return new ValuePeriodBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuePeriodBase> typeFormatValidator() {
		return new ValuePeriodBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuePeriodBase, Set<String>> onlyExistsValidator() {
		return new ValuePeriodBaseOnlyExistsValidator();
	}
}
