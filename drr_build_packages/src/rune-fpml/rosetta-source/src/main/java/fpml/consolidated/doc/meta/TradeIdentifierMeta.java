package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.validation.TradeIdentifierTypeFormatValidator;
import fpml.consolidated.doc.validation.TradeIdentifierValidator;
import fpml.consolidated.doc.validation.datarule.TradeIdentifierChoice;
import fpml.consolidated.doc.validation.exists.TradeIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeIdentifier.class)
public class TradeIdentifierMeta implements RosettaMetaData<TradeIdentifier> {

	@Override
	public List<Validator<? super TradeIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeIdentifier> validator(ValidatorFactory factory) {
		return factory.<TradeIdentifier>create(TradeIdentifierValidator.class);
	}

	@Override
	public Validator<? super TradeIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeIdentifier>create(TradeIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeIdentifier> validator() {
		return new TradeIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeIdentifier> typeFormatValidator() {
		return new TradeIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeIdentifier, Set<String>> onlyExistsValidator() {
		return new TradeIdentifierOnlyExistsValidator();
	}
}
