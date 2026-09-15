package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DividendPeriod;
import fpml.consolidated.eq.shared.validation.DividendPeriodTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.DividendPeriodValidator;
import fpml.consolidated.eq.shared.validation.exists.DividendPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendPeriod.class)
public class DividendPeriodMeta implements RosettaMetaData<DividendPeriod> {

	@Override
	public List<Validator<? super DividendPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendPeriod> validator(ValidatorFactory factory) {
		return factory.<DividendPeriod>create(DividendPeriodValidator.class);
	}

	@Override
	public Validator<? super DividendPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendPeriod>create(DividendPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendPeriod> validator() {
		return new DividendPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendPeriod> typeFormatValidator() {
		return new DividendPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPeriod, Set<String>> onlyExistsValidator() {
		return new DividendPeriodOnlyExistsValidator();
	}
}
