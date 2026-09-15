package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.PartyIdentification248Choice;
import iso20022.auth108.iso.validation.PartyIdentification248ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.PartyIdentification248ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.PartyIdentification248ChoiceChoice;
import iso20022.auth108.iso.validation.exists.PartyIdentification248ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyIdentification248Choice.class)
public class PartyIdentification248ChoiceMeta implements RosettaMetaData<PartyIdentification248Choice> {

	@Override
	public List<Validator<? super PartyIdentification248Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyIdentification248Choice>create(PartyIdentification248ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyIdentification248Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyIdentification248Choice> validator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice>create(PartyIdentification248ChoiceValidator.class);
	}

	@Override
	public Validator<? super PartyIdentification248Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice>create(PartyIdentification248ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice> validator() {
		return new PartyIdentification248ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice> typeFormatValidator() {
		return new PartyIdentification248ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyIdentification248Choice, Set<String>> onlyExistsValidator() {
		return new PartyIdentification248ChoiceOnlyExistsValidator();
	}
}
