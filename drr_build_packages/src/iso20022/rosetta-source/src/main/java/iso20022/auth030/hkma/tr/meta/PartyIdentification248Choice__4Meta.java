package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__4;
import iso20022.auth030.hkma.tr.validation.PartyIdentification248Choice__4TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.PartyIdentification248Choice__4Validator;
import iso20022.auth030.hkma.tr.validation.exists.PartyIdentification248Choice__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyIdentification248Choice__4.class)
public class PartyIdentification248Choice__4Meta implements RosettaMetaData<PartyIdentification248Choice__4> {

	@Override
	public List<Validator<? super PartyIdentification248Choice__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyIdentification248Choice__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyIdentification248Choice__4> validator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__4>create(PartyIdentification248Choice__4Validator.class);
	}

	@Override
	public Validator<? super PartyIdentification248Choice__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__4>create(PartyIdentification248Choice__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__4> validator() {
		return new PartyIdentification248Choice__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__4> typeFormatValidator() {
		return new PartyIdentification248Choice__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyIdentification248Choice__4, Set<String>> onlyExistsValidator() {
		return new PartyIdentification248Choice__4OnlyExistsValidator();
	}
}
