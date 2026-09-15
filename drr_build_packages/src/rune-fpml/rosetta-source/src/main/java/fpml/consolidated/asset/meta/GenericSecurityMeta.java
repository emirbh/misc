package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.GenericSecurity;
import fpml.consolidated.asset.validation.GenericSecurityTypeFormatValidator;
import fpml.consolidated.asset.validation.GenericSecurityValidator;
import fpml.consolidated.asset.validation.exists.GenericSecurityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericSecurity.class)
public class GenericSecurityMeta implements RosettaMetaData<GenericSecurity> {

	@Override
	public List<Validator<? super GenericSecurity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericSecurity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericSecurity> validator(ValidatorFactory factory) {
		return factory.<GenericSecurity>create(GenericSecurityValidator.class);
	}

	@Override
	public Validator<? super GenericSecurity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericSecurity>create(GenericSecurityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericSecurity> validator() {
		return new GenericSecurityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericSecurity> typeFormatValidator() {
		return new GenericSecurityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericSecurity, Set<String>> onlyExistsValidator() {
		return new GenericSecurityOnlyExistsValidator();
	}
}
