package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeIdentifiers;
import fpml.consolidated.doc.validation.PartyTradeIdentifiersTypeFormatValidator;
import fpml.consolidated.doc.validation.PartyTradeIdentifiersValidator;
import fpml.consolidated.doc.validation.exists.PartyTradeIdentifiersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyTradeIdentifiers.class)
public class PartyTradeIdentifiersMeta implements RosettaMetaData<PartyTradeIdentifiers> {

	@Override
	public List<Validator<? super PartyTradeIdentifiers>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTradeIdentifiers, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTradeIdentifiers> validator(ValidatorFactory factory) {
		return factory.<PartyTradeIdentifiers>create(PartyTradeIdentifiersValidator.class);
	}

	@Override
	public Validator<? super PartyTradeIdentifiers> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyTradeIdentifiers>create(PartyTradeIdentifiersTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeIdentifiers> validator() {
		return new PartyTradeIdentifiersValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeIdentifiers> typeFormatValidator() {
		return new PartyTradeIdentifiersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeIdentifiers, Set<String>> onlyExistsValidator() {
		return new PartyTradeIdentifiersOnlyExistsValidator();
	}
}
