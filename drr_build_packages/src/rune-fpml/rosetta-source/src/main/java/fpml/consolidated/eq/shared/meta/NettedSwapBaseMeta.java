package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.NettedSwapBase;
import fpml.consolidated.eq.shared.validation.NettedSwapBaseTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.NettedSwapBaseValidator;
import fpml.consolidated.eq.shared.validation.exists.NettedSwapBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NettedSwapBase.class)
public class NettedSwapBaseMeta implements RosettaMetaData<NettedSwapBase> {

	@Override
	public List<Validator<? super NettedSwapBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NettedSwapBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NettedSwapBase> validator(ValidatorFactory factory) {
		return factory.<NettedSwapBase>create(NettedSwapBaseValidator.class);
	}

	@Override
	public Validator<? super NettedSwapBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NettedSwapBase>create(NettedSwapBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NettedSwapBase> validator() {
		return new NettedSwapBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NettedSwapBase> typeFormatValidator() {
		return new NettedSwapBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NettedSwapBase, Set<String>> onlyExistsValidator() {
		return new NettedSwapBaseOnlyExistsValidator();
	}
}
