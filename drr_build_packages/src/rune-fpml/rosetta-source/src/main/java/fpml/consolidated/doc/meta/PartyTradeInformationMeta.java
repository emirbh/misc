package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.validation.PartyTradeInformationTypeFormatValidator;
import fpml.consolidated.doc.validation.PartyTradeInformationValidator;
import fpml.consolidated.doc.validation.datarule.PartyTradeInformationChoice0;
import fpml.consolidated.doc.validation.datarule.PartyTradeInformationChoice1;
import fpml.consolidated.doc.validation.exists.PartyTradeInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyTradeInformation.class)
public class PartyTradeInformationMeta implements RosettaMetaData<PartyTradeInformation> {

	@Override
	public List<Validator<? super PartyTradeInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyTradeInformation>create(PartyTradeInformationChoice0.class),
			factory.<PartyTradeInformation>create(PartyTradeInformationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super PartyTradeInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTradeInformation> validator(ValidatorFactory factory) {
		return factory.<PartyTradeInformation>create(PartyTradeInformationValidator.class);
	}

	@Override
	public Validator<? super PartyTradeInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyTradeInformation>create(PartyTradeInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeInformation> validator() {
		return new PartyTradeInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyTradeInformation> typeFormatValidator() {
		return new PartyTradeInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeInformation, Set<String>> onlyExistsValidator() {
		return new PartyTradeInformationOnlyExistsValidator();
	}
}
