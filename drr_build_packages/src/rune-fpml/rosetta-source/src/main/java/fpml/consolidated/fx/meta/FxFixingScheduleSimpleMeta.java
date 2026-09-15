package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import fpml.consolidated.fx.validation.FxFixingScheduleSimpleTypeFormatValidator;
import fpml.consolidated.fx.validation.FxFixingScheduleSimpleValidator;
import fpml.consolidated.fx.validation.datarule.FxFixingScheduleSimpleChoice;
import fpml.consolidated.fx.validation.exists.FxFixingScheduleSimpleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFixingScheduleSimple.class)
public class FxFixingScheduleSimpleMeta implements RosettaMetaData<FxFixingScheduleSimple> {

	@Override
	public List<Validator<? super FxFixingScheduleSimple>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxFixingScheduleSimple>create(FxFixingScheduleSimpleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingScheduleSimple, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFixingScheduleSimple> validator(ValidatorFactory factory) {
		return factory.<FxFixingScheduleSimple>create(FxFixingScheduleSimpleValidator.class);
	}

	@Override
	public Validator<? super FxFixingScheduleSimple> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFixingScheduleSimple>create(FxFixingScheduleSimpleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingScheduleSimple> validator() {
		return new FxFixingScheduleSimpleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingScheduleSimple> typeFormatValidator() {
		return new FxFixingScheduleSimpleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingScheduleSimple, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleSimpleOnlyExistsValidator();
	}
}
