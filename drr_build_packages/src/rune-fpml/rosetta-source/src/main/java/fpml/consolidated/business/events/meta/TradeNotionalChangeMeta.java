package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeChangeBase;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.validation.TradeNotionalChangeTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeNotionalChangeValidator;
import fpml.consolidated.business.events.validation.datarule.TradeChangeBaseChoice;
import fpml.consolidated.business.events.validation.datarule.TradeNotionalChangeChoice;
import fpml.consolidated.business.events.validation.exists.TradeNotionalChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeNotionalChange.class)
public class TradeNotionalChangeMeta implements RosettaMetaData<TradeNotionalChange> {

	@Override
	public List<Validator<? super TradeNotionalChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeChangeBase>create(TradeChangeBaseChoice.class),
			factory.<TradeNotionalChange>create(TradeNotionalChangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeNotionalChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeNotionalChange> validator(ValidatorFactory factory) {
		return factory.<TradeNotionalChange>create(TradeNotionalChangeValidator.class);
	}

	@Override
	public Validator<? super TradeNotionalChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeNotionalChange>create(TradeNotionalChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeNotionalChange> validator() {
		return new TradeNotionalChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeNotionalChange> typeFormatValidator() {
		return new TradeNotionalChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNotionalChange, Set<String>> onlyExistsValidator() {
		return new TradeNotionalChangeOnlyExistsValidator();
	}
}
