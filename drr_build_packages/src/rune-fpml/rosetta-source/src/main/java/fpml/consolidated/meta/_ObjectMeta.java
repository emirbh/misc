package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated._Object;
import fpml.consolidated.validation._ObjectTypeFormatValidator;
import fpml.consolidated.validation._ObjectValidator;
import fpml.consolidated.validation.exists._ObjectOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=_Object.class)
public class _ObjectMeta implements RosettaMetaData<_Object> {

	@Override
	public List<Validator<? super _Object>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super _Object, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super _Object> validator(ValidatorFactory factory) {
		return factory.<_Object>create(_ObjectValidator.class);
	}

	@Override
	public Validator<? super _Object> typeFormatValidator(ValidatorFactory factory) {
		return factory.<_Object>create(_ObjectTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super _Object> validator() {
		return new _ObjectValidator();
	}

	@Deprecated
	@Override
	public Validator<? super _Object> typeFormatValidator() {
		return new _ObjectTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super _Object, Set<String>> onlyExistsValidator() {
		return new _ObjectOnlyExistsValidator();
	}
}
