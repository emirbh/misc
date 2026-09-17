package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DividendConditions;
import fpml.consolidated.eq.shared.validation.DividendConditionsTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.DividendConditionsValidator;
import fpml.consolidated.eq.shared.validation.datarule.DividendConditionsChoice0;
import fpml.consolidated.eq.shared.validation.datarule.DividendConditionsChoice1;
import fpml.consolidated.eq.shared.validation.exists.DividendConditionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendConditions.class)
public class DividendConditionsMeta implements RosettaMetaData<DividendConditions> {

	@Override
	public List<Validator<? super DividendConditions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DividendConditions>create(DividendConditionsChoice0.class),
			factory.<DividendConditions>create(DividendConditionsChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super DividendConditions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendConditions> validator(ValidatorFactory factory) {
		return factory.<DividendConditions>create(DividendConditionsValidator.class);
	}

	@Override
	public Validator<? super DividendConditions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendConditions>create(DividendConditionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendConditions> validator() {
		return new DividendConditionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendConditions> typeFormatValidator() {
		return new DividendConditionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendConditions, Set<String>> onlyExistsValidator() {
		return new DividendConditionsOnlyExistsValidator();
	}
}
