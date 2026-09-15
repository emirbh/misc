package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeInformationSimple;
import fpml.consolidated.doc.validation.PartyTradeInformationSimpleTypeFormatValidator;
import fpml.consolidated.doc.validation.PartyTradeInformationSimpleValidator;
import fpml.consolidated.doc.validation.exists.PartyTradeInformationSimpleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyTradeInformationSimple.class)
public class PartyTradeInformationSimpleMeta implements RosettaMetaData<PartyTradeInformationSimple> {

	@Override
	public List<Validator<? super PartyTradeInformationSimple>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTradeInformationSimple, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTradeInformationSimple> validator(ValidatorFactory factory) {
		return factory.<PartyTradeInformationSimple>create(PartyTradeInformationSimpleValidator.class);
	}

	@Override
	public Validator<? super PartyTradeInformationSimple> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyTradeInformationSimple>create(PartyTradeInformationSimpleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeInformationSimple> validator() {
		return new PartyTradeInformationSimpleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeInformationSimple> typeFormatValidator() {
		return new PartyTradeInformationSimpleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeInformationSimple, Set<String>> onlyExistsValidator() {
		return new PartyTradeInformationSimpleOnlyExistsValidator();
	}
}
