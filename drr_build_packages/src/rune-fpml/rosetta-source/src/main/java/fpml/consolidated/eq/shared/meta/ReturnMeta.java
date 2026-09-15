package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.Return;
import fpml.consolidated.eq.shared.validation.ReturnTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Return.class)
public class ReturnMeta implements RosettaMetaData<Return> {

	@Override
	public List<Validator<? super Return>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Return, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Return> validator(ValidatorFactory factory) {
		return factory.<Return>create(ReturnValidator.class);
	}

	@Override
	public Validator<? super Return> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Return>create(ReturnTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Return> validator() {
		return new ReturnValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Return> typeFormatValidator() {
		return new ReturnTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Return, Set<String>> onlyExistsValidator() {
		return new ReturnOnlyExistsValidator();
	}
}
