package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Unit;
import fpml.consolidated.shared.validation.UnitTypeFormatValidator;
import fpml.consolidated.shared.validation.UnitValidator;
import fpml.consolidated.shared.validation.exists.UnitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Unit.class)
public class UnitMeta implements RosettaMetaData<Unit> {

	@Override
	public List<Validator<? super Unit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Unit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Unit> validator(ValidatorFactory factory) {
		return factory.<Unit>create(UnitValidator.class);
	}

	@Override
	public Validator<? super Unit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Unit>create(UnitTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Unit> validator() {
		return new UnitValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Unit> typeFormatValidator() {
		return new UnitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Unit, Set<String>> onlyExistsValidator() {
		return new UnitOnlyExistsValidator();
	}
}
