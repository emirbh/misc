package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.BasketId;
import fpml.consolidated.asset.validation.BasketIdTypeFormatValidator;
import fpml.consolidated.asset.validation.BasketIdValidator;
import fpml.consolidated.asset.validation.exists.BasketIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BasketId.class)
public class BasketIdMeta implements RosettaMetaData<BasketId> {

	@Override
	public List<Validator<? super BasketId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketId> validator(ValidatorFactory factory) {
		return factory.<BasketId>create(BasketIdValidator.class);
	}

	@Override
	public Validator<? super BasketId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketId>create(BasketIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketId> validator() {
		return new BasketIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketId> typeFormatValidator() {
		return new BasketIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketId, Set<String>> onlyExistsValidator() {
		return new BasketIdOnlyExistsValidator();
	}
}
