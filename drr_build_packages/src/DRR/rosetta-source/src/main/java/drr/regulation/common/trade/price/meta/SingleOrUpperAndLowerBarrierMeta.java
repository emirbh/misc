package drr.regulation.common.trade.price.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.price.validation.SingleOrUpperAndLowerBarrierTypeFormatValidator;
import drr.regulation.common.trade.price.validation.SingleOrUpperAndLowerBarrierValidator;
import drr.regulation.common.trade.price.validation.datarule.SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.price.validation.exists.SingleOrUpperAndLowerBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=SingleOrUpperAndLowerBarrier.class)
public class SingleOrUpperAndLowerBarrierMeta implements RosettaMetaData<SingleOrUpperAndLowerBarrier> {

	@Override
	public List<Validator<? super SingleOrUpperAndLowerBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SingleOrUpperAndLowerBarrier>create(SingleOrUpperAndLowerBarrierSingleOrUpperAndLowerBarrier.class)
		);
	}
	
	@Override
	public List<Function<? super SingleOrUpperAndLowerBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SingleOrUpperAndLowerBarrier> validator(ValidatorFactory factory) {
		return factory.<SingleOrUpperAndLowerBarrier>create(SingleOrUpperAndLowerBarrierValidator.class);
	}

	@Override
	public Validator<? super SingleOrUpperAndLowerBarrier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SingleOrUpperAndLowerBarrier>create(SingleOrUpperAndLowerBarrierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SingleOrUpperAndLowerBarrier> validator() {
		return new SingleOrUpperAndLowerBarrierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SingleOrUpperAndLowerBarrier> typeFormatValidator() {
		return new SingleOrUpperAndLowerBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SingleOrUpperAndLowerBarrier, Set<String>> onlyExistsValidator() {
		return new SingleOrUpperAndLowerBarrierOnlyExistsValidator();
	}
}
