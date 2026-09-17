package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeChangeBase;
import fpml.consolidated.business.events.validation.TradeChangeBaseTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeChangeBaseValidator;
import fpml.consolidated.business.events.validation.datarule.TradeChangeBaseChoice;
import fpml.consolidated.business.events.validation.exists.TradeChangeBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeChangeBase.class)
public class TradeChangeBaseMeta implements RosettaMetaData<TradeChangeBase> {

	@Override
	public List<Validator<? super TradeChangeBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeChangeBase>create(TradeChangeBaseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeChangeBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeChangeBase> validator(ValidatorFactory factory) {
		return factory.<TradeChangeBase>create(TradeChangeBaseValidator.class);
	}

	@Override
	public Validator<? super TradeChangeBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeChangeBase>create(TradeChangeBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeBase> validator() {
		return new TradeChangeBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeBase> typeFormatValidator() {
		return new TradeChangeBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeBase, Set<String>> onlyExistsValidator() {
		return new TradeChangeBaseOnlyExistsValidator();
	}
}
