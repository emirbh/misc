package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Security;
import fpml.consolidated.asset.validation.SecurityTypeFormatValidator;
import fpml.consolidated.asset.validation.SecurityValidator;
import fpml.consolidated.asset.validation.exists.SecurityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Security.class)
public class SecurityMeta implements RosettaMetaData<Security> {

	@Override
	public List<Validator<? super Security>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Security, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Security> validator(ValidatorFactory factory) {
		return factory.<Security>create(SecurityValidator.class);
	}

	@Override
	public Validator<? super Security> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Security>create(SecurityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Security> validator() {
		return new SecurityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Security> typeFormatValidator() {
		return new SecurityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Security, Set<String>> onlyExistsValidator() {
		return new SecurityOnlyExistsValidator();
	}
}
