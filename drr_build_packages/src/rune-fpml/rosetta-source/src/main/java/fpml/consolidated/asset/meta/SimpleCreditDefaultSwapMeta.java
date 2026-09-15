package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.SimpleCreditDefaultSwap;
import fpml.consolidated.asset.validation.SimpleCreditDefaultSwapTypeFormatValidator;
import fpml.consolidated.asset.validation.SimpleCreditDefaultSwapValidator;
import fpml.consolidated.asset.validation.datarule.SimpleCreditDefaultSwapChoice;
import fpml.consolidated.asset.validation.exists.SimpleCreditDefaultSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SimpleCreditDefaultSwap.class)
public class SimpleCreditDefaultSwapMeta implements RosettaMetaData<SimpleCreditDefaultSwap> {

	@Override
	public List<Validator<? super SimpleCreditDefaultSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SimpleCreditDefaultSwap>create(SimpleCreditDefaultSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SimpleCreditDefaultSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimpleCreditDefaultSwap> validator(ValidatorFactory factory) {
		return factory.<SimpleCreditDefaultSwap>create(SimpleCreditDefaultSwapValidator.class);
	}

	@Override
	public Validator<? super SimpleCreditDefaultSwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SimpleCreditDefaultSwap>create(SimpleCreditDefaultSwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SimpleCreditDefaultSwap> validator() {
		return new SimpleCreditDefaultSwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SimpleCreditDefaultSwap> typeFormatValidator() {
		return new SimpleCreditDefaultSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimpleCreditDefaultSwap, Set<String>> onlyExistsValidator() {
		return new SimpleCreditDefaultSwapOnlyExistsValidator();
	}
}
