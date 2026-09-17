package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DelayedDraw;
import fpml.consolidated.loan.validation.DelayedDrawTypeFormatValidator;
import fpml.consolidated.loan.validation.DelayedDrawValidator;
import fpml.consolidated.loan.validation.exists.DelayedDrawOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DelayedDraw.class)
public class DelayedDrawMeta implements RosettaMetaData<DelayedDraw> {

	@Override
	public List<Validator<? super DelayedDraw>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DelayedDraw, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DelayedDraw> validator(ValidatorFactory factory) {
		return factory.<DelayedDraw>create(DelayedDrawValidator.class);
	}

	@Override
	public Validator<? super DelayedDraw> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DelayedDraw>create(DelayedDrawTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DelayedDraw> validator() {
		return new DelayedDrawValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DelayedDraw> typeFormatValidator() {
		return new DelayedDrawTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DelayedDraw, Set<String>> onlyExistsValidator() {
		return new DelayedDrawOnlyExistsValidator();
	}
}
