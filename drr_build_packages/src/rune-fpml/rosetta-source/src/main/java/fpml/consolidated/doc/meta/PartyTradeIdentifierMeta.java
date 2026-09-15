package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.validation.PartyTradeIdentifierTypeFormatValidator;
import fpml.consolidated.doc.validation.PartyTradeIdentifierValidator;
import fpml.consolidated.doc.validation.datarule.PartyTradeIdentifierChoice;
import fpml.consolidated.doc.validation.datarule.TradeIdentifierChoice;
import fpml.consolidated.doc.validation.exists.PartyTradeIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyTradeIdentifier.class)
public class PartyTradeIdentifierMeta implements RosettaMetaData<PartyTradeIdentifier> {

	@Override
	public List<Validator<? super PartyTradeIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeIdentifier>create(TradeIdentifierChoice.class),
			factory.<PartyTradeIdentifier>create(PartyTradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyTradeIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTradeIdentifier> validator(ValidatorFactory factory) {
		return factory.<PartyTradeIdentifier>create(PartyTradeIdentifierValidator.class);
	}

	@Override
	public Validator<? super PartyTradeIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyTradeIdentifier>create(PartyTradeIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeIdentifier> validator() {
		return new PartyTradeIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeIdentifier> typeFormatValidator() {
		return new PartyTradeIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeIdentifier, Set<String>> onlyExistsValidator() {
		return new PartyTradeIdentifierOnlyExistsValidator();
	}
}
