package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.validation.TradeNovationContentTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeNovationContentValidator;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice0;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice1;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice2;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice3;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice4;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice5;
import fpml.consolidated.business.events.validation.datarule.TradeNovationContentChoice6;
import fpml.consolidated.business.events.validation.exists.TradeNovationContentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeNovationContent.class)
public class TradeNovationContentMeta implements RosettaMetaData<TradeNovationContent> {

	@Override
	public List<Validator<? super TradeNovationContent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeNovationContent>create(TradeNovationContentChoice0.class),
			factory.<TradeNovationContent>create(TradeNovationContentChoice1.class),
			factory.<TradeNovationContent>create(TradeNovationContentChoice2.class),
			factory.<TradeNovationContent>create(TradeNovationContentChoice3.class),
			factory.<TradeNovationContent>create(TradeNovationContentChoice4.class),
			factory.<TradeNovationContent>create(TradeNovationContentChoice5.class),
			factory.<TradeNovationContent>create(TradeNovationContentChoice6.class)
		);
	}
	
	@Override
	public List<Function<? super TradeNovationContent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeNovationContent> validator(ValidatorFactory factory) {
		return factory.<TradeNovationContent>create(TradeNovationContentValidator.class);
	}

	@Override
	public Validator<? super TradeNovationContent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeNovationContent>create(TradeNovationContentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeNovationContent> validator() {
		return new TradeNovationContentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeNovationContent> typeFormatValidator() {
		return new TradeNovationContentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNovationContent, Set<String>> onlyExistsValidator() {
		return new TradeNovationContentOnlyExistsValidator();
	}
}
