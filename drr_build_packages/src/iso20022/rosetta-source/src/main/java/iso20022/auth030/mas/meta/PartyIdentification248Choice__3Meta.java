package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.PartyIdentification248Choice__3;
import iso20022.auth030.mas.validation.PartyIdentification248Choice__3TypeFormatValidator;
import iso20022.auth030.mas.validation.PartyIdentification248Choice__3Validator;
import iso20022.auth030.mas.validation.datarule.PartyIdentification248Choice__3Choice;
import iso20022.auth030.mas.validation.exists.PartyIdentification248Choice__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyIdentification248Choice__3.class)
public class PartyIdentification248Choice__3Meta implements RosettaMetaData<PartyIdentification248Choice__3> {

	@Override
	public List<Validator<? super PartyIdentification248Choice__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyIdentification248Choice__3>create(PartyIdentification248Choice__3Choice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyIdentification248Choice__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyIdentification248Choice__3> validator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__3>create(PartyIdentification248Choice__3Validator.class);
	}

	@Override
	public Validator<? super PartyIdentification248Choice__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyIdentification248Choice__3>create(PartyIdentification248Choice__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__3> validator() {
		return new PartyIdentification248Choice__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyIdentification248Choice__3> typeFormatValidator() {
		return new PartyIdentification248Choice__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyIdentification248Choice__3, Set<String>> onlyExistsValidator() {
		return new PartyIdentification248Choice__3OnlyExistsValidator();
	}
}
