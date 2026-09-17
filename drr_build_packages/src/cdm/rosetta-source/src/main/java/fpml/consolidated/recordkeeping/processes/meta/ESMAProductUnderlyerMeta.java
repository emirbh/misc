package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import fpml.consolidated.recordkeeping.processes.validation.ESMAProductUnderlyerTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.ESMAProductUnderlyerValidator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.ESMAProductUnderlyerChoice0;
import fpml.consolidated.recordkeeping.processes.validation.datarule.ESMAProductUnderlyerChoice1;
import fpml.consolidated.recordkeeping.processes.validation.exists.ESMAProductUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ESMAProductUnderlyer.class)
public class ESMAProductUnderlyerMeta implements RosettaMetaData<ESMAProductUnderlyer> {

	@Override
	public List<Validator<? super ESMAProductUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ESMAProductUnderlyer>create(ESMAProductUnderlyerChoice0.class),
			factory.<ESMAProductUnderlyer>create(ESMAProductUnderlyerChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super ESMAProductUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMAProductUnderlyer> validator(ValidatorFactory factory) {
		return factory.<ESMAProductUnderlyer>create(ESMAProductUnderlyerValidator.class);
	}

	@Override
	public Validator<? super ESMAProductUnderlyer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMAProductUnderlyer>create(ESMAProductUnderlyerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMAProductUnderlyer> validator() {
		return new ESMAProductUnderlyerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMAProductUnderlyer> typeFormatValidator() {
		return new ESMAProductUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMAProductUnderlyer, Set<String>> onlyExistsValidator() {
		return new ESMAProductUnderlyerOnlyExistsValidator();
	}
}
