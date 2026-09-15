package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.eq.shared.validation.ReturnSwapNotionalTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapNotionalValidator;
import fpml.consolidated.eq.shared.validation.datarule.ReturnSwapNotionalChoice;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapNotional.class)
public class ReturnSwapNotionalMeta implements RosettaMetaData<ReturnSwapNotional> {

	@Override
	public List<Validator<? super ReturnSwapNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReturnSwapNotional>create(ReturnSwapNotionalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapNotional> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapNotional>create(ReturnSwapNotionalValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapNotional> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapNotional>create(ReturnSwapNotionalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapNotional> validator() {
		return new ReturnSwapNotionalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapNotional> typeFormatValidator() {
		return new ReturnSwapNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapNotional, Set<String>> onlyExistsValidator() {
		return new ReturnSwapNotionalOnlyExistsValidator();
	}
}
