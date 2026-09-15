package iso20022.auth108.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.mas.PartyIdentification248Choice__2;
import iso20022.auth108.mas.validation.PartyIdentification248Choice__2TypeFormatValidator;
import iso20022.auth108.mas.validation.PartyIdentification248Choice__2Validator;
import iso20022.auth108.mas.validation.datarule.PartyIdentification248Choice__2Choice;
import iso20022.auth108.mas.validation.exists.PartyIdentification248Choice__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyIdentification248Choice__2.class)
public class PartyIdentification248Choice__2Meta implements RosettaMetaData<PartyIdentification248Choice__2> {

	@Override
	public List<Validator<? super PartyIdentification248Choice__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyIdentification248Choice__2>create(PartyIdentification248Choice__2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyIdentification248Choice__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyIdentification248Choice__2> validator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__2>create(PartyIdentification248Choice__2Validator.class);
	}

	@Override
	public Validator<? super PartyIdentification248Choice__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__2>create(PartyIdentification248Choice__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__2> validator() {
		return new PartyIdentification248Choice__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__2> typeFormatValidator() {
		return new PartyIdentification248Choice__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyIdentification248Choice__2, Set<String>> onlyExistsValidator() {
		return new PartyIdentification248Choice__2OnlyExistsValidator();
	}
}
