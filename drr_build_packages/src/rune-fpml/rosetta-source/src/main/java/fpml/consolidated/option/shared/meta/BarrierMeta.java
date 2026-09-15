package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.Barrier;
import fpml.consolidated.option.shared.validation.BarrierTypeFormatValidator;
import fpml.consolidated.option.shared.validation.BarrierValidator;
import fpml.consolidated.option.shared.validation.exists.BarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Barrier.class)
public class BarrierMeta implements RosettaMetaData<Barrier> {

	@Override
	public List<Validator<? super Barrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Barrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Barrier> validator(ValidatorFactory factory) {
		return factory.<Barrier>create(BarrierValidator.class);
	}

	@Override
	public Validator<? super Barrier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Barrier>create(BarrierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Barrier> validator() {
		return new BarrierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Barrier> typeFormatValidator() {
		return new BarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Barrier, Set<String>> onlyExistsValidator() {
		return new BarrierOnlyExistsValidator();
	}
}
