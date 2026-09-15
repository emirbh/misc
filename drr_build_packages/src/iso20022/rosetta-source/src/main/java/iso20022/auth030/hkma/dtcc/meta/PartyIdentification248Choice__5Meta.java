package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.PartyIdentification248Choice__5;
import iso20022.auth030.hkma.dtcc.validation.PartyIdentification248Choice__5TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.PartyIdentification248Choice__5Validator;
import iso20022.auth030.hkma.dtcc.validation.datarule.PartyIdentification248Choice__5Choice;
import iso20022.auth030.hkma.dtcc.validation.exists.PartyIdentification248Choice__5OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyIdentification248Choice__5.class)
public class PartyIdentification248Choice__5Meta implements RosettaMetaData<PartyIdentification248Choice__5> {

	@Override
	public List<Validator<? super PartyIdentification248Choice__5>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyIdentification248Choice__5>create(PartyIdentification248Choice__5Choice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyIdentification248Choice__5, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyIdentification248Choice__5> validator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__5>create(PartyIdentification248Choice__5Validator.class);
	}

	@Override
	public Validator<? super PartyIdentification248Choice__5> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__5>create(PartyIdentification248Choice__5TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__5> validator() {
		return new PartyIdentification248Choice__5Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__5> typeFormatValidator() {
		return new PartyIdentification248Choice__5TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyIdentification248Choice__5, Set<String>> onlyExistsValidator() {
		return new PartyIdentification248Choice__5OnlyExistsValidator();
	}
}
