package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.validation.TradeAmendmentContentTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeAmendmentContentValidator;
import fpml.consolidated.business.events.validation.datarule.TradeAmendmentContentChoice;
import fpml.consolidated.business.events.validation.exists.TradeAmendmentContentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeAmendmentContent.class)
public class TradeAmendmentContentMeta implements RosettaMetaData<TradeAmendmentContent> {

	@Override
	public List<Validator<? super TradeAmendmentContent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeAmendmentContent>create(TradeAmendmentContentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeAmendmentContent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeAmendmentContent> validator(ValidatorFactory factory) {
		return factory.<TradeAmendmentContent>create(TradeAmendmentContentValidator.class);
	}

	@Override
	public Validator<? super TradeAmendmentContent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeAmendmentContent>create(TradeAmendmentContentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeAmendmentContent> validator() {
		return new TradeAmendmentContentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeAmendmentContent> typeFormatValidator() {
		return new TradeAmendmentContentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeAmendmentContent, Set<String>> onlyExistsValidator() {
		return new TradeAmendmentContentOnlyExistsValidator();
	}
}
