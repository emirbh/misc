package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.validation.TradeChangeContentTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeChangeContentValidator;
import fpml.consolidated.business.events.validation.datarule.TradeChangeContentChoice;
import fpml.consolidated.business.events.validation.exists.TradeChangeContentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeChangeContent.class)
public class TradeChangeContentMeta implements RosettaMetaData<TradeChangeContent> {

	@Override
	public List<Validator<? super TradeChangeContent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeChangeContent>create(TradeChangeContentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeChangeContent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeChangeContent> validator(ValidatorFactory factory) {
		return factory.<TradeChangeContent>create(TradeChangeContentValidator.class);
	}

	@Override
	public Validator<? super TradeChangeContent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeChangeContent>create(TradeChangeContentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeContent> validator() {
		return new TradeChangeContentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeContent> typeFormatValidator() {
		return new TradeChangeContentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeContent, Set<String>> onlyExistsValidator() {
		return new TradeChangeContentOnlyExistsValidator();
	}
}
