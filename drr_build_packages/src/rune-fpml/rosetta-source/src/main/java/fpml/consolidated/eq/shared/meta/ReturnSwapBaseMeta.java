package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapBase;
import fpml.consolidated.eq.shared.validation.ReturnSwapBaseTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapBaseValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapBase.class)
public class ReturnSwapBaseMeta implements RosettaMetaData<ReturnSwapBase> {

	@Override
	public List<Validator<? super ReturnSwapBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapBase> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapBase>create(ReturnSwapBaseValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapBase>create(ReturnSwapBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapBase> validator() {
		return new ReturnSwapBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapBase> typeFormatValidator() {
		return new ReturnSwapBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapBase, Set<String>> onlyExistsValidator() {
		return new ReturnSwapBaseOnlyExistsValidator();
	}
}
