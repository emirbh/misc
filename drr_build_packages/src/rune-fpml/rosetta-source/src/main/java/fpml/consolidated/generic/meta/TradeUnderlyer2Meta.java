package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.generic.validation.TradeUnderlyer2TypeFormatValidator;
import fpml.consolidated.generic.validation.TradeUnderlyer2Validator;
import fpml.consolidated.generic.validation.datarule.TradeUnderlyer2Choice0;
import fpml.consolidated.generic.validation.datarule.TradeUnderlyer2Choice1;
import fpml.consolidated.generic.validation.exists.TradeUnderlyer2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeUnderlyer2.class)
public class TradeUnderlyer2Meta implements RosettaMetaData<TradeUnderlyer2> {

	@Override
	public List<Validator<? super TradeUnderlyer2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeUnderlyer2>create(TradeUnderlyer2Choice0.class),
			factory.<TradeUnderlyer2>create(TradeUnderlyer2Choice1.class)
		);
	}
	
	@Override
	public List<Function<? super TradeUnderlyer2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeUnderlyer2> validator(ValidatorFactory factory) {
		return factory.<TradeUnderlyer2>create(TradeUnderlyer2Validator.class);
	}

	@Override
	public Validator<? super TradeUnderlyer2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeUnderlyer2>create(TradeUnderlyer2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeUnderlyer2> validator() {
		return new TradeUnderlyer2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeUnderlyer2> typeFormatValidator() {
		return new TradeUnderlyer2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeUnderlyer2, Set<String>> onlyExistsValidator() {
		return new TradeUnderlyer2OnlyExistsValidator();
	}
}
