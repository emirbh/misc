package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ReplacementValueMethodBase;
import fpml.consolidated.ird.validation.ReplacementValueMethodBaseTypeFormatValidator;
import fpml.consolidated.ird.validation.ReplacementValueMethodBaseValidator;
import fpml.consolidated.ird.validation.exists.ReplacementValueMethodBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReplacementValueMethodBase.class)
public class ReplacementValueMethodBaseMeta implements RosettaMetaData<ReplacementValueMethodBase> {

	@Override
	public List<Validator<? super ReplacementValueMethodBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReplacementValueMethodBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReplacementValueMethodBase> validator(ValidatorFactory factory) {
		return factory.<ReplacementValueMethodBase>create(ReplacementValueMethodBaseValidator.class);
	}

	@Override
	public Validator<? super ReplacementValueMethodBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReplacementValueMethodBase>create(ReplacementValueMethodBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValueMethodBase> validator() {
		return new ReplacementValueMethodBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValueMethodBase> typeFormatValidator() {
		return new ReplacementValueMethodBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReplacementValueMethodBase, Set<String>> onlyExistsValidator() {
		return new ReplacementValueMethodBaseOnlyExistsValidator();
	}
}
