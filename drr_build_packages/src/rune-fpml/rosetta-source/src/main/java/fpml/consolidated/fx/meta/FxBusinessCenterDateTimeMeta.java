package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxBusinessCenterDateTime;
import fpml.consolidated.fx.validation.FxBusinessCenterDateTimeTypeFormatValidator;
import fpml.consolidated.fx.validation.FxBusinessCenterDateTimeValidator;
import fpml.consolidated.fx.validation.exists.FxBusinessCenterDateTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxBusinessCenterDateTime.class)
public class FxBusinessCenterDateTimeMeta implements RosettaMetaData<FxBusinessCenterDateTime> {

	@Override
	public List<Validator<? super FxBusinessCenterDateTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxBusinessCenterDateTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxBusinessCenterDateTime> validator(ValidatorFactory factory) {
		return factory.<FxBusinessCenterDateTime>create(FxBusinessCenterDateTimeValidator.class);
	}

	@Override
	public Validator<? super FxBusinessCenterDateTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxBusinessCenterDateTime>create(FxBusinessCenterDateTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxBusinessCenterDateTime> validator() {
		return new FxBusinessCenterDateTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxBusinessCenterDateTime> typeFormatValidator() {
		return new FxBusinessCenterDateTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBusinessCenterDateTime, Set<String>> onlyExistsValidator() {
		return new FxBusinessCenterDateTimeOnlyExistsValidator();
	}
}
