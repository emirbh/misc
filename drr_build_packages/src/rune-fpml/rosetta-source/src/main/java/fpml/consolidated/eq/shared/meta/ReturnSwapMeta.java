package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.eq.shared.validation.ReturnSwapTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwap.class)
public class ReturnSwapMeta implements RosettaMetaData<ReturnSwap> {

	@Override
	public List<Validator<? super ReturnSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwap> validator(ValidatorFactory factory) {
		return factory.<ReturnSwap>create(ReturnSwapValidator.class);
	}

	@Override
	public Validator<? super ReturnSwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwap>create(ReturnSwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwap> validator() {
		return new ReturnSwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwap> typeFormatValidator() {
		return new ReturnSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwap, Set<String>> onlyExistsValidator() {
		return new ReturnSwapOnlyExistsValidator();
	}
}
