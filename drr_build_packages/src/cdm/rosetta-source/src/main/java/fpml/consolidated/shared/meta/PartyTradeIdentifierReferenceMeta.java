package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PartyTradeIdentifierReference;
import fpml.consolidated.shared.validation.PartyTradeIdentifierReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.PartyTradeIdentifierReferenceValidator;
import fpml.consolidated.shared.validation.exists.PartyTradeIdentifierReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyTradeIdentifierReference.class)
public class PartyTradeIdentifierReferenceMeta implements RosettaMetaData<PartyTradeIdentifierReference> {

	@Override
	public List<Validator<? super PartyTradeIdentifierReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTradeIdentifierReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTradeIdentifierReference> validator(ValidatorFactory factory) {
		return factory.<PartyTradeIdentifierReference>create(PartyTradeIdentifierReferenceValidator.class);
	}

	@Override
	public Validator<? super PartyTradeIdentifierReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyTradeIdentifierReference>create(PartyTradeIdentifierReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeIdentifierReference> validator() {
		return new PartyTradeIdentifierReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeIdentifierReference> typeFormatValidator() {
		return new PartyTradeIdentifierReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeIdentifierReference, Set<String>> onlyExistsValidator() {
		return new PartyTradeIdentifierReferenceOnlyExistsValidator();
	}
}
