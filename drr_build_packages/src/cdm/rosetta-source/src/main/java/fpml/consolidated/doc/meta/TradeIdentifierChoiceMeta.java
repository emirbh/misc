package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.doc.validation.TradeIdentifierChoiceTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeIdentifierChoiceValidator;
import fpml.consolidated.doc.validation.datarule.TradeIdentifierChoiceChoice;
import fpml.consolidated.doc.validation.exists.TradeIdentifierChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeIdentifierChoice.class)
public class TradeIdentifierChoiceMeta implements RosettaMetaData<TradeIdentifierChoice> {

	@Override
	public List<Validator<? super TradeIdentifierChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifierChoice>create(TradeIdentifierChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeIdentifierChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeIdentifierChoice> validator(ValidatorFactory factory) {
		return factory.<TradeIdentifierChoice>create(TradeIdentifierChoiceValidator.class);
	}

	@Override
	public Validator<? super TradeIdentifierChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeIdentifierChoice>create(TradeIdentifierChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeIdentifierChoice> validator() {
		return new TradeIdentifierChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeIdentifierChoice> typeFormatValidator() {
		return new TradeIdentifierChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeIdentifierChoice, Set<String>> onlyExistsValidator() {
		return new TradeIdentifierChoiceOnlyExistsValidator();
	}
}
